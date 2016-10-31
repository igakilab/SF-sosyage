package jp.ac.oit.igakilab.dwr.multiple;

import java.util.ArrayList;
import java.util.List;

public class BattleSystem {
	public List<String> getatkhp(int userID) throws InvalidValueException {
		// 自分のパーティのATとHPを返す
		List<String> list = new ArrayList<>();

		DBController reader = new DBController();
		int atk = 0, hp = 0;

		String[] result = reader.doget("SELECT slot1,slot2,slot3 FROM user WHERE userID = " + userID);
		for (int i = 0; i < 3; ++i) {
			String[] tmp = reader.doget("SELECT atk,hp FROM sfchara WHERE charaID = " + result[i]);
			atk += Integer.valueOf(tmp[0]);
			hp += Integer.valueOf(tmp[1]);
		}

		list.add(String.valueOf(atk));
		list.add(String.valueOf(hp));

		return list;
	}

	public List<String> getenemy(int eneID) throws InvalidValueException {
		// 敵のHPとATと画像のアドレスを返す
		List<String> list = new ArrayList<>();

		DBController reader = new DBController();

		String[] result = reader.doget("SELECT HP,AT,imageaddr FROM sfenechara WHERE eneID = " + eneID);
		list.add(String.valueOf(result[0]));
		list.add(String.valueOf(result[1]));
		list.add(String.valueOf(result[2]));

		return list;
	}

	public List<String> getturn(int userID) throws InvalidValueException {
		// turnをデータベースから取り出す
		List<String> list = new ArrayList<>();
		DBController reader = new DBController();

		String[] result = reader.doget("SELECT turn FROM user WHERE userID = " + userID);
		list.add(String.valueOf(result[0]));

		return list;
	}

	public Double[] battle(BattleData battledata){
		//userIDと味方の行動の読み込み//
		int ID = battledata.getuserID();
		int c1 = battledata.getc1();
		int c2 = battledata.getc2();
		int c3 = battledata.getc3();
		int eneID = battledata.getene();
		//味方の基礎攻撃力
 		double atk = 0;
 		//味方の必殺攻撃力倍率
 		double bai = 1;
 		//敵の必殺攻撃力軽減
 		double los = 1;
		String[] s = null;
		String[] result = null;
		String[] element = null;
		String[] enement = null;
		int[] get = new int[3] ;
		//敵に与える必殺ダメージ,list[1]に格納する
		Double adm = 0.0;
		//味方への回復,list[2]に格納する
		Double ahr = 0.0;
		Double[] list = new Double[4];
		DBController reader = new DBController();
		double feel = 1 ;

		//敵の属性の判定
		enement = reader.doget("SELECT elm FROM sfenechara WHERE eneID = " + eneID );
		//slotのキャラの行動判定
		for(int i = 0;i<3;i++){
			s = reader.doget("SELECT slot" + (i+1) + " FROM user WHERE userID = " + ID );
			get[i] = Integer.valueOf(s[0]);

		}

		//slot1のキャラの行動判定
		if(c1 == 1){
			result = reader.doget("SELECT atk FROM sfchara WHERE charaID = " + get[0]);
			element = reader.doget("SELECT elm FROM sfchara WHERE charaID = " + get[0]);
			feel = feeling(Integer.valueOf(element[0]),Integer.valueOf(enement[0]));
			atk = atk + Double.valueOf(result[0])*feel;
		}else{
			int x = Integer.valueOf((reader.doget("SELECT atype FROM sfchara WHERE charaID = " + get[0])[0]));
			if(x == 1){
				adm  = adm + Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[0])[0]);
			}else if(x == 2){
				ahr  = ahr + Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[0])[0]);
			}else if(x == 3){
				bai = bai * Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[0])[0]);
			}else {
				los = los*Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[0])[0]);
			}
		}
			//slot2のキャラの行動判定//
		if(c2 == 1){
			result = reader.doget("SELECT atk FROM sfchara WHERE charaID = " + get[1]);
			element = reader.doget("SELECT elm FROM sfchara WHERE charaID = " + get[1]);
			feel = feeling(Integer.valueOf(element[0]),Integer.valueOf(enement[0]));
			atk = atk + Double.valueOf(result[0])*feel;
		}else{
			int x = Integer.valueOf((reader.doget("SELECT atype FROM sfchara WHERE charaID = " + get[1])[0]));
			if(x == 1){
				adm  += Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[1])[0]);
			}else if(x == 2){
				ahr  += Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[1])[0]);
			}else if(x == 3){
				bai = bai * Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[1])[0]);
			}else {
				los = los*Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[1])[0]);
			}
		}

		//slot3のキャラの行動判定//
		if(c3 ==1){
			result = reader.doget("SELECT atk FROM sfchara WHERE charaID = " + get[2]);
			element = reader.doget("SELECT elm FROM sfchara WHERE charaID = " + get[2]);
			feel = feeling(Integer.valueOf(element[0]),Integer.valueOf(enement[0]));
			atk = atk + Double.valueOf(result[0])*feel;
		}else{
			int x = Integer.valueOf((reader.doget("SELECT atype FROM sfchara WHERE charaID = " + get[2])[0]));
			if(x == 1){
				adm  += Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[2])[0]);
			}else if(x == 2){
				ahr  += Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[2])[0]);
			}else if(x == 3){
				bai = bai * Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[2])[0]);
			}else {
				los = los*Double.valueOf(reader.doget("SELECT aefe FROM sfchara WHERE charaID = " + get[2])[0]);
			}
		}
		list[0] = atk*bai;
		list[1] = Double.valueOf(reader.doget("SELECT AT FROM sfenechara WHERE eneID = " + eneID)[0])*los;
		list[2] = adm;
		list[3] = ahr;
		return list;

	}

	public double feeling(int my,int ene){
		if((my == 1&& ene == 2)||(my == 2&&ene == 3)||(my == 3&&ene == 1)){
			return 1.25;
		}else if((my == 1&&ene == 3)||(my == 2&&ene == 1)||(my == 3&&ene == 2)){
			return 0.75;
		}

		return 1;
	}

	public int geteneID(int userID){
		DBController reader = new DBController();
		String[] result = reader.doget("SELECT nextenemy FROM user WHERE "+ userID );
		return Integer.valueOf(result[0]);
	}
}