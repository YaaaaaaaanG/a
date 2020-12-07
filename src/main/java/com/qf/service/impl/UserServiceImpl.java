package com.qf.service.impl;

import com.qf.common.BaseResult;
import com.qf.dao.TbUserMapper;
import com.qf.pojo.TbUser;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    TbUserMapper tbUserMapper;


    @Override
    public BaseResult login(String username) {
        TbUser byUserName = tbUserMapper.findByUserName(username);
        BaseResult baseResult = new BaseResult();
        if (byUserName != null){
            baseResult.setCode(200);
            baseResult.setMessage("登录成功");
            return baseResult;
        }
        baseResult.setCode(201);
        baseResult.setMessage("登录失败");
        return baseResult;
    }
}
