package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Trapezoid extends Quadrangle {

    int width,width2,height;

    public Trapezoid(Point p, int width, int width2, int height, boolean fill, Color color) {//TODO проверить на ошибки
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
                т.к. у 1-ой точки(p) сдвиг по координатам равен -width/2,
                то центральной координатой x будет p.getX()-this+width/2
            */
            int x = p.getX() + this.width/2;
            if (x + width/2 < Lab5.getWindows_w() && x - width/2 > 0) {
                getP().setX(x - width / 2);
                getP2().setX(x + width / 2);
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
            т.к. у 1-ой точки(p) сдвиг по координатам равен -width/2,
            то центральной координатой x будет p.getX()+this.width/2
        */
        int x = p.getX() + this.width/2;
        if(width2>0) {
            if (x + width2/2 < Lab5.getWindows_w() && x - width2/2 > 0) {
                getP3().setX(x + width2 / 2);
                getP4().setX(x - width2 / 2);
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
                т.к. у 1-ой точки(p) сдвиг по координатам равен -height/2,
                то центральной координатой н будет p.getY()+this.height/2
            */
            int y = p.getY() + this.height/2;
            if ( y < Lab5.getWindows_h() && y > 0) {
                getP().setY(y - height / 2);
                getP2().setY(y - height / 2);
                getP3().setY(y + height / 2);
                getP4().setY(y + height / 2);
                this.height = height;
            }
        }
    }
}
