package com.game.snake;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Itamar on 29-Aug-17.
 */
@SuppressWarnings("serial")
public class RenderPanel extends JPanel
{
    private static Color backGround = new Color(15253271);
    private Snake snake;

    public RenderPanel(Snake snake)
    {
        this.snake = snake;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(backGround);
        g.fillRect(0,0,800,700);
        g.setColor(Color.red);

        for (Point point : snake.getSnakeParts())
        {
            g.fillRect(point.x * Snake.SCALA, point.y * Snake.SCALA, Snake.SCALA, Snake.SCALA);

        }
    }


}
