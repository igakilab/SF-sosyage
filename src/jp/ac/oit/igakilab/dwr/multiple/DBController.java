package jp.ac.oit.igakilab.dwr.multiple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBController {
	// スキーマ名、ユーザ名、パスワードはMySQLとの接続に必要なため
	// ここで定数として定義しておく、使う時はここ変えてね
	private static final String SCHEMA = "SFSDB";
	private static final String USER = "akimoto";
	private static final String PASSWORD = "aaaa";

	public void dowrite(String sql) {
		// DBとのコネクション
		Connection conn = null;
		// DBの状態
		Statement stmt = null;
		// ファイルに触る関係上例外発生の可能性があるためcatchできるように
		try {
			// DBと接続するのに必要,詳しく知りたいなら"Class.forName"で検索(難しい話が山ほど出てくる)
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// DBとのコネクションを張る
			conn = DriverManager
					.getConnection("jdbc:mysql://150.89.234.221/" + SCHEMA + "?user=" + USER + "&password=" + PASSWORD);
			// DBの状態を生成(？)
			stmt = conn.createStatement();
			// SQL文を実行し結果をrsに格納
			stmt.executeUpdate(sql);
			// SELECT id, text FROM message
			// これはmessageテーブルからid,textをすべて読み込んで返すSQL
		} catch (Exception e) {
			// 例外処理(スタックトレースを表示)
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String[] doget(String sql, int selectLength) {
		// DBとのコネクション
		Connection conn = null;
		// DBの状態
		Statement stmt = null;
		// DBにSQL文を投げて戻ってきた結果
		ResultSet rs = null;

		List<String> list = new ArrayList<String>();
		int elementNum = 0;

		// ファイルに触る関係上例外発生の可能性があるためcatchできるように
		try {
			// DBと接続するのに必要,詳しく知りたいなら"Class.forName"で検索(難しい話が山ほど出てくる)
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// DBとのコネクションを張る
			conn = DriverManager
					.getConnection("jdbc:mysql://150.89.234.221/" + SCHEMA + "?user=" + USER + "&password=" + PASSWORD);
			// DBの状態を生成(？)
			stmt = conn.createStatement();
			// SQL文を実行し結果をrsに格納
			rs = stmt.executeQuery(sql);
			// SELECT id, text FROM message
			// これはmessageテーブルからid,textをすべて読み込んで返すSQL

			// SQL文の結果が空になるまで1行ずつ読み込み
			while (rs.next()) {
				for (int i = 1; i <= selectLength; ++i) {
					list.add(rs.getString(i));
					elementNum = (i - 1) * selectLength;
				}
			}
		} catch (Exception e) {
			// 例外処理(スタックトレースを表示)
			e.printStackTrace();
		} finally {
			// DBとの接続を開放
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// StringBuilderの中身をStringにして返却
		return list.toArray(new String[elementNum]);
	}
}