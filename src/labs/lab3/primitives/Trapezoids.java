package labs.lab3.primitives;

import labs.lab3.Lab3;

import java.awt.*;

public class Trapezoids extends Quadro{

    int width2;

    public Trapezoids(Point p, int width,int width2, int height, boolean fill, Color color) {

        super(p, Math.min(width,width2), height, fill, color);
        this.width2 = Math.max(width,width2);
    }

    @Override
    public void show(Graphics g) {
        int[] x_points = new int[]{p.getX()-width/2, p.getX()-width2/2, p.getX()+width2/2, p.getX()+width/2};
        int[] y_point = new int[]{p.getY()-height/2,p.getY()+height/2,p.getY()+height/2, p.getY()-height/2};
        g.setColor(color);
        if(isFill()){
            g.fillPolygon(x_points,y_point,4);
        }else {
            g.drawPolygon(x_points,y_point,4);
        }

    }

    @Override
    public void move(int dx, int dy) {
        Point p = new Point(this.p.getX(),this.p.getY());
        p.move(dx,dy);
        if(p.getX()> Lab3.getWindows_w()-getWidth()/2){
            p.setX(Lab3.getWindows_w()-getWidth()/2);
        }
        if(p.getY()> Lab3.getWindows_h()-getHeight()/2){
            p.setY(Lab3.getWindows_h()-getHeight()/2);
        }
        if(p.getX()<getWidth()/2){
            p.setX(getWidth()/2);
        }
        if(p.getY()<getHeight()/2){
            p.setY(getHeight()/2);
        }
        this.p = p;
    }
}
