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
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();
		Integer deptId = (Integer) deptIdReader.input();
		department.setDeptId(deptId);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employeeList = employeeDAO.findByDeptId(deptId);
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
