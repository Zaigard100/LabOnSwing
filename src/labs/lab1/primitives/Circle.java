package labs.lab1.primitives;

import labs.lab1.Lab1;

import javax.swing.*;
import java.awt.*;

public class Circle {

    private int x,y;
    private int diameter;
    private Color color;

    public Circle(int x, int y, int diameter,Color color) {
        super();
        this.x = x;
        this.y = y;
        this.diameter = diameter;
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
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
