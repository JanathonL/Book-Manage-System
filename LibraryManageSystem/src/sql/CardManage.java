package sql;
import java.sql.*;

import javax.swing.JTextField;
public class CardManage {
	ConnectToLibrary connectToLibrary=new ConnectToLibrary();
	String cardNumber;
	String userName;
	String userDepartment;
	String userCategory;
	public CardManage(String cardNumber,String userName,String userDepartment,String userCategory){
		this.cardNumber=cardNumber;
		this.userName=userName;
		this.userDepartment=userDepartment;
		this.userCategory=userCategory;
	}
	public void addCard(JTextField t) throws SQLException{
		PreparedStatement statement=connectToLibrary.conn.prepareStatement("insert into card values(?,?,?,?)");
		if(cardNumber.equals("")){
			t.setText("借阅证号不能为空");
			return ;
		}
		else if(userName.equals("")){
			t.setText("用户姓名不能为空");
			return ;
		}
		else if(userDepartment.equals("")){
			t.setText("用户所属部门不能为空");
			return ;
		}
		else if(userCategory.equals("")){
			t.setText("用户类别不能为空");
			return ;
		}
		statement.setString(1, cardNumber);
		statement.setString(2, userName);
		statement.setString(3, userDepartment);
		statement.setString(4, userCategory);
		try{
			statement.executeUpdate();
			t.setText("加入借书证成功");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			t.setText("加入借书证失败");
		}
	}
	public void deleteCard(JTextField t) throws SQLException{
		PreparedStatement statement=connectToLibrary.conn.prepareStatement("delete from card where cardNumber=?");
		statement.setString(1, cardNumber);
		PreparedStatement statementfind=connectToLibrary.conn.prepareStatement("select * from card where cardNumber=?");
		statementfind.setString(1, cardNumber);
		ResultSet rs=statementfind.executeQuery();
		if(rs.next()){
			statement.executeUpdate();
			t.setText("删除借书证成功");
		}
		else{
			System.out.println("找不到此借阅证");
			t.setText("找不到此借阅证");
		}
	}
}
