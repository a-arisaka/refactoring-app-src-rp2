package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {

	public static void printUnknown() {
		System.out.println(ConstantMsg.MSG_UNKNOWN);
	}

	public static void delete() {
		System.out.println(ConstantMsg.DELETE_COMPLETE);
	}

	public static void update() {
		System.out.println(ConstantMsg.UPDATE_COMPLETE);
	}

	public static void show() {
		System.out.println(ConstantMsg.MSG_RECORD);
	}

	public static void regisuter() {
		System.out.println(ConstantMsg.REGISTER_COMPLETE);
	}

	public static void message(int messageNo) {
		switch (messageNo) {
		case 1:
			System.out.println(ConstantMsg.EMP_NAME);
			break;
		case 2:
			System.out.println(ConstantMsg.EMP_ID);
			break;
		case 3:
			System.out.println(ConstantMsg.GENDER);
			break;
		case 4:
			System.out.println(ConstantMsg.BIRTHDAY);
			break;
		case 5:
			System.out.println(ConstantMsg.DEPT_ID);
			break;
		case 6:
			System.out.println(ConstantMsg.MSG_UPDATE_EMP_ID);
			break;
		case 7:
			System.out.println(ConstantMsg.MSG_DEPT_ID);
			break;
		case 8:
			System.out.println(ConstantMsg.MSG_DELETE_EMP_ID);
			break;
		}
	}

	public static void startMessage() {
		System.out.println(ConstantMsg.START_MENU);
	}
	public static void end() {
		System.out.println(ConstantMsg.SYSTEM_END);
	}
}