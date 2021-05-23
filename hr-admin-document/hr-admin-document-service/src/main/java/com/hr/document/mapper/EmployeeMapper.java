package com.hr.document.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.document.dto.EmployeeDto;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junjie
 * @since 2021-05-21
 */
@Repository
public interface EmployeeMapper extends BaseMapper<EmployeeDto> {

    /**
     * 获取所有员工（分页）
     * @param page
     * @param employee
     * @param beginDateScope
     * @return
     */
    IPage<EmployeeDto> getEmployeeByPage(Page<EmployeeDto> page, EmployeeDto employee, Date beginDateScope);
}
