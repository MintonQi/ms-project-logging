package com.minton.logging.service;

import com.minton.logging.dao.ExceptionLogMapper;
import com.minton.logging.entity.ExceptionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionLogService {

    @Autowired
    private final ExceptionLogMapper exceptionLogMapper;

    public ExceptionLogService(ExceptionLogMapper exceptionLogMapper) {
        this.exceptionLogMapper = exceptionLogMapper;
    }

    public void saveExceptionLog(ExceptionLog exceptionLog){
        exceptionLogMapper.insert(exceptionLog);
    }

}
