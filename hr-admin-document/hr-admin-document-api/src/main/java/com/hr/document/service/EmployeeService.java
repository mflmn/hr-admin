package com.hr.document.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.common.domain.CommonPage;
import com.hr.document.dto.EmployeeDto;
import com.hr.document.entity.Employee;

import java.util.Date;

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
    CommonPage<EmployeeDto> getEmployeeByPage(Integer currentPage, Integer size, EmployeeDto employee, Date beginDateScope);
}
