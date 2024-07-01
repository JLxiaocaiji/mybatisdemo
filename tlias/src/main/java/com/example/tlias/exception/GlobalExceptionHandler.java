package com.example.tlias.exception;


import com.example.tlias.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice   // 等于 @ControllerAdvice + @ResponseBody, 将 Result 对象转化为 Json
public class GlobalExceptionHandler {
    // 标注需要捕捉哪一类的异常
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex) {
        ex.printStackTrace();
        return Result.error("发生错误");
    }
}
