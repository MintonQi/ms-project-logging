package com.minton.logging;

import com.minton.logging.dao.OperationLogMapper;
import com.minton.logging.entity.OperationLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoggingApplicationTests {

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testInsertOperation() {

    }


}
