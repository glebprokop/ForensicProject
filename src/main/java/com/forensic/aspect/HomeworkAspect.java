//package com.forensic.aspect;
//
//import org.apache.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StopWatch;
//
//import java.util.Map;
//
///**
// * {@link Aspect} class - crosscutting component used in all methods described in {@link Pointcut}`s
// *
// */
//@Component
//@Aspect
//public class HomeworkAspect {
//
//    /**
//     * Log4j logger used in project now. In the future it may be other realisation.
//     */
//    private static final Logger log = Logger.getLogger(HomeworkAspect.class);
//
//    /**
//     * Map for count of calling of application methods
//     */
//    private final Map<String, Integer> countMethodsCall;
//
//    public HomeworkAspect(Map<String, Integer> countMethodsCall) {
//        this.countMethodsCall = countMethodsCall;
//    }
//
//    public Map<String, Integer> getCountMethodsCall(){
//        return this.countMethodsCall;
//    }
//
//    /**
//     * Pointcut expression used for advising of {@link com.forensic.repository.crime} package methods
//     */
//    @Pointcut("execution(* com.forensic.repository.crime..*(..))")
//    public void repositoryPointcut(){
//    }
//
//    /**
//     * Advice used for counting of calling application methods. All information about count of call
//     * contains in logger
//     *
//     * @param jp {@link JoinPoint} object contains info about called method
//     */
//    @Before("repositoryPointcut()")
//    public void countMethodCall(JoinPoint jp){
//        String methodSignature = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
//
//        log.info("Method called: " + methodSignature);
//
//        if (countMethodsCall.containsKey(methodSignature)){
//            countMethodsCall.put(methodSignature, countMethodsCall.get(methodSignature) + 1);
//        } else {
//            countMethodsCall.put(methodSignature, 1);
//        }
//    }
//
//    /**
//     * Advice used for watching the execution time of application methods. All information about benchmarks
//     * contains in logger
//     *
//     * @param jp {@link ProceedingJoinPoint} object contains info about called method
//     */
//    @Around("repositoryPointcut()")
//    public void testRepositoryAspect(ProceedingJoinPoint jp){
//        String methodSignature = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
//
//        StopWatch watcher = new StopWatch();
//
//        try {
//            watcher.start();
//            jp.proceed();
//            watcher.stop();
//
//            log.info("For method " + methodSignature + " runtime is " + watcher.getLastTaskTimeMillis());
//        } catch (Throwable throwable) {
//            log.error("Exception in method: " + methodSignature +
//                    ". Error message: " + throwable.getMessage());
//            throwable.printStackTrace();
//        }
//    }
//}
