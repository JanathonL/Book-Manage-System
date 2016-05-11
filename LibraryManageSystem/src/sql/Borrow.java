package sql;

import java.sql.*;

public class Borrow {
	String cardnumber;

	public Borrow(String cardNumber) {
		cardnumber = cardNumber;
	}
	

	public boolean Isok() throws SQLException {
		ConnectToLibrary connectToLibrary = new ConnectToLibrary();
		PreparedStatement statement = connectToLibrary.conn.prepareStatement("Select * from card where cardNumber = ?");
		statement.setString(1, cardnumber);
		ResultSet rs = statement.executeQuery();
		// System.out.println(rs.getString(1));
		try {
			if (rs.next()) {
				connectToLibrary.conn.close();
				statement.close();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("failed");
			connectToLibrary.conn.close();
			statement.close();
			return false;
		}
		connectToLibrary.conn.close();
		statement.close();
		return false;
	}

}
