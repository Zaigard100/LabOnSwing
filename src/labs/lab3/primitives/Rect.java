package labs.lab3.primitives;

import labs.lab3.Lab3;

import java.awt.*;

public class Rect extends Quadro {

    public Rect(Point p, int width, int height, boolean fill, Color color) {
        super(p, width, height, fill, color);
    }

    @Override
    public void show(Graphics g) {
        int[] x_point = new int[]{p.getX()-width/2,p.getX()+width/2, p.getX()+width/2, p.getX()-width/2};
        int[] y_point = new int[]{p.getY()-height/2, p.getY()-height/2,p.getY()+height/2,p.getY()+height/2};

        g.setColor(color);
        if(isFill()){
            g.fillPolygon(x_point,y_point,4);
        }else{
            g.drawPolygon(x_point,y_point,4);
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
