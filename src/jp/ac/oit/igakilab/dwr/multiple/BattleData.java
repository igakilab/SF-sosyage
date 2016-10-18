package jp.ac.oit.igakilab.dwr.multiple;

public class BattleData {
	    private String userID = "";
	    private int c1 = 1;
	    private int c2 = 1;
	    private int c3 = 1;

	    public BattleData(){
	    }

	    public void setusername(String userID){
	        this.userID = userID;
	    }

	    public String getuserID(){
	        return userID;
	    }

		public int getc1() {
			return c1;
		}

		public void set1(int c1) {
			this.c1 = c1;
		}
		public int getc2() {
			return c2;
		}

		public void setc2(int c2) {
			this.c2 = c2;
		}
		public int getc3() {
			return c3;
		}

		public void set3(int c3) {
			this.c1 = c3;
		}

}
