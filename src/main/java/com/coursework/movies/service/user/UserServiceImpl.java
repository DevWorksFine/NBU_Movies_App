package com.coursework.movies.service.user;

import com.coursework.movies.domain.user.AuthorityEntity;
import com.coursework.movies.domain.user.UserDto;
import com.coursework.movies.domain.user.UserEntity;
import com.coursework.movies.mapper.UserMapper;
import com.coursework.movies.repository.AuthorityRepository;
import com.coursework.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    UserMapper mapper;



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserEntity user = userRepository.getByUsername(userName).orElse(null);

        //TODO Exception handling is missing!

        return user;
    }

    @Override
    public UserEntity register(UserDto userDto) {
        UserEntity userEntity = mapper.map(userDto,UserEntity.class);
        userEntity.setPassword(encoder.encode(userDto.getPassword()));
        AuthorityEntity authorityEntity = authorityRepository.findById(2L).get();

        Set<AuthorityEntity> userAuthorities = new HashSet<>();
        userAuthorities.add(authorityEntity);
        userEntity.setAuthorities(userAuthorities);

        return userRepository.save(userEntity);
    }
}
