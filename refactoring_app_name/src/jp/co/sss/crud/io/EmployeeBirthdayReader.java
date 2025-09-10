package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeBirthdayReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.BIRTHDAY_ERROR;
	}

	@Override
	public boolean isValid(String inputString) {
		// nullまたは空文字列の場合は無効
		if (inputString == null || inputString.isEmpty()) {
			return false;
		}
		// 正規表現を使い、生年月日が正規の型になっているかチェック
		return inputString.matches("^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$");

	}

	@Override
	public boolean isParseInt() {
		return false;
	}
}
