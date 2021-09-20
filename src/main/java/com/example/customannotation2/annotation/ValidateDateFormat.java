package com.example.customannotation2.annotation;


import com.example.customannotation2.ConstraintValidator.DateFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Documented
//@Constraint(validatedBy = DateFormatValidator.class)
public @interface ValidateDateFormat {

    String message () default "not a valid date";
    String style() default "SS";

    ValidateDateFormat.ISO iso() default ValidateDateFormat.ISO.DATE_TIME;

    String pattern() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fallbackPatterns() default {};

    public static enum ISO {
        DATE,
        TIME,
        DATE_TIME,
        NONE;

        private ISO() {
        }
    }

}
