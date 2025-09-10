package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService implements IEmployeeService {
	//全件検索のメソッド
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employeeList = employeeDAO.findAll();
		//検索結果がないとき、「該当者はいませんでした」というメッセージを表示
		if (employeeList.isEmpty()) {
			ConsoleWriter.printUnknown();
		} else {
			ConsoleWriter.show();
			//employeeのtoStringメソッドが呼び出される
			for (Employee employee : employeeList) {
				System.out.println(employee);
			}
		}

	}

}
