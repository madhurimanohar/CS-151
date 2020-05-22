package hw2p2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TextView extends JFrame implements Observer {

    private DataModel model;
    
    public TextView(DataModel dm) {
        model = dm;
        ArrayList<Integer> data = model.getDataInput();
        ArrayList<JTextField> texts = new ArrayList<>();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        for (Integer i : data) {
            JTextField j = new JTextField();
            j.setText(i.toString());
            texts.add(j);
        }
        
        for (JTextField t : texts) {
            add(t);
            t.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JTextField tField = (JTextField) e.getSource();
                    int position = 0;
                    for (int i = 0; i < texts.size(); i++) {
                        if (texts.get(i) == tField) {
                            position = i;
                        }
                    }
                    int val = Integer.parseInt(tField.getText());
                    dm.setChanged(position, val);
                }
            });
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        
    }
}
