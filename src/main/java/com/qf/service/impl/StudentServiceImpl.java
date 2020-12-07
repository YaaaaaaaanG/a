package com.qf.service.impl;

import com.qf.common.BaseResult;
import com.qf.dao.StudentRepository;
import com.qf.pojo.Student;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public BaseResult findAll(Integer page, Integer size) {
        PageRequest pageRequest = new PageRequest(page, size);
        Page<Student> all = studentRepository.findAll(pageRequest);
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(200);
        baseResult.setMessage("查询成功");
        baseResult.setData(all.getContent());
        baseResult.setTotal(all.getTotalElements());
        return baseResult;
    }
}
