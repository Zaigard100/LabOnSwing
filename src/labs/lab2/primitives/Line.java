package labs.lab2.primitives;

import java.awt.*;
import labs.lab2.Lab2;


public class Line {
    private Color color;
    Point p1,p2;

    public Line(Point p1, Point p2,Color color) {
        this.color = color;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void show(Graphics g){
        g.setColor(color);
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public void move(int dx, int dy){
        int max_x,max_y,min_x,min_y;
        max_x = Math.max(p1.getX(),p2.getX());
        max_y = Math.max(p1.getY(),p2.getY());
        min_x = Math.min(p1.getX(),p2.getX());
        min_y = Math.min(p1.getY(),p2.getY());
        if(max_x+dx> Lab2.getWindows_w()){
            dx = Lab2.getWindows_w()-max_x;
        }
        if(max_y+dy>Lab2.getWindows_h()){
            dy = Lab2.getWindows_h()-max_y;
        }
        if(min_x+dx<0){
            dx = -min_x;
        }
        if(min_y+dy<0){
            dy = -min_y;
        }

        p1.move(dx,dy);
        p2.move(dx,dy);

    }

    public int getX() {
        return p1.getX();
    }

    public int getY() {
        return p1.getY();
    }

    public int getX1() {
        return p2.getX();
    }

    public int getY1() {
        return p2.getY();
    }

    public void setX(int x) {
        if (x > 0 && x < Lab2.getWindows_w()){
            p1.setX(x);
        }
    }

    public void setY(int y) {
        if (y > 0 && y < Lab2.getWindows_h()){
            p1.setY(y);
        }
    }

    public void setX1(int x1) {
        if (x1 > 0 && x1 < Lab2.getWindows_w()) {
            p2.setX(x1);
        }
    }

    public void setY1(int y1) {
        if (y1 > 0 && y1 < Lab2.getWindows_h()) {
            p2.setY(y1);
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(int r,int g,int b) {
        if(r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255) {
            this.color = new Color(r,g,b);
        }
    }
}