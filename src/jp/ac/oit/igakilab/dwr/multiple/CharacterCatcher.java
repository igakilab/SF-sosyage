package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class CharacterCatcher {
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
}
