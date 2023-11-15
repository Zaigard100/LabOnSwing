package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Rect extends Quadrangle {

    int width,height;

    public Rect(Point p, int width, int height, boolean fill, Color color) {
        super(
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
            /*
                востанавливаем изначальную точку,
                т.к. у 1-ой точки(p) сдвиг по координатам равен -width,
                то центральной координатой x будет p.getX()-this.width
            */
            if(p.getX()-this.width + width<Lab5.getWindows_w()&&p.getX()-this.width - width>0) {
                getP().setX(p.getX() - width / 2);
                getP2().setX(p.getX() + width / 2);
                getP3().setX(p.getX() + width / 2);
                getP4().setX(p.getX() - width / 2);
                this.width = width;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height>0) {
            /*
                востанавливаем изначальную точку,
                т.к. у 1-ой точки(p) сдвиг по координатам равен -height,
                то центральной координатой н будет p.getY()-this.height
            */
            if(p.getY()-this.height + height<Lab5.getWindows_h()&&p.getY()-this.height - height>0) {
                getP().setY(p.getY() - height / 2);
                getP2().setY(p.getY() - height / 2);
                getP3().setY(p.getY() + height / 2);
                getP4().setY(p.getY() + height / 2);
                this.height = height;
            }
        }
    }
}
