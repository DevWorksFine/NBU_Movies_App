package com.coursework.movies.service.user;

import com.coursework.movies.domain.user.UserDto;
import com.coursework.movies.domain.user.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    UserEntity register(UserDto userDto);
}
