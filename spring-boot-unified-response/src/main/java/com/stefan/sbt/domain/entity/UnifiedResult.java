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

    /** 响应码 */
    private Integer code;
    /** 响应状态 */
    private String status;
    /** 响应信息 */
    private String msg;
    /** 响应结果 */
    private T data;

}
