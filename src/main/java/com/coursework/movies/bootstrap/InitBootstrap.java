package com.coursework.movies.bootstrap;

import com.coursework.movies.domain.user.AuthorityEntity;
import com.coursework.movies.domain.user.UserEntity;
import com.coursework.movies.repository.AuthorityRepository;
import com.coursework.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class InitBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    BCryptPasswordEncoder encoder;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createAdmin();
    }

    private void createAdmin() {
        AuthorityEntity adminAuthority = new AuthorityEntity(1L, "ADMIN");
        authorityRepository.save(adminAuthority);
        Set<AuthorityEntity> authorities = new HashSet<>();
        authorities.add(adminAuthority);
        UserEntity admin = new UserEntity(
                1L,
                "admin",
                "admin@admin.com",
                encoder.encode("admin"),
                "admin",
                true,
                LocalDateTime.now(),
                0.0,
                authorities);


        AuthorityEntity userAuthority = new AuthorityEntity(2L, "ROLE_USER");
        authorityRepository.save(userAuthority);
        Set<AuthorityEntity> userAuthorities = new HashSet<>();
        authorities.add(adminAuthority);

        UserEntity user = new UserEntity(
                1L,
                "user",
                "user@user.com",
                encoder.encode("user"),
                "user",
                true,
                LocalDateTime.now(),
                0.0,
                userAuthorities);

        List<UserEntity> dbUsers = userRepository.findAll();
        if (dbUsers.isEmpty()) {
            userRepository.save(admin);
            userRepository.save(user);
        }
    }


}
