package jp.co.sss.crud.io;

public class ConsoleWriter {
	/*	・printメソッドをラッピングし、コンソールにメッセージを出力する。メッセージはConstantsクラスにまとめる 
		・DTOのコンソール出力はtoStringメソッドを活用する。 
	*/
	 /**
     * メッセージとDTOオブジェクトを組み合わせてコンソールに出力
     * @param ConstantMsgから渡された定数を表示
     * @param dto 表示するDTOオブジェクト
     */
 public void print(String message, Object dto) {
	 System.out.println(message + dto);
 }
 /**
  * DTOオブジェクト単体をコンソールに出力
  * @param dto 表示するDTOオブジェクト（toString()メソッドが呼ばれる）
  */
 public void print(Object dto) {
 
     System.out.println(dto);
 }
 
 /**
  * メッセージ単体でコンソールに出力
  * @param ConstantMsgから渡された定数
  */
 public void print(String message) {
	 System.out.println(message);
 }
}
