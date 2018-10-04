package com.ssm.controller;

import com.ssm.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController extends BaseController {

    @RequestMapping(value = "/login_toLogin")
    public ModelAndView toLogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title","欢迎使用Thymeleaf!");
        mv.setViewName("index");
        return mv;
    }
}
