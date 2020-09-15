package covid;

public interface TravelDAO {
	
	public int insertTravel(Travel t);
	public Travel getTravel(String emailid);

}
