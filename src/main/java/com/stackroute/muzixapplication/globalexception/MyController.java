package com.stackroute.muzixapplication.globalexception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyController {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionhandler(Exception e)
    {
        return new ResponseEntity<>("erorr exception occured in music application"   +e.getMessage(), HttpStatus.CONFLICT);
    }
}
