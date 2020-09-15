package covid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginRegister() {
        
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			ClientDAO cd=new ClientDAOImpl();
			String username=request.getParameter("username");
			String password=request.getParameter("password1");
			String submitType=request.getParameter("submit");
			Client c=cd.getClient(username, password);
			
			String emailid1=c.getEmailid();
			
			if(submitType.equals("login") && c.getUsername()!=null && c.getPassword()!=null){
				
				HttpSession session= request.getSession();
				session.setAttribute("emailid", emailid1);
				
				request.getRequestDispatcher("travel.jsp").forward(request, response);
			}
			else if(submitType.equals("register")){
				
				
				String name=request.getParameter("name");
				String emailid=request.getParameter("emailid");
				String phonenumber=request.getParameter("phonenumber");
		
				
				c.setUsername(username);
				c.setName(request.getParameter("name"));
				c.setEmailid(request.getParameter("emailid"));
				c.setPhonenumber(request.getParameter("phonenumber"));
				c.setPassword(password);
				
				
				cd.insertClient(c);
				
				request.setAttribute("successMessage","Registration done,please login to continue..");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else{
				request.setAttribute("Message", "Data not found,Create your Account!!!");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
			}
			catch(Exception e){
				System.out.print(e);
			}
		
	}

}
