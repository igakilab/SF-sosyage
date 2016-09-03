package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class BattleSystem {
	public List<String> getatkhp(int userID) throws InvalidValueException {
		List<String> list = new ArrayList<>();

		DBReader reader = new DBReader();
		int atk=0,hp=0;

		String[] result = reader.doget("SELECT slot1,slot2,slot3 FROM user WHERE userID == " + userID, 3);
		for (int i = 0; i < 3; ++i) {
			String[] tmp = reader.doget("SELECT atk,hp FROM character WHERE charaID == " + result[i], 2);
			atk += Integer.valueOf(tmp[0]);
			hp += Integer.valueOf(tmp[1]);
		}

		list.add(String.valueOf(atk));
		list.add(String.valueOf(hp));

		return list;
	}
}