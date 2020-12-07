package com.qf.gloableException;

import com.qf.common.BaseResult;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UnauthorizedException.class)
    public BaseResult authonewrizationEx(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(300);
        baseResult.setMessage("无权限");
        return baseResult;
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public BaseResult unauthenticatedException(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(400);
        baseResult.setMessage("未登录");
        return baseResult;
    }
}
