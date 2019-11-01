package com.sauzny.jkitchen_note.swing.demo01;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author QuinnNorris
 * 基本框架
 */
public class FrameTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 开启一个线程，所有的Swing组件必须由事件分派线程进行配置，线程将鼠标点击和按键控制转移到用户接口组件。
        EventQueue.invokeLater(new Runnable() {
            // 匿名内部类，是一个Runnable接口的实例，实现了run方法
            public void run() {

                SimpleFrame frame = new SimpleFrame();
                // 创建下面自己定义的SimpleFrame类对象，以便于调用构造器方法

                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                // 将窗口最大化
                // 其他可选属性：Frame.NORMAL ICONIFIED MAXIMIZED_HORIZ MAXIMIZED_VERT
                // MAXIMIZED_BOTH

                frame.setTitle("Christmas");
                // 设置窗口标题

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 选择当用户关闭框架时进行的操作 ，在有些时候需要将窗口隐藏，不能直接退出需要用到这个方法

                frame.setVisible(true);
                // 将窗口可见化，这样以便用户在第一次看见窗口之前我们能够向其中添加内容
            }

        });
    }
    // main结束时，程序并没有结束，而是结束了主线程，知道所有框架关闭或者调用了 System.exit事才终止程序
}
