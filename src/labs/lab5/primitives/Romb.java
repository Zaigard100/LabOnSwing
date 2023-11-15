package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Romb extends Quadrangle {
    int width,height;
    public Romb(Point p, int width, int height, boolean fill, Color color) {
        super(
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
            /*
                востанавливаем изначальную точку,
                т.к. у 2-ой точки(p2) сдвиг по координатам равен 0,
                он и является центальной координатой для x
            */
            int x = p2.getX();
            if (x + width < Lab5.getWindows_w() && x - width > 0) {
                getP().setX(x - width / 2);
                getP3().setX(x + width / 2);
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
                т.к. у 1-ой точки(p) сдвиг по координатам равен 0,
                он и является центальной координатой для y
            */
            int y = p.getY();
            if (y + height < Lab5.getWindows_h() && y - height > 0) {
                getP2().setY(y - height / 2);
                getP4().setY(y + height / 2);
                this.height = height;
            }
        }
    }
}
