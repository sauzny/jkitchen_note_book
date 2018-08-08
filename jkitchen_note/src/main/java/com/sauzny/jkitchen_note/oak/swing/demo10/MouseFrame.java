package com.sauzny.jkitchen_note.oak.swing.demo10;

import javax.swing.*;

import com.sauzny.jkitchen_note.oak.swing.demo06.BaseFrame;
import com.sauzny.jkitchen_note.oak.swing.demo09.ActionFrame;

/**
 * 
 * @author QuinnNorris
 * 继承JFrame的子类，将Component对象内容打包
 */
public class MouseFrame extends JFrame{

    public MouseFrame(){
        add(new MouseComponent());
        //向框架中添加一个JComponent的实例
        pack();
    }
    
    public static void main(String[] args) {
        BaseFrame.JFrameRun(new MouseFrame());
    }
}