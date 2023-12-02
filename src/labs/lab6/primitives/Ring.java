package labs.lab6.primitives;

import labs.lab6.Lab6;

import java.awt.*;

public class Ring extends Oval {

    public Ring(int x,int y, int diameter1, int diameter2, Color color){
        super(x,y,Math.max(diameter1,diameter2),Math.min(diameter1,diameter2),true,color);
    }

    public Ring(Point p, int diameter1, int diameter2, Color color){
        super(p,Math.max(diameter1,diameter2),Math.min(diameter1,diameter2),true,color);
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(getX()-getDiameterX()/2,getY()-getDiameterX()/2,getDiameterX(),getDiameterX());
        g.setColor(new Color(239,239,239));
        g.fillOval(getX()-getDiameterY()/2,getY()-getDiameterY()/2,getDiameterY(),getDiameterY());

    }

    public void setX(int x){
        if(x < Lab6.getWindows_w()-Math.max(getDiameterX(),getDiameterY())&&x>0) {
            setX(x);
        }
    }

    public void setY(int y){
        if(y < Lab6.getWindows_h()-Math.max(getDiameterX(),getDiameterY())&&y>0) {
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
            if(getX()> Lab6.getWindows_w()-diameter1/2) return;
            if(getX()<diameter1/2)return;
            if(getY()> Lab6.getWindows_h()-diameter1/2)return;
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
            if(getX()> Lab6.getWindows_w()-diameter2/2) return;
            if(getX()<diameter2/2)return;
            if(getY()> Lab6.getWindows_h()-diameter2/2)return;
            if(getY()<diameter2/2)return;

            setDiameterY(diameter2);
            diameterNormalize();
        }
    }

}
