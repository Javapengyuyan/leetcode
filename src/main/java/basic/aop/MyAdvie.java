package basic.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAdvie {

    private Logger logger = LoggerFactory.getLogger(MyAdvie.class);

    @Pointcut(value = "execution(com.quan.controller.*.*(..)")
    public void myPointcut(){}

    @Around("myPointcut()")
    public Object mylogger(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();

        ObjectMapper mapper = new ObjectMapper();
        logger.info("调用前"+className+methodName+"传递的参数"+mapper.writeValueAsString(args));
        Object proceed = pjp.proceed();
        logger.info("调用后"+className+":"+methodName+"返回值"+mapper.writeValueAsString(args));

        return proceed;
    }

}
