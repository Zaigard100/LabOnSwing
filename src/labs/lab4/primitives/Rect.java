package labs.lab4.primitives;

import labs.lab4.Lab4;

import java.awt.*;

public class Rect extends Quadro {

    public Rect(Point p, int width, int height, boolean fill, Color color) {
        super(p, width, height, fill, color);
    }

    @Override
    public void show(Graphics g) {
        int[] x_point = new int[]{p.getX()-getWidth()/2,p.getX()+getWidth()/2, p.getX()+getWidth()/2, p.getX()-getWidth()/2};
        int[] y_point = new int[]{p.getY()-getHeight()/2, p.getY()-getHeight()/2,p.getY()+getHeight()/2,p.getY()+getHeight()/2};

        g.setColor(color);
        if(isFill()){
            g.fillPolygon(x_point,y_point,4);
        }else{
            g.drawPolygon(x_point,y_point,4);
        }
    }



}
