package com.sauzny.process;

public class ProcessEx {
    public static void main(String[] args) {
        ProcessHandle ph =  ProcessHandle.current();
        long pid =  ph.pid();
        System.out.println("PID："+pid);
    }
}
