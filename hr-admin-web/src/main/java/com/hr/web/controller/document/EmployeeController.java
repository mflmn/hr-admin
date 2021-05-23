package com.hr.web.controller.document;

import com.hr.common.domain.CommonPage;
import com.hr.document.dto.EmployeeDto;
import com.hr.document.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author junjie
 * @version 1.0.0
 */
@RestController
@RequestMapping("/document/employee")
public class EmployeeController {

    @Reference(interfaceClass = EmployeeService.class)
    private EmployeeService employeeService;

    @ApiOperation(value = "获取所有员工(分页)")
    @GetMapping("/")
    public CommonPage<EmployeeDto> getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                                               @RequestParam(defaultValue = "10") Integer size,
                                               EmployeeDto employee,
                                               Date beginDateScope){
        return employeeService.getEmployeeByPage(currentPage, size, employee, beginDateScope);
    }
}
