package labs.lab3.primitives;

import labs.lab3.Lab3;

import java.awt.*;


public class Line extends Figure{
    Point p2;

    public Line(Point p1, Point p2, Color color) {
        super(p1,color);
        this.p2 = p2;
    }

    public void show(Graphics g){
        g.setColor(color);
        g.drawLine(p.getX(), p.getY(), p2.getX(), p2.getY());
    }

    public void move(int dx, int dy){
        int max_x,max_y,min_x,min_y;
        max_x = Math.max(p.getX(),p2.getX());
        max_y = Math.max(p.getY(),p2.getY());
        min_x = Math.min(p.getX(),p2.getX());
        min_y = Math.min(p.getY(),p2.getY());
        if(max_x+dx> Lab3.getWindows_w()){
            dx = Lab3.getWindows_w()-max_x;
        }
        if(max_y+dy>Lab3.getWindows_h()){
            dy = Lab3.getWindows_h()-max_y;
        }
        if(min_x+dx<0){
            dx = -min_x;
        }
        if(min_y+dy<0){
            dy = -min_y;
        }

        p.move(dx,dy);
        p2.move(dx,dy);

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
        if (x > 0 && x < Lab3.getWindows_w()){
            p.setX(x);
        }
    }

    public void setY(int y) {
        if (y > 0 && y < Lab3.getWindows_h()){
            p.setY(y);
        }
    }

    public void setX1(int x1) {
        if (x1 > 0 && x1 < Lab3.getWindows_w()) {
            p2.setX(x1);
        }
    }

    public void setY1(int y1) {
        if (y1 > 0 && y1 < Lab3.getWindows_h()) {
            p2.setY(y1);
        }
    }

}