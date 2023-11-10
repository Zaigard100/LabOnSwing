package labs.lab4.primitives;

import labs.lab4.Lab4;

import java.awt.*;

public class Circle extends Oval {

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
