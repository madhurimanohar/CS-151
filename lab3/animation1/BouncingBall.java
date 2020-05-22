package lab3;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class BouncingBall implements MoveableShape {
    Ellipse2D ellipse;
    private int x;
    private int y;
    private int w;
    private int h;
    private int min = 1;
    private int max = 50;
    private int result;
    
    public BouncingBall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub
     // Ellipse2D.Double(double x, double y, double w, double h)
        ellipse = new Ellipse2D.Double(x, y, w, h);
        g2.setColor(Color.CYAN);
        g2.fill(ellipse);
        g2.setColor(g2.getColor());
        g2.draw(ellipse);
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
       /* while (1) {
            for (x = w/2; x < ww -(w/2); x++) {
                   // Reposition the ball
            }
            for (; x > (w/2); x--) {
                // Reposition the ball
            }
        }*/
       result = (int) (Math.floor(Math.random() * (1 + max - min)) + min);
       y = result;
    }
}
