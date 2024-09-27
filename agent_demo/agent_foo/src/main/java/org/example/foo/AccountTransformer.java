package org.example.foo;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;

import java.io.File;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class AccountTransformer implements ClassFileTransformer {

    public AccountTransformer() {
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("agentmain load Class  :" + className);


        if (className.contains("Account")){
            System.out.println("classBeingRedefined.getTypeName()  :" + classBeingRedefined.getTypeName());

            try {
                new ByteBuddy()
                        .subclass(classBeingRedefined)
                        .method(named("operation"))
                        .intercept(MethodDelegation.to(AdviceInterceptor.class))
                        .make()
                        .saveIn(new File("D:\\temp\\hhhh"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        // 如果返回null则字节码不会被修改
        return null;
    }

}
