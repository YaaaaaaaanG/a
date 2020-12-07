package com.qf.controller;

import com.qf.common.BaseResult;
import com.qf.pojo.TbUser;
import com.qf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public BaseResult login(@RequestBody TbUser tbUser){
        BaseResult baseResult = new BaseResult();
        //从subjectUtils中获取主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(tbUser.getUserName(), tbUser.getPassword());
        try {
            subject.login(token);
        } catch (Exception e){
            System.out.println("登录失败");
        }
        if (subject.isAuthenticated()){
            baseResult.setCode(200);
            baseResult.setMessage("登录成功");
            return baseResult;
        }else {
            baseResult.setCode(201);
            baseResult.setMessage("登录失败");
            return baseResult;
        }
    }

    @RequestMapping("/unauth")
    public BaseResult unauth(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(202);
        baseResult.setMessage("无权限");
        return baseResult;
    }
}
