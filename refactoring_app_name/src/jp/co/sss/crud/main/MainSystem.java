package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;

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
		EmployeeAllFindService employeeAllFindService = new EmployeeAllFindService();
		EmployeeFindByEmpNameService employeeFindByEmpNameService = new EmployeeFindByEmpNameService();
		EmployeeFindByDeptIdService employeeFindByDeptIdService = new EmployeeFindByDeptIdService();
		EmployeeDeleteService employeeDeleteService = new EmployeeDeleteService();
		EmployeeRegisterService employeeRegisterService = new EmployeeRegisterService();
		EmployeeUpdateService employeeUpdateService = new EmployeeUpdateService();
		MenuNoReader menuNoReader = new MenuNoReader();

		int menuNo = 0;

		do {
			// メニューの表示
			ConsoleWriter.startMessage();

			// メニュー番号の入力
			menuNo = (int) menuNoReader.input();

			// 機能の呼出
			try {
				switch (menuNo) {
				case 1:
					//全件検索機能の呼出
					employeeAllFindService.execute();
					break;

				case 2:
					// 社員名検索機能の呼出
					employeeFindByEmpNameService.execute();
					break;

				case 3:
					// 部署ID検索機能の呼出
					employeeFindByDeptIdService.execute();
					break;

				case 4:
					employeeRegisterService.execute();
					break;

				case 5:
					// 更新機能の呼出
					employeeUpdateService.execute();
					break;

				case 6:
					// 削除機能の呼出
					employeeDeleteService.execute();
					break;

				}
			} catch (IllegalInputException e) {//不正な入力があった場合、ループに戻る 
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			} catch (SystemErrorException e) {//継続不能なエラーの場合、ループを抜ける 
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}
		} while (menuNo != 7);
		ConsoleWriter.end();
	}
}
