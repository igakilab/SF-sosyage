package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class BattleSystem {
	public List<String> getatkhp(int userID) throws InvalidValueException {
		// 自分のパーティのATとHPを返す
		List<String> list = new ArrayList<>();

		DBController reader = new DBController();
		int atk = 0, hp = 0;

		String[] result = reader.doget("SELECT slot1,slot2,slot3 FROM user WHERE userID = " + userID);
		for (int i = 0; i < 3; ++i) {
			String[] tmp = reader.doget("SELECT atk,hp FROM sfchara WHERE charaID = " + result[i]);
			atk += Integer.valueOf(tmp[0]);
			hp += Integer.valueOf(tmp[1]);
		}

		list.add(String.valueOf(atk));
		list.add(String.valueOf(hp));

		return list;
	}

	public List<String> getenemy(int eneID) throws InvalidValueException {
		// 敵のHPとATと画像のアドレスを返す
		List<String> list = new ArrayList<>();

		DBController reader = new DBController();

		String[] result = reader.doget("SELECT HP,AT,imageaddr FROM sfenechara WHERE eneID = " + eneID);
		list.add(String.valueOf(result[0]));
		list.add(String.valueOf(result[1]));
		list.add(String.valueOf(result[2]));

		return list;
	}

	public List<String> getturn(int userID) throws InvalidValueException {
		// turnをデータベースから取り出す
		List<String> list = new ArrayList<>();
		DBController reader = new DBController();

		String[] result = reader.doget("SELECT turn FROM user WHERE userID = " + userID);
		list.add(String.valueOf(result[0]));

		return list;
	}

	public List<String> battle(BattleData battledata){
		//userIDと味方の行動の読み込み//
		String userID = battledata.getuserID();
		int c1 = battledata.getc1();
		int c2 = battledata.getc2();
		int c3 = battledata.getc3();
		int atk = 0;

		DBController reader = new DBController();
		List<String> list = new ArrayList<>();

		if(c1 == 1){
			String[] s1 = reader.doget("SELECT slot1 FROM user WHERE userID = " + userID );
			String[] result = reader.doget("SELECT atk FROM sfchara WHERE charaID = " + s1[0]);
			atk += Integer.valueOf(result[0]);
		}
		if(c2 == 1){
			String[] s2 = reader.doget("SELECT slot2 FROM user WHERE userID = " + userID );
			String[] result = reader.doget("SELECT atk FROM sfchara WHERE charaID = " + s2[0]);
			atk += Integer.valueOf(result[0]);
		}
		if(c3 == 3){
			String[] s3 = reader.doget("SELECT slot1 FROM user WHERE userID = " + userID );
			String[] result = reader.doget("SELECT atk FROM sfchara WHERE charaID = " + s3[0]);
			atk += Integer.valueOf(result[0]);
		}
		list.add(String.valueOf(atk));
		return list;

	}
}