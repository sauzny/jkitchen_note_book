package com.sauzny.jkitchen_note.oak.swing.demo03;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;

/**
 * 
 * @author QuinnNorris
 * 打印图形
 */
public class DrawTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 开启一个线程，所有的Swing组件必须由事件分派线程进行配置，线程将鼠标点击和按键控制转移到用户接口组件。
        EventQueue.invokeLater(new Runnable()
        {
            // 匿名内部类，是一个Runnable接口的实例，实现了run方法
            public void run(){

                JFrame frame = new DrawFrame();
                // 创建下面自己定义的SimpleFrame类对象，以便于调用构造器方法

                frame.setTitle("DrawTest");
                // 设置标题

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 选择当用户关闭框架的时候进行的操作 ，在有些时候需要将窗口隐藏，不能直接退出需要用到这个方法

                frame.setVisible(true);
                // 将窗口可见化，这样以便用户在第一次看见窗口之前我们能够向其中添加内容
            }
        });
    }

}


class DrawFrame extends JFrame
{
    public DrawFrame(){

        add(new DrawComponent());
        //向其中添加一个实例化的实现JComponent类的子类

        pack();
        //调用框架组件的首选大小，或者我们可以用SetSize方法来替换它
    }
}

class DrawComponent extends JComponent
{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    /**
     * 我们覆盖了这个以用来打印图形
     * 
     * @param g
     *            Graphics对象是我们需要用的Graphics2D的父类
     */
    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D)g;
        //实例化Graphics2D这个类的对象，他是参数Graphics2D的一个子类

        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;
        //我们设置矩形的四个属性

        Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
        //创建一个Rectangle2D的对象，这个对象继承了Sharp接口
        //Double是其中的一个静态内部类，当我们初始化时需要在Double中设置参数

        g2.setColor(Color.BLUE);
        // 为g2对象设置一种填充颜色,会影响线条颜色

        g2.fill(rect);
        // 将我们选择的颜色填充到rect表示的封闭图形中

        g2.draw(rect);
        // 传入一个实现Sharp接口的实例，并在画布上画出
        
        
        g2.draw(rect);
        //传入一个实现Sharp接口的实例，并在画布上画出

        Ellipse2D ellipse = new Ellipse2D.Double();
        //创建一个椭圆的实例

        ellipse.setFrame(rect);
        //椭圆和矩形类是兄弟关系，因为他们有着相同的边界判断方式
        //这里我们直接用rect来对椭圆形进行描述（通过椭圆的外接矩形）

        g2.draw(ellipse);
        //传入一个实现Sharp接口的实例，并在画布上画出

        g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));
        //在画布上画出一条直线

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;
        //定义圆心坐标和半径

        Ellipse2D circle = new Ellipse2D.Double();
        //创建一个圆的实例
        circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
        //设置坐标和半径
        g2.draw(circle);
        //在画布上画出一个圆
    }

    /**
     * 我们覆盖了这个方法来表示出这个类的组件的大小
     * 
     * @return 返回这个类的组件本身应该有多大
     */
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        // 返回一个Dimension对象，表示这个组件的大小
    }
}
