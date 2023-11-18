package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Triangle extends Figure {

    Point p2,p3;

    Color color;

    public Triangle(Point p1, Point p2, Point p3, boolean fill, Color color) {
        super(p1, fill, color);
        this.p2 = p2;
        this.p3 = p3;
        this.fill = fill;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        if(fill){
            g.fillPolygon(getX_point(),getY_point(),3);
        }else {
            g.drawPolygon(getX_point(),getY_point(), 3);
        }
    }

    @Override
    public boolean checkBoundaries(int dx, int dy) {
        return p.inFrame(dx,dy) && p2.inFrame(dx,dy) && p3.inFrame(dx,dy) ;
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
        if(x1>0&&x1< Lab5.getWindows_w()) {
            p.setX(x1);
        }
    }
    public void setY1(int y1){
        if(y1>0&&y1< Lab5.getWindows_h()) {
            p.setY(y1);
        }
    }
    public void setX2(int x2){
        if(x2>0&&x2< Lab5.getWindows_w()) {
            p2.setX(x2);
        }
    }
    public void setY2(int y2){
        if(y2>0&&y2< Lab5.getWindows_h()) {
            p2.setY(y2);
        }
    }
    public void setX3(int x3){
        if(x3>0&&x3< Lab5.getWindows_w()) {
            p3.setX(x3);
        }
    }
    public void setY3(int y3){
        if(y3>0&&y3< Lab5.getWindows_h()) {
            p3.setY(y3);
        }
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
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



}
