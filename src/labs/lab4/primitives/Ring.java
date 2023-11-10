package labs.lab4.primitives;

import labs.lab4.Lab4;

import java.awt.*;

public class Ring extends Circle {

    private final Circle c2;
    private int diameter1,diameter2;

    public Ring(Point p, int diameter1, int diameter2, Color color){

        super(p,Math.max(diameter1,diameter2),true,color);
        this.diameter2 = Math.min(diameter1,diameter2);
        c2 = new Circle(p,diameter2,true,new Color(239, 239, 239));
        this.color = color;

    }

    public void show(Graphics g){

        super.show(g);
        c2.show(g);

    }

    public void move(int dx,int dy){

        super.move(dx, dy);
        c2.setP(super.getP());

    }

    public int getX(){
        return super.getX();
    }

    public int getY(){
        return super.getY();
    }

    public void setX(int x){
        if(x< Lab4.getWindows_w()-Math.max(diameter1,diameter2)&&x>0) {
            super.setX(x);
            c2.setX(x);
        }
    }

    public void setY(int y){
        if(y< Lab4.getWindows_h()-Math.max(diameter1,diameter2)&&y>0) {
            super.setY(y);
            c2.setY(y);
        }
    }

    private void diameterNormalize(){
        int max = Math.max(diameter1,diameter2);
        int min = Math.min(diameter1,diameter2);
        diameter1 = max;
        diameter2 = min;
        super.setDiameter(max);
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

}
