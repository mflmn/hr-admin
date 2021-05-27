package com.hr.document.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.document.dto.EmployeeDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    IPage<EmployeeDto> getEmployeeByPage(Page<EmployeeDto> page, @Param("employee") EmployeeDto employee, @Param("beginDateScope") String[] beginDateScope);

    /**
     * 通过员工id获取员工信息
     * @param id
     * @return
     */
    EmployeeDto getEmployeeById(@Param("id") Integer id);

    /**
     * 员工名称模糊查询
     * @param name
     * @return
     */
    IPage<EmployeeDto> getEmployeeByName(Page<EmployeeDto> page, @Param("name") String name);

    /**
     * 查询所有员工
     * @return
     */
    List<EmployeeDto> getEmployee();
}
