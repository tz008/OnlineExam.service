package com.onlineExam.api;


import com.OnlineExam.APIException;
import com.OnlineExam.JsonResult;
import com.OnlineExam.ResultCode;
import com.OnlineExam.annotation.ExceptionCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;

/**
 * @author
 * @description 全局异常处理
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(APIException.class)
    public JsonResult<String> APIExceptionHandler(APIException e) {
        return new JsonResult<>(ResultCode.FAILED, e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) throws NoSuchFieldException {
        // 从异常对象中拿到错误信息
        String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        // 参数的Class对象，等下好通过字段名称获取Field对象
        Class<?> parameterType = e.getParameter().getParameterType();
        // 拿到错误的字段名称
        String fieldName = e.getBindingResult().getFieldError().getField();
        Field field = parameterType.getDeclaredField(fieldName);
        // 获取Field对象上的自定义注解
        ExceptionCode annotation = field.getAnnotation(ExceptionCode.class);

        // 有注解的话就返回注解的响应信息
        if (annotation != null) {
            return new JsonResult<>(annotation.value(),annotation.message(),defaultMessage);
        }

        // 没有注解就提取错误提示信息进行返回统一错误码
        return new JsonResult<>(ResultCode.VALIDATE_FAILED, defaultMessage);
    }

}
