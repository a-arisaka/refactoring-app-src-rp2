package jp.co.sss.crud.dto;

import java.time.LocalDate;
//社員テーブル
public class Employee {
	  /** 従業員ID */
    private int empId;

    /** 従業員名 */
    private String empName;

    /** 性別 */
    private String gender;

    /** 誕生日 */
    private LocalDate birthday;

    /** 所属部署  */
    private Department department;

    // --- コンストラクタ ---

    /**
     * デフォルトコンストラクタ
     */
    public Employee() {
    }

    /**
     * 全てのフィールドを初期化するコンストラクタ
     * @param empId 従業員ID
     * @param empName 従業員名
     * @param gender 性別
     * @param birthday 誕生日
     * @param department 所属部署
     */
    public Employee(int empId, String empName, String gender, LocalDate birthday, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.birthday = birthday;
        this.department = department;
    }

    // --- ゲッターとセッター ---

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
