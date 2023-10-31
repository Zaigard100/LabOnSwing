package labs.lab2;

import labs.lab2.primitives.Circle;
import labs.lab2.primitives.Line;
import labs.lab2.primitives.Ring;
import labs.lab2.primitives.Triangle;

import javax.swing.*;
import java.awt.*;

public class Picture extends JComponent {


    @Override
    protected void paintComponent(Graphics g){
        for(Circle c:Utils.getCircles()){
            c.show(g);
        }
        for(Line l:Utils.getLines()){
            l.show(g);
        }
        for(Triangle t:Utils.getTriangles()){
            t.show(g);
        }
        for (Ring r:Utils.getRing()){
            r.show(g);
        }
    }

}
