package labs.lab3.primitives;

import labs.lab3.Lab3;

import java.awt.*;

public class Quadro extends Figure{

    int width, height;
    boolean fill;

    public Quadro(Point p,int width,int height,boolean fill, Color color) {
        super(p, color);
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    @Override
    public void show(Graphics g) {

    }

    @Override
    public void move(int dx, int dy) {

    }

    public int getX(){
        return p.getX();
    }

    public int getY(){
        return p.getY();
    }

    public void setX(int x) {
        if(x< Lab3.getWindows_w()-width/2||x>width/2) {
            p.setX(x);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public void setY(int y) {
        if(y<Lab3.getWindows_h()-height/2||y>height/2) {
            p.setY(y);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
