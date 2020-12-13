package com.pywl.mapper;

import com.pywl.entity.Department;

/**
 * @Description 部门 mapper
 * @Author DongPo
 * @Date 2020-12 15:49
 */
public interface DepartmentMapper {

	/**
	 * 根据id查询
	 *
	 * @param id
	 * @return
	 */
	Department findByPrimaryId(Integer id);

	/**
	 * 根据id查询，同时查出部门下所有的员工
	 *
	 * @param id
	 * @return
	 */
	Department findByPrimaryIdIncludeEmps(Integer id);

	/**
	 * 根据id查询，同时查出部门下所有的员工，分步查询
	 *
	 * @param id
	 * @return
	 */
	Department findByPrimaryIdIncludeEmpsStep(Integer id);
}
