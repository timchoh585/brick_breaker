package Game;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Tim on 8/19/2014.
 */
public class Racquet {

    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 0, xa = 0;
    private Main game;

    public Racquet(Main game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - 60) {
            x += xa;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, 330, 60, 10);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -game.speed * 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = game.speed * 2;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        xa = 0;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY()
    {
        return Y - HEIGHT;
    }
}