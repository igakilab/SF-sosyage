package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class TeamPrinter {
	public List<String> fetchslot(LoginData user) throws InvalidValueException {
		List<String> list = new ArrayList<>();
		int userID = user.getuserID();
		DBController reader = new DBController();
		
		String[] result = reader.doget("SELECT slot1,slot2,slot3 FROM user WHERE userID = " + userID, 3);
		for (int i = 0; i < 3; ++i) {
			list.add(reader.doget("SELECT imgaddr FROM sfchara WHERE charaID = " + result[i], 1)[0]);
		}

		return list;
	}

	public List<String> changeslot(LoginData user) throws InvalidValueException {
		int userID = user.getuserID();
		int spot1 = user.getuserspot1();
		int spot2 = user.getuserspot2();

		DBController reader = new DBController();
		String[] slotch = reader.doget("SELECT slot" + spot1 + ",slot" + spot2 + " FROM user WHERE userID = " + userID,
				2);

		reader.dowrite("UPDATE user SET " + "slot" + spot1 + "=" + slotch[1] + ", slot" + spot2 + "=" + slotch[0]
				+ " WHERE userID = " + userID);

		return fetchslot(user);
	}
}
