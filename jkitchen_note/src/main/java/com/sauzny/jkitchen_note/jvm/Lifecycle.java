package com.sauzny.jkitchen_note.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.List;

/**
 * *************************************************************************
 * 
 * @文件名称: Lifecycle.java
 *
 * @包路径 : com.sauzny.javaknife.jvm
 *
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:
 * 
 * @创建人: ljx
 *
 * @创建时间: 2016年9月23日 - 下午3:48:57
 *
 **************************************************************************
 */
public final class Lifecycle {

    private Lifecycle() {}

    /**
     * 	方法描述:  
     *   
     *  @author  ljx 创建时间 2016年9月23日 下午4:20:21
     */
    public static String start() {
        
        // 操作系统
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        
        // 运行时信息
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        String osName = operatingSystemMXBean.getName();
        int availableProcessors = operatingSystemMXBean.getAvailableProcessors();

        String name = runtimeMXBean.getName();
        String vmName = runtimeMXBean.getVmName();

        System.out.println("操作系统名字：" + osName);
        System.out.println("可使用的处理器数目：" + availableProcessors);

        System.out.println("进程号：" + name.split("@")[0]);
        System.out.println("计算机名：" + name.split("@")[1]);
        System.out.println("jvm信息：" + vmName);

        // 注册 ShutdownHook
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    end();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        return "";
    }
    
    /**
     * 	方法描述:   结束的时候 输出 内存回收信息  
     *   
     *  @author  ljx 创建时间 2016年9月23日 下午4:19:56
     */
    public static void end(){
        
        System.out.println("ShutdownHook 阶段 ");
        
        // 不同的内存管理器 使用了不同的 回收方式
        List<GarbageCollectorMXBean> garbageCollectorMXBeanList = ManagementFactory.getGarbageCollectorMXBeans();
        
        for(GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeanList){
            System.out.println();
            System.out.println("内存管理器名字：" + garbageCollectorMXBean.getName());
            System.out.println("回收累计次数：" + garbageCollectorMXBean.getCollectionCount());
            System.out.println("回收累计耗时：" + garbageCollectorMXBean.getCollectionTime());
        }
        
    }

    public static void main(String[] args) {
        Lifecycle.start();
        System.out.println();
        System.out.println("do something...");
        System.out.println();
    }

}
