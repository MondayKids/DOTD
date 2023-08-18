package com.dotd.user.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


/*
전역적으로 예외 처리
컨트롤러에서 발생하는 예외들을 한 곳에서 일관되게 처리할 수 있다.
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request) {

        StackTraceElement[] stackTrace = ex.getStackTrace();

        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.contains(".service.") || className.contains(".controller.")) {
                log.error("에러 발생 위치 : {}.{}", className, element.getMethodName());
                break;
            }
        }
        log.error("메시지 : {}", ex.getMessage());

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
