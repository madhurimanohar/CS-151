package lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * code for Part 1.2
 * @author madhurim
 *
 */
public class ActionTester {
    
   public static void main(String[] args) {
       
      JFrame frame = new JFrame();

      final int FIELD_WIDTH = 40;
      JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");

      JButton helloButton = new JButton("Say Hello");
      
      JButton goodbyeButton = new JButton("Say Goodbye");
      goodbyeButton.setEnabled(false);
      
      helloButton.addActionListener(event -> {
          helloButton.setEnabled(false);
          goodbyeButton.setEnabled(true);
          textField.setText("Hello\n");
      });
      
      goodbyeButton.addActionListener(event -> {
          helloButton.setEnabled(true);
          goodbyeButton.setEnabled(false);
          textField.setText("Goodbye\n");
      });

     // helloButton.addActionListener(event ->
     //    textField.setText("Hello, World!"));

     // JButton goodbyeButton = new JButton("Say Goodbye");

      frame.setLayout(new FlowLayout());

      frame.add(helloButton);
      frame.add(goodbyeButton);
      frame.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
