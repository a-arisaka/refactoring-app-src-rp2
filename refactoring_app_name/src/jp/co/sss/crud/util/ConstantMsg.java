package jp.co.sss.crud.util;

public class ConstantMsg {
	//固定値のメッセージを記述するクラス
	//インスタンス化を禁止する
	private ConstantMsg() {
	}

	public static final int MENU_SELECT_ALL = 1;
	public static final int MENU_SEARCH_EMP_NAME = 2;
	public static final int MENU_SEARCH_DEPT_ID = 3;
	public static final int MENU_INSERT = 4;
	public static final int MENU_UPDATE = 5;
	public static final int MENU_DELETE = 6;
	
	public static final String MSG_SYSTEM_ERROR = "エラーが発生しました";
}
