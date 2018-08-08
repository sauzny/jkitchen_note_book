package com.sauzny.jkitchen_note.db.rabbitmq;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.sauzny.jkitchen_note.metrics.TestTimers;

@Component
public class QueueListenter implements MessageListener {

    /**
     * 实例化一个registry，最核心的一个模块，相当于一个应用程序的metrics系统的容器，维护一个Map
     */
    private static MetricRegistry metrics;
    
    /**
     * 在控制台上打印输出
     */
    private static ConsoleReporter reporter;
    
    /**
     * 实例化一个Meter
     */
    //private static final Timer requests = metrics.timer(name(TestTimers.class, "request"));
    private static Timer requests;
    
	@PostConstruct
	public void init(){
		System.out.println("QueueListenter init ... ");

	    /**
	     * 实例化一个registry，最核心的一个模块，相当于一个应用程序的metrics系统的容器，维护一个Map
	     */
	    metrics = new MetricRegistry();
	    
	    /**
	     * 在控制台上打印输出
	     */
	    reporter = ConsoleReporter.forRegistry(metrics).build();
	    
	    /**
	     * 实例化一个Meter
	     */
	    //private static final Timer requests = metrics.timer(name(TestTimers.class, "request"));
	    requests = metrics.timer(MetricRegistry.name(TestTimers.class, "request"));
        
        reporter.start(3, TimeUnit.SECONDS);
	}
	
    @Override
    public void onMessage(Message msg) {
        
        try{

            Timer.Context context = requests.time();
            
            //long threadId = Thread.currentThread().getId();
            String body = new String(msg.getBody(), StandardCharsets.UTF_8);
            
            //System.out.println("线程ID："+threadId+ " | 获取信息：" + body);
            
            // 测试，假设需要5秒运行
            //Thread.sleep(5000);
            
            context.stop();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
