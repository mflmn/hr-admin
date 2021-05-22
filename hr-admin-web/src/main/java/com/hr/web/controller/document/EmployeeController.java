package com.hr.web.controller.document;

import com.hr.common.domain.CommonPage;
import com.hr.document.entity.Employee;
import com.hr.document.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @author junjie
 * @version 1.0.0
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "获取所有员工(分页)")
    @GetMapping("/")
    public CommonPage<Employee> getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer size,
                                  Employee employee,
                                  LocalDate beginDateScope){
        // return employeeService.getEmployeeByPage(currentPage, size, employee, beginDateScope);
        return null;
    }
}
