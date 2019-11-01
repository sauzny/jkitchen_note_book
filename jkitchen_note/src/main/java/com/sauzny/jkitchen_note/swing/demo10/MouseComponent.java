package com.sauzny.jkitchen_note.swing.demo10;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/**
 * 
 * @author QuinnNorris 鼠标点击
 */
public class MouseComponent extends JComponent {

    private static final int SIDELENGTH = 100;
    // 定义创造的正方形的边长

    private ArrayList<Rectangle2D> squares;
    // 声明一个正方形集合

    private Rectangle2D current;

    // java类库中用来描述矩形的类，它的对象可以看作是一个矩形

    /**
     * 构造器方法，做初始化工作
     */
    public MouseComponent() {

        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        // 添加一个我们实现的类，这个类继承了监测鼠标点击情况的MouseListener

        addMouseMotionListener(new MouseMotionHandler());
        // 添加另一个实现类，这个类继承了监测鼠标移动情况的MouseMotionListener
    }

    /**
     * 我们覆盖了这个以用来打印图形，将会被自动调用
     * 
     * @param g
     *            Graphics是我们要使用的2D的一个父类
     */
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        // 转换为我们需要使用的类型

        for (Rectangle2D r : squares)
            g2.draw(r);
        // 对数组中的每个正方形，都进行绘制
    }

    /**
     * 判断在这个坐标上是否有图形
     * 
     * @param p
     *            一对当前的x，y的坐标值
     * @return 返回存在的图形或者null
     */
    public Rectangle2D find(Point2D p) {

        for (Rectangle2D r : squares) {
            if (r.contains(p))
                //contains方法测定坐标是否在图形的边界内

                return r;
        }
        // 如果在squares这个数组中有这个位置的坐标，表明这个位置上非空
        // 返回这个位置上的对象

        return null;
        // 否则如果什么都没有，返回null
    }

    /**
     * 在这个坐标位置增加一个图形
     * @param p 坐标位置
     */
    public void add(Point2D p) {

        double x = p.getX();
        double y = p.getY();
        //获取x和y的坐标

        current = new Rectangle2D.Double(x - SIDELENGTH / 2,
                y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        //用获得的坐标和既定的边长构建一个新的正方形，并将其赋值给current

        squares.add(current);
        //将current添加到squares队列中

        repaint();
        //重绘图像

    }

    /**
     * 将这个位置的图形移除
     * @param s 代表所要移除的矩形对象
     */
    public void remove(Rectangle2D s) {
        if (s == null)
            return;
        //如果要移除的内容为空，直接返回

        if (s == current)
            current = null;
        //如果要移除的内容和current正指向的内容相同，则将current清空
        //避免发生不必要的错误

        squares.remove(s);
        //将s从squares的列表中直接删去

        repaint();
        //重绘图像
    }

    /**
     * 
     * @author QuinnNorris 继承了MouseAdapter类的鼠标点击控制类
     */
    private class MouseHandler extends MouseAdapter {

        /**
         * 单击鼠标操作
         */
        public void mousePressed(MouseEvent event) {

            current = find(event.getPoint());
            // 将鼠标单击的这个点的坐标的对象赋给current

            if (current == null)
                //如果这个点没有对象，当前指向空的位置

                add(event.getPoint());
                //在这个点绘制正方形
        }

        /**
         * 鼠标双击操作
         */
        public void mouseClicked(MouseEvent event) {

            current = find(event.getPoint());
            // 将鼠标单击的这个点的坐标的对象赋给current

            if (current != null && event.getClickCount() >= 2)
                //如果这个点有对象，而且点击鼠标的次数大于2

                remove(current);
                //移除current

        }
    }

    /**
     * 
     * @author QuinnNorris
     * 鼠标移动拖动类
     */
    private class MouseMotionHandler implements MouseMotionListener {

        /**
         * 鼠标光标移动到组件上，但未按下时调用
         */
        public void mouseMoved(MouseEvent event) {

            if (find(event.getPoint()) == null)
                //如果鼠标所在位置不是空

                setCursor(Cursor.getDefaultCursor());
                //则将光标的图像设置为默认的图像
            else
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                //如果当前位置有图像，则将光标样式设置为手型
        }

        /**
         * 鼠标光标在组件上按下，并拖动时调用
         */
        public void mouseDragged(MouseEvent event) {

            if (current != null) {
                //因为在调用这个方法之前肯定会调用点击鼠标的方法
                //所以我们直接判断：如果现在current不为空

                int x = event.getX();
                int y = event.getY();
                //获取到坐标

                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2,
                        SIDELENGTH, SIDELENGTH);
                //最后在鼠标放下时进行图形绘制

                repaint();
                //重绘图像
            }
        }
    }

}
