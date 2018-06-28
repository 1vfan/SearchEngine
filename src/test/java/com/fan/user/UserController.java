package com.fan.user;

import com.fan.ApplicationTests;
import com.fan.entity.User;
import com.fan.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lf on 2018/6/28.
 */
public class UserController extends ApplicationTests{

    @Autowired
    public UserRepository userRepository;

    @Test
    public void test() {
        User user = userRepository.findByName("吕凡");
        //Assert.assertEquals(user.getPassword(), "55b3d0936a3fb63168d57a6bda0ddbbf");
        Assert.assertEquals(user.getPassword(), "wieoo_ksksj82373388");
    }

}
