package labs.lab2.primitives;

import labs.lab2.Lab2;

import javax.swing.*;
import java.awt.*;

public class Line extends JComponent {
    private Color color;
    int x,y,x1,y1;

    public Line(int x, int y, int x1, int y1,Color color) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }

    public void move(int dx, int dy){
        int max_x,max_y,min_x,min_y;
        max_x = Math.max(x,x1);
        max_y = Math.max(y,y1);
        min_x = Math.min(x,x1);
        min_y = Math.min(y,y1);
        if(max_x+dx> Lab2.getWindows_w()){
            dx = Lab2.getWindows_w()-max_x;
        }
        if(max_y+dy> Lab2.getWindows_h()){
            dy = Lab2.getWindows_h()-max_y;
        }
        if(min_x+dx<0){
            dx = -min_x;
        }
        if(min_y+dy<0){
            dy = -min_y;
        }
        x+=dx;
        y+=dy;
        x1+=dx;
        y1+=dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public void setX(int x) {
        if (x > 0 && x < Lab2.getWindows_w()){
            this.x = x;
        }
    }

    public void setY(int y) {
        if (y > 0 && y < Lab2.getWindows_h()){
            this.y = y;
        }
    }

    public void setX1(int x1) {
        if (x1 > 0 && x1 < Lab2.getWindows_w()) {
            this.x1 = x1;
        }
    }

    public void setY1(int y1) {
        if (y1 > 0 && y1 < Lab2.getWindows_h()) {
            this.y1 = y1;
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
