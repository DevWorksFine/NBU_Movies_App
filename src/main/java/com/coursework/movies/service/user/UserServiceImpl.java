package com.coursework.movies.service.user;

import com.coursework.movies.domain.UserEntity;
import com.coursework.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserEntity user = userRepository.getByUsername(userName).orElse(null);

        //TODO Exception handling is missing!

        return user;
    }
}
