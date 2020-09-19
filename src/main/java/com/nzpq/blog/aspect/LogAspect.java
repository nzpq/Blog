package com.nzpq.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 配置切入点表达式
     */
    @Pointcut("execution(* com.nzpq.blog.controller.*.*(..))")
    private void log(){

    }

    /**
     * 前置通知
     */
    @Before("log()")
    public void before(JoinPoint joinPoint){
        logger.info("========before=========");
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();//获取请求url
        String ip = request.getRemoteAddr();//获取请求IP
        String classMethodName = joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName();//获取类名+方法名
        Object[] args = joinPoint.getArgs();//获取请求参数
        RequestLog requestLog = new RequestLog(ip, url, classMethodName, args);
        logger.info("Request : {}",requestLog);

    }

    /**
     *后置通知
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void afterReturning(Object result){
        //记录方法执行完的返回值
        logger.info("result : {}" ,result);
        logger.info("========afterReturning=========");
    }

    /**
     * 最终通知
     */
    @After("log()")
    public void after(){
//        logger.info("=======after==========");
    }

    /**
     * 内部类，封装请求信息，用于记录日志
     */
    private class RequestLog{
        private String ip;
        private String url;
        private String classMethodName;//方法名
        private Object[] args;//请求参数

        public RequestLog(String ip, String url, String classMethodName, Object[] args) {
            this.ip = ip;
            this.url = url;
            this.classMethodName = classMethodName;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "ip='" + ip + '\'' +
                    ", url='" + url + '\'' +
                    ", classMethodName='" + classMethodName + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}
