package labs.lab5.dialogs.transform;

import labs.lab5.Lab4;
import labs.lab5.Utils;
import labs.lab5.primitives.Circle;
import labs.lab5.primitives.Figure;
import labs.lab5.primitives.Line;

import javax.swing.*;
import java.awt.*;

public class TransformFigure extends Dialog {

    JPanel figureChoosing,dataPlain,editPanel;
    JComboBox<String> figureNumber,editParameter;
    public TransformFigure(){

        super(Lab4.getjFrame(),"Edit",false);

        figureChoosing = new JPanel();
        dataPlain = new JPanel();
        editPanel = new JPanel();

        figureNumber = new JComboBox<>();
        editParameter = new JComboBox<>();

    }

    public void updateFigureList(){
        int i = 0;
        for(Figure figure:Utils.getFigures()){
            if(figure instanceof Line){
                figureNumber.addItem(i+"(Line)");
            }

            i++;
        }

    }

}
