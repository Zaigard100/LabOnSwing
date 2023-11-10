package labs.lab3.primitives;

import labs.lab3.Lab3;

import java.awt.*;

public class Trapezoid extends Quadro{

    int width2;

    public Trapezoid(Point p, int width, int width2, int height, boolean fill, Color color) {

        super(p, Math.max(width,width2), height, fill, color);
        this.width2 = Math.min(width,width2);
    }

    @Override
    public void show(Graphics g) {
        move(0,0);
        int[] x_points = new int[]{p.getX()-width2/2, p.getX()-width/2, p.getX()+width/2, p.getX()+width2/2};
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
        if(p.getX()> Lab3.getWindows_w()-Math.max(getWidth(),getWidth2())/2){
            p.setX(Lab3.getWindows_w()-Math.max(getWidth(),getWidth2())/2);
        }
        if(p.getY()> Lab3.getWindows_h()-getHeight()/2){
            p.setY(Lab3.getWindows_h()-getHeight()/2);
        }
        if(p.getX()<Math.max(getWidth(),getWidth2())/2){
            p.setX(Math.max(getWidth(),getWidth2())/2);
        }
        if(p.getY()<getHeight()/2){
            p.setY(getHeight()/2);
        }
        setP(p);
    }


    public int getWidth2() {
        return width2;
    }

    public void setWidth2(int width2) {
        this.width2 = width2;
    }
}
