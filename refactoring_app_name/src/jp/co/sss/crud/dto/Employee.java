package jp.co.sss.crud.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sss.crud.util.ConstantMsg;

//社員テーブル
public class Employee {
	  /** 従業員ID */
    private int empId;

    /** 従業員名 */
    private String empName;

    /** 性別 */
    private int gender;

    /** 誕生日 */
    private Date birthday;

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
    public Employee(int empId, String empName, int gender, Date birthday, Department department) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

	public Department getDepartment() {
		return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
  //Employee#toStringのオーバーライド
    @Override
     public String toString() { 
      String gender = ""; 
      if (this.gender == 1) { 
       gender = ConstantMsg.GENDER_MALE; 
      } else if (this.gender == 2) { 
       gender = ConstantMsg.GENDER_FEMALE ; 
      } 
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      String formattedBirthday = "";
      if (this.birthday != null) {
          // formatメソッドで Date -> String に変換
          formattedBirthday = sdf.format(this.birthday);
      }
     
      return empId + "\t" + empName + "\t" + gender + "\t" + formattedBirthday
        + "\t" + department.getDeptName(); 
   } 
}
