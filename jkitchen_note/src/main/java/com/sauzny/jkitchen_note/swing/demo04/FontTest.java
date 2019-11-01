package com.sauzny.jkitchen_note.swing.demo04;

import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

/**
 * 
 * @author QuinnNorris 特殊字体
 */
public class FontTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 开启一个线程，所有的Swing组件必须由事件分派线程进行配置，线程将鼠标点击和按键控制转移到用户接口组件。
        EventQueue.invokeLater(new Runnable() {
            // 匿名内部类，是一个Runnable接口的实例，实现了run方法
            public void run() {
                JFrame frame = new FontFrame();
                // 创建下面自己定义的SimpleFrame类对象，以便于调用构造器方法

                frame.setTitle("FontTest");
                // 设置标题

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 选择当用户关闭框架的时候进行的操作 ，在有些时候需要将窗口隐藏，不能直接退出需要用到这个方法

                frame.setVisible(true);
                // 将窗口可见化，这样以便用户在第一次看见窗口之前我们能够向其中添加内容
            }
        });
    }

}

class FontFrame extends JFrame {
    public FontFrame() {
        add(new FontComponent());
        // 向其中添加一个实例化的实现JComponent类的子类

        pack();
        // 调用框架组件的首选大小，或者我们可以用SetSize方法来替换它
    }
}

class FontComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    /**
     * 我们覆盖了这个以用来做一些工作
     * 
     * @param g
     *            Graphics对象是我们需要用的Graphics2D的父类
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // 实例化Graphics2D这个类的对象，他是参数Graphics2D的一个子类

        String message = "Hello World!";
        // 写出我们要操作的文字

        Font f = new Font("Dialog", Font.BOLD, 36);
        // 创建一个字体类型，参数包括字体族，风格类型，大小
        // 也可以通过特殊的方法，调用加载得到本地的字体包

        g2.setFont(f);
        // 将f设置在g2之中

        FontRenderContext context = g2.getFontRenderContext();
        // 通过调用方法，得到屏幕设备字体属性的描述对象

        Rectangle2D bounds = f.getStringBounds(message, context);
        // getStringBounds方法返回一个包围着字符串的矩形

        double x = (DEFAULT_WIDTH - bounds.getWidth()) / 2;
        // bounds.getWidth方法可以获得字符串的宽度

        double y = (DEFAULT_HEIGHT - bounds.getHeight()) / 2;
        // bounds.getHeight方法可以获得字符串的高度

        double ascent = -bounds.getY();
        // 获得字体的上坡度

        double baseY = y + ascent;
        // 文字的基线位置

        g2.drawString(message, (int) x, (int) y);
        // 设置字符串位置

        g2.setPaint(Color.LIGHT_GRAY);
        // 设置线条颜色为亮灰色

        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));
        // 在文字的基线上画下一条横线

        Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(),
                bounds.getHeight());

        g2.draw(rect);
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
