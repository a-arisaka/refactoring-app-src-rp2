package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO implements IEmployeeDAO{

	@Override
	public List<Employee> findAll() throws SystemErrorException {		
		   List<Employee> employeeList = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            
	            connection = DBManager.getConnection();
	            preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);
	            resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()) {
	            	  int empId = resultSet.getInt("emp_id");
	                  String empName = resultSet.getString("emp_name");
	                  int gender = resultSet.getInt("gender");
	                  Date birthday = resultSet.getDate("birthday");
	                  Department deptName = (Department) resultSet.getObject("depe_name");
	                  
	                  Employee employee = new Employee(empId, empName, gender, birthday, deptName);
	                  employeeList.add(employee);
	            }

	        } catch (SQLException | ClassNotFoundException e) { 
	            // チェック例外であるSystemErrorExceptionをスロー
	            throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
	        } finally {
	         
	        }
	        return employeeList;
	}

	@Override
	public List<Employee> findByEmployeeName(String searchName) throws SystemErrorException {
		return null;
	}

	@Override
	public List<Employee> findByDeptId(int deptId) throws SystemErrorException {
		return null;
	}

	@Override
	public void insert(Employee employee) throws SystemErrorException {
		
	}

	@Override
	public Integer update(Employee employee) throws SystemErrorException {
		
		return null;
	}

	@Override
	public Integer delete(Integer empId) throws SystemErrorException {
		
		return null;
	}

}
