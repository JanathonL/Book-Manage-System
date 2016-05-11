package sql;

import java.sql.*;

public class ConnectToLibrary {
	Connection conn;
	public ConnectToLibrary(){
		// 驱动程序名
				String driver = "com.mysql.jdbc.Driver";
				// URL指向要访问的数据库名scutcs
				String url = "jdbc:mysql://127.0.0.1:3306/Library";
				// MySQL配置时的用户名
				String user = "root"; 
				// MySQL配置时的密码
				String password = "ljt123456";
				try { 
					// 加载驱动程序
					Class.forName(driver);
					// 连续数据库
					conn = DriverManager.getConnection(url, user, password);
					if(!conn.isClosed()) 
						System.out.println("Succeeded connecting to the Database!");
					// statement用来执行SQL语句
				//	Statement statement = conn.createStatement();
				} catch(ClassNotFoundException e) {
					System.out.println("Sorry,can`t find the Driver!"); 
					e.printStackTrace();
				} catch(SQLException e) {
					e.printStackTrace();
				} catch(Exception e) {
					e.printStackTrace();
				} 
				
	};
	public static void main(String[] agrs){
		new ConnectToLibrary();
	}
}
