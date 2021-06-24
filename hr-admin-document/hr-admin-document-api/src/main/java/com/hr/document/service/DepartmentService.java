package com.hr.document.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.document.entity.Department;

import java.util.List;

public interface DepartmentService extends IService<Department> {
    List<Department> getAllDepartments();
    void addDep(Department dep);
    void deleteDepById(Department dep);
    List<Department> getAllDepartmentsWithOutChildren();
}
