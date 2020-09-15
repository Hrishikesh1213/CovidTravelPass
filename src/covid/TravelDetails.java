package covid;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TravelDetails")
public class TravelDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelDetails() {

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			TravelDAO td=new TravelDAOImpl();
			String source="states_daily_"+(String)request.getParameter("source");
			String destination="states_daily_"+(String)request.getParameter("destination");
			
			//System.out.println(source+"           this is travel details page");
			
			HttpSession session= request.getSession();
			session.setAttribute("source", source);
			session.setAttribute("destination", destination);
			
			String emailid=(String) session.getAttribute("emailid");
			
			String submitType=request.getParameter("submit");

			Travel t =new Travel();
			t.setDestination(destination);
			t.setEmailid(emailid);
			t.setSource(source);
			
			if(submitType.equals("Report") && t!=null ){
				td.insertTravel(t);
				request.setAttribute("emailid", emailid);
				request.getRequestDispatcher("ReportDetails").forward(request, response);
			}
		}

		catch(Exception e){
			System.out.print(e);
		}
		
	}

}
