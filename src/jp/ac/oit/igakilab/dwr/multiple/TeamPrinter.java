package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class TeamPrinter {
	public List<String> fetchslot(LoginData user) throws InvalidValueException {

		List<String> list = new ArrayList<>();
		int userID = user.getuserID();
		DBController reader = new DBController();
		for (int i = 1; i <= 3; ++i) {
			list.add(reader.doget("SELECT slot"+i+" FROM user WHERE userID = " + userID)[0]);
		}

		return list;
	}


	public void changeslot(LoginData user) throws InvalidValueException {
		int userID = user.getuserID();
		int spot1 = user.getuserspot1();
		int spot2 = user.getuserspot2();

		DBController reader = new DBController();

		String[] slotch = reader.doget("SELECT slot" + spot1 + ",slot" + spot2 + " FROM user WHERE userID = " + userID);


		reader.dowrite("UPDATE user SET " + "slot" + spot1 + "=" + slotch[1] + ", slot" + spot2 + "=" + slotch[0]
				+ " WHERE userID = " + userID);
	}
	public void changeslot2(LoginData user) throws InvalidValueException {
		int userID = user.getuserID();
		int spot1 = user.getuserspot1();
		int spot2 = user.getuserspot2();

		DBController reader = new DBController();

		String[] slotch = reader.doget("SELECT slot" + spot1 + " FROM user WHERE userID = " + userID);


		reader.dowrite("UPDATE user SET " + "slot" + spot1 + "=" + spot2 + " WHERE userID = " + userID);
	}
	public List<String> characterfetch(LoginData user) throws InvalidValueException {
        List<String> list = new ArrayList<>();
        int userID = user.getuserID();
        DBController reader = new DBController();
        int count = reader.doget("SELECT charaID FROM sfchara").length;
        String sql;
        for(int i=1;i<=count;i++){
            sql = "SELECT chara" + i +" FROM user WHERE userID = " + userID;
            	list.add(reader.doget(sql)[0]);
        }

        return list;
	}

	public List<String>charaname(){
		   List<String> list = new ArrayList<>();
	        DBController reader = new DBController();
	        int count = reader.doget("SELECT charaID FROM sfchara").length;
	        for(int i=1;i<=count;i++){
	            	list.add(reader.doget("SELECT charaname FROM sfchara WHERE charaID = " + i)[0]);
	        }
	        return list;
	}
	public List<String>charaatk(){
		   List<String> list = new ArrayList<>();
	        DBController reader = new DBController();
	        int count = reader.doget("SELECT charaID FROM sfchara").length;
	        for(int i=1;i<=count;i++){
	            	list.add(reader.doget("SELECT atk FROM sfchara WHERE charaID = " + i)[0]);
	        }
	        return list;
	}
	public List<String>charahp(){
		   List<String> list = new ArrayList<>();
	        DBController reader = new DBController();
	        int count = reader.doget("SELECT charaID FROM sfchara").length;
	        for(int i=1;i<=count;i++){
	            	list.add(reader.doget("SELECT hp FROM sfchara WHERE charaID = " + i)[0]);
	        }
	        return list;
	}
	public String geteneID(int userID){
		DBController reader = new DBController();
		return reader.doget("SELECT nextenemy FROM user WHERE userID ="+ userID)[0];
	}

	public String enemyelm(int userID){
		String eneID =geteneID(userID);
		DBController reader = new DBController();
		String enement[] = reader.doget("SELECT elm FROM sfenechara WHERE eneID = " + eneID );
		return enement[0];
	}
}
