package com.stefan.sbt.controller.demo;

import com.stefan.sbt.domain.entity.UnifiedResult;
import com.stefan.sbt.domain.enums.UnifiedResponseStatusEnum;
import com.stefan.sbt.exception.CustomException;
import com.stefan.sbt.util.UnifiedResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试Controller
 * @Author: Stefan
 * @Date: 2019/7/13 8:49 PM
 */
@Slf4j
@RestController
public class DemoController {

    @GetMapping(value = "/demo")
    public UnifiedResult demo() {
        /** 自定义异常 */
        if(false) {
            log.error("Custom 1 Exception");
            throw new CustomException(UnifiedResponseStatusEnum.ERROR_CUSTOM_1);
        }
        /** 一般运行时异常 */
        //int a = 1/0;
        /** 返回请求成功响应体 */
        log.info("request success");
        return UnifiedResultUtil.success("success result data");
    }

}
