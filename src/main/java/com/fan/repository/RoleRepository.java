package com.fan.repository;

import com.fan.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by lf on 2018/6/28.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findRolesByUserId(Long userId);

}
