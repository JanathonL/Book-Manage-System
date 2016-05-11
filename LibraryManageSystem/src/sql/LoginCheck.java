package sql;
import java.sql.*;
public class LoginCheck {
	String CheckId, CheckPasswd;
	public LoginCheck(String userName, String userPasswd){
		
		CheckId=userName;
		CheckPasswd=userPasswd;		
	}
	public boolean Isok() throws SQLException{
		ConnectToLibrary connectToLibrary = new ConnectToLibrary();
		PreparedStatement Statement=connectToLibrary.conn.prepareStatement("select * from administrator where id=? and passwd=?"); 
		Statement.setString(1,CheckId);  
        Statement.setString(2,CheckPasswd);  
        ResultSet rs= Statement.executeQuery();     
   //     System.out.println(rs.findColumn("id"));
        try {
			if (rs.next()) {			
				return true;
			} 
		}
		catch (SQLException e) {
			System.out.print("failed");
			return false;
		}
		
		return false;
        		
	}
}
