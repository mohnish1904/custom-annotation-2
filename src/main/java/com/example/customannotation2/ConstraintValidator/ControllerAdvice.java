package com.example.customannotation2.ConstraintValidator;

import com.example.customannotation2.annotation.NoSuchDateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestControllerAdvice
@Configuration
class ControllerAdvice {


    @ExceptionHandler(NoSuchDateTime.class)
    public ResponseEntity<Object> NoSuchDateTime(NoSuchDateTime e, HttpServletRequest req){
        System.out.println(req.getRequestURI());
        System.out.println(req.getContextPath());
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @Bean
    public Formatter<OffsetDateTime> localDateTimeFormatter() {

        return new Formatter<OffsetDateTime>() {
            @Override
            public OffsetDateTime parse(String s, Locale locale) {
                try {
                    System.out.println("===parse=========> " + s);
                    return OffsetDateTime.parse(s, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                } catch (Exception e){
                    throw new NoSuchDateTime(s + " is not a valid date.");
                }
            }

            @Override
            public String print(OffsetDateTime offsetDateTime, Locale locale) {
                System.out.println("=====print=======> "+ offsetDateTime.toString());
                return DateTimeFormatter.ISO_DATE_TIME.format(offsetDateTime);
            }
        };
    }

}