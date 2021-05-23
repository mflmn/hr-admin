package com.hr.web.controller.document;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.hr.common.domain.CommonErrorCode;
import com.hr.common.domain.CommonPage;
import com.hr.common.domain.CommonResult;
import com.hr.common.exception.BusinessException;
import com.hr.document.dto.EmployeeDto;
import com.hr.document.entity.Employee;
import com.hr.document.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

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

    @ApiOperation(value = "通过员工id获取员工信息")
    @GetMapping("/{id}")
    public CommonResult<EmployeeDto> getEmployeeById(@PathVariable("id") Integer id){
        //id为空判断
        if (id > 0){
            return employeeService.getEmployeeById(id);
        }else throw new BusinessException(CommonErrorCode.USER_NOT_EXISTS);//抛出异常

    }

    @ApiOperation(value = "员工名称模糊查询")
    @GetMapping("/getEmployeeByName")
    public CommonPage<EmployeeDto> getEmployeeByName(@RequestParam(defaultValue = "1") Integer currentPage,
                                                     @RequestParam(defaultValue = "10") Integer size,
                                                     @RequestBody String name) {
        System.out.println(name);

        if (!"".equals(name)){
            return employeeService.getEmployeeByName(currentPage,size,name);
        }else throw new BusinessException(CommonErrorCode.USER_NOT_EXISTS);//抛出异常
    }

    @ApiOperation("导出员工数据")
    @GetMapping(value = "/export",produces = "application/octet-stream")
    public void exportEmployee(HttpServletResponse response){
        List<EmployeeDto> list = employeeService.getEmployee();
        System.out.println(list);
        ExportParams params = new ExportParams("员工表", "员工表", ExcelType.HSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params, EmployeeDto.class, list);
        ServletOutputStream out = null;
        try {
            //流形式
            response.setHeader("content-type","application/octet-stream");
            //防止中文乱码
            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode("" +
                    "员工表.xls","UTF-8"));
            out = response.getOutputStream();
            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
