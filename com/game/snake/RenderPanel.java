package com.game.snake;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Itamar on 29-Aug-17.
 */
@SuppressWarnings("serial")
public class RenderPanel extends JPanel
{
    public static int curColor = 0;
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(curColor));
        g.fillRect(0,0,800,700);
        curColor++;
    }


}
