package jp.ac.oit.igakilab.dwr.multiple;

import java.util.Random;

public class GachaSystem {
	public int gachareturn(){
		DBController reader = new DBController();
		String[] result = reader.doget("SELECT raregrade FROM rare");
		int rare = (int) (Math.random() * 100);
		for (int i = 0; i < result.length; ++i) {
			int checker = Integer.valueOf(result[i]);
			if (checker > rare) {
				return i + 1;
			}
			rare -= checker;
		}
		return 0;
	}

	public int gachakekka(LoginData user){
		int userID = user.getuserID();
		DBController reader = new DBController();
		int grade = gachareturn();

		String[] result = reader.doget("SELECT charaID FROM sfchara WHERE rareid = "+grade);

		Random rand = new Random();

		int get = rand.nextInt(result.length);

		int charaid = Integer.valueOf(result[get]);
		reader.dowrite("UPDATE user SET " + "chara" + charaid + " = chara" + charaid + " + 1" + " WHERE userID = " + userID);
		result = reader.doget("SELECT gachacount FROM user WHERE userID =" + userID);
		int x = Integer.valueOf(result[0])-1;
		reader.dowrite("UPDATE user SET gachacount = " + x +" WHERE userID = "+ userID );
		return charaid;
	}

	public int gachacount(int userID){
		DBController reader = new DBController();
		String[] result = reader.doget("SELECT gachacount FROM user WHERE userID = "+userID);
		return Integer.valueOf(result[0]);
	}
}
