package covid;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmailServlet() {
    }
    
    
    
	private static Message prepareMessage(Session session_mail, String sendermail,String recipient,String text) {
		
		try {
			Message message= new MimeMessage(session_mail);
			message.setFrom(new InternetAddress(sendermail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("COVID Travel Pass");
			message.setText(text);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return null;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");  
	    out.println("<html><body>"); 
		
		HttpSession session=request.getSession();
		String recipient = (String) session.getAttribute("emailid");
		String source_confirmed=(String) session.getAttribute("source_cases_confirmed");
		String destination_confirmed=(String) session.getAttribute("destination_cases_confirmed");
		String datetime=(String) session.getAttribute("datetime");
		String add_travelpass;
		if(Integer.parseInt(source_confirmed)>=Integer.parseInt(destination_confirmed)){
			add_travelpass="you are permitted to travel";
		}
		else{
			add_travelpass="you are not permitted to travel";
		}
		
		String text="confirmed COVID cases at Source: "+source_confirmed+"\n"+
					"confired COVID cases at Destination: "+destination_confirmed+"\n"+
					"as of "+datetime+"\n"+
					add_travelpass+"";

		out.println("Preparing to send mail to ..."+recipient);
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String sendermail="covid19javamail@gmail.com";
		String passmail="mail.java.covid19";
			
		
		Session session_mail= Session.getInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(sendermail, passmail);	
			}
		});
		
		Message message=prepareMessage(session_mail,sendermail,recipient,text);
		
		try {
			//for(int k=0;k<20;k++){Transport.send(message);}
			Transport.send(message);
			out.println("<br>");
			out.println("Mail sent successfully");

		} 
		catch (Exception e) {
			out.println(e);

		}
		out.println("<br>");
		out.println("<form action="+"SessionDataClear " +"method="+"post"+"><input type="+"submit" +" name="+"logout " +"value="+" logout"+" ></form>");
		out.println("</body></html>"); 
	}
}
