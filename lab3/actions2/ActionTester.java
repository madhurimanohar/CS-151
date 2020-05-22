package lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester {
    
   public static void main(String[] args) {
       
      JFrame frame = new JFrame();

      final int FIELD_WIDTH = 40;
      JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");
      
      int[] count = {1};

      JButton helloButton = new JButton("Say Hello");
      
      JButton goodbyeButton = new JButton("Say Goodbye");
      goodbyeButton.setEnabled(false);
      
      helloButton.addActionListener(event -> {
          helloButton.setEnabled(false);
          goodbyeButton.setEnabled(true);
          textField.setText("Hello\n" + count[0]);
          //count[0]++;
      });
      
      goodbyeButton.addActionListener(event -> {
          helloButton.setEnabled(true);
          goodbyeButton.setEnabled(false);
          textField.setText("Goodbye\n" + count[0]);
          count[0]++;
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
