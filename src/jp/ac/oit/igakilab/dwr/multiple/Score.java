package jp.ac.oit.igakilab.dwr.multiple;

public class Score {
	public  int scorecount (int turn,int userID){
		DBController reader = new DBController();
		String[] result = reader.doget("SELECT nextenemy FROM user WHERE userID = " + userID );
		reader.dowrite("UPDATE user SET gachacount = " + turn +" WHERE userID = "+userID);
		int x = Integer.valueOf(result[0]);
		reader.dowrite("UPDATE user SET nextenemy = " + (x+1) +" WHERE userID = "+userID);
		return turn;
	}
}
