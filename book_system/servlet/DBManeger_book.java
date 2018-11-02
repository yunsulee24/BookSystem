package book_system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DBManeger_book {

	private static String driver = "***.**********.******";
	private static String url = "****:**********://***.***.*.**/******_*";
	private static String user = "********";
	private static String pass = "********";

	//データベースへの接続
	public static Connection getConnection() {
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch ( Exception e) {
			throw new IllegalStateException(e);
		}
	}


	//データベースへsql文を送る、データベースとの接続を切る。
	public static int simpleUpdate(String sql)throws SQLException{

		Connection con = null;
		Statement smt = null;

		try{
			con = DBManeger_book.getConnection();
			smt = con.createStatement();
			return smt.executeUpdate(sql);
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
	}

	public static int update(PreparedStatement ps)throws SQLException{

			Connection con = null;
			Statement smt = null;

			try{
				con = DBManeger_book.getConnection();
				smt = con.createStatement();
				return ps.executeUpdate();
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
	}


	public static <T> List<T> simpleFind(String sql, ResultSetBeanMapping_book <T> mapping ) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;



		try{

			con = DBManeger_book.getConnection();
			ps = con.prepareStatement(sql);

			//実行の確認のためのprint文
			//System.out.println("DBMANAGERでのsql");
			//System.out.println("plint = " + sql);

			ResultSet rs = ps.executeQuery();

			List<T> list = new ArrayList<T>();

			while (rs.next()) {
				T bean = mapping.createFromResultSet(rs);

				list.add(bean);

			}

			return list;

		}finally{
			if (ps != null){
				try{
					ps.close();
				}catch(SQLException ignore){}
			}
			if (con != null){
				try { con.close();}catch(SQLException ignore){}
			}
		}
	}




	public static void main(String[] args) throws Exception {
		Connection con = getConnection();
		System.out.println("con = " + con);
		con.close();

	}
}
