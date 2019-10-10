package com.stefan.sbt.domain.enums;

import lombok.Getter;

/**
 * @Description: 统一请求响应状态枚举类
 * @Author: Stefan
 * @Date: 2019/7/13 7:05 PM
 */
public enum UnifiedResponseStatusEnum {

    /** 请求响应状态 */
    SUCCESS(200, "success", "OK"),
    ERROR_UNKNOW(100, "error", null),
    ERROR_CUSTOM_1(101, "error", "custom 1 exception"),
    ERROR_CUSTOM_2(102, "error", "custom 2 exception");

    @Getter
    private Integer code;

    @Getter
    private String status;

    @Getter
    private String msg;

    UnifiedResponseStatusEnum(Integer code, String status, String msg) {
        this.code = code;
        this.status = status;
        this.msg = msg;
    }
}
