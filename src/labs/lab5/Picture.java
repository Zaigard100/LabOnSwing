package labs.lab5;

import labs.lab5.primitives.*;

import javax.swing.*;
import java.awt.*;

public class Picture extends JComponent {


    public Picture(){
    }

    @Override
    protected void paintComponent(Graphics g){
        for(FigureContainer fC: Utils.getFigureContainers()){
            if(fC.isVisible()){
                for (Figure f: fC.getFigures()){
                    f.show(g);
                }
            }
        }

    }

}
