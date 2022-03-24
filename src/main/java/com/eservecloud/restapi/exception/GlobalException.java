package com.eservecloud.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleNoDataFoundException(NoDataFoundException ex)
    {
        ErrorObject eObject=new ErrorObject();
        eObject.setStatusCode(HttpStatus.NO_CONTENT.value());
        eObject.setMessage(ex.getMessage());
        eObject.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(eObject,HttpStatus.OK);

    }

}
