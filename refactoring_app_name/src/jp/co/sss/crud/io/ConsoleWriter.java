package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	/*	・printメソッドをラッピングし、コンソールにメッセージを出力する。メッセージはConstantsクラスにまとめる 
		・DTOのコンソール出力はtoStringメソッドを活用する。 
	*/
	 /**
     * メッセージとDTOオブジェクトを組み合わせてコンソールに出力
     * @param ConstantMsgから渡された定数を表示
     * @param dto 表示するDTOオブジェクト
     */
 public static void print(String message, Object dto) {
	 System.out.println(message + dto);
 }
 /**
  * DTOオブジェクト単体をコンソールに出力
  * @param dto 表示するDTOオブジェクト（toString()メソッドが呼ばれる）
  */
 public static void print(Object dto) {
 
     System.out.println(dto);
 }
 
 /**
  * メッセージ単体でコンソールに出力
  * @param ConstantMsgから渡された定数
  */
 public static void print(String message) {
	 System.out.println(message);
 }
 
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
 
}