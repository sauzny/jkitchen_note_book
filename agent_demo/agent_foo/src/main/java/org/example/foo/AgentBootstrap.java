package org.example.foo;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.ResettableClassFileTransformer;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.LockSupport;

public class AgentBootstrap {

    private final static Map<Class<?>/* Class */, Object> classBytesCache = new WeakHashMap<Class<?>, Object>();

    /**
     * 如果需要在目标JVM启动的同时加载Agent
     * @param args
     * @param inst
     */
    public static void premain(String args, Instrumentation inst) {
        main(args, inst);
    }

    /**
     * 如果希望在目标JVM运行时加载Agent
     * @param args
     * @param inst
     */
    public static void agentmain(String args, Instrumentation inst) {
        main(args, inst);
    }

    private static synchronized void main(String agentArgs, final Instrumentation inst) {
        System.out.println("Agent Main called");
        System.out.println("agentArgs : " + agentArgs);

        // 我已经在 target 中 自定义的类
        Class<?> clazz = null;
        try {
            clazz = ClassLoader.getSystemClassLoader().loadClass("org.example.Account");
            System.out.println(clazz.getTypeName());
            // 增强成功，记录类
            classBytesCache.put(clazz, new Object());
            // Arrays.stream(clazz.getMethods()).forEach(m -> System.out.println(m.getName()));
        } catch (ClassNotFoundException e) {
            return;
        }

/*

        ResettableClassFileTransformer transformer = new AgentBuilder.Default()
                .type(ElementMatchers.named("org/example/Account"))
                .transform((builder, type, loader, module, protectionDomain) -> builder
                        .method(ElementMatchers.named("operation"))
                        .intercept(MethodDelegation.to(AdviceInterceptor.class)))
                        .installOn(inst);
*/


        ResettableClassFileTransformer transformer = new AgentBuilder.Default()
                .with(AgentBuilder.PoolStrategy.Default.EXTENDED)
                .with(AgentBuilder.InitializationStrategy.NoOp.INSTANCE)
                .with(AgentBuilder.RedefinitionStrategy.REDEFINITION)
                .with(AgentBuilder.TypeStrategy.Default.REDEFINE)
                .type(ElementMatchers.named("org.example.Account"))
                .transform((builder, type, loader, module, protectionDomain) -> builder
                        .visit(Advice.to(AdviceInterceptor.class).on(ElementMatchers.named("operation")))
                )
                .installOn(inst);

        /*
        AccountTransformer transformer = new AccountTransformer();
        inst.addTransformer(transformer, true);
        try {
            inst.retransformClasses(clazz);
        } catch (UnmodifiableClassException e) {
            throw new RuntimeException(e);
        }

        */

        System.out.println("transformer installOn instrumentation");

        reset(inst);

    }

    public static void reset(final Instrumentation inst){

        new Thread(() -> {
            // 10秒之后，将原 clazz 重新 retrans 达到还原增强的效果
            LockSupport.parkNanos(Duration.ofSeconds(10).toNanos());

            try {
                for (Class<?> classInCache : classBytesCache.keySet()) {
                    inst.retransformClasses(classInCache);
                }
                System.out.println("removeTransformer and retransformClasses");
            } catch (UnmodifiableClassException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
