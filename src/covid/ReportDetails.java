package covid;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Servlet implementation class ReportDetails
 */
@WebServlet("/ReportDetails")
public class ReportDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Connection con;
	static PreparedStatement ps;
	
   
    public ReportDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	 try{
		 con=MyConnectionProvider.getCon();
		 PrintWriter out=response.getWriter();
		 response.setContentType("text/html");  
	     out.println("<html><body>"); 
		 ps=con.prepareStatement("SELECT * FROM daily_cases WHERE states_daily_status=?");
		 
		 HttpSession session=request.getSession();
		 String source=(String) session.getAttribute("source");
		 String destination=(String) session.getAttribute("destination");

		ps.setString(1,"Confirmed");
		ResultSet rs = ps.executeQuery();

		
		ArrayList<String> source_data=new ArrayList<String>();
		ArrayList<String> destination_data=new ArrayList<String>();
		ArrayList<String> datetime_data=new ArrayList<String>();
		int size=0;
		rs.next();
		
		while(rs.next()){
			source_data.add(rs.getString(source));//(String) session.getAttribute("source")
			destination_data.add(rs.getString(destination));//(String) session.getAttribute("destination")
			datetime_data.add(rs.getString("states_daily_date"));
			size++;
		}	
		session.setAttribute("source_cases_confirmed", source_data.get(size-1));
		session.setAttribute("destination_cases_confirmed", destination_data.get(size-1));
		session.setAttribute("datetime", datetime_data.get(size-1));
		
		System.out.println(source+"	; "+destination+" ; size= "+size); 
		System.out.println();
		
		out.println(" Confirmed cases in source is: "+source_data.get(size-1));
		out.println("<br>");
		out.println(" Confirmed cases in destination is: "+destination_data.get(size-1));
		out.println("<br>");
		out.println(" as of  "+datetime_data.get(size-1));
		out.println("<br>");
		if(Integer.parseInt(source_data.get(size-1))>=Integer.parseInt(destination_data.get(size-1))){
			out.println("You can travel safely");
		}
		else{
			out.println("You cannot travel safely");
		}
		out.println("<br>");

		out.println("<form action="+"EmailServlet " +"method="+"post"+"><input type="+"submit" +" name="+"email " +"value="+" email"+" ></form>");
		out.println("<br>");
		out.println("<form action="+"SessionDataClear " +"method="+"post"+"><input type="+"submit" +" name="+"logout " +"value="+" logout"+" ></form>");

		
		out.println("</body></html>");  
		
		
        con.close();  
		
		
	 }
	 catch(Exception e){
			System.out.print(e);
		}
		
	}

}
