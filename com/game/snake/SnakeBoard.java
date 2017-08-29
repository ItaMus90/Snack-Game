package com.game.snake;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by Itamar on 29-Aug-17.
 */
public class SnakeBoard implements ActionListener
{
    private static SnakeBoard snakeBoard = null;
    private static boolean firstThread = true;
    private Timer timer = new Timer(20,this);
    private JFrame jFrame;
    private RenderPanel panel;
    private Snake snake;
    private Dimension dimension;

    private SnakeBoard()
    {
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        snake = new Snake(dimension);
        jFrame = new JFrame("SnakeBoard");
        jFrame.setVisible(true);
        jFrame.setSize(800,700);
        jFrame.setLocation(dimension.width / (2 * jFrame.getWidth()),dimension.height / (2 * jFrame.getHeight()));
        jFrame.add(panel = new RenderPanel(snake));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
    }

    public static synchronized SnakeBoard getInstance()
    {
        if (snakeBoard == null)
        {
            if(firstThread)
            {
                firstThread = false;
                Thread.currentThread();

                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ie)
                {
                    JOptionPane.showMessageDialog(null,ie.getMessage());
                }
            }

            synchronized (SnakeBoard.class)
            {
                if (snakeBoard == null)
                {
                    snakeBoard = new SnakeBoard();
                }
            }
        }

        return snakeBoard;
    }

    public static void main(String[] args)
    {
        SnakeBoard snakeBoard = SnakeBoard.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        panel.repaint();
        snake.GrowSnake();
    }
}
