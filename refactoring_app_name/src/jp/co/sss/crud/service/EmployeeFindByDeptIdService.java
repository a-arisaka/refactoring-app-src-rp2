package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

//部署IDで探す
public class EmployeeFindByDeptIdService implements IEmployeeService {
	Employee employee = new Employee();
	Department department = new Department();

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		ConsoleWriter.selectDeptId();
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();
		Integer deptId = (Integer) deptIdReader.input();
		department.setDeptId(deptId);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		//DAOクラスのfindByDeptId(deptId)メソッドを呼び出す
		List<Employee> employeeList = employeeDAO.findByDeptId(deptId);
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
