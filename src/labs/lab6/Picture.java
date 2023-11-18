package labs.lab6;

import labs.lab6.contaners.AbstractContainer;
import labs.lab6.primitives.Figure;
import labs.lab6.contaners.FigureContainer;

import javax.swing.*;
import java.awt.*;

public class Picture extends JComponent {


    public Picture(){
    }

    @Override
    protected void paintComponent(Graphics g){
        for(AbstractContainer fC: Utils.getFigureContainers()){
            if(fC.isVisible()){
                do{
                    if(fC.iterator()!=null) {
                        fC.iterator().draw(g);
                    }
                }while (fC.next());
            }
        }

    }

}
