package lab3;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      
      MoveableShape shape2 = new BouncingBall(5, 5, 50, 50);
      
      ShapeIcon icon = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);
      
      JLabel label = new JLabel(icon);
      frame.setLayout(new FlowLayout());
      frame.add(label);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, event ->
         {
             shape2.move();
            label.repaint();
         });
      t.start();
   }

   /* Need to change the icon width and height to see all 
    * the cars, depending on the user input */
   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 50;
}

