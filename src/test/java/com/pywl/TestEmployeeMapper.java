package com.pywl;

import com.pywl.entity.Employee;
import com.pywl.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 测试 EmployeeMapper
 * @Author DongPo
 * @Date 2020-12 20:08
 */
public class TestEmployeeMapper {

	// 从 XML 中构建 SqlSessionFactory
	private SqlSessionFactory getFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 使用 mapper 接口，使用 EmployeeMapper.xml
	 *
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Employee employee = employeeMapper.selectByPrimaryId(1);
			System.out.println(employee);
		}
	}

	/**
	 * 测试插入
	 *
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		// 使用opensession()需要手动提交，若使用 openSession(true)则会自动提交
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Employee employee = new Employee(null, "Jerry2", "2", "jerry@163.com");
			// 会将影响的行数返回自动封装到方法返回值中
			Integer insertNumber = employeeMapper.insert(employee);
			System.out.println(insertNumber);
			session.commit();
			System.out.println(employee);
		}
	}

	/**
	 * 测试更新
	 *
	 * @throws IOException
	 */
	@Test
	public void test3() throws IOException {
		try (SqlSession session = getFactory().openSession(true)) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Employee employee = new Employee(4, "Jerry", "1", "Jerry@163.com");
			// 返回值是 Integer/Long/Boolean 时会将返回值自动封装，是 void 的时正常执行，不封装
			Boolean aBoolean = employeeMapper.updateByPrimaryKey(employee);
			System.out.println(aBoolean);
		}
	}

	/**
	 * 测试删除
	 *
	 * @throws IOException
	 */
	@Test
	public void test4() throws IOException {
		try (SqlSession session = getFactory().openSession(true)) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			employeeMapper.deleteByPrimaryKey(4);
		}
	}

	/**
	 * 根据 用户名 模糊查询
	 *
	 * @throws IOException
	 */
	@Test
	public void test5() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			List<Employee> employeeList = employeeMapper.findLikeUserName("%e%");
			System.out.println(employeeList);
		}
	}

	/**
	 * 根据id查询出一条记录，然后封装进map
	 *
	 * @throws IOException
	 */
	@Test
	public void test6() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Map<String, Object> map = employeeMapper.findByPrimaryIdAndReturnMap(1);
			System.out.println(map);
		}
	}

	/**
	 * 根据 id 查询，返回以 id 为键的 map
	 *
	 * @throws IOException
	 */
	@Test
	public void test7() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Map<String, Employee> map = employeeMapper.findByIdAndReturnMap(1);
			System.out.println(map);
		}
	}

	/**
	 * 根据 userName 模糊查询，返回以 userName 为键的 map
	 *
	 * @throws IOException
	 */
	@Test
	public void test8() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Map<String, Employee> map = employeeMapper.findLikeUserNameAndReturnMap("%e%");
			System.out.println(map);
		}
	}

	/**
	 * 根据 id和用户名查询
	 *
	 * @throws IOException
	 */
	@Test
	public void test9() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Employee tom = employeeMapper.findByIdAndUserName(1, "tom");
			System.out.println(tom);
		}
	}

	/**
	 * 根据 map 查询
	 *
	 * @throws IOException
	 */
	@Test
	public void test10() throws IOException {
		try (SqlSession session = getFactory().openSession()) {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Map<String, Object> map = new HashMap<>();
			map.put("id", 1);
			map.put("name", "tom");
			Employee employee = employeeMapper.findByMap(map);
			System.out.println(employee);
		}
	}
}
