package jp.ac.oit.igakilab.dwr.multiple;

public class LoginSystem {
	public int login(UserData user){
		String username = user.getusername();
		String password = user.getpassword();
		DBController reader = new DBController();
		String[] result = reader.doget("SELECT password FROM user WHERE username like '"+username+"'");
		String[] ID = reader.doget("SELECT userID FROM user WHERE username LIKE '" + username + "'");

		if(result[0].equals(password)){
			return Integer.valueOf(ID[0]);
		}
		return -1;

	}
	public void newuser(UserData user){
		String username = user.getusername();
		String password = user.getpassword();
		DBController reader = new DBController();
		String[] result = reader.doget("SELECT COUNT(userID) FROM user");
		reader.dowrite("INSERT INTO user (userID,username,password,slot1,slot2,slot3,chara1,chara2,chara3,chara4,chara5,chara6,chara7,chara8,chara9,chara10,chara11,chara12,chara13,turn,bestturn)VALUES(" +result[0] +",'"+ username +"','"+password+"',4,5,6,0,0,0,1,1,1,0,0,0,0,0,0,0,0,99999)");
	}

}
