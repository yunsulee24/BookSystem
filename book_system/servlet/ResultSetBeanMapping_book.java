package book_system;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetBeanMapping_book<T> {

	public T createFromResultSet(ResultSet rs)throws SQLException;

}
