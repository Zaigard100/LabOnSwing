package labs.lab5.primitives;

import java.awt.*;

public abstract class Figure {

    Point p;
    Color color;
    boolean fill;
    public Figure(Point p,boolean fill, Color color){
        this.p = p;
        this.color = color;
        this.fill = fill;
    }

    public abstract void draw(Graphics g);
    public void show(Graphics g){
        draw(g);
    }

    public abstract boolean checkBoundaries(int dx,int dy);


    public void move(int dx, int dy){
        if(checkBoundaries(dx,dy)){
            p.move(dx,dy);
            if(this.getClass().isAssignableFrom(Line.class)){
                ((Line)this).getP2().move(dx,dy);
            }
            if(this.getClass().isAssignableFrom(Triangle.class)){
                ((Triangle)this).getP2().move(dx,dy);
                ((Triangle)this).getP3().move(dx,dy);
            }
            if(this.getClass().isAssignableFrom(Quadrangle.class)|| this.getClass().isAssignableFrom(Rect.class)|| this.getClass().isAssignableFrom(Romb.class)|| this.getClass().isAssignableFrom(Trapezoid.class)){
                ((Quadrangle)this).getP1().move(dx,dy);
                ((Quadrangle)this).getP2().move(dx,dy);
                ((Quadrangle)this).getP3().move(dx,dy);
                ((Quadrangle)this).getP4().move(dx,dy);
            }

        }
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
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
