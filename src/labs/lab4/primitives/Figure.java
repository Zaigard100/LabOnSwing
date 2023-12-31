package labs.lab4.primitives;

import java.awt.*;

public abstract class Figure {

    Point p;
    Color color;

    public Figure(Point p, Color color){
        this.p = p;
        this.color = color;
    }

    public abstract void show(Graphics g);

    public abstract boolean checkBoundaries(int dx,int dy);

    public void move(int dx, int dy){
        if(checkBoundaries(dx,dy)){
            p.move(dx,dy);
        }
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(int r, int g, int b) {
        if(r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255) {
            this.color = new Color(r,g,b);
        }
    }

}
