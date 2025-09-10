package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {

	public static void printUnknown() {
	//「該当者はいませんでした」
		System.out.println(ConstantMsg.MSG_UNKNOWN);
	}

	//「社員情報を削除しました」
	public static void delete() {
		System.out.println(ConstantMsg.DELETE_COMPLETE);
	}

	//「社員情報を更新しました」
	public static void update() {
		System.out.println(ConstantMsg.UPDATE_COMPLETE);
	}

	//「社員ID\\t社員名\\t性別\\t生年月日\\t部署名」
	public static void show() {
		System.out.println(ConstantMsg.MSG_RECORD);
	}

	//「社員情報を登録しました」
	public static void regisuter() {
		System.out.println(ConstantMsg.REGISTER_COMPLETE);
	}

	//生年月日のエラー
	public static void birthdayError() {
		System.out.println(ConstantMsg.BIRTHDAY_ERROR);
	}

	//スタートメッセージ
	public static void startMessage() {
		System.out.println(ConstantMsg.START_MENU);
	}

	//終了メッセージ
	public static void end() {
		System.out.println(ConstantMsg.SYSTEM_END);
	}

	public static void message(int messageNo) {
		switch (messageNo) {
		case 1:
			//社員名
			System.out.println(ConstantMsg.EMP_NAME);
			break;
		case 2:
			//社員ID
			System.out.println(ConstantMsg.EMP_ID);
			break;
		case 3:
			//性別
			System.out.println(ConstantMsg.GENDER);
			break;
		case 4:
			//生年月日
			System.out.println(ConstantMsg.BIRTHDAY);
			break;
		case 5:
			//部署ID
			System.out.println(ConstantMsg.DEPT_ID);
			break;
		case 6:
			//更新したい社員の社員ID
			System.out.println(ConstantMsg.MSG_UPDATE_EMP_ID);
			break;
		case 7:
			//選択したい部署ID
			System.out.println(ConstantMsg.MSG_DEPT_ID);
			break;
		case 8:
			//削除したい社員の社員ID
			System.out.println(ConstantMsg.MSG_DELETE_EMP_ID);
			break;
		}
	}
}