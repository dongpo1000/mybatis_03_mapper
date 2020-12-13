package com.pywl.entity;

import java.util.List;

/**
 * @Description 部门
 * @Author DongPo
 * @Date 2020-12 14:45
 */
public class Department {

	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 员工列表
	 */
	private List<Employee> emps;

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public Department() {
	}

	public Department(Integer id, String deptName) {
		this.id = id;
		this.deptName = deptName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department{" +
			"id=" + id +
			", deptName='" + deptName + '\'' +
			'}';
	}
}
