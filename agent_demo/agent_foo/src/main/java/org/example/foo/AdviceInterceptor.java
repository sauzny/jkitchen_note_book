package org.example.foo;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class AdviceInterceptor {

    @Advice.OnMethodEnter
    public static void onMethodEnter(){
        System.out.println("enter！");

    }

    @Advice.OnMethodExit
    public static void onMethodExit(){
        System.out.println("exit！");
    }

    /**
     * 进行方法拦截, 注意这里可以对所有修饰符的修饰的方法（包含private的方法）进行拦截
     *
     * @param method   待处理方法
     * @param callable 原方法执行
     * @return 执行结果
     */
    @RuntimeType
    public static Object intercept(@Origin Method method, @SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("agent test: before method invoke! Method name: " + method.getName());
        try {
            return callable.call();
        } catch (Exception e) {
            // 进行异常信息上报
            System.out.println("方法执行发生异常" + e.getMessage());
            throw e;
        } finally {
            System.out.println("agent test: after method invoke! Method name: " + method.getName());
            System.out.println(method + ": took " + (System.currentTimeMillis() - start) + " millisecond");
        }
    }
}
