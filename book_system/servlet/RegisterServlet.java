package book_system;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet{

	public void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		String register_book ="";
		String register_type ="";
		String register_ather ="";

		register_book = request.getParameter("regiserbook_title");
		register_type = request.getParameter("registerbook_type");
		register_ather = request.getParameter("registerbook_ather");

		//実行確認用のprint
		System.out.println(request.getParameter("regiserbook_title"));

		// SQL文の発行
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO book_manage_y(book_title, book_type, ather, update, delete)");
		sb.append(" VALUES(");
		sb.append("'");
		sb.append(register_book);
		sb.append("', ");
		sb.append("'");
		sb.append(register_type);
		sb.append("', ");
		sb.append("'");
		sb.append(register_ather);
		sb.append("', ");
		sb.append("'");
		sb.append("直更新");
		sb.append("', ");
		sb.append("'");
		sb.append("直削除");
		sb.append("'");
		sb.append(")");



//		String sql = "INSERT INTO book_manage_y(book_title, book_type, ather, update, delete)"
//				+ " VALUES("
//				+ "'" + register_book  + "', "
//				+ "'" + register_type  + "', "
//				+ "'" + register_ather + "', "
//				+ "'" + "直更新"       + "', "
//				+ "'" + "直削除"       + "' " + ")";


		String sql = sb.toString();

		//テキストボックスの入力を確認、nullや空文字の場合はエラー画面（errer.jsp）に画面遷移する。
		if (register_book.equals("") || register_book.equals(null) || register_ather.equals("") || register_type.equals(null)){
			register_book = "";
			register_type = "";
			register_ather = "";
			request.getRequestDispatcher("/jsp/errer.jsp").forward(request, response);
		}else{



		try{
			DBManeger_book.simpleUpdate(sql);
		}catch (SQLException e) {
			throw new IllegalStateException(e);
		}


		//実行確認用のprint
		System.out.println("sqlの表示2");
		System.out.println(sql);

		//処理が無事に行われた場合、完了画面(complete.jsp)に画面遷移する。
		request.getRequestDispatcher("/jsp/complete.jsp").forward(request, response);

	}
	}

}