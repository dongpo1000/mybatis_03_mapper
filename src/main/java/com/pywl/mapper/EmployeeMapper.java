package com.pywl.mapper;

import com.pywl.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description mapper 基础功能
 * @Author DongPo
 * @Date 2020-12 20:45
 */
public interface EmployeeMapper {

	/**
	 * 根据 id 查询
	 *
	 * @param id
	 * @return
	 */
	Employee selectByPrimaryId(Integer id);

	/**
	 * 增加
	 * 返回值是 Integer/Long/Boolean 时会将更新数或更新成功与否自动封装自动封装，是 void 的时正常执行，不封装
	 *
	 * @param employee
	 * @return
	 */
	Integer insert(Employee employee);

	/**
	 * 根据主键id 更新
	 * 返回值是 Integer/Long/Boolean 时会将更新数或更新成功与否自动封装自动封装，是 void 的时正常执行，不封装
	 *
	 * @param employee
	 * @return
	 */
	Boolean updateByPrimaryKey(Employee employee);

	/**
	 * 根据 主键id 删除
	 * 返回值是 Integer/Long/Boolean 时会将更新数或更新成功与否自动封装，是 void 的时正常执行，不封装
	 *
	 * @param id
	 */
	void deleteByPrimaryKey(Integer id);

	/**
	 * 根据 用户名 模糊查询
	 *
	 * @param userName
	 * @return
	 */
	List<Employee> findLikeUserName(String userName);

	/**
	 * 返回一条记录的map；key就是列名，值就是对应的值
	 *
	 * @param id
	 * @return
	 */
	Map<String, Object> findByPrimaryIdAndReturnMap(Integer id);


	/**
	 * 根据 id 查询，返回 以 id 为键的 map
	 *
	 * @param id
	 * @return
	 * @MapKey: 告诉mybatis封装这个map的时候使用哪个属性作为map的key
	 */
	@MapKey("id")
	Map<String, Employee> findByIdAndReturnMap(Integer id);

	/**
	 * 根据 userName 模糊查询，返回以 userName 为键的 map
	 * 如果查询出来的记录有 key 相同的情况，会用map.put(K,V)把后查询出来的记录覆盖先查询出的记录
	 *
	 * @param userName
	 * @return
	 */
	@MapKey("userName")
	Map<String, Employee> findLikeUserNameAndReturnMap(String userName);

	/**
	 * 根据 id 和 用户名 查询
	 * 多个参数正确取值：
	 * WHERE id=#{arg0} AND user_name=#{arg1}
	 * 或：WHERE id=#{param1} AND user_name=#{param2}
	 * 或： 使用 @Param 指定
	 *
	 * @param id
	 * @param userName
	 * @return
	 */
	Employee findByIdAndUserName(@Param("id") Integer id, @Param("userName") String userName);

	/**
	 * 根据 map 查询
	 *
	 * @param map
	 * @return
	 */
	Employee findByMap(Map<String, Object> map);

	/**
	 * 根据部门id查询部门下所有员工
	 *
	 * @param deptId
	 * @return
	 */
	List<Employee> findEmpsByDeptId(Integer deptId);


}
