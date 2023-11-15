package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Trapezoid extends Quadrangle {

    int width,width2,height;

    public Trapezoid(Point p, int width, int width2, int height, boolean fill, Color color) {
        super(
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
            /*
                востанавливаем изначальную точку,
                т.к. у 1-ой точки(p) сдвиг по координатам равен -width,
                то центральной координатой x будет p.getX()-this.width
            */
            if (p.getX() - this.width + width < Lab5.getWindows_w() && p.getX() - this.width - width > 0) {
                getP().setX(p.getX() - width / 2);
                getP2().setX(p.getX() + width / 2);
                this.width = width;
            }
        }
    }

    public int getWidth2() {
        return width2;
    }

    public void setWidth2(int width2) {
        /*
            востанавливаем изначальную точку,
            т.к. у 1-ой точки(p) сдвиг по координатам равен -width,
            то центральной координатой x будет p.getX()-this.width
        */
        if(width2>0) {
            if (p.getX() - this.width + width2 < Lab5.getWindows_w() && p.getX() - this.width - width2 > 0) {
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
            /*
                востанавливаем изначальную точку,
                т.к. у 1-ой точки(p) сдвиг по координатам равен -height,
                то центральной координатой н будет p.getY()-this.height
            */
            if (p.getY() - this.height + height < Lab5.getWindows_h() && p.getY() + this.height - height > 0) {
                getP().setX(p.getX() - width / 2);
                getP2().setX(p.getX() + width / 2);
                getP3().setX(p.getX() + width / 2);
                getP4().setX(p.getX() - width / 2);
                this.height = height;
            }
        }
    }
}
