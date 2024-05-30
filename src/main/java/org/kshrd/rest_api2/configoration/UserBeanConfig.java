package org.kshrd.rest_api2.configoration;

import org.kshrd.rest_api2.mapper.UserMapper;
import org.kshrd.rest_api2.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfig {
    @Bean
    public UserMapper userMapper(){
        return new UserMapperImpl();
    }
}
