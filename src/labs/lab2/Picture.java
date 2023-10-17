package labs.lab2;

import labs.lab2.primitives.Circle;
import labs.lab2.primitives.Line;
import labs.lab2.primitives.Triangle;

import javax.swing.*;
import java.awt.*;

public class Picture extends JComponent {

    Utils utils;
    public Picture(Utils utils){
        this.utils = utils;
    }

    @Override
    protected void paintComponent(Graphics g){
        for(Circle c:utils.getCircles()){
            g.setColor(c.getColor());
            if(c.isFill()){
                g.fillOval(c.getX(),c.getY(),c.getDiameter(),c.getDiameter());
            }else {
                g.drawOval(c.getX(), c.getY(), c.getDiameter(), c.getDiameter());
            }
        }
        for(Line l:utils.getLines()){
            g.setColor(l.getColor());
            g.drawLine(l.getX(),l.getY(),l.getX1(),l.getY1());
        }
        for(Triangle t:utils.getTriangles()){
            g.setColor(t.getColor());
            if(t.isFill()){
                g.fillPolygon(t.getX_point(),t.getY_point(),3);
            }else {
                g.drawPolygon(t.getX_point(), t.getY_point(), 3);
            }
        }
    }

}
