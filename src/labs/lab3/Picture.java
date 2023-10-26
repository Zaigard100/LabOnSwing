package labs.lab3;

import labs.lab3.primitives.*;

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
        for(Oval o:utils.getOvals()){
            o.show(g);
        }
        for(Romb r: utils.getRombs()){
            r.show(g);
        }
        for(Trapezoids t:utils.getTrapezoids()){
            t.show(g);
        }
        for (Rect r: utils.getRects()){
            r.show(g);
        }
    }

}
