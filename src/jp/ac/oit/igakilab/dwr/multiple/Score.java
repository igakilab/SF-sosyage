package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class Score {
	public  List<String> scorecount (int turn,int userID){
		DBController reader = new DBController();
		List<String> list = new ArrayList<>();
		String[] result = reader.doget("SELECT score FROM user WHERE userID = " + userID );
		reader.dowrite("UPDATE user SET score = " +(Integer.valueOf(result[0])+ turn) +" WHERE userID = "+userID);
		list.add(String.valueOf(turn));
		result = reader.doget("SELECT gachacount FROM user WHERE userID = " + userID );
		reader.dowrite("UPDATE user SET gachacount = " + (Integer.valueOf(result[0])+turn) +" WHERE userID = "+userID);
		result = reader.doget("SELECT nextenemy FROM user WHERE userID = " + userID );
		int x = Integer.valueOf(result[0])+1;
		if(x>5){
			list.add(String.valueOf(x));
			return list;
		}
		reader.dowrite("UPDATE user SET nextenemy = " + x +" WHERE userID = "+userID);
		return list;
	}
}
