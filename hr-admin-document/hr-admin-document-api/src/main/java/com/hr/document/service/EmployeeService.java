package com.hr.document.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.common.domain.CommonPage;
import com.hr.common.domain.CommonResult;
import com.hr.document.dto.EmployeeDto;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junjie
 * @since 2021-05-21
 */
public interface EmployeeService extends IService<EmployeeDto> {

    /**
     * 获取所有员工（分页）
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    CommonPage<EmployeeDto> getEmployeeByPage(Integer currentPage, Integer size, EmployeeDto employee, Date[] beginDateScope);

    /**
     * 通过员工id获取员工信息
     * @param id
     * @return
     */
    CommonResult<EmployeeDto> getEmployeeById(Integer id);

    /**
     * 员工名称模糊查询
     * @param name
     * @return
     */
    CommonPage<EmployeeDto> getEmployeeByName(Integer currentPage, Integer size,String name);

    /**
     * 查询所有员工
     * @return
     */
    List<EmployeeDto> getEmployee();

    /**
     * 新增员工
     * @param employeeDto
     * @return
     */
    Integer insertEmployee(EmployeeDto employeeDto);


    /**
     * 通过id 删除员工表
     * @param id
     * @return
     */
    Integer deleteEmployeeById(Integer id);


    /**
     * 通过id 更新员工表
     * @param employeeDto
     * @return
     */
    Integer updateEmployeeById(Integer id,EmployeeDto employeeDto);

}
