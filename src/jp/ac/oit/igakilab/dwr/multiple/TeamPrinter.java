package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class TeamPrinter {
	public List<String> fetch(LoginData user) throws InvalidValueException {
        List<String> list = new ArrayList<>();
        int userID = user.getuserID();
        DBReader reader = new DBReader();
        String[] result = reader.doget("SELECT slot1,slot2,slot3 FROM user WHERE userID == 1",3);

        for(int i= 1; i<=max; i++){
        	if(i % multiple == 0){
        		list.add("ryokun");
        	}else{
        		list.add(Integer.toString(i));
        	}
        }

        return list;
}
}
