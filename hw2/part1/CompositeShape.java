package hw2;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.util.ArrayList;

public class CompositeShape implements Shape {

    class PI implements PathIterator {
        private int curIn;
        private ArrayList<PathIterator> pi;

        public PI() {
            curIn = 0;
            pi = new ArrayList<>();
        }

        @Override
        public boolean isDone() {
            if (pi.size() == 0) {
                return true;
            }
            else {
                return pi.get(pi.size() - 1).isDone();
            } 
        }

        @Override
        public void next() {
            PathIterator cur = pi.get(curIn);
            if (!cur.isDone()) {
                cur.next();
            } 
            else {
                curIn++;
                pi.get(curIn).next();
            }
        }

        @Override
        public int currentSegment(float[] c) {
            PathIterator currentIterator = pi.get(curIn);
            if (!currentIterator.isDone()) {
                return currentIterator.currentSegment(c);
            } 
            else {
                curIn++;
                return pi.get(curIn).currentSegment(c);
            }
        }

        public void add(PathIterator pathIterator) {
            pi.add(pathIterator);
        }

        @Override
        public int getWindingRule() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int currentSegment(double[] coords) {
            // TODO Auto-generated method stub
            return 0;
        }
    }

    private ArrayList<Shape> shapes;

    public CompositeShape() {
        shapes = new ArrayList<>();
    }

    public void add(Shape s) {
        shapes.add(s);
    }

    public boolean contains(double x, double y) {
        for (Shape s : shapes) {
            if (s.contains(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        for (Shape s : shapes) {
            if (s.contains(x, y, w, h)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Rectangle2D r) {
        for (Shape s : shapes) {
            if (s.contains(r)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Point2D p) {
        for (Shape s : shapes) {
            if (s.contains(p)) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getBounds() {
        if (shapes.size() == 0) {
            return new Rectangle();
        }
        Shape s = shapes.get(0);
        Rectangle r = s.getBounds();

        for (int i = 1; i < shapes.size(); i++) {
            s = shapes.get(i);
            r = r.union(s.getBounds());
        }
        return r;
    }

    public Rectangle2D getBounds2D() {
        if (shapes.size() == 0) {
            return new Rectangle2D.Double();
        }
        Shape s = shapes.get(0);
        Rectangle2D r = s.getBounds2D();

        for (int i = 1; i < shapes.size(); i++) {
            s = shapes.get(i);
            Rectangle2D.union(r, s.getBounds(), r);
        }
        return r;
    }

    public PathIterator getPathIterator(AffineTransform at) {
        PI iterator = new PI();
        for (Shape s : shapes) {
            iterator.add(s.getPathIterator(at));
        }
        return iterator;
    }

    public boolean intersects(double x, double y, double w, double h) {
        for (Shape s : shapes) {
            if (s.intersects(x, y, w, h)) {
                return true;
            }
        }
        return false;
    }

    public boolean intersects(Rectangle2D r) {
        for (Shape s : shapes) {
            if (s.intersects(r)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        // TODO Auto-generated method stub
        return null;
    }
}
