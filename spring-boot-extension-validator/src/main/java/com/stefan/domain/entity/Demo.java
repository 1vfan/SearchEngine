package com.stefan.domain.entity;

import com.stefan.domain.annotation.GeoLonCheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description: 测试类，添加属性约束
 * @Author: Stefan
 * @Date: 2019/7/16 9:06 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo {

    @Min(value = 18, message = "未成年止步")
    private int age;

    @NotBlank(message = "名称不能为空")
    private String name;

    /** 自定义注解 */
    @NotNull
    @GeoLonCheck
    private Double lon;
}
