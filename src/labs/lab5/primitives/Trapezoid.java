package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Trapezoid extends Quadro {

    int width2;

    public Trapezoid(Point p, int width, int width2, int height, boolean fill, Color color) {

        super(p, Math.max(width,width2), height, fill, color);
        this.width2 = Math.min(width,width2);
    }

    @Override
    public void show(Graphics g) {
        move(0,0);
        int[] x_points = new int[]{p.getX()-getWidth2()/2, p.getX()-getWidth()/2, p.getX()+getWidth()/2, p.getX()+getWidth2()/2};
        int[] y_point = new int[]{p.getY()-getHeight()/2,p.getY()+getHeight()/2,p.getY()+getHeight()/2, p.getY()-getHeight()/2};
        g.setColor(color);
        if(isFill()){
            g.fillPolygon(x_points,y_point,4);
        }else {
            g.drawPolygon(x_points,y_point,4);
        }

    }

    @Override
    public boolean checkBoundaries(int dx, int dy) {

        if(p.getX() + dx + Math.max(getWidth(),getWidth2())/2 > Lab5.getWindows_w()){
            return false;
        }
        if(p.getY() + dy + getHeight()/2 > Lab5.getWindows_h()){
            return false;
        }
        if(p.getX()+dx - Math.max(getWidth(),getWidth2())/2 < 0){
            return false;
        }
        if(p.getY()+dy - getHeight()/2 < 0){
            return false;
        }

        return true;

    }

    public int getWidth2() {
        return width2;
    }

    public void setWidth2(int width2) {
        if(width2>0) {
            if (p.getX() + width / 2 > Lab5.getWindows_w()) return;
            if (p.getX() - width / 2 < 0) return;
            this.width2 = width2;
        }
    }
}
