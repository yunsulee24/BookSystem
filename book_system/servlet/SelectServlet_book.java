package book_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectServlet_book extends HttpServlet{

	public void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//文字コードの指定
		request.setCharacterEncoding("UTF-8");

		//変数の宣言、値の取得
		String h_title = request.getParameter("booktitletext");
		String h_type = request.getParameter("pulldownlist");

		//　SQL文の発行
		String sql = "SELECT * FROM book_manage_y WHERE book_title LIKE '%" + h_title + "%' AND book_type LIKE '%" + h_type + "%' ORDER BY no";


		try{
			Connection con = null;
			Statement smt = null;;

			try{
				con = DBManeger_book.getConnection();
				smt = con.createStatement();
				ResultSet rs = smt.executeQuery(sql);

				List<Account_book> list = new ArrayList<Account_book>();
				
				//ループで該当するデータを入れていく、listに追加
				while(rs.next()){
					Account_book bean = new Account_book();
					bean.setBook_title(rs.getString("book_title"));
					bean.setBook_type(rs.getString("book_type"));
					bean.setAther(rs.getString("ather"));
					bean.setUpdate(rs.getString("update"));
					bean.setDelete(rs.getString("delete"));
					bean.setNo(rs.getInt("no"));

					list.add(bean);
				}

				request.setAttribute("list", list);

			}finally{
				if (smt != null){
					try{
						smt.close();
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

		//　main.jspに画面遷移する。forwardで情報渡す。
		request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
	}
}


