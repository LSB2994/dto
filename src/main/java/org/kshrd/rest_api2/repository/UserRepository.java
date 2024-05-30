package org.kshrd.rest_api2.repository;

import org.apache.ibatis.annotations.*;
import org.kshrd.rest_api2.model.entity.UserApp;
import org.kshrd.rest_api2.model.request.UserRequest;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("SELECT * FROM user_tb WHERE id = #{userId}")
    UserApp findUserById(Integer userId);

    @Select("SELECT * FROM user_tb")
    List<UserApp> findAllUser();

    @Select("INSERT INTO user_tb(name, email, password, address) " +
            "VALUES (#{rq.name},#{rq.email},#{rq.password},#{rq.address}) " +
            "RETURNING id")
    Integer saveUser(@Param("rq") UserRequest userRequest);
}
