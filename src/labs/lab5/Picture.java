package labs.lab5;

import labs.lab5.primitives.*;

import javax.swing.*;
import java.awt.*;

public class Picture extends JComponent {


    public Picture(){
    }

    @Override
    protected void paintComponent(Graphics g){
        System.out.println(Utils.getFigures().size());
        for(Figure figure: Utils.getFigures()){
            figure.show(g);
        }

    }

}
