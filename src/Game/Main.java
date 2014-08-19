package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Tim on 8/18/2014.
 */
public class Main extends JPanel
{
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    int speed = 1;

    public Main()
    {
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }
            @Override
            public void keyPressed(KeyEvent e)
            {
                racquet.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e)
            {
                racquet.keyReleased(e);
            }
        });
        setFocusable(true);
    }

    private int getScore()
    {
        return speed - 1;
    }

    private void move()
    {
        ball.move();
        racquet.move();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d);

        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore()), 10, 30);
    }

    public void gameOver()
    {
        JOptionPane.showMessageDialog(this, "your score is: " + getScore(), "Game Over",
                JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException
    {
        JFrame mFrame = new JFrame("JFrame Tennis");
        Main game = new Main();
        mFrame.add(game);
        mFrame.setSize(400, 400);
        mFrame.setVisible(true);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true)
        {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}