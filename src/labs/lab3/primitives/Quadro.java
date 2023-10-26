package labs.lab3.primitives;

import java.awt.*;

public class Quadro extends Figure{

    int width, height;
    boolean fill;

    public Quadro(Point p,int width,int height,boolean fill, Color color) {
        super(p, color);
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    @Override
    public void show(Graphics g) {

    }

    @Override
    public void move(int dx, int dy) {

    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
