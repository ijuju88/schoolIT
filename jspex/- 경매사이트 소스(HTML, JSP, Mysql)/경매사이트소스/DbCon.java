package MyBean.DB;
import java.sql.*;
public class DbCon
{
	
	final static String url = "jdbc:mysql://localhost:3306/auction";
	final static String user = "admin";
	final static String password = "1234";
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.out.print(e);
		
		}
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
};  

