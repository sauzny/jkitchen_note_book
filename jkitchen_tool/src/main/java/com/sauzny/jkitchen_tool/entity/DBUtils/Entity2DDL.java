package com.sauzny.jkitchen_tool.entity.DBUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.sauzny.jkitchen_tool.entity.LogEntity;

public class Entity2DDL {

    private static Map<String, String> typeMapping = Maps.newHashMap();
    
    static{
        typeMapping.put("long","long");
        typeMapping.put("double","double");
        typeMapping.put("int","int(11)");
        typeMapping.put("boolean","varchar(255)");
        typeMapping.put("java.time.LocalDate","date");
        typeMapping.put("java.sql.Date","date");
        typeMapping.put("java.lang.String","varchar(255)");
    }
    
    public static String entity2DDL(Class<?> clazz){
        
        String result = "CREATE TABLE `"+clazz.getSimpleName()+"` (";
        
        List<String> fieldList = new ArrayList<String>();
        
        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields){
            String name = field.getName();
            String typeName = field.getType().getName();
            if(typeName.contains(".") && !typeName.startsWith("java")){
                continue;
            }
            fieldList.add("`"+name+"` " + typeMapping.get(typeName));
        }
        
        return result+Joiner.on(",").join(fieldList)+")";
    }
    
    public static void main(String[] args) {
        
        String sql = Entity2DDL.entity2DDL(LogEntity.class);
        
        System.out.println(sql);
    }
}
