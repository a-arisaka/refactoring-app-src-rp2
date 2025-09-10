package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeRegisterService implements IEmployeeService {
	
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee newEmployee = new Employee();
		Department newDepartment = new Department();

		//社員名の入力
		ConsoleWriter.empName();
		EmployeeNameReader nameReader = new EmployeeNameReader();
		String newName = (String) nameReader.input();

		//性別の入力
		ConsoleWriter.gender();
		EmployeeGenderReader genderReader = new EmployeeGenderReader();
		Integer newGender = (Integer) genderReader.input();

		//生年月日の入力
		ConsoleWriter.birthday();
		EmployeeBirthdayReader birthdayReader = new EmployeeBirthdayReader();
		String birthday = (String) birthdayReader.input();
		java.text.SimpleDateFormat sdFormat = new java.text.SimpleDateFormat("yyyy/MM/dd");
		java.util.Date newBirthday = null;
		try {
			// parseメソッドで文字列を日付に変換
			newBirthday = sdFormat.parse(birthday);
		} catch (java.text.ParseException e) {
			// 日付の形式が正しくない場合のエラー処理
			ConsoleWriter.birthdayError();
			return;
		}

		//部署IDの入力
		ConsoleWriter.deptId();
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();
		Integer newDeptId = (Integer) deptIdReader.input();

		//新しい値をDTOに渡す
		newEmployee.setEmpName(newName);
		newEmployee.setGender(newGender);
		newEmployee.setBirthday(newBirthday);
		newDepartment.setDeptId(newDeptId);
		newEmployee.setDepartment(newDepartment);

		employeeDAO.insert(newEmployee);
		
		if (newEmployee != null && newEmployee.getEmpName() != null && !newEmployee.getEmpName().isEmpty()) {
		ConsoleWriter.regisuter();
		}
	}
}
