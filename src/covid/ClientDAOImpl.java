package covid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDAOImpl implements ClientDAO {
	
	static Connection con;
	static PreparedStatement ps;

	@Override
	public int insertClient(Client c) {
		
		int status=0;
		try{
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("insert into hi.client values(?,?,?,?,?)");
			
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getName());
			ps.setString(3, c.getEmailid());
			ps.setString(4, c.getPhonenumber());
			ps.setString(5, c.getPassword());
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
		
	}

	@Override
	public Client getClient(String username, String password) {
		
		Client c=new Client();
		try{
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("select*from hi.client where username=? and password=? ");
			ps.setString(1,username);
			ps.setString(2,password);
	
	
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				c.setUsername(rs.getString(1));
				c.setName(rs.getString(2));
				c.setEmailid(rs.getString(3));
				c.setPhonenumber(rs.getString(4));
				c.setPassword(rs.getString(5));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return c;
		}
		
	}


