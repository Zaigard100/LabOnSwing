package labs.lab6;

import labs.lab6.contaners.AbstractContainer;

import javax.swing.*;
import java.awt.*;

public class Picture extends JComponent {


    public Picture(){
    }

    @Override
    protected void paintComponent(Graphics g){
        for(AbstractContainer figureContainers: Utils.getFigureContainers()){
            if(figureContainers.isShow()){
                figureContainers.show(g);
            }
        }

    }

}
