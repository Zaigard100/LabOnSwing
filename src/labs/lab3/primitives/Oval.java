package labs.lab3.primitives;

import labs.lab3.Lab3;

import java.awt.*;

public class Oval extends Circle{
    int diameter2;
    public Oval(Point p, int diameterX,int diameterY, boolean fill, Color color) {
        super(p, diameterX, fill, color);
        diameter2 = diameterY;
    }

    @Override
    public void show(Graphics g) {
        g.setColor(color);
        if(isFill()){
            g.fillOval(p.getX()-getDiameter()/2, p.getY()-diameter2/2, getDiameter(),diameter2);
        }else {
            g.drawOval(p.getX()-getDiameter()/2, p.getY()-diameter2/2, getDiameter(),diameter2);
        }
    }

    @Override
    public void move(int dx, int dy) {
        Point p = new Point(this.p.getX(),this.p.getY());
        p.move(dx,dy);
        if(p.getX()> Lab3.getWindows_w()-diameter/2){
            p.setX(Lab3.getWindows_w()-diameter/2);
        }
        if(p.getY()> Lab3.getWindows_h()-diameter2/2){
            p.setY(Lab3.getWindows_h()-diameter2/2);
        }
        if(p.getX()<diameter/2){
            p.setX(diameter/2);
        }
        if(p.getY()<diameter2/2){
            p.setY(diameter2/2);
        }
        this.p = p;
    }

    public void rotate90(){
        int a = getDiameter();
        setDiameter(diameter2);
        diameter2 = a;
        move(0,0);
    }

    public int getDiameter2() {
        return diameter2;
    }

    public void setDiameter2(int diameter2) {
        if(diameter2>0){
        this.diameter2 = diameter2;
        }
    }

}
