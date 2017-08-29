package com.game.snake;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Itamar on 29-Aug-17.
 */
public class Snake
{
    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3 ,SCALA = 10;
    private int ticks = 0, direction = DOWN , score;
    private List<Point> snakeParts;
    private Point head, cherry;
    private Random random;
    private Dimension dimension;
    private boolean over;

    public Snake(Dimension dim)
    {
        head = new Point(0,0);
        snakeParts = new ArrayList<>();
        random = new Random();
        cherry = new Point(dim.width / SCALA, dim.height / SCALA);
        dimension = dim;
        over = false;
    }

    public void GrowSnake()
    {
        ticks ++;

        if (ticks % 10 == 0 && head != null && !over)
        {
            switch (direction)
            {
                case UP:
                    addUP();
                    break;
                case DOWN:
                    addDOWN();
                    break;
                case LEFT:
                    addLEFT();
                    break;
                case RIGHT:
                    addRIGHT();
                    break;
            }

            snakeParts.remove(0);
            head = snakeParts.get(snakeParts.size() - 1);

            if (cherry != null)
            {
                if (head.equals(cherry))
                {
                    score++;
                    cherry.setLocation(dimension.width / SCALA, dimension.height / SCALA);
                }
            }
        }
    }

    private void addUP()
    {
        if (head.y - 1 > 0)
        {
            snakeParts.add(new Point(head.x , head.y - 1));
        }
        else
        {
            over = true;
        }
    }

    private void addDOWN()
    {
        if (head.y + 1 < (dimension.height / SCALA))
        {
            snakeParts.add(new Point(head.x , head.y + 1));
        }
        else
        {
            over = true;
        }
    }

    private void addLEFT()
    {
        if (head.x - 1 > 0)
        {
            snakeParts.add(new Point(head.x - 1, head.y));
        }
        else
        {
            over = true;
        }
    }

    private void addRIGHT()
    {
        if (head.x + 1 < (dimension.width / SCALA))
        {
            snakeParts.add(new Point(head.x + 1, head.y));
        }
        else
        {
            over = true;
        }
    }

    public List<Point> getSnakeParts()
    {
        return snakeParts;
    }
}
