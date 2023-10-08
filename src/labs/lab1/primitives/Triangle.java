package labs.lab1.primitives;

import javax.swing.*;
import java.awt.*;

public class Triangle extends JComponent {

    int[] x_point, y_point;

    Color color;

    public Triangle(int x1, int y1,int x2, int y2,int x3, int y3, Color color) {
        this.x_point = new int[]{x1, x2, x3};
        this.y_point = new int[]{y1, y2, y3};
        this.color = color;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(color);
        g.drawPolygon(x_point,y_point,3);

    }


    public void move(int dx, int dy){
        x_point[0]+=dx;
        x_point[1]+=dx;
        x_point[2]+=dx;
        y_point[0]+=dy;
        y_point[1]+=dy;
        y_point[2]+=dy;
    }

    public int getX1(){
        return x_point[0];
    }
    public int getY1(){
        return y_point[0];
    }

    public int getX2(){
        return x_point[1];
    }
    public int getY2(){
        return y_point[1];
    }

    public int getX3(){
        return x_point[1];
    }
    public int getY3(){
        return y_point[1];
    }

    public void setX1(int x1){
        x_point[0]=x1;
    }
    public void setY1(int y1){
        y_point[0]=y1;
    }
    public void setX2(int x2){
        x_point[1]=x2;
    }
    public void setY2(int y2){
        y_point[1]=y2;
    }
    public void setX3(int x3){
        x_point[2]=x3;
    }
    public void setY3(int y3){
        y_point[2]=y3;
    }

    public int[] getX_point() {
        return x_point;
    }

    public int[] getY_point() {
        return y_point;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
