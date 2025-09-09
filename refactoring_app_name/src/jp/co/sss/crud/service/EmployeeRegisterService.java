package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeRegisterService implements IEmployeeService{
	Employee emp = new Employee();
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee newEmployee = null;
		
		//社員名の入力
		ConsoleWriter.message(1);
		EmployeeNameReader nameReader = new EmployeeNameReader();
		String newName = (String) nameReader.input();

		//性別の入力
		ConsoleWriter.message(3);
		EmployeeGenderReader genderReader = new EmployeeGenderReader();
		Integer newGender = (Integer) genderReader.input();

		//生年月日の入力
		ConsoleWriter.message(4);
		EmployeeBirthdayReader birthdayReader = new EmployeeBirthdayReader();
		java.util.Date newBirthday = (java.util.Date) birthdayReader.input();

		//部署IDの入力
		ConsoleWriter.message(5);
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();
		Integer newDeptId = (Integer) deptIdReader.input();
		
		//新しい値をDTOに渡す
		newEmployee.setEmpName(newName);
		newEmployee.setGender(newGender);
		newEmployee.setBirthday(newBirthday);
		newEmployee.getDepartment().setDeptId(newDeptId);

		employeeDAO.insert(newEmployee);
			
	}
}
