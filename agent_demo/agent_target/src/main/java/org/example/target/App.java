package org.example.target;

import org.example.Account;

import java.lang.management.ManagementFactory;
import java.time.Duration;
import java.util.concurrent.locks.LockSupport;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];

        for (; ; ) {
            System.out.println("");
            System.out.println(pid + " ===========================================");
            new Account().operation();
            System.out.println(pid + " ===========================================");
            System.out.println("");
            LockSupport.parkNanos(Duration.ofSeconds(2).toNanos());
        }
    }
}
