package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class BattleSystem {
	public List<String> getatkhp(int userID) throws InvalidValueException {
		// 自分のパーティのATとHPを返す
		List<String> list = new ArrayList<>();

		DBController reader = new DBController();
		int atk = 0, hp = 0;

		String[] result = reader.doget("SELECT slot1,slot2,slot3 FROM user WHERE userID = " + userID, 3);
		for (int i = 0; i < 3; ++i) {
			String[] tmp = reader.doget("SELECT atk,hp FROM sfchara WHERE charaID = " + result[i], 2);
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

		String[] result = reader.doget("SELECT HP,AT,imageaddr FROM sfenechara WHERE eneID = " + eneID, 3);
		list.add(String.valueOf(result[0]));
		list.add(String.valueOf(result[1]));
		list.add(String.valueOf(result[2]));

		return list;
	}

	public List<String> getturn(int userID) throws InvalidValueException {
		// turnをデータベースから取り出す
		List<String> list = new ArrayList<>();
		DBController reader = new DBController();

		String[] result = reader.doget("SELECT turn FROM user WHERE userID = " + userID, 1);
		list.add(String.valueOf(result[0]));

		return list;
	}
}