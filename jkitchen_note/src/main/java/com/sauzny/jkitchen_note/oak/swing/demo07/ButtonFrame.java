package com.sauzny.jkitchen_note.oak.swing.demo07;

import java.awt.*;
import javax.swing.*;

import com.sauzny.jkitchen_note.oak.swing.demo06.BaseFrame;

import java.awt.event.*;

/**
 * 
 * @author QuinnNorris 按钮事件
 */
public class ButtonFrame extends JFrame {

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        // 设置默认宽度和高度

        buttonPanel = new JPanel();
        // 将类的实例域中的JPanel面板对象实例化

        makeButton("yellow",Color.YELLOW);
        makeButton("blue",Color.BLUE);
        makeButton("red",Color.RED);
        //调用makeButton方法来创建并添加按钮

        add(buttonPanel);
        // 我们将这个添加好按钮的面板添加到原框架中


    }

    /**
     * 通过方法来创建按钮，并且完成关联监视器和添加入面板的操作
     * @param name 创建按钮的标识
     * @param backgroundColor 点击按钮后改变的颜色，匿名内部类只能访问final修饰的变量，所以要用final
     */
    public void makeButton(String name,final Color backgroundColor){

        JButton colorButton = new JButton(name);
        //通过不同的标识名，我们创建按钮

        buttonPanel.add(colorButton);
        //我们将创建的按钮添加到面板中

        //匿名内部类，创建一个ActionListener的实例
        colorButton.addActionListener(new ActionListener(){

            /**
             * 当按钮点击的时候，会自动的调用actionPerformed方法
             */
            public void actionPerformed(ActionEvent event) {

                buttonPanel.setBackground(backgroundColor);
                // 调用setBackground方法，设置背景颜色
            }
        });
    }

    public static void main(String[] args) {
        BaseFrame.JFrameRun(new ButtonFrame());
    }
}
