import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import java.awt.geom.*;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class BoxedIcon implements Icon {
    private Icon icon;

    public BoxedIcon(Icon i) {
        icon = i;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(1));
        g2.draw(new Rectangle2D.Double(x, y, getIconWidth() - 2, getIconHeight() - 2));
        g2.setStroke(oldStroke);
        icon.paintIcon(c, g, x + 5, y + 5);
        //System.out.println("Padding" + padding);
    }

    @Override
    public int getIconWidth() {
        return icon.getIconWidth() + 2 + 10;
    }

    @Override
    public int getIconHeight() {
        return icon.getIconHeight() + 2 + 10;
    }
}

class MarsIcon implements Icon {
    private int size;

    /**
      Constructs a Mars icon of a given size.
      @param aSize the size of the icon
     */
    public MarsIcon(int s) {
        size = s;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        this.size = s;
    }

    public int getIconWidth() {
        return size;
    }

    public int getIconHeight() {
        return size;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double planet = new Ellipse2D.Double(x, y, size, size);
        g2.setColor(Color.RED);
        g2.fill(planet);
    }
}