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

public class EmployeeDAO implements IEmployeeDAO {

	@Override
	public List<Employee> findAll() throws SystemErrorException {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//DBに接続
			connection = DBManager.getConnection();
			//ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);
			//SQL文を実行
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
		}
		return employeeList;
	}

	/**
	 * 社員名検索
	 * 
	 * @param searchName 検索社員名 
	 * @return {@code List<Employee>} 検索社員名を含むエンティティリスト
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
	@Override
	public List<Employee> findByEmployeeName(String searchName) throws SystemErrorException {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//DBに接続
			connection = DBManager.getConnection();
			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + ((Employee) employeeList).getEmpName() + "%");

			// SQL文を実行
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
		}
		return employeeList;
	}

	@Override
	public List<Employee> findByDeptId(int deptId) throws SystemErrorException {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptId);

			// SQL文を実行
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
		}
		return employeeList;
	}

	@Override
	public void insert(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			java.util.Date utilBirthday = employee.getBirthday();
			java.sql.Date sqlBirthday = new java.sql.Date(utilBirthday.getTime());
			preparedStatement.setDate(3, sqlBirthday);

			// Departmentオブジェクトから部署IDを取得してセット
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());

			// INSERT文を実行
			preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// チェック例外であるSystemErrorExceptionをスロー
			throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
		}

	}

	@Override
	public Integer update(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0; // 結果を格納する変数

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			java.util.Date utilBirthday = employee.getBirthday();
			java.sql.Date sqlBirthday = new java.sql.Date(utilBirthday.getTime());
			preparedStatement.setDate(3, sqlBirthday);
			// Departmentオブジェクトから部署IDを取得してセット
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());

			// WHERE句のパラメータを追加
			preparedStatement.setInt(5, employee.getEmpId());
			// SQL文を実行し、更新された行数を取得
			result = preparedStatement.executeUpdate();

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// チェック例外であるSystemErrorExceptionをスロー
			throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
		}
		return result;

	}

	@Override
	public Integer delete(Integer empId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, empId);

			preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// チェック例外であるSystemErrorExceptionをスロー
			throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
		}

		return 1;
	}

	//社員IDで検索するメソッド(配布されたコードに新たに追加したもの)
	/**
	 * 社員IDによる1件検索
	 * @param empId 検索する社員ID
	 * @return 見つかったEmployeeオブジェクト、見つからなければnull
	 * @throws SystemErrorException
	 */

	@Override
	public List<Employee> findByEmpId(int empId) throws SystemErrorException {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//DBに接続
			connection = DBManager.getConnection();
			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_SELECT_BY_EMP_ID);
			preparedStatement.setInt(1, empId);
			resultSet = preparedStatement.executeQuery();

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int empSearchId = resultSet.getInt("emp_id");
				String empName = resultSet.getString("emp_name");
				int gender = resultSet.getInt("gender");
				Date birthday = resultSet.getDate("birthday");
				Department deptName = (Department) resultSet.getObject("depe_name");

				Employee employee = new Employee(empSearchId, empName, gender, birthday, deptName);
				employeeList.add(employee);
			}

		} catch (SQLException | ClassNotFoundException e) {
			// チェック例外であるSystemErrorExceptionをスロー
			throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
		}
		return employeeList;

	}

}
