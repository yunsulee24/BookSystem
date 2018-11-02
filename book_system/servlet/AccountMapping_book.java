package book_system;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapping_book implements ResultSetBeanMapping_book<Account_book> {

	public Account_book createFromResultSet(ResultSet rs) throws SQLException{

		Account_book account = new Account_book();
		account.setBook_title(rs.getString("book_title"));
		account.setBook_type(rs.getString("book_type"));
		account.setAther(rs.getString("ather"));
		account.setUpdate(rs.getString("update"));
		account.setDelete(rs.getString("delete"));
		account.setNo(rs.getInt("no"));

		return account;


	}
}