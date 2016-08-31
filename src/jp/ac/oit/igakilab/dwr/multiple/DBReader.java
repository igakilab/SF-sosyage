package jp.ac.oit.igakilab.dwr.multiple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBReader {
	//読み込むテーブル名
	public DBReader() {
	}
	public String[] doget(String sql, int selectLength) {
		//DBとのコネクション
		Connection conn = null;
		//DBの状態
		Statement stmt = null;
		//DBにSQL文を投げて戻ってきた結果
		ResultSet rs = null;

		List<String> list = new ArrayList<String>();

		//ファイルに触る関係上例外発生の可能性があるためcatchできるように
		try {
			//DBと接続するのに必要,詳しく知りたいなら"Class.forName"で検索(難しい話が山ほど出てくる)
			Class.forName("org.sqlite.JDBC");
			//DBとのコネクションを張る
			conn = DriverManager.getConnection("jdbc:sqlite:C:/SQL/sqlite/SFSDB.sqlite");
			//DBの状態を生成(？)
			stmt = conn.createStatement();
			//SQL文を実行し結果をrsに格納
			rs = stmt.executeQuery(sql);
			//SELECT id, text FROM message
			//これはmessageテーブルからid,textをすべて読み込んで返すSQL

			//SQL文の結果が空になるまで1行ずつ読み込み
			while (rs.next()) {
				for (int i = 0; i < selectLength; ++i) {
					list.add(rs.getString(i));
				}
			}
		} catch(Exception e) {
			//例外処理(スタックトレースを表示)
			e.printStackTrace();
		} finally {
			//DBとの接続を開放
			if (rs != null ) { try {rs.close(); } catch (SQLException e) {e.printStackTrace();} }
			if (stmt != null ) { try {stmt.close(); } catch (SQLException e) {e.printStackTrace();} }
			if (conn != null ) { try {conn.close(); } catch (SQLException e) {e.printStackTrace();} }
		}
		//StringBuilderの中身をStringにして返却
		return (String[]) list.toArray();
	}
}
