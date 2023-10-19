package labs.lab2.primitives;

import labs.lab2.Lab2;

import java.awt.*;

public class Circle {

    private Point p;
    private int diameter;
    private Color color;
    private boolean fill;

    public Circle(Point p, int diameter,boolean fill,Color color) {
        System.out.println("Circle was created");
        this.p = p;
        this.diameter = diameter;
        this.fill = fill;
        this.color = color;
    }

    public void show(Graphics g){
        g.setColor(color);
        if(fill){
            g.fillOval(p.getX(), p.getY(),diameter,diameter);
        }else {
            g.drawOval(p.getX(), p.getY(),diameter,diameter);
        }
    }

    public void move(int dx,int dy){
        p.move(dx,dy);
        if(p.getX()> Lab2.getWindows_w()-diameter){
            p.setX(Lab2.getWindows_w()-diameter);
        }
        if(p.getY()> Lab2.getWindows_h()){
            p.setY(Lab2.getWindows_h()-diameter);
        }
        if(p.getX()<0){
            p.setX(0);
        }
        if(p.getY()<0){
            p.setY(0);
        }
    }
    public int getX() {
        return p.getX();
    }
    public void setX(int x) {
        if(x> Lab2.getWindows_w()-diameter||x<0) {
            p.setX(x);
        }
    }

    public int getY() {
        return p.getY();
    }

    public void setY(int y) {
        if(y> Lab2.getWindows_h()-diameter||y<0) {
            p.setY(y);
        }
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        if(diameter>0) {
            this.diameter = diameter;
        }
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(int r, int g, int b) {
        if(r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255) {
            this.color = new Color(r,g,b);
        }
    }
}
