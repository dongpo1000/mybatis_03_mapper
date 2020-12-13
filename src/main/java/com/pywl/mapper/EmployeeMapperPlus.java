package com.pywl.mapper;

import com.pywl.entity.Employee;

/**
 * @Description Mapper 高级功能
 * @Author DongPo
 * @Date 2020-12 13:36
 */
public interface EmployeeMapperPlus {

	/**
	 * 根据 id 查询
	 *
	 * @param id
	 * @return
	 */
	Employee findByPrimaryId(Integer id);

	/**
	 * 根据 id 查询，同时查出对应的 Department
	 *
	 * @param id
	 * @return
	 */
	Employee findByIdIncludeDept(Integer id);

	/**
	 * 根据id查询，然后分步查出对应的 Department
	 *
	 * @param id
	 * @return
	 */
	Employee findByIdIncludeDeptStep(Integer id);

	/**
	 * 根据id查询 使用鉴别器
	 * @param id
	 * @return
	 */
	Employee findByIdIncludeDeptUseDiscriminator(Integer id);
}
