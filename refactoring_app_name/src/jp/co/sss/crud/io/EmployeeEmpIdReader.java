package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeEmpIdReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.HALF_WIDTH_ERROR;
	}

	@Override
	public boolean isValid(String inputString) {
		/**
		 * 入力文字列のバリデーションメソッド
		 * 
		 * @param inputString コンソール入力した文字列
		 * @return inputStringが適正な値であるときはtrue、そうでないときはfalseを返す。
		 */
		// nullまたは空文字列の場合は無効
		if (inputString == null || inputString.isEmpty()) {
			return false;
		}
		// 正規表現を使い、文字列が1文字以上の半角数字で構成されているかチェック
		return inputString.matches("\\d+");

	}

	@Override
	public boolean isParseInt() {

		return true;
	}

}
