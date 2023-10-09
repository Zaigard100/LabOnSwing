package labs.lab1.primitives;

import javax.swing.*;
import java.awt.*;

public class Circle extends JComponent {

    int x,y;
    int diameter;
    Color color;

    public Circle(int x, int y, int diameter,Color color) {
        super();
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public void move(int x,int y){
        this.x+=x;
        this.y+=y;
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
