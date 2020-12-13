package com.pywl;

import com.pywl.entity.Employee;
import com.pywl.mapper.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description 测试 EmployeeMapperPlus
 * @Author DongPo
 * @Date 2020-12 13:39
 */
public class TestEmployeeMapperPlus {

	// 从 XML 中构建 SqlSessionFactory
	private SqlSessionFactory getFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 根据id查询
	 *
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapperPlus employeeMapperPlus = session.getMapper(EmployeeMapperPlus.class);
			Employee employee = employeeMapperPlus.findByPrimaryId(1);
			System.out.println(employee);
		}
	}

	/**
	 * 根据id查询，包括部门
	 *
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapperPlus employeeMapperPlus = session.getMapper(EmployeeMapperPlus.class);
			Employee employee = employeeMapperPlus.findByIdIncludeDept(1);
			System.out.println(employee);
			System.out.println(employee.getDept());
		}
	}

	/**
	 * 根据id查询，包括部门
	 *
	 * @throws IOException
	 */
	@Test
	public void test3() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapperPlus employeeMapperPlus = session.getMapper(EmployeeMapperPlus.class);
			Employee employee = employeeMapperPlus.findByIdIncludeDeptStep(1);
			System.out.println(employee);
			System.out.println(employee.getDept());
		}
	}

	/**
	 * 根据id查询，包括部门，测试懒加载
	 *
	 * @throws IOException
	 */
	@Test
	public void test4() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapperPlus employeeMapperPlus = session.getMapper(EmployeeMapperPlus.class);
			Employee employee = employeeMapperPlus.findByIdIncludeDeptStep(1);
			System.out.println(employee.getUserName());
			System.out.println(employee.getDept());
		}
	}

	/**
	 * 根据id查询 使用鉴别器
	 *
	 * @throws IOException
	 */
	@Test
	public void test5() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapperPlus employeeMapperPlus = session.getMapper(EmployeeMapperPlus.class);
			Employee employee = employeeMapperPlus.findByIdIncludeDeptUseDiscriminator(1);
			System.out.println(employee);
			System.out.println(employee.getDept());
		}
	}
}
