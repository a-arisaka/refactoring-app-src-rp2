package jp.co.sss.crud.service;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

/**
 * 社員管理のためのビジネスロジックインターフェース
 */
public interface IEmployeeService {

	  public static final int MENU_SELECT_ALL       = 1;
	    public static final int MENU_SEARCH_EMP_NAME  = 2;
	    public static final int MENU_SEARCH_DEPT_ID   = 3;
	    public static final int MENU_INSERT           = 4;
	    public static final int MENU_UPDATE           = 5;
	    public static final int MENU_DELETE           = 6;
	/**
	 * サービスクラスのインスタンスを生成する
	 * @param menuNo
	 * @return IEmployeeServiceを実装したサービスクラス
	 */
	public static IEmployeeService getInstanceByMenuNo(int menuNo) {
		IEmployeeService newInstance = null;

		/*====menuNoごとにインスタンスを生成する。必要に応じてcaseを追加する====*/
		switch (menuNo) {
		//menu1 全件検索
		case MENU_SELECT_ALL:
			newInstance = new EmployeeAllFindService();
			break;
		case MENU_SEARCH_EMP_NAME:
			newInstance = new EmployeeFindByEmpNameService();
			break;
		case MENU_SEARCH_DEPT_ID:
			newInstance = new EmployeeFindByDeptIdService();
			break;
		case MENU_INSERT:
			newInstance = new EmployeeRegisterService();
			break;
		case MENU_UPDATE:
			newInstance = new EmployeeUpdateService();
			break;
		case MENU_DELETE:
			newInstance = new EmployeeDeleteService();
			break;

		}
		return newInstance;
	}

	/**
	 * ビジネスロジックの実行
	 * DAOのメソッドを呼び出し、ユースケース（登録や更新）を実装する
	 * また実行結果のコンソールへの表示を行う
	 * 
	 * @throws SystemErrorException, IllegalInputException
	 */
	public void execute() throws SystemErrorException, IllegalInputException;

}
