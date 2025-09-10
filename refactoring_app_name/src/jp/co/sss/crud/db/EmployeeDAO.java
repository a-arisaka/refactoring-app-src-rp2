package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO implements IEmployeeDAO {
	/**
	 * 全件表示
	 *
	 * @return {@code List<Employee>} 全社員エンティティリスト
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
	@Override
	public List<Employee> findAll() throws SystemErrorException {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

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
				// まずは文字列として日付を取得
				String birthdayStr = resultSet.getString("birthday");

				// 定義したフォーマットで文字列をDateオブジェクトに変換
				Date birthday = null;
				if (birthdayStr != null && !birthdayStr.isEmpty()) {
					try {
						birthday = sdf.parse(birthdayStr);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				Department department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));

				Employee employee = new Employee(empId, empName, gender, birthday, department);
				employeeList.add(employee);
			}

		} catch (SQLException | ClassNotFoundException e) {
			// チェック例外であるSystemErrorExceptionをスロー
			throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
		} finally {
			// リソースの解放処理
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		try {
			//DBに接続
			connection = DBManager.getConnection();
			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			//preparedStatement.setString(1, "%" + ((Employee) employeeList).getEmpName() + "%");★互換性のない型に変換しようとしたためエラー
			preparedStatement.setString(1, "%" + searchName + "%");
			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int empId = resultSet.getInt("emp_id");
				String empName = resultSet.getString("emp_name");
				int gender = resultSet.getInt("gender");
				// まずは文字列として日付を取得
				String birthdayStr = resultSet.getString("birthday");

				// 定義したフォーマットで文字列をDateオブジェクトに変換
				Date birthday = null;
				if (birthdayStr != null && !birthdayStr.isEmpty()) {
					try {
						birthday = sdf.parse(birthdayStr);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				Department department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));

				Employee employee = new Employee(empId, empName, gender, birthday, department);
				employeeList.add(employee);
			}

		} catch (SQLException | ClassNotFoundException e) {
			// チェック例外であるSystemErrorExceptionをスロー
			throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
		} finally {
			// リソースの解放処理
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}

	/**
	 * 部署ID検索
	 * 
	 * @param deptId 部署ID
	 * @return {@code List<Employee>} 検索部署IDを含むエンティティリスト
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
	@Override
	public List<Employee> findByDeptId(int deptId) throws SystemErrorException {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
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
				// 文字列として日付を取得
				String birthdayStr = resultSet.getString("birthday");

				// 定義したフォーマットで文字列をDateオブジェクトに変換
				Date birthday = null;
				if (birthdayStr != null && !birthdayStr.isEmpty()) {
					try {
						birthday = sdf.parse(birthdayStr);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				Department department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));

				Employee employee = new Employee(empId, empName, gender, birthday, department);
				employeeList.add(employee);
			}

		} catch (SQLException | ClassNotFoundException e) {
			// チェック例外であるSystemErrorExceptionをスロー
			throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
		} finally {
			// リソースの解放処理
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}

	/**
	 * 登録
	 * <br>引数のEmployeeから社員名、性別、生年月日、部署番号を取得し新たな社員情報を生成する。
	 * <br>社員IDは自動採番機能を用いること
	 * 
	 * @param employee
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
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
			java.util.Date birthday = employee.getBirthday();
			if (birthday != null) {
				// 誕生日がセットされている場合、Timestampとして設定
				preparedStatement.setTimestamp(3, new java.sql.Timestamp(birthday.getTime()));
			} else {
				// 誕生日がnullの場合、DBにもNULLを設定
				preparedStatement.setNull(3, java.sql.Types.TIMESTAMP);
			}

			// Departmentオブジェクトから部署IDを取得してセット
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());

			// INSERT文を実行
			preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// チェック例外であるSystemErrorExceptionをスロー
			throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
		} finally {
			// リソースの解放処理
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 社員情報を1件更新する
	 * <br>引数のEmployeeから社員ID、社員名、性別、生年月日、部署番号を取得し社員情報を更新する。
	 * 
	 * @param employee
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
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
			java.util.Date birthday = employee.getBirthday();
			if (birthday != null) {
				// 誕生日がセットされている場合、Timestampとして設定
				preparedStatement.setTimestamp(3, new java.sql.Timestamp(birthday.getTime()));
			} else {
				// 誕生日がnullの場合、DBにもNULLを設定
				preparedStatement.setNull(3, java.sql.Types.TIMESTAMP);
			}
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
		} finally {
			// リソースの解放処理
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	/**
	 * 社員情報を1件削除する
	 * <br>引数のEmployeeから社員IDから社員情報を削除する。
	 * 
	 * @param empId 
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
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
		} finally {
			// リソースの解放処理
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	public Employee findByEmpId(int empId) throws SystemErrorException {
		Employee employee = null; // 返却用オブジェクト
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = ConstantSQL.SQL_SELECT_BY_EMP_ID;

		try {
			//DBに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, empId);
			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int empSearchId = resultSet.getInt("emp_id");
				String empName = resultSet.getString("emp_name");
				int gender = resultSet.getInt("gender");
				String birthdayStr = resultSet.getString("birthday");

				Date birthday = null;
				if (birthdayStr != null && !birthdayStr.isEmpty()) {
					try {
						birthday = sdf.parse(birthdayStr);
					} catch (ParseException e) {
						// エラーを無視せず、システム例外として通知する
						throw new SystemErrorException("日付フォーマットが不正です: " + birthdayStr, e);
					}
				}
				Department department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));

				// 見つかった従業員をセット
				employee = new Employee(empSearchId, empName, gender, birthday, department);
			}

		} catch (SQLException |

				ClassNotFoundException e) {
			throw new SystemErrorException("システムエラー: データベース処理中に問題が発生しました。", e);
		} finally {
			// リソースの解放処理
			try {
				if (resultSet != null) {// resultSetをクローズ
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;

	}

}
