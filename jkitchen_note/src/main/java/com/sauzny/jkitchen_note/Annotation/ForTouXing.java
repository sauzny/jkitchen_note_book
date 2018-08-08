package com.sauzny.jkitchen_note.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//在运行时执行    
@Retention(RetentionPolicy.RUNTIME)    
//注解适用地方(字段和方法)    
//@Target({ ElementType.FIELD, ElementType.METHOD }) 

//注解适用地方(参数)    
@Target({ ElementType.PARAMETER }) 
public @interface ForTouXing {

    //注解的name属性    
    public String name() default "";  
}
