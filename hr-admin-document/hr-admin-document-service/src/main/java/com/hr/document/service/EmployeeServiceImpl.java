package com.hr.document.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hr.common.domain.CommonErrorCode;
import com.hr.common.domain.CommonPage;
import com.hr.common.domain.CommonResult;
import com.hr.common.exception.BusinessException;
import com.hr.document.dto.EmployeeDto;
import com.hr.document.mapper.EmployeeMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public CommonPage<EmployeeDto> getEmployeeByPage(Integer currentPage, Integer size, EmployeeDto employee, String[] beginDateScope) {
        //开启分页
        Page<EmployeeDto> page = new Page<>(currentPage,size);
        IPage<EmployeeDto> employeeByPage = employeeMapper.getEmployeeByPage(page, employee, beginDateScope);
        return new CommonPage<>(employeeByPage.getTotal(),employeeByPage.getRecords());
    }

    /**
     * 通过员工id获取员工信息
     * @param id
     * @return
     */
    @Override
    public CommonResult<EmployeeDto> getEmployeeById(Integer id) {
        EmployeeDto employeeById = employeeMapper.getEmployeeById(id);
        if (employeeById != null){
            return CommonResult.success(employeeById);
        }else throw new BusinessException(CommonErrorCode.USER_NOT_EXISTS);//抛出异常
    }

    /**
     * 员工名称模糊查询
     * @param name
     * @return
     */
    @Override
    public CommonPage<EmployeeDto> getEmployeeByName(Integer currentPage, Integer size,String name) {
        Page<EmployeeDto> page = new Page<>(currentPage,size);
        IPage<EmployeeDto> employeeByName = employeeMapper.getEmployeeByName(page,name);
        return new CommonPage<>(employeeByName.getTotal(),employeeByName.getRecords());
    }

    /**
     * 查询所有员工
     * @return
     */
    @Override
    public List<EmployeeDto> getEmployee() {
        return employeeMapper.getEmployee();
    }

    /**
     *
     * @param employeeDto
     * @return  新增员工数据
     */
    @Override
    public Integer insertEmployee(EmployeeDto employeeDto) {

        return employeeMapper.insert(employeeDto);

    }

    /**
     * 通过id 删除员工表
     * @param id
     * @return
     */
    @Override
    public Integer deleteEmployeeById(Integer id) {
        return employeeMapper.deleteById(id);

    }

    /**
     * 更新员工信息通过id
     * @param employeeDto
     * @return
     */
    @Override
    public Integer updateEmployeeById(Integer id,EmployeeDto employeeDto){

        UpdateWrapper<EmployeeDto> up= new UpdateWrapper<>();
        up.eq("id",id);

        return employeeMapper.update(employeeDto,up);
    }
}
