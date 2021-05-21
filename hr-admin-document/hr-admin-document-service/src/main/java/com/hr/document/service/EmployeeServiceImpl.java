package com.hr.document.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hr.document.entity.Employee;
import com.hr.document.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junjie
 * @since 2021-05-21
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
