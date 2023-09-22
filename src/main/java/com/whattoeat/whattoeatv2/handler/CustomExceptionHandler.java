package com.whattoeat.whattoeatv2.handler;

import com.whattoeat.whattoeatv2.entity.User;
import com.whattoeat.whattoeatv2.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@AllArgsConstructor
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandle(Exception e){
        System.out.println(e.getMessage());
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}
