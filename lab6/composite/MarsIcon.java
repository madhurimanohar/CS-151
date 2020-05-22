package lab6;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.Icon;

public class MarsIcon implements Icon{ 
    private int size; 
    private Icon icon;

    public MarsIcon(int aSize) { 
        size = aSize; 
    }
    public int getIconWidth() { 
        return this.size; 
    }
    public int getIconHeight() { 
        return this.size; 
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double planet = new Ellipse2D.Double(x, y,
              size, size);
        g2.setColor(Color.RED);
        g2.fill(planet);
    }
}


