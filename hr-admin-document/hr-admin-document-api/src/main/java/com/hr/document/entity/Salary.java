package com.hr.document.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author junjie
 * @since 2021-05-21
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Salary implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 基本工资
     */
      @TableField("basicSalary")
    private Integer basicSalary;

      /**
     * 奖金
     */
      private Integer bonus;

      /**
     * 午餐补助
     */
      @TableField("lunchSalary")
    private Integer lunchSalary;

      /**
     * 交通补助
     */
      @TableField("trafficSalary")
    private Integer trafficSalary;

      /**
     * 应发工资
     */
      @TableField("allSalary")
    private Integer allSalary;

      /**
     * 养老金基数
     */
      @TableField("pensionBase")
    private Integer pensionBase;

      /**
     * 养老金比率
     */
      @TableField("pensionPer")
    private Float pensionPer;

      /**
     * 启用时间
     */
      @TableField("createDate")
    private LocalDateTime createDate;

      /**
     * 医疗基数
     */
      @TableField("medicalBase")
    private Integer medicalBase;

      /**
     * 医疗保险比率
     */
      @TableField("medicalPer")
    private Float medicalPer;

      /**
     * 公积金基数
     */
      @TableField("accumulationFundBase")
    private Integer accumulationFundBase;

      /**
     * 公积金比率
     */
      @TableField("accumulationFundPer")
    private Float accumulationFundPer;

      /**
     * 名称
     */
      private String name;


}
