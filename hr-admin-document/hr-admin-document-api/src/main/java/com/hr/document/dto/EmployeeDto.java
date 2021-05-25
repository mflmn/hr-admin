package com.hr.document.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hr.document.entity.*;
import com.hr.system.entity.Department;
import com.hr.system.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author junjie
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "employee")
@ApiModel(value="Employee对象", description="Employee对象")
public class EmployeeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工姓名")
    @Excel(name = "员工姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    @Excel(name = "性别")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "出生日期",format = "yyyy-MM-dd",width = 20)
    private Date birthday;

    @ApiModelProperty(value = "身份证号")
    @Excel(name = "身份证号",width = 30)
    @TableField(value = "idCard")
    private String idCard;

    @ApiModelProperty(value = "婚姻状况")
    @Excel(name = "婚姻状况")
    private String wedlock;

    @ApiModelProperty(value = "民族")
    @TableField(value = "nationId")
    private Integer nationId;

    @ApiModelProperty(value = "籍贯")
    @Excel(name = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "政治面貌")
    @TableField(value = "politicId")
    private Integer politicId;

    @ApiModelProperty(value = "邮箱")
    @Excel(name = "邮箱",width = 30)
    private String email;

    @ApiModelProperty(value = "电话号码")
    @Excel(name = "电话号码",width = 15)
    private String phone;

    @ApiModelProperty(value = "联系地址")
    @Excel(name = "联系地址",width = 40)
    private String address;

    @ApiModelProperty(value = "所属部门")
    @TableField(value = "departmentId")
    private Long departmentId;

    @ApiModelProperty(value = "职称ID")
    @TableField(value = "jobLevelId")
    private Integer jobLevelId;

    @ApiModelProperty(value = "职位ID")
    private Integer posId;

    @ApiModelProperty(value = "聘用形式")
    @Excel(name = "聘用形式")
    private String engageForm;

    @ApiModelProperty(value = "最高学历")
    @Excel(name = "最高学历")
    @TableField(value = "tiptopDegree")
    private String tiptopDegree;

    @ApiModelProperty(value = "所属专业")
    @Excel(name = "所属专业",width = 20)
    private String specialty;

    @ApiModelProperty(value = "毕业院校")
    @Excel(name = "毕业院校",width = 20)
    private String school;

    @ApiModelProperty(value = "入职日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "入职日期",format = "yyyy-MM-dd",width = 20)
    @TableField(value = "beginDate")
    private Date beginDate;

    @ApiModelProperty(value = "在职状态")
    @Excel(name = "在职状态")
    @TableField("workState")
    private String workState;

    @ApiModelProperty(value = "工号")
    @Excel(name = "工号")
    @TableField(value = "workID")
    private String workID;

    @ApiModelProperty(value = "合同期限")
    @Excel(name = "合同期限",suffix = "年")
    @TableField(value = "contractTerm")
    private Double contractTerm;

    @ApiModelProperty(value = "转正日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "转正日期",format = "yyyy-MM-dd",width = 20)
    @TableField(value = "conversionTime")
    private Date conversionTime;

    @ApiModelProperty(value = "离职日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "notWorkDate")
    private Date notWorkDate;

    @ApiModelProperty(value = "合同起始日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "合同起始日期",format = "yyyy-MM-dd",width = 20)
    @TableField(value = "beginContract")
    private Date beginContract;

    @ApiModelProperty(value = "合同终止日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "合同终止日期",format = "yyyy-MM-dd",width = 20)
    @TableField(value = "endContract")
    private Date endContract;

    @ApiModelProperty(value = "工龄")
    @Excel(name = "工龄")
    private Integer workAge;

    @ApiModelProperty(value = "工资账套ID")
    @TableField(value = "salaryId")
    private Integer salaryId;

    @ApiModelProperty(value = "用户ID")
    @TableField(value = "userId")
    private Long userId;

    @ApiModelProperty(value = "民族")
    @TableField(exist = false)
    @ExcelEntity(name = "民族")
    private Nation nation;

    @ApiModelProperty(value = "政治面貌")
    @TableField(exist = false)
    @ExcelEntity(name = "政治面貌")
    private PoliticsStatus politicsStatus;

    @ApiModelProperty(value = "部门")
    @TableField(exist = false)
    @ExcelEntity(name = "部门")
    private Department department;

    @ApiModelProperty(value = "职称")
    @TableField(exist = false)
    @ExcelEntity(name = "职称")
    private Joblevel joblevel;

    @ApiModelProperty(value = "职位")
    @TableField(exist = false)
    @ExcelEntity(name = "职位")
    private Position position;

    @ApiModelProperty(value = "工资套账")
    @TableField(exist = false)
    @ExcelEntity(name = "工资套账")
    private Salary salary;

    @ApiModelProperty(value = "用户")
    @TableField(exist = false)
    private User user;

}
