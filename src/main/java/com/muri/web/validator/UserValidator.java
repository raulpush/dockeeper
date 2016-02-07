package com.muri.web.validator;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
import com.muri.web.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    public boolean supports(Class<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public void validate(Object user, Errors errors) {

        User file = (User) user;
        System.out.printf("---------------------");
        if (((User) user).getUsername().length() == 0) {
            errors.rejectValue("username", "empty username",
                    "Please set username!");
        }
        if (((User) user).getPassword().length() == 0) {
            errors.rejectValue("password", "empty password",
                    "Please set username!");
        }
        if (!((User) user).getGenerate_publicKey() && ((User) user).getPublicKey().length() == 0 ) {
            errors.rejectValue("publickKey", "empty publickKey",
                    "Please set publickKey!");
        }

    }

}


