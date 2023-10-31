package labs.lab3;

import labs.lab3.primitives.*;

import javax.swing.*;
import java.awt.*;

public class Picture extends JComponent {


    public Picture(){
    }

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
        for(Oval o:Utils.getOvals()){
            o.show(g);
        }
        for(Romb r: Utils.getRombs()){
            r.show(g);
        }
        for(Trapezoids t:Utils.getTrapezoids()){
            t.show(g);
        }
        for (Rect r: Utils.getRects()){
            r.show(g);
        }
    }

}
