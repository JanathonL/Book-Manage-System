package sql;

import java.sql.*;

public class ConnectToLibrary {
	Connection conn;
	public ConnectToLibrary(){
		// ����������
				String driver = "com.mysql.jdbc.Driver";
				// URLָ��Ҫ���ʵ����ݿ���scutcs
				String url = "jdbc:mysql://127.0.0.1:3306/Library";
				// MySQL����ʱ���û���
				String user = "root"; 
				// MySQL����ʱ������
				String password = "ljt123456";
				try { 
					// ������������
					Class.forName(driver);
					// �������ݿ�
					conn = DriverManager.getConnection(url, user, password);
					if(!conn.isClosed()) 
						System.out.println("Succeeded connecting to the Database!");
					// statement����ִ��SQL���
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
