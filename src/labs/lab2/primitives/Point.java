package labs.lab2.primitives;

import labs.lab2.Lab2;

public class Point {

    int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void move(int dx,int dy){

        if(x+dx < 0){
            x = 1;
        }

        if(x+dx > Lab2.getWindows_w()){
            x= Lab2.getWindows_w();
        }

        if(y+dy < 0){
            y = 1;
        }

        if(y+dy > Lab2.getWindows_h()){
            y = Lab2.getWindows_h();
        }

        x += dx;
        y += dy;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
