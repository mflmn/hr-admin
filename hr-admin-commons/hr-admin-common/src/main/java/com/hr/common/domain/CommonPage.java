package com.hr.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuelimin
 * @description
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonPage<T> implements Serializable {
    private long total;
    private List<T> rows;
}


