package com.bluedsky.bean;

public class InspectionPersonnel {
	private String id; // 账号
	private String password; // 密码
	private String name; // 姓名
	private String sex; // 性别
	private String section; // 科室
	private String precinct; // 管辖区域
	private String tel; // 联系方式
	private String idCardNo; // 身份证号

	public InspectionPersonnel() {
	}

	public InspectionPersonnel(String id, String sex, String name, String password, String section, String precinct,
			String tel, String idCardNo) {
		super();
		this.id = id;
		this.sex = sex;
		this.name = name;
		this.password = password;
		this.section = section;
		this.precinct = precinct;
		this.tel = tel;
		this.idCardNo = idCardNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getPrecinct() {
		return precinct;
	}

	public void setPrecinct(String precinct) {
		this.precinct = precinct;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

}
