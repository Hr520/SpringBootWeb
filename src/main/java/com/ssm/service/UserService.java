package com.ssm.service;

import com.ssm.dao.DaoSupport;
import com.ssm.entity.PageData;
import com.ssm.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private DaoSupport dao;


    public PageData getUserInfo(PageData pd) throws Exception {
       return (PageData)dao.findForObject("UserMapper.getUserInfo",pd);
    }

    public List<User> getAlluser() throws Exception {
        return (List<User>) dao.findForList("UserMapper.getAlluser",new PageData());
    }
}
