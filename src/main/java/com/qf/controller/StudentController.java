package com.qf.controller;

import com.qf.common.BaseResult;
import com.qf.service.StudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/findAll")
    @RequiresPermissions(value = "{findAll}")
    public BaseResult findAll(@RequestParam("page")Integer page,@RequestParam("size")Integer size){
        return studentService.findAll(page,size);
    }

    @RequestMapping("update")
    public String update(){
        return "update";
    }
}
