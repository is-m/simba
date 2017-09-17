package cn.ism.fw.simba.security.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

import cn.ism.fw.simba.base.IUser;
import cn.ism.fw.simba.context.RequestContext;
import cn.ism.fw.simba.security.NoAuthenticationException;
import cn.ism.fw.simba.security.SecureOperation;

/**
 * 
 * 二： 切面方法说明
 * 
 * @Aspect 作用是把当前类标识为一个切面供容器读取
 * @Before 标识一个前置增强方法，相当于BeforeAdvice的功能
 * @AfterReturning 后置增强，相当于AfterReturningAdvice，方法退出时执行
 * @AfterThrowing 异常抛出增强，相当于ThrowsAdvice
 * @After final增强，不管是抛出异常或者正常退出都会执行
 * @Around 环绕增强，相当于MethodInterceptor
 * @since 2017年8月27日
 * @author Administrator
 */
@Aspect
@Component
public class SecurityAspect {

  private static final Logger LOG = LoggerFactory.getLogger(SecurityAspect.class);

  @Around("@annotation(cn.ism.fw.simba.security.SecureOperation) && @annotation(secureOperation)")
  public Object invoke(ProceedingJoinPoint joinPoint, SecureOperation secureOperation) throws Throwable {
    System.err.println("invoke----------拦截到方法啦");
    Class<?> clz = AopUtils.getTargetClass(joinPoint.getTarget());
    Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
    LOG.info("test method interceptor for class:{} ,method:{}", clz.getName(), method.getName());
    LOG.info("securiCode:" + secureOperation.code());
    IUser user = RequestContext.getCurrent().getUser();
    if(user == null) {
      throw new NoAuthenticationException();
    } 
    /*
     * Object returnValue = null; final StopWatch stopWatch = new StopWatch(); try {
     * stopWatch.start(); returnValue = pjp.proceed(); return returnValue; } catch (Throwable ex) {
     * throw ex; } finally { stopStopwatch(stopWatch); System.out.println(stopwatch); }
     */
    return joinPoint.proceed();
  }
}
