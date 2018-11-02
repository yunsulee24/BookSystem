package book_system;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class AccountDAO_book {

	public List<Account_book> findALL() throws UnsupportedEncodingException {

		String sql = null;

		try{
			return DBManeger_book.simpleFind(sql, new AccountMapping_book() );
		}catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}


	public int insert(Account_book account) {

		// INSERTÅiåüçıÅjÇÃSQLï∂ÇÃî≠çs
		String sql = "INSERT INTO book_manage_y(book_title, book_type, ather, update, delete, no)"
				+ " VALUE(" + account.getBook_title()
				+ " '" + account.getBook_type()
				+ " ,'" + account.getAther()
				+ " ,'" + account.getUpdate()
				+ " ,'" + account.getDelete()
				+ " ,'" + account.getNo()
				+ " )"
				;

		try{
			return DBManeger_book.simpleUpdate(sql);

		}catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

}
