package labs.lab2.primitives;

import labs.lab2.Lab2;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Triangle {

    Point p1,p2,p3;
    int dx1,dx2,dy1,dy2;
    private boolean fill;

    Color color;

    public Triangle(Point p1,Point p2,Point p3, boolean fill,Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.fill = fill;
        dx1 = p2.getX()-p1.getX();
        dx2 = p3.getX()-p1.getX();
        dy1 = p2.getY()-p1.getY();
        dy2 = p2.getY()-p1.getY();
        this.color = color;
    }

    public void show(Graphics g){
        g.setColor(color);
        if(fill){
            g.fillPolygon(getX_point(),getY_point(),3);
        }else {
            g.drawPolygon(getX_point(),getY_point(), 3);
        }
    }

    public void move(int dx, int dy){
        int max_x,max_y,min_x,min_y;
        int[] x_point = new int[]{p1.getX(),p2.getX(),p3.getX()};
        int[] y_point = new int[]{p1.getY(),p2.getY(),p3.getY()};
        max_x = Arrays.stream(x_point).max().getAsInt();
        max_y = Arrays.stream(y_point).max().getAsInt();
        min_x = Arrays.stream(x_point).min().getAsInt();
        min_y = Arrays.stream(y_point).min().getAsInt();
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
        p1.move(dx,dy);
        p2.move(dx,dy);
        p3.move(dx,dy);

    }

    public int getX1(){
        return p1.getX();
    }
    public int getY1(){
        return p1.getY();
    }

    public int getX2(){
        return p2.getX();
    }
    public int getY2(){
        return p2.getY();
    }

    public int getX3(){
        return p3.getX();
    }
    public int getY3(){
        return p3.getY();
    }

    public void setX1(int x1){
        if(x1>0&&x1< Lab2.getWindows_w()) {
            p1.setX(x1);
        }
    }
    public void setY1(int y1){
        if(y1>0&&y1< Lab2.getWindows_h()) {
            p1.setX(y1);
        }
    }
    public void setX2(int x2){
        if(x2>0&&x2< Lab2.getWindows_w()) {
            p2.setX(x2);
        }
    }
    public void setY2(int y2){
        if(y2>0&&y2< Lab2.getWindows_h()) {
            p2.setY(y2);
        }
    }
    public void setX3(int x3){
        if(x3>0&&x3< Lab2.getWindows_w()) {
            p3.setX(x3);
        }
    }
    public void setY3(int y3){
        if(y3>0&&y3< Lab2.getWindows_h()) {
            p3.setY(y3);
        }
    }

    public int[] getX_point(){
        return new int[]{p1.getX(),p2.getX(),p3.getX()};
    }

    public int[] getY_point(){
        return new int[]{p1.getY(),p2.getY(),p3.getY()};
    }
    public Color getColor() {
        return color;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public void setColor(int r, int g, int b) {
        if(r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255) {
            this.color = new Color(r,g,b);
        }
    }
}
