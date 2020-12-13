package com.pywl;

import com.pywl.entity.Department;
import com.pywl.mapper.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description 测试 部门
 * @Author DongPo
 * @Date 2020-12 16:30
 */
public class TestDepartmentMapper {

	// 从XML中构建 SqlSessionFactory
	public SqlSessionFactory getFactory() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		return new SqlSessionFactoryBuilder().build(is);
	}

	/**
	 * 根据id查询部门，同时查出部门所有员工
	 *
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
			Department department = departmentMapper.findByPrimaryIdIncludeEmps(1);
			System.out.println(department);
			System.out.println(department.getEmps());
		}
	}

	/**
	 * 根据id查询部门，同时查出部门所有员工，分步查询
	 *
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
			Department department = departmentMapper.findByPrimaryIdIncludeEmpsStep(1);
			System.out.println(department.getDeptName());
			System.out.println(department.getEmps());
		}
	}
}
