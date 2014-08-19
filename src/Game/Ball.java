package Game;

import java.awt.*;
import java.util.Random;

/**
 * Created by Tim on 8/19/2014.
 */
public class Ball
{

    private static final int DIAMETER = 30;
    int x, y = 0, xa = 1, ya = 1;
    private Main game;

    public Ball(Main game)
    {
        Random random = new Random();
        x = random.nextInt(350);
        this.game = game;
    }

    void move()
    {
        if (x + xa < 0)
            {xa = game.speed;}
        if (x + xa > game.getWidth() - 30)
            {xa = -game.speed;}
        if (y + ya < 0)
            {ya = game.speed;}
        if (y + ya > game.getHeight() -30)
            {game.gameOver();}
        if (collision())
        {
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            game.speed++;
        }

        x += xa;
        y += ya;
    }

    public void paint(Graphics2D g)
    {
        g.fillOval(x, y, 30, 30);
    }

    public boolean collision()
    {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}