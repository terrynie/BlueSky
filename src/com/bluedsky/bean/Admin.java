package com.bluedsky.bean;

public class Admin {
	private String id;// �˺�
	private String password;// ����
	private String name;// ����
	private String tel;// ��ϵ��ʽ
	private String idCardNo;// ���֤��

	public Admin() {
	}

	public Admin(String id, String name, String password, String tel, String idCardNo) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
