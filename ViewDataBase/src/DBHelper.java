import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHelper {
	Connection con;
	Statement stmt;
	ResultSet rs;
	public DBHelper() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
		stmt = con.createStatement();
		System.out.print("Done");
	}
	public ArrayList<UserDetails> readDB() throws SQLException {
		//UserDetails[] userss= new UserDetails[10];
		ArrayList<UserDetails> users = new ArrayList<UserDetails>();
 		rs = stmt.executeQuery("select * from testtable");
		int i = 0;
		while(rs.next()){
			users.add(new UserDetails(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		return users;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBHelper helper = new DBHelper();
		ArrayList<UserDetails> users = helper.readDB();
		
		for (UserDetails x:users){
			System.out.println(x.userName);
			System.out.println(x.phNo);
			System.out.println(x.mailId);
			
		}
	}
}
