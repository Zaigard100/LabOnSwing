package labs.lab6.primitives;

import labs.lab6.Lab6;

public class Point {

    private int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void move(int dx,int dy){
            x += dx;
            y += dy;
    }


    public boolean inFrame(int dx,int dy){
        return x+dx>0 && y+dy>0 && x+dx< Lab6.getWindows_w() && y+dy< Lab6.getWindows_h();
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
