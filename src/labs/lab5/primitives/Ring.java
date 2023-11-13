package labs.lab5.primitives;

import labs.lab5.Lab4;

import java.awt.*;

public class Ring extends Oval {

    public Ring(Point p, int diameter1, int diameter2, Color color){
        super(p,diameter1,diameter2,true,color);
    }

    public void show(Graphics g){
        g.setColor(color);
        g.fillOval(getX(),getY(),getDiameterX(),getDiameterX());
        g.setColor(new Color(239,239,239));
        g.fillOval(getX(),getY(),getDiameterY(),getDiameterY());
    }

    public void move(int dx,int dy){
        super.move(dx, dy);
    }

    public void setX(int x){
        if(x < Lab4.getWindows_w()-Math.max(getDiameterX(),getDiameterY())&&x>0) {
            setX(x);
        }
    }

    public void setY(int y){
        if(y < Lab4.getWindows_h()-Math.max(getDiameterX(),getDiameterY())&&y>0) {
            setY(y);
        }
    }

    private void diameterNormalize(){
        int max = Math.max(getDiameterX(),getDiameterY());
        int min = Math.min(getDiameterX(),getDiameterY());
        setDiameterX(max);
        setDiameterY(min);
        move(0,0);
    }

    public int getDiameter1() {
        return getDiameterX();
    }

    public void setDiameter1(int diameter1) {
        if(diameter1 > 0) {
            setDiameterX(diameter1);
            diameterNormalize();
        }
    }

    public int getDiameter2() {
        return getDiameterY();
    }

    public void setDiameter2(int diameter2) {
        if(diameter2 > 0) {
            setDiameterY(diameter2);
            diameterNormalize();
        }
    }

}
