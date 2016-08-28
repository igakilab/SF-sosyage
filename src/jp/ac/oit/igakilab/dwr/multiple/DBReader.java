package jp.ac.oit.igakilab.dwr.multiple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBReader {
	//読み込むテーブル名
	private String tableName;
	public DBReader(String tableName) {
		this.tableName = tableName;
	}
	public String doget() {
		//DBとのコネクション
		Connection conn = null;
		//DBの状態
		Statement stmt = null;
		//DBにSQL文を投げて戻ってきた結果
		ResultSet rs = null;

		//この2つのStringはSQL文のみに使うので、変数でなくともよい
		//主キー
		String pKey = "id";
		//副キー
		String sKey = "text";

		//Stringの加算は遅いのでStringBuilderを使う(考え方が古い？)
		StringBuilder sb = new StringBuilder();

		//ファイルに触る関係上例外発生の可能性があるためcatchできるように
		try {
			//DBと接続するのに必要,詳しく知りたいなら"Class.forName"で検索(難しい話が山ほど出てくる)
			Class.forName("org.sqlite.JDBC");
			//DBとのコネクションを張る
			conn = DriverManager.getConnection("jdbc:sqlite:C:/pleiades/sqlite/test.sqlite");
			//DBの状態を生成(？)
			stmt = conn.createStatement();
			//SQL文を実行し結果をrsに格納
			rs = stmt.executeQuery("SELECT " + pKey + "," + sKey + " FROM " + tableName);
			//SELECT id, text FROM message
			//これはmessageテーブルからid,textをすべて読み込んで返すSQL

			//SQL文の結果が空になるまで1行ずつ読み込み
			while (rs.next()) {
				//主キーをStringBuilderに追加
				sb.append(rs.getString(pKey));
				//区切り文字を追加
				sb.append(" : ");
				//副キーを追加
				sb.append(rs.getString(sKey));
				//改行文字を追加(htmlに出す場合これだけじゃダメらしい)
				sb.append("\n");
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
		return sb.toString();
	}
}
