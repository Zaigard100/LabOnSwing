package labs.lab4.primitives;

import labs.lab4.Lab4;

import java.awt.*;

public class Oval extends Figure {
    int diameterX, diameterY;
    boolean fill;
    public Oval(Point p, int diameterX, int diameterY, boolean fill, Color color) {
        super(p, color);
        this.diameterX = diameterX;
        this.diameterY = diameterY;
        this.fill = fill;
    }

    @Override
    public void show(Graphics g) {
        g.setColor(color);
        if(isFill()){
            g.fillOval(p.getX()-getDiameterX()/2, p.getY()- getDiameterY() /2, getDiameterX(), getDiameterY());
        }else {
            g.drawOval(p.getX()-getDiameterX()/2, p.getY()- getDiameterY() /2, getDiameterX(), getDiameterY());
        }
    }

    @Override
    public boolean checkBoundaries(int dx, int dy) {
        if(p.getX()+dx> Lab4.getWindows_w()-getDiameterX()/2){
            return false;
        }
        if(p.getY()+dy> Lab4.getWindows_h()-getDiameterY()/2){
            return false;
        }
        if(p.getX()+dx<getDiameterX()/2){
            return false;
        }
        if(p.getY()+dy<getDiameterY()/2){
            return false;
        }
        return true;
    }

    public void rotate90(){
        int a = getDiameterX();
        setDiameterX(getDiameterY());
        setDiameterY(a);
        move(0,0);
    }

    public int getX() {
        return p.getX();
    }
    public void setX(int x) {
        if(x< Lab4.getWindows_w()-getDiameterX()/2||x>getDiameterX()/2) {
            p.setX(x);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public int getY() {
        return p.getY();
    }

    public void setY(int y) {
        if(y< Lab4.getWindows_h()-getDiameterY()/2||y>getDiameterY()/2) {
            p.setY(y);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public int getDiameterX() {
        return diameterX;
    }

    public void setDiameterX(int diameterX) {
        this.diameterX = diameterX;
    }

    public int getDiameterY() {
        return diameterY;
    }

    public void setDiameterY(int diameterY) {
        if(diameterY >0){
        this.diameterY = diameterY;
        }
    }


    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
