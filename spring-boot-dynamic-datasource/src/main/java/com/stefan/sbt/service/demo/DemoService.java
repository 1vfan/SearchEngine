package com.stefan.sbt.service.demo;

import com.stefan.sbt.dao.demo.DemoMapper;
import com.stefan.sbt.domain.annotation.Dynamic;
import com.stefan.sbt.domain.entity.Demo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: 测试
 * @Author: Stefan
 * @Date: 2019/10/9 9:31 AM
 */
@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    @Dynamic("Master")
    public Demo findDemoByName(String name) {
        return demoMapper.selectOneByName(name);
    }

}
