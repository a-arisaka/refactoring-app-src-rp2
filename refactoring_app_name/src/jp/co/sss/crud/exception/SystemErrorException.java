package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception {
	//例外が起きたときの処理を記入
	/**
	* コンストラクタ
	* @param message エラーメッセージ
	* @param cause 元となった例外
	*/
	public SystemErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
