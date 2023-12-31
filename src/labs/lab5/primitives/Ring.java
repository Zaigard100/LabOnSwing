package labs.lab5.primitives;

import labs.lab5.Lab5;

import java.awt.*;

public class Ring extends Oval {

    public Ring(Point p, int diameter1, int diameter2, Color color){
        super(p,diameter1,diameter2,true,color);
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(getX(),getY(),getDiameterX(),getDiameterX());
        g.setColor(new Color(239,239,239));
        g.fillOval(getX(),getY(),getDiameterY(),getDiameterY());
    }

    public void setX(int x){
        if(x < Lab5.getWindows_w()-Math.max(getDiameterX(),getDiameterY())&&x>0) {
            setX(x);
        }
    }

    public void setY(int y){
        if(y < Lab5.getWindows_h()-Math.max(getDiameterX(),getDiameterY())&&y>0) {
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
            if(getX()> Lab5.getWindows_w()-diameter1/2) return;
            if(getX()<diameter1/2)return;
            if(getY()> Lab5.getWindows_h()-diameter1/2)return;
            if(getY()<diameter1/2)return;

            setDiameterX(diameter1);
            diameterNormalize();
        }
    }

    public int getDiameter2() {
        return getDiameterY();
    }

    public void setDiameter2(int diameter2) {
        if(diameter2 > 0) {
            if(getX()> Lab5.getWindows_w()-diameter2/2) return;
            if(getX()<diameter2/2)return;
            if(getY()> Lab5.getWindows_h()-diameter2/2)return;
            if(getY()<diameter2/2)return;

            setDiameterY(diameter2);
            diameterNormalize();
        }
    }

}
