package com.manulife.guli.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manulife.guli.pojo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//private Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
@ExceptionHandler(BindException.class)
@ResponseBody
public ResultBean validateErrorHandler(BindException e) throws JsonProcessingException {
    //1.记录错误日志
    // logger.error(e.toString());
       BindingResult bindingResult = e.getBindingResult();
        Map<String,String> result=new HashMap<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            log.error("{}:{}",field,message);
            result.put(field,message);
        }
        ObjectMapper objectMapper=new  ObjectMapper();
        String value = objectMapper.writeValueAsString(result);
        return  new ResultBean("400",value);

}

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handlerException(Exception e){
        //1.记录错误日志
       // logger.error(e.toString());
        log.error(e.toString());
     return  new ResultBean("success","当前服务器繁忙，请稍后再试！");
    }
}
