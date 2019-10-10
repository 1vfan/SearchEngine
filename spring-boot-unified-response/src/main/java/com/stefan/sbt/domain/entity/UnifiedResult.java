package com.stefan.sbt.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 统一请求处理返回结果类
 * @Author: Stefan
 * @Date: 2019/7/13 7:00 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnifiedResult<T> {

    private Integer code;

    private String status;

    private String msg;

    private T data;

}
