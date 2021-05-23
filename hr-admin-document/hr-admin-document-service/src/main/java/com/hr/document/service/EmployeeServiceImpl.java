package com.hr.document.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hr.common.domain.CommonPage;
import com.hr.document.dto.EmployeeDto;
import com.hr.document.entity.Employee;
import com.hr.document.mapper.EmployeeMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junjie
 * @since 2021-05-21
 */
@Service(interfaceClass = EmployeeService.class)
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeDto> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 获取所有员工（分页）
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    @Override
    public CommonPage<EmployeeDto> getEmployeeByPage(Integer currentPage, Integer size, EmployeeDto employee, Date beginDateScope) {
        //开启分页
        Page<EmployeeDto> page = new Page<>(currentPage,size);
        IPage<EmployeeDto> employeeByPage = employeeMapper.getEmployeeByPage(page, employee, beginDateScope);
        return new CommonPage<>(employeeByPage.getTotal(),employeeByPage.getRecords());
    }
}
