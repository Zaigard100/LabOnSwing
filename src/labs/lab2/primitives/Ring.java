package labs.lab2.primitives;

import labs.lab2.Lab2;

import java.awt.*;

public class Ring {

    private Circle c1,c2;
    private int diameter1,diameter2;
    private Color color;

    public Ring(Point p, int diameter1, int diameter2, Color color){

        this.diameter1 = Math.max(diameter1,diameter2);
        this.diameter2 = Math.min(diameter1,diameter2);
        c1 = new Circle(p,diameter1,false,color);
        c2 = new Circle(new Point(p.getX()+(diameter1-diameter2)/2, p.getY()+(diameter1-diameter2)/2),diameter2,false,color);
        this.color = color;

    }

    public void show(Graphics g){

        c1.show(g);
        c2.show(g);

    }

    public void move(int dx,int dy){

        c1.move(dx, dy);
        c2.setX(c1.getX()+(diameter1-diameter2)/2);
        c2.setY(c1.getY()+(diameter1-diameter2)/2);

    }

    public int getX(){
        return c1.getX();
    }

    public int getY(){
        return c1.getY();
    }

    public void setX(int x){
        if(x< Lab2.getWindows_w()-Math.max(diameter1,diameter2)&&x>0) {
            c1.setX(x);
            c2.setX(x+(diameter1-diameter2)/2);
        }
    }

    public void setY(int y){
        if(y< Lab2.getWindows_h()-Math.max(diameter1,diameter2)&&y>0) {
            c1.setY(y);
            c2.setY(y+(diameter1-diameter2)/2);
        }
    }

    private void diameterNormalize(){
        int max = Math.max(diameter1,diameter2);
        int min = Math.min(diameter1,diameter2);
        diameter1 = max;
        diameter2 = min;
        c1.setDiameter(max);
        c2.setDiameter(min);
        move(1,1);
        move(-1,-1);
    }

    public int getDiameter1() {
        return diameter1;
    }

    public void setDiameter1(int diameter1) {
        if(diameter1>0) {
            this.diameter1 = diameter1;
            diameterNormalize();
        }
    }

    public int getDiameter2() {
        return diameter2;
    }

    public void setDiameter2(int diameter2) {
        if(diameter2>0) {
            this.diameter2 = diameter2;
            diameterNormalize();
        }
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
