package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Quadrangle extends Figure {

    Point p2,p3,p4;

    public Quadrangle(Point p1, Point p2, Point p3, Point p4, boolean fill, Color color) {
        super(p1, fill, color);
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.fill = fill;
    }

    @Override
    public void show(Graphics g) {
        int[] x_p = new int[]{p.getX(),p2.getX(),p3.getX(),p4.getX()};
        int[] y_p = new int[]{p.getY(),p2.getY(),p3.getY(),p4.getY()};

        if(isFill()){
            g.fillPolygon(x_p,y_p,4);
        }else {
            g.drawPolygon(x_p,y_p,4);
        }
    }

    @Override
    public boolean checkBoundaries(int dx, int dy) {

        if(Math.max(Math.max(p.getX(), p2.getX()),Math.max(p3.getX(), p4.getX()))+dx> Lab5.getWindows_w()/2){
            return false;
        }
        if(Math.max(Math.max(p.getY(), p2.getY()),Math.max(p3.getY(), p4.getY()))+dy> Lab5.getWindows_h()/2){
            return false;
        }
        if(Math.min(Math.min(p.getX(), p2.getX()),Math.min(p3.getX(), p4.getX()))+dx<0){
            return false;
        }
        if(Math.min(Math.min(p.getY(), p2.getY()),Math.min(p3.getY(), p4.getY()))+dy<0){
            return false;
        }
        return true;

    }

    public int getX(){
        return p.getX();
    }

    public int getY(){
        return p.getY();
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

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }
}
