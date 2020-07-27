package com.coursework.movies.bootstrap;

import com.coursework.movies.domain.AuthorityEntity;
import com.coursework.movies.domain.UserEntity;
import com.coursework.movies.repository.AuthorityRepository;
import com.coursework.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        AuthorityEntity adminAuthority = new AuthorityEntity(1L,"ADMIN");
        authorityRepository.save(adminAuthority);
        Set<AuthorityEntity> authorities = new HashSet<>();
        authorities.add(adminAuthority);
        UserEntity admin = new UserEntity(
                1L,
                "admin",
                "admin@admin.com",
                encoder.encode("admin"),
                true,
                LocalDateTime.now(),
                0.0,
                authorities);

        List<UserEntity> dbUsers = userRepository.findAll();
        if (dbUsers.isEmpty()) {
            userRepository.save(admin);
        }
    }


}
