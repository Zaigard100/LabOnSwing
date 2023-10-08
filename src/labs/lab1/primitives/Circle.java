package labs.lab1.primitives;

import javax.swing.*;
import java.awt.*;

public class Circle extends JComponent {

    int x,y;
    int radius;
    Color color;

    public Circle(int x, int y, int radius,Color color) {
        super();
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public void move(int x,int y){
        this.x+=x;
        this.x+=y;
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
