package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService implements IEmployeeService {

	Employee emp = new Employee();

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employeeList = employeeDAO.findAll();
		if (employeeList.isEmpty()) {
			ConsoleWriter.printUnknown();
		} else {
			ConsoleWriter.show();
			for (Employee employee : employeeList) {
				System.out.println(employee);
			}
		}

	}

}
