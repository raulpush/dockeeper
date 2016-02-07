package com.muri.web.service;

import com.muri.web.model.User;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
public interface UserService {
    User save(User seq);
    User findByUsername(String username);
    User findByEmail(String email);
}
