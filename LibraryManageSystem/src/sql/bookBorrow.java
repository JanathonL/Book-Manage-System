package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class bookBorrow {
	String bookNumber;
	String cardNumber;
	String borrowDay;
	String returnDay;
	String administratorId;
	ConnectToLibrary connectToLibrary = new ConnectToLibrary();

	public bookBorrow(JTextArea textArea, String bookNumber, String cardNumber, String administratorId) {
		// ConnectToLibrary connectToLibrary =new ConnectToLibrary();
		this.bookNumber = bookNumber;
		this.cardNumber = cardNumber;
		this.administratorId = administratorId;
	}

	public boolean Isok() throws SQLException {
		PreparedStatement statement = connectToLibrary.conn.prepareStatement("Select * from book where bookNumber=?");
		statement.setString(1, bookNumber);
		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			return true;
		} else
			return false;
	}

	public void borrowTheBook(JTextArea t) throws SQLException {
		PreparedStatement statement = connectToLibrary.conn.prepareStatement("Select * from book where bookNumber=?");
		PreparedStatement statementCount = connectToLibrary.conn
				.prepareStatement("Update book set bookStorage=bookStorage-1 where bookNumber = ?");
		PreparedStatement statementBorrow = connectToLibrary.conn
				.prepareStatement("insert into borrowRecord values(?,?,?,null,?)");
		statement.setString(1, bookNumber);
		ResultSet rs = statement.executeQuery();
		int bookStorage=0;
		try{
		if(rs.next())
		bookStorage = rs.getInt(9);
		}
		catch(SQLException e){
			System.out.println("getInt failed");
		}
		if (bookStorage == 0) {
			t.setText("书的库存不足");
			return;
		}
		statementCount.setString(1, bookNumber);
		statementCount.executeUpdate();
		
		statementBorrow.setString(1, cardNumber);
		statementBorrow.setString(2, bookNumber);
		Date day = new Date();
		System.out.println(DateFormat.getDateInstance().format(day).toString());
		statementBorrow.setString(3, DateFormat.getDateInstance().format(day).toString());

		statementBorrow.setString(4, administratorId);
		System.out.println(statementBorrow);
		int result = statementBorrow.executeUpdate();
		if (result == 0){
			t.setText("借书失败\n");
			System.out.println("插入bookRecord失败");
			t.append("更新借书记录失败");
		}
		else{
			t.setText("借书成功\n");
			System.out.println("插入bookRecord成功");
			t.append("更新借书记录成功");
		}
	}
	public void returnTheBook(JTextArea t) throws SQLException{
		PreparedStatement statementCount = connectToLibrary.conn
				.prepareStatement("Update book set bookStorage=bookStorage+1 where bookNumber = ?");
		PreparedStatement statementReturn = connectToLibrary.conn
				.prepareStatement("Update borrowRecord set returnDay=? where bookNumber = ? and cardNumber=? and returnDay is null");
		statementCount.setString(1, bookNumber);
		statementCount.executeUpdate();
		
		Date day = new Date();
		statementReturn.setString(1, DateFormat.getDateInstance().format(day).toString());
		statementReturn.setString(2, bookNumber);
		statementReturn.setString(3, cardNumber);
		int result = statementReturn.executeUpdate();
		if (result == 0){
			t.setText("还书失败\n");
			System.out.println("更新还书记录失败");
			t.append("更新还书记录失败");
		}
		else{
			t.setText("还书成功\n");
			System.out.println("更新还书记录成功");
			t.append("更新还书记录成功");
		}
	}

}
