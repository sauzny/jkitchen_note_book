 package com.sauzny.jkitchen_note.swing.demo06;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author QuinnNorris
 * 共用代码
 */
public class BaseFrame {
    
    public static void JFrameRun(JFrame frame){
     // 开启一个线程，所有的Swing组件必须由事件分派线程进行配置，线程将鼠标点击和按键控制转移到用户接口组件。
        EventQueue.invokeLater(new Runnable() {
            // 匿名内部类，是一个Runnable接口的实例，实现了run方法
            public void run() {

                //JFrame frame = new JFrame();
                // 将*号的地方换成你实现的JFrame的子类，来实现你的代码

                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                // 将窗口最大化

                frame.setTitle("Christmas");
                // 设置窗口标题

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 选择当用户关闭框架的时候进行的操作 ，在有些时候需要将窗口隐藏，不能直接退出需要用到这个方法

                frame.setVisible(true);
                // 将窗口可见化，这样以便用户在第一次看见窗口之前我们能够向其中添加内容
            }

        });
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 开启一个线程，所有的Swing组件必须由事件分派线程进行配置，线程将鼠标点击和按键控制转移到用户接口组件。
        EventQueue.invokeLater(new Runnable() {
            // 匿名内部类，是一个Runnable接口的实例，实现了run方法
            public void run() {

                JFrame frame = new JFrame();
                // 将*号的地方换成你实现的JFrame的子类，来实现你的代码

                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                // 将窗口最大化

                frame.setTitle("Christmas");
                // 设置窗口标题

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 选择当用户关闭框架的时候进行的操作 ，在有些时候需要将窗口隐藏，不能直接退出需要用到这个方法

                frame.setVisible(true);
                // 将窗口可见化，这样以便用户在第一次看见窗口之前我们能够向其中添加内容
            }

        });
    }

}