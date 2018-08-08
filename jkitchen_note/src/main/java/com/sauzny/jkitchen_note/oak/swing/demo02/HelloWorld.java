package com.sauzny.jkitchen_note.oak.swing.demo02;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author QuinnNorris
 * 输出文字
 */
public class HelloWorld {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 开启一个线程，所有的Swing组件必须由事件分派线程进行配置，线程将鼠标点击和按键控制转移到用户接口组件
        EventQueue.invokeLater(new Runnable() {
            // 匿名内部类，是一个Runnable接口的实例，实现了run方法
            public void run() {

                JFrame frame = new HelloWorldFrame();
                // HelloworldFrame在下面定义，继承了JFrame,使用其中的构造器方法

                frame.setTitle("HelloWrold");
                // 设置标题

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 选择当用户关闭框架时进行的操作 ，在有些时候需要将窗口隐藏，不能直接退出需要用到这个方法

                frame.setVisible(true);
                // 将窗口可见化，这样以便用户在第一次看见窗口之前我们能够向其中添加内容
            }
        });

    }

}

//编写继承了JFrame的类，我们的工作在这里进行
class HelloWorldFrame extends JFrame {
 public HelloWorldFrame() {

     add(new HelloWorldComponent());
     //向其中添加一个实例化的实现JComponent类的子类

     pack();
     //调用框架组件的首选大小，或者我们可以用SetSize方法来替换它
 }
}

class HelloWorldComponent extends JComponent {
 public static final int MESSAGE_X = 75;
 public static final int MESSAGE_Y = 100;

 private static final int DEFAULT_WIDTH = 300;
 private static final int DEFAULT_HEIGHT = 200;

 /**
  * 我们覆盖了这个以用来书写内容
  * 
  * @param g
  *            Graphics对象保存着用于绘制图像和文本的设置
  */
 public void paintComponent(Graphics g) {
     g.drawString("Hello World!", MESSAGE_X, MESSAGE_Y);
     // 参数：书写内容，字符串中第一个字符位于从左向右75像素，字符串中第一个字符从上向下100像素
 }

 /**
  * 我们覆盖了这个方法来表示出这个类的组件的大小
  * 
  * @return 返回这个类的组件本身应该有多大
  */
 public Dimension getPreferredSize() {
     return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
     // 返回一个Dimension对象，表示这个组件的大小
 }
}
