package com.sauzny.jkitchen_note.swing.demo01;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SimpleFrame extends JFrame {
    public SimpleFrame() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        // 修改窗口在屏幕上面的位置，改变窗口大小
        // Toolkit类包含很多与本地窗口交互的方法

        Dimension screenSize = kit.getScreenSize();
        // Toolkit的获取频幕大小的方法返回一个Dimension的类对象

        setSize((int) (screenSize.getWidth()), (int) (screenSize.getHeight()));
        // setBounds(0,0,(int)(screenSize.getWidth()),(int)(screenSize.getHeight()));
        // 定义窗口的位置和大小
        // setLocation(0,0); 定位窗口距离左上角的位置
        // setLocationByPlatform(true); 让窗口系统控制窗口位置，距离上一个窗口很小的偏移量

        // 用图片来替换窗口图标
        Image img = new ImageIcon("C:/Users/1/Pictures/xm/panda_128px_521085_easyicon.net.png").getImage();
        setIconImage(img);

    }
}