package com.sauzny.jkitchen_note.oak.swing.demo09;

import javax.swing.*;

import com.sauzny.jkitchen_note.oak.swing.demo06.BaseFrame;
import com.sauzny.jkitchen_note.oak.swing.demo08.MetalFrame;

import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author QuinnNorris 按钮与击键动作
 */
public class ActionFrame extends JFrame {

    private JPanel buttonPanel;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ActionFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        // 设置默认宽度和高度

        buttonPanel = new JPanel();
        // 将类的实例域中的JPanel面板对象实例化

        Action yellowAction = new ColorAction("Yellow", Color.YELLOW);
        // 创建一个自己定义的ColorAction对象yellowAction

        buttonPanel.add(new JButton(yellowAction));
        // 创建一个按钮，其属性从所提供的 Action中获取

        add(buttonPanel);
        // 我们将这个添加好按钮的面板添加到原框架中

        InputMap imap = buttonPanel
                .getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        // 我们将JPanel对象的InputMap设置为第二种输入映射，并创建该对象

        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        // 在imap中通过调用击键类KeyStroke的静态方法设置击键输入ctrl+Y的组合
        // 第二个参数是一个标志参数，将这对参数用键值对的形式存入imap

        ActionMap amap = buttonPanel.getActionMap();
        // 我们不能将InputMap直接和Action做映射，我们需要用ActionMap做过渡
        // 用JPanel中的getACtionMap方法获得amap对象

        amap.put("panel.yellow", yellowAction);
        // 将imap中标记参数对应的击键组合和相应的Action组合起来
    }

    public class ColorAction extends AbstractAction {

        /**
         * ColorAction的构造器，存放键值对
         * @param name 按钮的名称
         * @param c 按钮对应点击后显示的颜色
         */
        public ColorAction(String name, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION,
                    "Set panel color to " + name.toLowerCase());
            putValue("color", c);
            //在构造器中设置一些键值对映射,这些设置的属性将会被JPanel读取
        }

        /**
         * 当按钮点击或击键的时候，会自动的调用actionPerformed方法
         */
        public void actionPerformed(ActionEvent event) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
            // 调用setBackground方法，设置背景颜色
        }
    }
    

    public static void main(String[] args) {
        BaseFrame.JFrameRun(new ActionFrame());
    }
}
