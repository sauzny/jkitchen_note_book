package com.sauzny.jkitchen_note.db.rabbitmq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.sauzny.jkitchen_note.metrics.TestTimers;

public class TestQueue extends BaseJunit4Test{
    

    /**
     * 实例化一个registry，最核心的一个模块，相当于一个应用程序的metrics系统的容器，维护一个Map
     */
    private static final MetricRegistry metrics = new MetricRegistry();
    
    /**
     * 在控制台上打印输出
     */
    private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();
    
    /**
     * 实例化一个Meter
     */
    //private static final Timer requests = metrics.timer(name(TestTimers.class, "request"));
    private static final Timer requests = metrics.timer(MetricRegistry.name(TestTimers.class, "request"));
    
    @Autowired
    Producer producer;

    final String queue_key = "message_queue";

    @Test	
    public void send() throws InterruptedException{
        
        // push数据测试代码
        
       /*     
        reporter.start(3, TimeUnit.SECONDS);

        ExecutorService service = Executors.newFixedThreadPool(40);
        
        for (int i=0; i<500000; i++) {
            
            service.execute(new Worker(producer, requests));
        }
        */
        
        while (true) {
            
        }
    }
}
    
class Worker implements Runnable {

    private Producer producer;
    private Timer requests;
    
    final String queue_key = "message_queue";
    
    public Worker(Producer producer, Timer requests){
        this.producer = producer;
        this.requests = requests;
    }
    
    @Override
    public void run() {

        Timer.Context context = requests.time();
        
        // TODO Auto-generated method stub
        String value = RandomStringUtils.randomAlphabetic(16);
        
        producer.sendDataToQueue(queue_key,value);
        
        context.stop();
    }
    
}
