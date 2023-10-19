package labs.lab2;

import labs.lab2.primitives.Circle;
import labs.lab2.primitives.Line;
import labs.lab2.primitives.Ring;
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
            c.show(g);
        }
        for(Line l:utils.getLines()){
            l.show(g);
        }
        for(Triangle t:utils.getTriangles()){
            t.show(g);
        }
        for (Ring r:utils.getRing()){
            r.show(g);
        }
    }

}
