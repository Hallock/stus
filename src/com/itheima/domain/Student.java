package com.itheima.domain;

import java.util.Date;

/**
 * 这是学封装的对象 bean
 * @author xiaomi
 */
public class Student {

	
	private int sid;
	private int sno;
	private String sname;
	private String gender;
	private String phone;
	private String cs;
	private String grade;
	private Date birthday;
	private int ch;
	private int en;
	private int math;
	private int physics;
	private int chemistry;
	private String password;

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public void setEn(int en) {
		this.en = en;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getCh() {
		return ch;
	}

	public int getEn() {
		return en;
	}

	public int getMath() {
		return math;
	}

	public int getPhysics() {
		return physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sno, String sname, String gender, String phone, String cs, String grade, Date birthday) {
		this.sno = sno;
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.cs = cs;
		this.grade = grade;
		this.birthday = birthday;

	}

	public Student(int sid, int sno, String sname, String gender, String phone, String cs, String grade, Date birthday) {
		this.sid = sid;
		this.sno = sno;
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.cs = cs;
		this.grade = grade;
		this.birthday = birthday;
	}

	public Student(int sid, int sno, String sname, int ch, int en, int math, int physics, int chemistry) {
		this.sid = sid;
		this.sno = sno;
		this.sname = sname;
		this.ch = ch;
		this.en = en;
		this.math = math;
		this.physics = physics;
		this.chemistry = chemistry;
	}

	public int getSid() {
		return sid;
	}

	public int getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public String getGender() {
		return gender;
	}

	public String getPhone() {
		return phone;
	}

	public String getCs() {
		return cs;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGrade() {
		return grade;
	}

	public Date getBirthday() {
		return birthday;
	}

	@Override
	public String toString() {
		return "Student{" +
				"sid=" + sid +
				", sno=" + sno +
				", sname='" + sname + '\'' +
				", gender='" + gender + '\'' +
				", phone='" + phone + '\'' +
				", cs='" + cs + '\'' +
				", grade='" + grade + '\'' +
				", birthday=" + birthday +
				", ch=" + ch +
				", en=" + en +
				", math=" + math +
				", physics=" + physics +
				", chemistry=" + chemistry +
				", password='" + password + '\'' +
				'}';
	}
}
