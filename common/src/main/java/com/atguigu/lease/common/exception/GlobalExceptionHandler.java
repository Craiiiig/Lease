package com.atguigu.lease.common.exception;

import com.atguigu.lease.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class is to handle exception globally
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

}
