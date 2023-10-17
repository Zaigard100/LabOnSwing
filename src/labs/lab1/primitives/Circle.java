package labs.lab1.primitives;

import labs.lab1.Lab1;

import javax.swing.*;
import java.awt.*;

public class Circle {

    private int x,y;
    private int diameter;
    private Color color;
    private boolean fill;

    public Circle(int x, int y, int diameter,boolean fill,Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.fill = fill;
        this.color = color;
    }

    public void move(int dx,int dy){
        this.x+=dx;
        this.y+=dy;
        if(this.x>Lab1.getWindows_w()-diameter){
            this.x=Lab1.getWindows_w()-diameter;
        }
        if(this.y>Lab1.getWindows_h()){
            this.y=Lab1.getWindows_h()-diameter;
        }
        if(this.x<0){
            this.x=0;
        }
        if(this.y<0){
            this.y=0;
        }
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        if(x>Lab1.getWindows_w()-diameter||x<0) {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(this.y>Lab1.getWindows_h()||y<0) {
            this.y = y;
        }
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        if(diameter>0) {
            this.diameter = diameter;
        }
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
