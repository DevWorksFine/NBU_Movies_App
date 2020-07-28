package com.coursework.movies.mapper;

import com.coursework.movies.domain.user.UserDto;
import com.coursework.movies.domain.user.UserEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends ConfigurableMapper {


    protected void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(UserDto.class, UserEntity.class)
                .field("username", "username")
                .field("email", "email")
                .field("password", "password")
                .field("name", "name")
                .register();
    }
}
