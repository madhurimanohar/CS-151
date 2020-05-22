package hw2p2;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GraphView extends JFrame implements Observer, ChangeListener {

    public class Bar extends JPanel implements Icon {

        private int width;
        private final static int HEIGHT = 20;

       public Bar(int width) {
          this.width = width;
       }
       
       public void setWidth(int w) {
           width = w;
       }
       
       public int getIconHeight() {
          return HEIGHT;
       }

       public int getIconWidth() {
          return width;
       }

       public void paintComponent(Graphics g) {
           super.paintComponent(g);
           Graphics2D g2 = (Graphics2D)g;
       }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            // TODO Auto-generated method stub
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.BLACK);
            g.drawRect (x, y, getIconWidth(), getIconHeight()); 
            
        }
    }
    
    protected static final int HEIGHT = 20;
    private DataModel m;
    private ArrayList<Integer> data;
    private ArrayList<JLabel> labels = new ArrayList<>();
    private ArrayList<Bar> icons = new ArrayList<>();

    public GraphView(DataModel m) {
        this.m = m;
        data = m.getDataInput();

        setLayout(new FlowLayout());

        for (Integer i : data) {
            Bar b = new Bar(i);
            icons.add(b);
            JLabel j = new JLabel(b);
            j.setText(i.toString());
            j.setHorizontalTextPosition(JLabel.CENTER);
            j.setVerticalTextPosition(JLabel.TOP);
            labels.add(j);
            for (JLabel jl : labels) {
                add(jl);
            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void stateChanged(ChangeEvent event) {
        data = m.getDataInput();
        int i = 0;
        for (JLabel j : labels) {
            Bar b = icons.get(i);
            b.setWidth(data.get(i));
            j.setText(data.get(i).toString());
            j.setHorizontalTextPosition(JLabel.CENTER);
            j.setVerticalTextPosition(JLabel.TOP);
            j.repaint();
            i++;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub  
    }
}
