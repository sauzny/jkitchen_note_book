package com.sauzny.jkitchen_note.oak.future;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class Tools {

    public static void main(String[] args) {
        
        Class<?> clazz = CompletableFuture.class;
        
        List<Method> methods = Lists.newArrayList(clazz.getMethods());
        
        methods.forEach(method -> {

            String name = method.getName();
            
            String rtName = method.getReturnType().getSimpleName();
            
            List<Class<?>> parameterTypes = Lists.newArrayList(method.getParameterTypes());
            List<String> ptNames = parameterTypes.stream().map(pt -> pt.getSimpleName()).collect(Collectors.toList());
            
            if(Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())){
                System.out.println(rtName + "\t" + name + "(" + Joiner.on(",").join(ptNames) + ")");
            }
            
        });
        
        methods.forEach(method -> {

            String name = method.getName();
            
            String rtName = method.getReturnType().getSimpleName();
            
            List<Class<?>> parameterTypes = Lists.newArrayList(method.getParameterTypes());
            List<String> ptNames = parameterTypes.stream().map(pt -> pt.getSimpleName()).collect(Collectors.toList());
            
            if(!Modifier.isStatic(method.getModifiers()) && Modifier.isPublic(method.getModifiers())){
                System.out.println(rtName + "\t" + name + "(" + Joiner.on(",").join(ptNames) + ")");
            }
            
        });
    }
}
