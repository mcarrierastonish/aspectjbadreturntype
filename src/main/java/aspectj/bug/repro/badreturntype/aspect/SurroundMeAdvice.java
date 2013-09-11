package aspectj.bug.repro.badreturntype.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SurroundMeAdvice {
    @Pointcut("execution(@aspectj.bug.repro.badreturntype.anno.SurroundMe * *.*(..))")
    public void surroundMe() {
    }

    @Around("surroundMe()")
    public Object aroundSurroundMe(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
