package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Quadro extends Figure {

    int width, height;

    public Quadro(Point p, int width, int height, boolean fill, Color color) {
        super(p, fill, color);
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    @Override
    public void show(Graphics g) {

    }

    @Override
    public boolean checkBoundaries(int dx, int dy) {

        if(p.getX() + dx + getWidth()/2 > Lab5.getWindows_w()){
            return false;
        }
        if(p.getY() + dy + getHeight()/2 > Lab5.getWindows_h()){
            return false;
        }
        if(p.getX() + dx - getWidth()/2 < 0){
            return false;
        }
        if(p.getY() + dy - getHeight()/2 < 0){
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
        if(x< Lab5.getWindows_w()-getWidth()/2&&x>getWidth()/2) {
            p.setX(x);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }

    public void setY(int y) {
        if(y< Lab5.getWindows_h()-getHeight()/2&&y> getHeight()/2) {
            p.setY(y);
        }else {
            System.out.println("Overstepping boundaries");
        }
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width>0) {
            if(p.getX() + width/2 > Lab5.getWindows_w()) return;
            if(p.getX() - width/2 < 0)return;
            this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(width>0) {
            if (p.getY() + height / 2 > Lab5.getWindows_h()) return;
            if (p.getY() - height / 2 < 0) return;
            this.height = height;
        }
    }
}
