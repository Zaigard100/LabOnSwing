package labs.lab1;

import labs.lab1.primitives.Circle;
import labs.lab1.primitives.Line;
import labs.lab1.primitives.Triangle;

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
    }

}
