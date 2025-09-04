package jp.co.sss.crud.db;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeDAO implements IEmployeeDAO{

	@Override
	public List<Employee> findAll() throws SystemErrorException {		
		return null;
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
