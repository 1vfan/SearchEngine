package com.stefan.sbt.dao.demo;

import com.stefan.sbt.domain.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 测试Mapper
 * @Author: Stefan
 * @Date: 2019/7/11 4:35 PM
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
