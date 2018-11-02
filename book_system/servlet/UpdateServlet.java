package book_system;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateServlet extends HttpServlet{

	public void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//動作確認のためのprint
		System.out.println("sqlの表示,UpdateServletの開始地点");

		//文字コードの指定
		request.setCharacterEncoding("UTF-8");

		//変数の宣言、初期値の入力
		String up_title  ="";
		String up_type ="";
		String up_ather ="";
		int up_no;

		// jspから値の受け取り
		up_title = request.getParameter("update_title");
		up_type = request.getParameter("update_type");
		up_ather = request.getParameter("update_ather");
		up_no = Integer.valueOf(request.getParameter("no"));

		//　SQL文の発行
		String sql = "UPDATE book_manage_y SET book_title = '" + up_title +"', book_type = '" + up_type + "', ather = '" + up_ather + "' WHERE no = "+ up_no;

		//動作確認のためのprint
		System.out.println("up_title = " + up_type);


		// 入力の"null",空文字の確認
		if (up_title.equals("") || up_title.equals(null)){

			// エラー画面（errer.jsp）に画面遷移する。
			request.getRequestDispatcher("/jsp/errer.jsp").forward(request, response);
		}else{

		try{

			System.out.println("sqlの表示1");
			System.out.println(sql);

			DBManeger_book.simpleUpdate(sql);

		}catch (SQLException e) {
			throw new IllegalStateException(e);
		}

		//動作確認のためのprint
		System.out.println("sqlの表示2");
		System.out.println(sql);

		// 完了画面（complete.jsp）に画面遷移する。
		request.getRequestDispatcher("/jsp/complete.jsp").forward(request, response);

		}
	}



}

