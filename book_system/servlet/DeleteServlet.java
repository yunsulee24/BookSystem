package book_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		//文字コードの指定
		request.setCharacterEncoding("UTF-8");

		try{
			Connection con = null;
			PreparedStatement ps = null;

			//　SQL文
			String sql = "DELETE FROM book_manage_y WHERE no=?";

			//実行確認用のprint
			System.out.println("sqlの表示1");
			System.out.println(sql);

			try{
				con = DBManeger_book.getConnection();
				ps = con.prepareStatement(sql);

				// jspから渡された"hid_no"を使用
				ps.setInt(1, Integer.valueOf(request.getParameter("hid_no")));

				ps.executeUpdate();
			}finally{
				if (ps != null){
					try{
						ps.close();
					}catch(SQLException ignore){}
				}
				if (con != null){
					try {
						con.close();
					}catch(SQLException ignore){}
				}
			}

		}catch (SQLException e) {
			throw new IllegalStateException(e);
		}

		// 完了画面へ画面遷移する。
		request.getRequestDispatcher("/jsp/complete.jsp").forward(request, response);

	}
}