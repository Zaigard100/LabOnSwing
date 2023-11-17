package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Quadrangle extends Figure {

    Point p1,p2,p3,p4;

    public Quadrangle(Point pc,Point p1, Point p2, Point p3, Point p4, boolean fill, Color color) {
        super(pc, fill, color);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.fill = fill;
    }

    @Override
    public void show(Graphics g) {
        int[] x_p = new int[]{p1.getX(),p2.getX(),p3.getX(),p4.getX()};
        int[] y_p = new int[]{p1.getY(),p2.getY(),p3.getY(),p4.getY()};

        g.setColor(color);

        if(isFill()){
            g.fillPolygon(x_p,y_p,4);
        }else {
            g.drawPolygon(x_p,y_p,4);
        }
    }

    @Override
    public boolean checkBoundaries(int dx, int dy) {
        return p.inFrame(dx,dy) && p1.inFrame(dx,dy) && p2.inFrame(dx,dy) && p3.inFrame(dx,dy) && p4.inFrame(dx,dy);
    }

    public int getX(){
        return p.getX();
    }

    public int getY(){
        return p.getY();
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
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
