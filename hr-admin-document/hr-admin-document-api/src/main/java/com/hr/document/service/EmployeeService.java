package com.hr.document.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.common.domain.CommonPage;
import com.hr.document.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junjie
 * @since 2021-05-21
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 获取所有员工（分页）
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    CommonPage<Employee> getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate beginDateScope);
}
