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

	//社員名
	public static void empName() {
		System.out.println(ConstantMsg.EMP_NAME);
	}

	//社員ID
	public static void empId() {
		System.out.println(ConstantMsg.EMP_ID);
	}

	//性別
	public static void gender() {
		System.out.println(ConstantMsg.GENDER);
	}

	//生年月日
	public static void birthday() {
		System.out.println(ConstantMsg.BIRTHDAY);
	}

	//部署ID
	public static void deptId() {
		System.out.println(ConstantMsg.DEPT_ID);
	}

	//更新したい社員の社員ID
	public static void updateEmpId() {
		System.out.println(ConstantMsg.MSG_UPDATE_EMP_ID);
	}

	//削除したい社員の社員ID
	public static void deleteEmpId() {
		System.out.println(ConstantMsg.MSG_DELETE_EMP_ID);
	}

	//選択したい部署ID
	public static void selectDeptId() {
		System.out.println(ConstantMsg.MSG_DEPT_ID);
	}

}