package com.stefan.sbt.dao.demo;

import com.stefan.sbt.domain.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 测试
 * @Author: Stefan
 * @Date: 2019/10/9 4:35 PM
 */
@Mapper
public interface DemoMapper {

    /**
     * 根据条件查询
     * @param name
     * @return
     */
    Demo selectOneByName(@Param("name") String name);

}
