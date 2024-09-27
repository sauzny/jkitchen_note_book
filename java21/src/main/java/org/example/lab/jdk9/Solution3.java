package org.example.lab.jdk9;

/**
 ProcessHandle 类，它代表一个本地操作系统进程的句柄
 */

public class Solution3 {
    public static void main(String[] args) {
        // 获取当前进程的 ProcessHandle
        ProcessHandle currentProcess = ProcessHandle.current();

        // 获取当前进程的PID
        long pid = currentProcess.pid();
        System.out.println("当前进程的PID：" + pid);

        // 获取当前进程的信息
        ProcessHandle.Info processInfo = currentProcess.info();
        System.out.println("命令行：" + processInfo.command().orElse(""));
        System.out.println("启动时间：" + processInfo.startInstant().orElse(null));
        System.out.println("累计CPU时间：" + processInfo.totalCpuDuration().orElse(null));

        /**
         * 当前进程的PID：37716
         * 命令行：C:\Users\ljxminipc\work\soft\java\jdk-21\bin\java.exe
         * 启动时间：2024-09-23T08:15:20.673Z
         * 累计CPU时间：PT0.046875S
         */
    }
}
