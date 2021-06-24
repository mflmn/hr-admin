package com.hr.web.controller.v1;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.hr.common.domain.CommonErrorCode;
import com.hr.common.domain.CommonPage;
import com.hr.common.domain.CommonResult;
import com.hr.common.exception.BusinessException;
import com.hr.document.dto.EmployeeDto;
import com.hr.document.entity.*;
import com.hr.document.service.*;
import io.swagger.annotations.Api;
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
@CrossOrigin
@Api(value = "员工操作",tags = {"document"})
@RequestMapping("/v1/document/employee")
public class DocumentEmployeeController {

    @Reference(interfaceClass = EmployeeService.class)
    private EmployeeService employeeService;
    @Reference(interfaceClass = NationService.class)
    private NationService nationService;
    @Reference(interfaceClass = PoliticsStatusService.class)
    private PoliticsStatusService politicsStatusService;
    @Reference(interfaceClass = JoblevelService.class)
    private JoblevelService joblevelService;
    @Reference(interfaceClass = PositionService.class)
    private PositionService positionService;
    @Reference(interfaceClass = DepartmentService.class)
    private DepartmentService departmentService;

    @ApiOperation(value = "获取所有员工(分页)")
    @GetMapping("/getPages")
    public CommonPage<EmployeeDto> getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                                               @RequestParam(defaultValue = "10") Integer size,
                                               EmployeeDto employee, Date[] beginDateScope
                                               ){
        return employeeService.getEmployeeByPage(currentPage, size, employee, beginDateScope);
    }

    @ApiOperation(value = "通过员工id获取员工信息")
    @GetMapping("/getEmployeeById/{id}")
    public CommonResult<EmployeeDto> getEmployeeById(@PathVariable("id") Integer id){
        //id为空判断
        if (id > 0){
            return employeeService.getEmployeeById(id);
        }else throw new BusinessException(CommonErrorCode.USER_NOT_EXISTS);//抛出异常
    }

    @ApiOperation(value = "员工名称模糊查询")
    @GetMapping("/getEmployeeByName/{name}")
    public CommonPage<EmployeeDto> getEmployeeByName(@RequestParam(defaultValue = "1") Integer currentPage,
                                                     @RequestParam(defaultValue = "10") Integer size,
                                                     @PathVariable("name") String name) {
        if (!"".equals(name)){
            return employeeService.getEmployeeByName(currentPage,size,name);
        }else throw new BusinessException(CommonErrorCode.USER_NOT_EXISTS);//抛出异常
    }

    @ApiOperation(value = "获取民族信息")
    @GetMapping("/getNations")
    public List<Nation> getNations(){
        return nationService.list();
    }
    @ApiOperation(value = "获取政治面貌信息")
    @GetMapping("/getPoliticsStatus")
    public List<PoliticsStatus> getPoliticsStatus(){
        return politicsStatusService.list();
    }
    @ApiOperation(value = "获取所有部门信息")
    @GetMapping("/getDepartments")
    public List<Department> getDepartments(){
        return departmentService.getAllDepartments();
    }
    @ApiOperation(value = "获取职称信息")
    @GetMapping("/getJoblevels")
    public List<Joblevel> getJoblevels(){
        return joblevelService.list();
    }
    @ApiOperation(value = "获取职位信息")
    @GetMapping("/getPositions")
    public List<Position> getPositions(){
        return positionService.list();
    }

    @ApiOperation("导出员工数据")
    @GetMapping(value = "/export",produces = "application/octet-stream")
    public void exportEmployee(HttpServletResponse response){
        List<EmployeeDto> list = employeeService.getEmployee();
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

    @ApiOperation("通过ID删除员工数据")
    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteEmployeeById(@PathVariable(value = "id") Integer id){
        Integer result=0;
        if (id > 0) {
            result= employeeService.deleteEmployeeById(id);
            if (result==0) {
                throw new BusinessException(CommonErrorCode.USER_NOT_EXISTS);
            }
        }else  throw new BusinessException(CommonErrorCode.VALIDATE_INPUT);
        return CommonResult.success(result) ;
    }

    @ApiOperation("增加员工数据")
    @PostMapping("/insertEmployee")
    public CommonResult<Integer>  insertEmployee(@RequestBody EmployeeDto employeeDto){

        Integer result = employeeService.insertEmployee(employeeDto);
        if (result == 0) {
            throw new BusinessException(CommonErrorCode.USER_NOT_EXISTS);//抛出异常
        }
        return  CommonResult.success(result);
    }

    @ApiOperation("通过ID更新员工数据")
    @PutMapping("/update")
    public CommonResult<Integer> updateEmployeeById(@RequestBody EmployeeDto employeeDto){
        Integer result=0;
        result = employeeService.updateEmployeeById(employeeDto);
        if (result == 0) {
            throw new BusinessException(CommonErrorCode.USER_NOT_EXISTS);//抛出异常
        }
        return  CommonResult.success(result);
    }

    @GetMapping("/maxWorkID")
    public CommonResult<String> maxWorkID(){
        return CommonResult.success(String.format("%08d", employeeService.maxWorkID() + 1));
    }


}
