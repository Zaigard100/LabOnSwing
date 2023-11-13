package labs.lab5.primitives;

import labs.lab5.Lab4;

import java.awt.*;

public class Quadro extends Figure {

    int width, height;
    boolean fill;

    public Quadro(Point p, int width, int height, boolean fill, Color color) {
        super(p, color);
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    @Override
    public void show(Graphics g) {

    }

    @Override
    public boolean checkBoundaries(int dx, int dy) {

        if(p.getX() + dx + getWidth()/2 > Lab4.getWindows_w()){
            return false;
        }
        if(p.getY() + dy + getHeight()/2 > Lab4.getWindows_h()){
            return false;
        }
        if(p.getX()+dx - getWidth()/2 < 0){
            return false;
        }
        if(p.getY()+dy - getHeight()/2 < 0){
            return false;
        }

        return true;

    }

    public int getX(){
        return p.getX();
    }

    public int getY(){
        return p.getY();
    }

    public void setX(int x) {
        if(x< Lab4.getWindows_w()-getWidth()/2&&x>getWidth()/2) {
            p.setX(x);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public void setY(int y) {
        if(y< Lab4.getWindows_h()-getHeight()/2&&y> getHeight()/2) {
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
