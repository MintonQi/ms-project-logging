package com.minton.logging;


import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.fastjson2.JSON;
import com.minton.logging.entity.ExceptionLog;
import com.minton.logging.entity.OperationLog;
import com.minton.logging.service.ExceptionLogService;
import com.minton.logging.service.OperationLogService;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperationLogService operationLogService;

    @Autowired
    private ExceptionLogService exceptionLogService;


    /**
     *  在注解的位置切入代码
     */
    @Pointcut("@annotation(com.minton.logging.OperLog)")
    public void operationLogPointcut(){
    }

    /**
     * 设置操作异常切入点 记录异常日志 扫描所有controller包下操作
     */
    @Pointcut("execution(public * com.minton.system.controller.*.*(..))")
    public void operationExceptionLogPointcut(){
    }

    @AfterReturning(value = "operationLogPointcut()", returning = "ret")
    public void saveOperationLog(JoinPoint joinPoint, Object ret){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = (HttpServletRequest) attributes.getRequest();


        //反射取到当前切入的方法，然后取到方法上的注释，及其中的值。
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        OperLog operlog = method.getAnnotation(OperLog.class);
        String desc = operlog.operationDesc();

        OperationLog oplog = new OperationLog();

        oplog.setOperation_Time(new Date());
        oplog.setOperation_Desc(desc);
        oplog.setOperation_Request_Parameters(JSON.toJSONString(request.getMethod())); //不能这么转
        oplog.setOperation_Response_Parameters(JSON.toJSONString(ret));

        //插入日志到数据库
        operationLogService.testInsert(oplog);

    }

    @AfterThrowing(pointcut = "operationExceptionLogPointcut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e){

        ExceptionLog exceptionLog = new ExceptionLog();

        exceptionLog.setException_name(e.getClass().getName());
        exceptionLog.setException_message(ExceptionUtil.stacktraceToString(e));
        exceptionLog.setException_time(new Date());

        exceptionLogService.saveExceptionLog(exceptionLog);
    }


}
