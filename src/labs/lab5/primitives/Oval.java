package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Oval extends Figure {
    int diameterX, diameterY;
    public Oval(Point p, int diameterX, int diameterY, boolean fill, Color color) {
        super(p, fill, color);
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
        if(getX()+dx> Lab5.getWindows_w()-getDiameterX()/2){
            return false;
        }
        if(getY()+dy> Lab5.getWindows_h()-getDiameterY()/2){
            return false;
        }
        if(getX()+dx<getDiameterX()/2){
            return false;
        }
        if(getY()+dy<getDiameterY()/2){
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
        if(x< Lab5.getWindows_w()-getDiameterX()/2||x>getDiameterX()/2) {
            p.setX(x);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public int getY() {
        return p.getY();
    }

    public void setY(int y) {
        if(y< Lab5.getWindows_h()-getDiameterY()/2||y>getDiameterY()/2) {
            p.setY(y);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public int getDiameterX() {
        return diameterX;
    }

    public void setDiameterX(int diameterX) {
        if(diameterY >0) {
            if(getX()> Lab5.getWindows_w()-diameterX/2) return;
            if(getX()<diameterX/2)return;
            this.diameterX = diameterX;
        }
    }

    public int getDiameterY() {
        return diameterY;
    }

    public void setDiameterY(int diameterY) {
        if(diameterY >0){
            if(getY()> Lab5.getWindows_h()-diameterY/2)return;
            if(getY()<diameterY/2)return;
            this.diameterY = diameterY;
        }
    }
}
