package lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
 */
public class AnimationTester implements Runnable {
    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;
    int delay = 0;
    int x  = 0;
    int y = 0;
    
    public void run() {
        try {
            JFrame frame = new JFrame();
            frame.setLocation(x, y);

            MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);

            ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);

            // MoveableShape shape2 = new CarShape(0, 0, CAR_WIDTH);

            // ShapeIcon icon2 = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);

            JLabel label = new JLabel(icon);
            // JLabel label2 = new JLabel(icon2);
            frame.setLayout(new FlowLayout());
            frame.add(label);
            // frame.add(label2);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            //final int DELAY = 100;
            // Milliseconds between timer ticks
            Timer t = new Timer(this.delay, event ->
            {
                shape.move();
                //shape2.move();
                label.repaint();
                //label2.repaint();

            });
            t.start();
            
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {

        }
    }
    
    public void setDelay(int delay) {
        this.delay = delay;
    }
    
    public void setNewLoc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {

        AnimationTester at1 = new AnimationTester();
        AnimationTester at2 = new AnimationTester();
        Thread t1 = new Thread(at1);
        Thread t2 = new Thread(at2);
        at1.setDelay(300);
        at2.setDelay(50);
        at1.setNewLoc(100, 100);
        at2.setNewLoc(100, 300);
        t1.setName("Car 1");
        t2.setName("Car 2");
        t1.start();
        t2.start();
    }
}
