package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeUpdateService implements IEmployeeService {
	Employee emp = new Employee();

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		//更新する社員IDを入力
		ConsoleWriter.updateEmpId();
		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();
		int updateEmpId = (int) empIdReader.input();

		//社員IDで検索
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employeeToUpdate = (Employee) employeeDAO.findByEmpId(updateEmpId);
		if (employeeToUpdate == null) {
			ConsoleWriter.printUnknown();
			return;
		}
		//新しい社員名の入力
		ConsoleWriter.empName();
		EmployeeNameReader nameReader = new EmployeeNameReader();
		String newName = (String) nameReader.input();

		//新しい性別の入力
		ConsoleWriter.gender();
		EmployeeGenderReader genderReader = new EmployeeGenderReader();
		Integer newGender = (Integer) genderReader.input();

		//新しい生年月日の入力
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

		//新しい部署IDの入力
		ConsoleWriter.deptId();
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();
		Integer newDeptId = (Integer) deptIdReader.input();
		
		
		//新しい値をDTOに渡す
		employeeToUpdate.setEmpName(newName);
		employeeToUpdate.setGender(newGender);
		employeeToUpdate.setBirthday(newBirthday);
		employeeToUpdate.getDepartment().setDeptId(newDeptId);

		Integer result = employeeDAO.update(employeeToUpdate);

		if (result == 1) {
			ConsoleWriter.update();
		}
	}

}
