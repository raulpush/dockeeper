package com.muri.web.service;

import com.muri.web.model.Email;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
public interface EmailService {
    void sendEmail(Email seq);
    void sendSimpleEmail(Email seq);
}
