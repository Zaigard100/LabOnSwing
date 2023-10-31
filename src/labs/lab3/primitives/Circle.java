package labs.lab3.primitives;

import labs.lab3.Lab3;

import java.awt.*;

public class Circle extends Figure{

    protected int diameter;
    private boolean fill;

    public Circle(Point p, int diameter, boolean fill, Color color) {
        super(p,color);
        this.diameter = diameter;
        this.fill = fill;
    }

    public void show(Graphics g){
        g.setColor(color);
        if(fill){
            g.fillOval(p.getX()-diameter/2, p.getY()- diameter/2,diameter,diameter);
        }else {
            g.drawOval(p.getX()-diameter/2, p.getY()-diameter/2,diameter,diameter);
        }
    }

    public void move(int dx,int dy){
        Point p = new Point(this.p.getX(),this.p.getY());
        p.move(dx,dy);
        if(p.getX()> Lab3.getWindows_w()-diameter/2){
            p.setX(Lab3.getWindows_w()-diameter/2);
        }
        if(p.getY()> Lab3.getWindows_h()-diameter/2){
            p.setY(Lab3.getWindows_h()-diameter/2);
        }
        if(p.getX()<diameter/2){
            p.setX(diameter/2);
        }
        if(p.getY()<diameter/2){
            p.setY(diameter/2);
        }
        this.p = p;
    }
    public int getX() {
        return p.getX();
    }
    public void setX(int x) {
        if(x< Lab3.getWindows_w()-diameter/2||x>diameter/2) {
            p.setX(x);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public int getY() {
        return p.getY();
    }

    public void setY(int y) {
        if(y<Lab3.getWindows_h()-diameter/2||y>diameter/2) {
            p.setY(y);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        if(diameter>0) {
            this.diameter = diameter;
            move(0,0);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
