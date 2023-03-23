package com.minton.logging.dao;

import com.minton.logging.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper {
    void testInsert(OperationLog operationLog);
}
