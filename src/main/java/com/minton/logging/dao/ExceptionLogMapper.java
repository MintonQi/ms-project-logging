package com.minton.logging.dao;

import com.minton.logging.entity.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExceptionLogMapper {

    void insert(ExceptionLog exceptionLog);
}
