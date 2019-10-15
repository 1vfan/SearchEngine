package com.stefan.sbt.handler;

import com.stefan.sbt.domain.entity.UnifiedResult;
import com.stefan.sbt.exception.CustomException;
import com.stefan.sbt.util.UnifiedResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 自定义全局异常处理类
 * @Author: Stefan
 * @Date: 2019/7/13 8:22 PM
 */
@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    /** 拦截异常并处理 */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public UnifiedResult exceptionHandler(Exception ex) {
        if(ex instanceof CustomException) {
            return UnifiedResultUtil.errorCustom(((CustomException) ex).getUrse());
        } else {
            log.error("throw unknow exception: {}", ex.getMessage());
            return UnifiedResultUtil.errorUnknow(ex);
        }
    }

}
