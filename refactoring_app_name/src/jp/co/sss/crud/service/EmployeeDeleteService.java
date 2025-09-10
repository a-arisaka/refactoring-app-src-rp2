package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;

public class EmployeeDeleteService implements IEmployeeService{

	Employee employee = new Employee();
	//削除のメソッド
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		ConsoleWriter.deleteEmpId();
		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();
		//入力を受け取る
		int empId = (int) empIdReader.input();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		//DAOクラスの削除メソッドを呼出
		Integer employees = employeeDAO.delete(empId);
		if(employees==1) {
			ConsoleWriter.delete();
		}
		
	}

}
