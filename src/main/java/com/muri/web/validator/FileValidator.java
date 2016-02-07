package com.muri.web.validator;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
import com.muri.web.model.UploadedFile;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileValidator implements Validator {

    public boolean supports(Class<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public void validate(Object uploadedFile, Errors errors) {

        UploadedFile file = (UploadedFile) uploadedFile;
        System.out.printf("---------------------");
        if (file.getFile().getSize() == 0) {
            errors.rejectValue("file", "uploadForm.salectFile",
                    "Please select a file!");
        }

    }

}


