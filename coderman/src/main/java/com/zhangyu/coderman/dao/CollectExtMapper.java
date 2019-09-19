package com.zhangyu.coderman.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectExtMapper {
    @Select("select question_Id from collect where user_Id=#{userId}")
    List<Integer> findQuestionById(Integer userId);
}
