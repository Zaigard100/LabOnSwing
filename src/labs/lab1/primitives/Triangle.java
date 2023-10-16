package labs.lab1.primitives;

import labs.lab1.Lab1;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Triangle extends JComponent {

    int[] x_point, y_point;
    int dx1,dx2,dy1,dy2;

    Color color;

    public Triangle(int x1, int y1,int x2, int y2,int x3, int y3, Color color) {
        this.x_point = new int[]{x1, x2, x3};
        this.y_point = new int[]{y1, y2, y3};
        dx1 = x2-x1;
        dx2 = x3-x1;
        dy1 = y2-y1;
        dy2 = y3-y1;
        this.color = color;
    }


    public void move(int dx, int dy){
        int max_x,max_y,min_x,min_y;
        max_x = Arrays.stream(x_point).max().getAsInt();
        max_y = Arrays.stream(y_point).max().getAsInt();
        min_x = Arrays.stream(x_point).min().getAsInt();
        min_y = Arrays.stream(y_point).min().getAsInt();
        if(max_x+dx>Lab1.getWindows_w()){
            dx = Lab1.getWindows_w()-max_x;
        }
        if(max_y+dy>Lab1.getWindows_h()){
            dy = Lab1.getWindows_h()-max_y;
        }
        if(min_x+dx<0){
            dx = -min_x;
        }
        if(min_y+dy<0){
            dy = -min_y;
        }
        x_point[0]+=dx;
        x_point[1]=x_point[0]+dx1;
        x_point[2]=x_point[0]+dx2;
        y_point[0]+=dy;
        y_point[1]=y_point[0]+dy1;
        y_point[2]=y_point[0]+dy2;

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
        if(x1>0&&x1<Lab1.getWindows_w()) {
            x_point[0] = x1;
        }
    }
    public void setY1(int y1){
        if(y1>0&&y1<Lab1.getWindows_h()) {
            y_point[0] = y1;
        }
    }
    public void setX2(int x2){
        if(x2>0&&x2<Lab1.getWindows_w()) {
            x_point[1] = x2;
        }
    }
    public void setY2(int y2){
        if(y2>0&&y2<Lab1.getWindows_h()) {
            y_point[1] = y2;
        }
    }
    public void setX3(int x3){
        if(x3>0&&x3<Lab1.getWindows_w()) {
            x_point[2] = x3;
        }
    }
    public void setY3(int y3){
        if(y3>0&&y3<Lab1.getWindows_h()) {
            y_point[2] = y3;
        }
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

    public void setColor(int r,int g,int b) {
        if(r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255) {
            this.color = new Color(r,g,b);
        }
    }
}
