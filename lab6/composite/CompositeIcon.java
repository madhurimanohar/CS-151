package lab6;

import java.util.*; 
import java.awt.*; 
import java.awt.geom.*;
import javax.swing.*;

public class CompositeIcon implements Icon { 
    private ArrayList<Integer> sizes;
    private ArrayList<Icon> icons;

    public CompositeIcon() { 
        icons = new ArrayList<Icon>(); 
        sizes = new ArrayList<Integer>();
    }

    public void addIcon(Icon icon) { 
        icons.add(icon);
        sizes.add(icon.getIconWidth());
    }

    public int getIconHeight() {
        int ht = 0;
        for (int i = 0; i < sizes.size(); i++) {
            ht = ht < sizes.get(i) ? sizes.get(i) : ht;
        }
        return ht;
    }
    public int getIconWidth() {
        int wd = 0;
        for (int i = 0; i < sizes.size(); i++) {
            wd += sizes.get(i);
        }
        return wd;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double planet = new Ellipse2D.Double(x, y, sizes.get(0), sizes.get(0)); 
        g2.setColor(Color.RED); 
        g2.fill(planet); 
        icons.get(1).paintIcon(null, g, sizes.get(0), 0);
    }
}

