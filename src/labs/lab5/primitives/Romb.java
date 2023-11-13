package labs.lab5.primitives;

import java.awt.*;

public class Romb extends Quadro {
    public Romb(Point p, int width, int height, boolean fill, Color color) {
        super(p, width, height, fill, color);
    }

    @Override
    public void show(Graphics g) {
        int[] x_points = new int[]{p.getX()-getWidth()/2, p.getX(), p.getX()+getWidth()/2, p.getX()};
        int[] y_points = new int[]{p.getY(), p.getY()-getHeight()/2, p.getY(),p.getY()+getHeight()/2};
        g.setColor(color);
        if(isFill()){
            g.fillPolygon(x_points,y_points,4);
        }else{
            g.drawPolygon(x_points,y_points,4);
        }

    }

}
