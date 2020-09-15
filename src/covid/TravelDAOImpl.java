package covid;

import java.sql.*;

public class TravelDAOImpl implements TravelDAO {
	
	static Connection con;
	static PreparedStatement ps;

	@Override
	public int insertTravel(Travel t) {
		
		int status=0;
		try{
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("insert into travel values(?,?,?)");
			ps.setString(1, t.getEmailid());
			ps.setString(2, t.getSource());
			ps.setString(3, t.getDestination());
	
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
		
	}

	@Override
	public Travel getTravel(String emailid) {
		
		Travel t=new Travel();
		try{
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("select*from travel where emailid=?");
			ps.setString(1, emailid);
	
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				t.setEmailid(rs.getString(1));
				t.setSource(rs.getString(2));
				t.setDestination(rs.getString(3));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return t;
		
	}

}
