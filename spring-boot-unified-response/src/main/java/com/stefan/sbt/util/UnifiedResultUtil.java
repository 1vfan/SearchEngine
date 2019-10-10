package com.stefan.sbt.util;

import com.stefan.sbt.domain.entity.UnifiedResult;
import com.stefan.sbt.domain.enums.UnifiedResponseStatusEnum;

/**
 * @Description: {@link UnifiedResult}组装工具类
 * @Author: Stefan
 * @Date: 2019/7/13 7:40 PM
 */
public class UnifiedResultUtil {

    public static UnifiedResult success(Object data) {
        UnifiedResponseStatusEnum urse = UnifiedResponseStatusEnum.SUCCESS;
        return new UnifiedResult(urse.getCode(), urse.getStatus(), urse.getMsg(), data);
    }

    public static UnifiedResult errorUnknow(Exception ex) {
        UnifiedResponseStatusEnum urse = UnifiedResponseStatusEnum.ERROR_UNKNOW;
        return new UnifiedResult(urse.getCode(), urse.getStatus(), ex.getMessage(),null);
    }

    public static UnifiedResult errorCustom(UnifiedResponseStatusEnum urse) {
        return new UnifiedResult(urse.getCode(), urse.getStatus(), urse.getMsg(),null);
    }

}
