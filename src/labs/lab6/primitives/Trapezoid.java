package labs.lab6.primitives;

import labs.lab6.Lab6;

import java.awt.*;

public class Trapezoid extends Quadrangle {

    int width,width2,height;

    public Trapezoid(int x, int y, int width, int width2, int height, boolean fill, Color color) {
        super(
                x, y,

                x - width / 2,
                y - height / 2,

                x + width / 2,
                y - height / 2,

                x + width2 / 2,
                y + height / 2,

                x - width2 / 2,
                y + height / 2,
                fill,
                color
        );
        this.width2 = Math.min(width, width2);
    }

    public Trapezoid(Point p, int width, int width2, int height, boolean fill, Color color) {
        super(
                p,
                new Point(p.getX() - width / 2,  p.getY() - height / 2),
                new Point(p.getX() + width / 2,  p.getY() - height / 2),
                new Point(p.getX() + width2 / 2, p.getY() + height / 2),
                new Point(p.getX() - width2 / 2, p.getY() + height / 2),
                fill,
                color
        );
        this.width2 = Math.min(width, width2);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width>0) {
            if (p.getX() + width/2 < Lab6.getWindows_w() && p.getX() - width/2 > 0) {
                getP1().setX(p.getX() - width / 2);
                getP2().setX(p.getX() + width / 2);
                this.width = width;
            }
        }
    }

    public int getWidth2() {
        return width2;
    }

    public void setWidth2(int width2) {
        if(width2>0) {
            if (p.getX() + width2/2 < Lab6.getWindows_w() && p.getX() - width2/2 > 0) {
                getP3().setX(p.getX() + width2 / 2);
                getP4().setX(p.getX() - width2 / 2);
                this.width2 = width2;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height>0) {
            if ( p.getY() < Lab6.getWindows_h() && p.getY() > 0) {
                getP1().setY(p.getY() - height / 2);
                getP2().setY(p.getY() - height / 2);
                getP3().setY(p.getY() + height / 2);
                getP4().setY(p.getY() + height / 2);
                this.height = height;
            }
        }
    }
}
