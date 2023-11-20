package labs.lab6;

import labs.lab6.contaners.AbstractContainer;

import javax.swing.*;
import java.awt.*;

public class Picture extends JComponent {


    public Picture(){
    }

    @Override
    protected void paintComponent(Graphics g){
        for(AbstractContainer fC: Utils.getFigureContainers()){
            if(fC.isVisible()){
                fC.show(g);
            }
        }

    }

}
