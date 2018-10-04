package com.ssm.controller;


import com.ssm.base.BaseController;
import com.ssm.entity.PageData;
import com.ssm.entity.ResponseEntity;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import com.ssm.service.serviceimpl.UserserviceImp;
import com.ssm.util.General;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("interface/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Resource
    private UserserviceImp userserviceImp;

    @RequestMapping(value = "user")
    public ModelAndView user(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("getUser")
    public ResponseEntity<?> getUser(HttpServletRequest request) {
        PageData pd = new PageData();
        pd.put("id", 1);
        try {
            pd = userService.getUserInfo(pd);
            return new ResponseEntity<PageData>().setState(General.SUCCESS).setData(pd).setMsg("数据获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<PageData>().setState(General.ERROR_2001).setData(null).setMsg(e.getMessage());
        }
    }

    @RequestMapping(value = "getUserlist")
    public ModelAndView getUserlist(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        List<User> userList= null;
        try {
            userList = userService.getAlluser();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        mv.addObject("userList",userList);
        mv.addObject("title","用户列表");
        mv.setViewName("list");
        return mv;
    }


    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public ResponseEntity<?> deleteUser(HttpServletRequest request){
        String  userid=request.getParameter("id");
        //controller控制 数据传输
       return  userserviceImp.deleuser(userid);


    }




}
