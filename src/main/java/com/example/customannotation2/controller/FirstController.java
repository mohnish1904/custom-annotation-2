package com.example.customannotation2.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@RestController
public class FirstController {

//    @GetMapping(value = "/check")
//    public String checkDate(
////            @RequestParam(value = "start", required = false) @DateTimeFormat OffsetDateTimeSerializer start){
//            @RequestParam(name = "startDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime startDate) {
//        System.out.println(startDate);
////        String response = "working fine on "+startDate.toString();
//        return "working fine";
//    }

//   Request URI : http://localhost:8080/check?startDate=2021-09-01T00:00:00Z

    @RequestMapping("/date")
    public String checkDate(){
        return OffsetDateTime.now().toString();
    }


    @GetMapping(value = "/app")
    public String checkController() {
        System.out.println("Request reached to application");
//        String response = "working fine on "+startDate.toString();
        return "working fine : " + LocalDateTime.now();
    }

}
