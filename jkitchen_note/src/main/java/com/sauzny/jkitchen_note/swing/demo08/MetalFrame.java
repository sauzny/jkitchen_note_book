package com.sauzny.jkitchen_note.swing.demo08;

import javax.swing.*;

import com.sauzny.jkitchen_note.swing.demo06.BaseFrame;

import java.awt.event.*;

/**
 * 
 * @author QuinnNorris 更换主题
 */
public class MetalFrame extends JFrame {

    private JPanel buttonPanel;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public MetalFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        // 设置默认宽度和高度

        buttonPanel = new JPanel();
        // 将类的实例域中的JPanel面板对象实例化

        UIManager.LookAndFeelInfo[] infos = UIManager
                .getInstalledLookAndFeels();
        // 调用这个静态方法，我们获得所有主题

        makeButton(infos);
        // 调用makeButton方法来将主题实现

        add(buttonPanel);
        // 我们将这个添加好按钮的面板添加到原框架中
    }

    /**
     * 通过方法来创建所有的主题按钮，并且将他们关联监视器
     * 
     * @param infos
     *            包含有所有类型主题的数组
     */
    private void makeButton(final UIManager.LookAndFeelInfo[] infos) {

        for (UIManager.LookAndFeelInfo info : infos) {
            JButton button = new JButton(info.getName());
            // 用for-each循环来遍历所有的主题

            final UIManager.LookAndFeelInfo innerInfo = info;
            // 将info复制并且定义位final类型，便于内部类的使用

            buttonPanel.add(button);
            // 我们将创建的按钮添加到面板中

            // 匿名内部类，创建一个ActionListener的实例
            button.addActionListener(new ActionListener() {

                /**
                 * 当按钮点击的时候，会自动的调用actionPerformed方法
                 */
                public void actionPerformed(ActionEvent ae) {

                    try {

                        UIManager.setLookAndFeel(innerInfo.getClassName());
                        // 调用setLookAndFeel方法，更改主题

                        SwingUtilities.updateComponentTreeUI(buttonPanel);
                        // 通过这个静态方法，将更改的主题立即应用

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    public static void main(String[] args) {
        BaseFrame.JFrameRun(new MetalFrame());
    }
    
}
