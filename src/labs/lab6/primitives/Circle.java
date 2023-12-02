package labs.lab6.primitives;

import java.awt.*;

public class Circle extends Oval {

    public Circle(int x, int y, int diameter, boolean fill, Color color) {
        super(x,y,diameter,diameter,fill,color);
    }
    public Circle(Point p, int diameter, boolean fill, Color color) {
        super(p,diameter,diameter,fill,color);
    }

    public int getDiameter() {
        return diameterX;
    }

    public void setDiameter(int diameter) {
        setDiameterX(diameter);
        setDiameterY(diameter);
    }
}
