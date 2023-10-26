package labs.lab3.primitives;

import labs.lab3.Lab3;

import java.awt.*;
import java.util.Arrays;

public class Triangle extends Figure{

    Point p2,p3;
    private boolean fill;

    Color color;

    public Triangle(Point p1, Point p2, Point p3, boolean fill, Color color) {
        super(p1,color);
        this.p2 = p2;
        this.p3 = p3;
        this.fill = fill;
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
        max_x = Arrays.stream(getX_point()).max().getAsInt();
        max_y = Arrays.stream(getY_point()).max().getAsInt();
        min_x = Arrays.stream(getX_point()).min().getAsInt();
        min_y = Arrays.stream(getY_point()).min().getAsInt();
        if(max_x+dx> Lab3.getWindows_w()){
            dx = Lab3.getWindows_w()-max_x;
        }
        if(max_y+dy> Lab3.getWindows_h()){
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
        p3.move(dx,dy);

    }

    public int getX1(){
        return p.getX();
    }
    public int getY1(){
        return p.getY();
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
        if(x1>0&&x1< Lab3.getWindows_w()) {
            p.setX(x1);
        }
    }
    public void setY1(int y1){
        if(y1>0&&y1< Lab3.getWindows_h()) {
            p.setX(y1);
        }
    }
    public void setX2(int x2){
        if(x2>0&&x2< Lab3.getWindows_w()) {
            p2.setX(x2);
        }
    }
    public void setY2(int y2){
        if(y2>0&&y2< Lab3.getWindows_h()) {
            p2.setY(y2);
        }
    }
    public void setX3(int x3){
        if(x3>0&&x3< Lab3.getWindows_w()) {
            p3.setX(x3);
        }
    }
    public void setY3(int y3){
        if(y3>0&&y3< Lab3.getWindows_h()) {
            p3.setY(y3);
        }
    }

    public int[] getX_point(){
        return new int[]{p.getX(),p2.getX(),p3.getX()};
    }

    public int[] getY_point(){
        return new int[]{p.getY(),p2.getY(),p3.getY()};
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

}
