package com.sauzny.jkitchen_note.swing.demo05;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author QuinnNorris 添加图片
 */
public class ImageTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 开启一个线程，所有的Swing组件必须由事件分派线程进行配置，线程将鼠标点击和按键控制转移到用户接口组件。
        EventQueue.invokeLater(new Runnable() {
            // 匿名内部类，是一个Runnable接口的实例，实现了run方法
            public void run() {
                JFrame frame = new ImageFrame();
                // 创建下面自己定义的SimpleFrame类对象，以便于调用构造器方法

                frame.setTitle("ImageTest");
                // 设置标题

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 选择当用户关闭框架的时候进行的操作 ，在有些时候需要将窗口隐藏，不能直接退出需要用到这个方法

                frame.setVisible(true);
                // 将窗口可见化，这样以便用户在第一次看见窗口之前我们能够向其中添加内容
            }
        });
    }

}

class ImageFrame extends JFrame {
    public ImageFrame() {
        add(new ImageComponent());
        // 向其中添加一个实例化的实现JComponent类的子类

        pack();
        // 调用框架组件的首选大小，或者我们可以用SetSize方法来替换它
    }
}

class ImageComponent extends JComponent {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private Image image;

    /**
     * ImageComponent的构造函数，用来实例化图片
     */
    public ImageComponent(){
        image = new ImageIcon("C:/Users/1/Pictures/xm/1178333.gif").getImage();
        //通过路径得到图片
    }

    /**
     * 我们覆盖了这个以用来做一些工作
     * 
     * @param g
     *           
     */
    public void paintComponent(Graphics g) {
        if(image == null ) return;
        //如果图片不正确，则直接返回避免发生错误

        g.drawImage(image, 0,0,null);
        //在画布上给出图片
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