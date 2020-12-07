package com.qf.dao;

import com.qf.pojo.TbPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbPermissionMapper {

    List<TbPermission> findByPermissionByUserName(@Param("username")String username);
}
