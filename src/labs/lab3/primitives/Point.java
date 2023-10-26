package labs.lab3.primitives;

import labs.lab3.Lab3;

public class Point {

    private int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void move(int dx,int dy){

        if(x+dx < 0){
            x = 0;
            dx = 0;
            dy = 0;
        }

        if(x+dx > Lab3.getWindows_w()){
            x= Lab3.getWindows_w();
            dx = 0;
            dy = 0;
        }

        if(y+dy < 0){
            y = 0;
            dx = 0;
            dy = 0;
        }

        if(y+dy > Lab3.getWindows_h()){
            y = Lab3.getWindows_h();
            dx = 0;
            dy = 0;
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
