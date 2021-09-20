package com.example.customannotation2.ConstraintValidator;

import com.example.customannotation2.annotation.ValidateDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateFormatValidator implements ConstraintValidator<ValidateDateFormat, String> {
    @Override
    public boolean isValid(String dt, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("======== Starting try ========");
        if (dt == null){ return true; }

        String s = dt.toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = simpleDateFormat.parse(s);
            OffsetDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"));
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
