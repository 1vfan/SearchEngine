package com.stefan.sbt.exception;

import com.stefan.sbt.domain.enums.UnifiedResponseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 自定义异常类
 * @Author: Stefan
 * @Date: 2019/7/13 8:06 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {
    /** 自定义属性，传递异常信息 */
    private UnifiedResponseStatusEnum urse;

}
