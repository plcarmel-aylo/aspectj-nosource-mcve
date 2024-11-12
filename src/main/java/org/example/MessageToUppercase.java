package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MessageToUppercase {

  @Around("execution(static String *.message())")
  public Object apply(ProceedingJoinPoint joinPoint) throws Throwable {
    var message = (String) joinPoint.proceed();
    return message.toUpperCase();
  }
}
