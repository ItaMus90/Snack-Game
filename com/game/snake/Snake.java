package com.game.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Itamar on 29-Aug-17.
 */
public class Snake implements ActionListener
{
    public static Snake snake;

    public JFrame jFrame;
    public RenderPanel panel;
    public Timer timer = new Timer(20,this);


    public Snake()
    {
        Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
        jFrame = new JFrame("Snake");
        jFrame.setVisible(true);
        jFrame.setSize(800,800);
        jFrame.setLocation(dimension.width / (2 * jFrame.getWidth()),dimension.height / (2 * jFrame.getHeight()));
        jFrame.add(panel = new RenderPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
    }

    public static void main(String[] args)
    {
        snake = new Snake();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        panel.repaint();
    }
}
