import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVCTester {
    
    JButton button;
    JTextField tf;
    JTextArea area;
    
    MVCTester(){

        JFrame f = new JFrame("MVCTester");
        
        button = new JButton("add");
        button.setBounds(0,0,500,30);
        f.add(button);
        
        tf = new JTextField();
        tf.setBounds(0,200,500,30);
        f.add(tf);
        
        area = new JTextArea();
        area.setBounds(0,40,490,150);
        f.add(area);
        
        area.setLineWrap(true);
        area.setWrapStyleWord(false);
        f.setSize(500, 250);
        f.setLayout(null);
        f.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller c = new Controller(area,tf);
            }
        });
    }
}
