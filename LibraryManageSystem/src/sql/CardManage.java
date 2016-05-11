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
			t.setText("����֤�Ų���Ϊ��");
			return ;
		}
		else if(userName.equals("")){
			t.setText("�û���������Ϊ��");
			return ;
		}
		else if(userDepartment.equals("")){
			t.setText("�û��������Ų���Ϊ��");
			return ;
		}
		else if(userCategory.equals("")){
			t.setText("�û������Ϊ��");
			return ;
		}
		statement.setString(1, cardNumber);
		statement.setString(2, userName);
		statement.setString(3, userDepartment);
		statement.setString(4, userCategory);
		try{
			statement.executeUpdate();
			t.setText("�������֤�ɹ�");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			t.setText("�������֤ʧ��");
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
			t.setText("ɾ������֤�ɹ�");
		}
		else{
			System.out.println("�Ҳ����˽���֤");
			t.setText("�Ҳ����˽���֤");
		}
	}
}
