package jp.co.sss.crud.dto;
//部署テーブル

public class Department {
	/**部署ID*/
	private int deptId;

	/**部署名*/
	private String deptName;

	/**
	 * デフォルトコンストラクタ
	 */
	public Department() {

	};

	/**
	* 全てのフィールドを初期化するコンストラクタ
	* @param deptId 部署ID
	* @param deptName 部署名
	*/
	public Department(int deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}

	// --- ゲッターとセッター ---

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
