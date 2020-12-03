package covid;

public interface ClientDAO {

	public int insertClient(Client c);
	public Client getClient(String username,String password);
	
}
