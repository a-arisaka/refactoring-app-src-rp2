package jp.co.sss.crud.io;

public class MenuNoReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "メニュー番号を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		// nullまたは空文字列の場合は無効
		if (inputString == null || inputString.isEmpty()) {
			return false;
		}
		// 正規表現を使い、文字列が1文字以上の半角数字で構成されているかチェック
		return inputString.matches("\\d+");

	}

	@Override
	public boolean isParseInt() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
