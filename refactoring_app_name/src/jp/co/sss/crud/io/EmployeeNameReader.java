package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeNameReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.NAME_ERROR;
	}

	@Override
	public boolean isValid(String inputString) {
		// nullまたは空文字列の場合は無効
		if (inputString == null || inputString.isEmpty()) {
			return false;
		}
		// 正規表現を使いひらがな、カタカナ、スペースで構成されているかチェック
		return inputString.matches("^[\\p{L} \\u3040-\\u309F\\u30A0-\\u30FF]+$");

	}
	
	/**
	 * コンソール入力した文字列をintに変換するかどうかを返す。
	 * 
	 * @return inputをint型へ変換する必要があるときはtrue、そうでないときはfalseを返す。
	 */
	@Override
	public boolean isParseInt() {
		return false;
	}

}
