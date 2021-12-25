package com.example.cosmo_lab.admin.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("select count(*) from qna")
    public int checkDb();

}