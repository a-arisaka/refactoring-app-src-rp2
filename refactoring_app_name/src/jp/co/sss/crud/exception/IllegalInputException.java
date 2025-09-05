package jp.co.sss.crud.exception;

public class IllegalInputException extends Exception {

	  /**
     * コンストラクタ
     * @param message エラーメッセージ
     * @param cause 元となった例外 (スタックトレースを維持するため)
     */
    public IllegalInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
