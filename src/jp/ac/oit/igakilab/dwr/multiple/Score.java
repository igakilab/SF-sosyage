package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class Score {
	public  List<String> scorecount (int turn,int userID){
		DBController reader = new DBController();
		List<String> list = new ArrayList<>();
		int score;
		String[] result = reader.doget("SELECT nextenemy FROM user WHERE userID = " + userID );
		int x = Integer.valueOf(result[0])+1;
		//スコアに対するレア度でのボーナス用変数
		int rare=0;
		//スコアに対するターン数でのボーナス用変数
		int tb=10;
		int gacha =0;
		if(turn<10){
			tb -= turn;
		}else{
			tb=1;
		}
		String[] slot = reader.doget("SELECT slot1,slot2,slot3 FROM user WHERE userID = " + userID );
		for(int i=0;i<3;i++){
			rare = rare + Integer.valueOf(reader.doget("SELECT rareid FROM sfchara WHERE charaID = "+ slot[i])[0]);
		}
		score = x*rare*tb;
		result = reader.doget("SELECT score FROM user WHERE userID = " + userID );
		reader.dowrite("UPDATE user SET score = " +(Integer.valueOf(result[0])+ score) +" WHERE userID = "+userID);
		list.add(String.valueOf(score));
		result = reader.doget("SELECT gachacount FROM user WHERE userID = " + userID );
		gacha = score /30;
		list.add(String.valueOf(gacha));
		reader.dowrite("UPDATE user SET gachacount = " + (Integer.valueOf(result[0])+gacha) +" WHERE userID = "+userID);
		list.add(String.valueOf(x));
		if(x>5){
			list.add(reader.doget("SELECT score FROM user WHERE userID = " + userID )[0]);
			String checkscore = reader.doget("SELECT score FROM user WHERE userID = " + userID )[0];
			String highscore = reader.doget("SELECT highscore FROM user WHERE userID = " + userID )[0];
			if(Integer.valueOf(checkscore)>Integer.valueOf(highscore)){
				reader.dowrite("UPDATE user SET highscore = " + checkscore +" WHERE userID = "+userID);
			}
			reader.dowrite("UPDATE user SET score = " + 0 +" WHERE userID = "+userID);
			reader.dowrite("UPDATE user SET nextenemy = " + 1 +" WHERE userID = "+userID);
			return list;
		}
		reader.dowrite("UPDATE user SET nextenemy = " + x +" WHERE userID = "+userID);
		return list;
	}

	public String finalscore(int userID){
		DBController reader = new DBController();
		String score = reader.doget("SELECT score FROM user WHERE userID = " + userID )[0];
		String highscore = reader.doget("SELECT highscore FROM user WHERE userID = " + userID )[0];
		if(Integer.valueOf(score)>Integer.valueOf(highscore)){
			reader.dowrite("UPDATE user SET highscore = " + score +" WHERE userID = "+userID);
		}
		//スコアと戦闘履歴の初期化
		return score;
	}
	public  String[] scoreranker (){
		DBController reader = new DBController();
		String[] result = reader.doget("SELECT highscore FROM user ORDER BY highscore DESC");
		return result;
	}
	public  String[] rankerpoint (){
		DBController reader = new DBController();
		String[] result = reader.doget("SELECT username FROM user ORDER BY highscore DESC");
		return result;
	}
}
