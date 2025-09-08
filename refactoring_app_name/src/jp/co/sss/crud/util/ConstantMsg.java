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
	public static final String MSG_UNKNOWN = "該当者はいませんでした";
	public static final String MSG_RECORD = "社員ID\\t社員名\\t性別\\t生年月日\\t部署名";
	public static final String GENDER_UNKNOWN = "\"回答なし\" + \"\\t\"";
	public static final String GENDER_MALE= "男性" + "\t";
	public static final String GENDER_FEMALE = "女性" + "\t";
	public static final String GENDER_OTHER = "その他" + "\t";
	public static final String DEPT_ID_1 = "営業部";
	public static final String DEPT_ID_2 = "経理部";
	public static final String DEPT_ID_3 = "総務部";
	public static final String REGISTER_COMPLETE = "社員情報を登録しました";
	public static final String UPDATE_COMPLETE = "社員情報を更新しました";
	public static final String DELETE_COMPLETE = "社員情報を削除しました";
	
	
	
			
	
}
