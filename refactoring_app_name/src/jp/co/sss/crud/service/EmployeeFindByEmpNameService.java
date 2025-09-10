package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeFindByEmpNameService implements IEmployeeService {
	//社員名検索メソッド
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		ConsoleWriter.empName();
		EmployeeNameReader nameReader = new EmployeeNameReader();
		String searchName = (String) nameReader.input();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employeeList = employeeDAO.findByEmployeeName(searchName);
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
