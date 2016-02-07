package com.muri.web.service;

import com.muri.web.model.User;
import com.muri.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User seq) {
        return userRepository.save(seq);
    }

    public User findByUsername(String index) {
        User user = userRepository.findByUsername(index);

        if(user != null) {
            return user;
        }
        return null;
    }


    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if(user != null) {
            return user;
        }
        return null;
    }


}
