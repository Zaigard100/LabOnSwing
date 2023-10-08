package labs.lab1.primitives;

import javax.swing.*;
import java.awt.*;

public class Line extends JComponent {
    private Color color;
    int x,y,x1,y1;

    public Line(int x, int y, int x1, int y1,Color color) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }

    public void move(int dx, int dy){
        x+=dx;
        y+=dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
