package com.minton.logging.service;

import com.minton.logging.dao.OperationLogMapper;
import com.minton.logging.entity.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogService {
    private final OperationLogMapper operationLogMapper;

    @Autowired
    public OperationLogService(OperationLogMapper operationLogMapper) {
        this.operationLogMapper = operationLogMapper;
    }

    public void testInsert(OperationLog operationLog){
        operationLogMapper.testInsert(operationLog);
    }
}
