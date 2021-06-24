package com.hr.document.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hr.document.entity.Department;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<Department> {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();
}
