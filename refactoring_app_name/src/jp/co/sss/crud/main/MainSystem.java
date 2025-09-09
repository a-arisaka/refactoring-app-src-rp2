package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
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

		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		EmployeeAllFindService employeeAllFindService = new EmployeeAllFindService();
		EmployeeFindByEmpNameService employeeFindByEmpNameService = new EmployeeFindByEmpNameService();
		EmployeeFindByDeptIdService employeeFindByDeptIdService = new EmployeeFindByDeptIdService();
		EmployeeDeleteService employeeDeleteService = new EmployeeDeleteService();
		EmployeeRegisterService employeeRegisterService = new EmployeeRegisterService();
		EmployeeUpdateService employeeUpdateService = new EmployeeUpdateService();
		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println("=== 社員管理システム ===");
			System.out.println("1.全件表示");
			System.out.println("2.社員名検索");
			System.out.println("3.部署ID検索");
			System.out.println("4.新規登録");
			System.out.println("5.更新");
			System.out.println("6.削除");
			System.out.println("7.終了");
			System.out.print("メニュー番号を入力してください：");

			// メニュー番号の入力
			String menuNoStr = userInput.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case 1:
				//全件検索機能の呼出
				employeeAllFindService.execute();

				break;

			case 2:
				// 社員名検索
				System.out.print("社員名:");
				
				// 社員名検索機能の呼出
				employeeFindByEmpNameService.execute();
				break;

			case 3:
				// 検索する部署IDを入力
				System.out.print("部署ID(1:営業部、2:経理部、3:総務部)を入力してください:");
				// 検索機能の呼出
				employeeFindByDeptIdService.execute();
				break;

			case 4:

				employeeRegisterService.execute();
				break;

			case 5:

				// 更新機能の呼出
				employeeDeleteService.execute();

				break;

			case 6:
				// 削除する社員IDを入力
				System.out.print("削除する社員の社員IDを入力してください：");

				// 削除機能の呼出
				employeeUpdateService.execute();
				break;

			}
		} while (menuNo != 7);
		System.out.println("システムを終了します。");
	}
}
