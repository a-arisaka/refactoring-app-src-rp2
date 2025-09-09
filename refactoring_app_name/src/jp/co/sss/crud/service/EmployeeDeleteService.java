package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeDeleteService implements IEmployeeService{
	Employee emp = new Employee();
	
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Integer employees = employeeDAO.delete(emp.getEmpId());
		if(employees==1) {
			ConsoleWriter.delete();
		}
		
	}

}
