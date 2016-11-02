package jp.ac.oit.igakilab.dwr.multiple;

public class LoginSystem {
	public int login(UserData user) throws InvalidValueException{
		String username = user.getusername();
		String password = user.getpassword();
		DBController reader = new DBController();

		String[] ID = reader.doget("SELECT userID FROM user WHERE username LIKE '" + username + "'");
		if(ID.length == 0){
			throw new InvalidValueException("IDもしくはパスワードが間違っています");
		}
		String[] result = reader.doget("SELECT password FROM user WHERE username like '"+username+"'");

		if(result[0].equals(password)){
			return Integer.valueOf(ID[0]);

		}
		throw new InvalidValueException("IDもしくはパスワードが間違っています");

	}
	public void newuser(UserData user) throws InvalidValueException{
		String username = user.getusername();
		String password = user.getpassword();
		DBController reader = new DBController();

		String[] ID = reader.doget("SELECT userID FROM user WHERE username LIKE '" + username + "'");
		if(ID.length >= 1){
			throw new InvalidValueException("このIDは使用できません");
		}
		String[] result = reader.doget("SELECT COUNT(userID)+1 FROM user");
		reader.dowrite("INSERT INTO user VALUES(" +  result[0] +",'" + username + "','"+password+"',2,18,22,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,99999,5,1,0,0)");
	}

}
