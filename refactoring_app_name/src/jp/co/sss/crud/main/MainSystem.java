package jp.co.sss.crud.main;

import static jp.co.sss.crud.util.ConstantMenuNo.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 *初回のコード変更
 *developブランチを利用した変更
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException,
			SystemErrorException, IllegalInputException {
		//サービスクラスの呼び出し
		MenuNoReader menuNoReader = new MenuNoReader();

		int menuNo = 0;

		do {
			// メニューの表示
			try{ 
			ConsoleWriter.startMessage();

			// メニュー番号の入力
			menuNo = (int) menuNoReader.input();
				// 機能の呼出
				
					// 実行可能なメニュー番号（1～6）が入力された場合
					if (menuNo >= MENU_SELECT_ALL && menuNo <= MENU_DELETE) {
						// ファクトリメソッドで適切なサービスのインスタンスを取得
						IEmployeeService service = IEmployeeService.getInstanceByMenuNo(menuNo);
						// サービスの実行
						service.execute();
					}
				
				} catch (IllegalInputException e) {//不正な入力があった場合、ループに戻る 
					System.out.println(e.getMessage());
					System.out.println();
				
				} catch (SystemErrorException e) {//継続不能なエラーの場合、ループを抜ける 
					System.out.println(e.getMessage());
					e.printStackTrace();
					break;
				}
			
		} while (menuNo != MENU_EXIT);
		ConsoleWriter.end();
	}
}
