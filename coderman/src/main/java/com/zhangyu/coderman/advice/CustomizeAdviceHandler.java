package com.zhangyu.coderman.advice;

import com.zhangyu.coderman.controller.IndexController;
import com.zhangyu.coderman.exception.CustomizeException;
import com.zhangyu.coderman.myenums.CustomizeErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class CustomizeAdviceHandler {

    protected static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView myHandException(HttpServletRequest request, Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        if(e instanceof CustomizeException){
            modelAndView.addObject("errormessage",e.getMessage());
            return modelAndView;
        }else {
            e.printStackTrace();
           logger.error("服务异常:"+e.getMessage()+"time:"+new Date());
            modelAndView.addObject("errormessage", CustomizeErrorCode.SYSTEM_Error.getMessage());
            return modelAndView;
        }
    }

}
