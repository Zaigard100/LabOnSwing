package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Rect extends Quadrangle {

    int width,height;

    public Rect(Point p, int width, int height, boolean fill, Color color) {
        super(
                p,
                new Point(p.getX()- width /2,p.getY()- height /2),
                new Point(p.getX()+ width /2,p.getY()- height /2),
                new Point(p.getX()+ width /2,p.getY()+ height /2),
                new Point(p.getX()- width /2,p.getY()+ height /2),
                fill,
                color
        );
        this.width = width;
        this.height = height;

    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width>0) {
            int x = p.getX()+this.width/2;
            if(x + width/2<Lab5.getWindows_w()&&x - width/2>0) {
                getP1().setX(x - width / 2);
                getP2().setX(x + width / 2);
                getP3().setX(x + width / 2);
                getP4().setX(x - width / 2);
                this.width = width;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height>0) {
            int y = p.getY()+this.height/2;
            if(y + height/2<Lab5.getWindows_h()&&y - height/2>0) {
                getP1().setY(y - height / 2);
                getP2().setY(y - height / 2);
                getP3().setY(y + height / 2);
                getP4().setY(y + height / 2);
                this.height = height;
            }
        }
    }
}
