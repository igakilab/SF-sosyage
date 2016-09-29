package jp.ac.oit.igakilab.dwr.multiple;


/**
 * JavaScriptから渡されるオブジェクト．DWRを利用してJavaScriptからフォームをオブジェクトとして渡す場合，下記を満たしている必要がある．
 * 1. すべてのフィールドがprivateであり，publicなsetter/getterを持っている
 * 2. publicなデフォルトコンストラクタ（引数を持たないコンストラクタ）が存在する
 * 3. クラスがpublicである
 * @author Hiroshi
 *
 */
public class LoginData{
    private int userID = 0;
    private int userspot1 = 0;
    private int userspot2 = 0;

    public LoginData(){
    }

    public void setuserID(int userID){
        this.userID = userID;
    }

    public int getuserID(){
        return userID;
    }

	public int getuserspot1() {
		return userspot1;
	}

	public void setuserspot1(int userspot1) {
		this.userspot1 = userspot1;
	}

	public int getuserspot2() {
		return userspot2;
	}

	public void setuserspot2(int userspot2) {
		this.userspot2 = userspot2;
	}



}

