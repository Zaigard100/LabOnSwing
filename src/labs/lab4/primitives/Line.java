package labs.lab4.primitives;

import labs.lab4.Lab4;

import java.awt.*;


public class Line extends Figure {
    Point p2;

    public Line(Point p1, Point p2, Color color) {
        super(p1,color);
        this.p2 = p2;
    }

    public void show(Graphics g){
        g.setColor(color);
        g.drawLine(p.getX(), p.getY(), p2.getX(), p2.getY());
    }

    @Override
    public boolean checkBoundaries(int dx, int dy) {
        if(Math.max(p.getX(), p2.getX())+dx> Lab4.getWindows_w()/2){
            return false;
        }
        if(Math.max(p.getY(), p2.getY())+dy> Lab4.getWindows_h()/2){
            return false;
        }
        if(Math.min(p.getX(), p2.getX())+dx<0){
            return false;
        }
        if(Math.min(p.getY(), p2.getY())+dy<0){
            return false;
        }
        p2.move(dx,dy);
        return true;
    }

    public int getX() {
        return p.getX();
    }

    public int getY() {
        return p.getY();
    }

    public int getX1() {
        return p2.getX();
    }

    public int getY1() {
        return p2.getY();
    }

    public void setX(int x) {
        if (x > 0 && x < Lab4.getWindows_w()){
            p.setX(x);
        }
    }

    public void setY(int y) {
        if (y > 0 && y < Lab4.getWindows_h()){
            p.setY(y);
        }
    }

    public void setX1(int x1) {
        if (x1 > 0 && x1 < Lab4.getWindows_w()) {
            p2.setX(x1);
        }
    }

    public void setY1(int y1) {
        if (y1 > 0 && y1 < Lab4.getWindows_h()) {
            p2.setY(y1);
        }
    }

}