package labs.lab6.primitives;

import labs.lab6.Lab6;

import java.awt.*;

public class Romb extends Quadrangle {
    int width,height;
    public Romb(Point p, int width, int height, boolean fill, Color color) {
        super(
                p,
                new Point(p.getX() - width /2, p.getY()),
                new Point(p.getX(),p.getY() - height /2),
                new Point(p.getX() + width /2, p.getY()),
                new Point(p.getX(),p.getY() + height /2),
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
            if (p.getX() + width < Lab6.getWindows_w() && p.getX() - width > 0) {
                getP1().setX(p.getX() - width / 2);
                getP3().setX(p.getX() + width / 2);
                this.width = width;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height>0) {
            if (p.getY() + height < Lab6.getWindows_h() && p.getY() - height > 0) {
                getP2().setY(p.getY() - height / 2);
                getP4().setY(p.getY() + height / 2);
                this.height = height;
            }
        }
    }
}
