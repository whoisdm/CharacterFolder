package com.whoisdm.characterFolder.service.user;

import com.whoisdm.characterFolder.dao.user.UserRepository;
import com.whoisdm.characterFolder.model.user.Authority;
import com.whoisdm.characterFolder.model.user.RegistrationUser;
import com.whoisdm.characterFolder.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User save(RegistrationUser user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return null;
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEnabled(true);
        newUser.addAuthority(new Authority(newUser, "ROLE_USER"));

        return userRepository.save(newUser);
    }
}
