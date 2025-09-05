package jp.co.sss.crud.io;

public class EmployeeNameReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "名前を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		// nullまたは空文字列の場合は無効
		if (inputString == null || inputString.isEmpty()) {
			return false;
		}
		// 
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
