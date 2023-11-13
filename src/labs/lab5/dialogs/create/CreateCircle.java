package labs.lab5.dialogs.create;

import labs.lab5.Lab5;
import labs.lab5.Utils;
import labs.lab5.primitives.Circle;
import labs.lab5.primitives.Point;

import javax.swing.*;
import java.awt.*;

public class CreateCircle extends JDialog {
    JTextField xField,yField,diameterField,rField,gField,bField;
    JPanel mainPanel,xPanel,yPanel,diameterPanel,colorPanel,fillPanel;
    JButton cancel,create;
    JCheckBox fillCheck;
    int width = 325;
    int height = 175;

    public CreateCircle(){
        super(Lab5.getjFrame(),"Create Circle",true);

        mainPanel = new JPanel();

        xPanel = new JPanel();
        yPanel = new JPanel();
        diameterPanel = new JPanel();

        xField = new JTextField(5);
        yField = new JTextField(5);
        diameterField = new JTextField(5);

        rField = new JTextField(3);
        gField = new JTextField(3);
        bField = new JTextField(3);

        cancel = new JButton("Cancel");
        create = new JButton("Create");

        xPanel = new JPanel();
        xPanel.add(new JLabel("X"));
        xPanel.add(xField);

        fillCheck = new JCheckBox();

        yPanel = new JPanel();
        yPanel.add(new JLabel("Y"));
        yPanel.add(yField);

        diameterPanel = new JPanel();
        diameterPanel.add(new JLabel("Diameter"));
        diameterPanel.add(diameterField);

        fillPanel = new JPanel();
        fillPanel.add(new JLabel("Filled: "));
        fillPanel.add(fillCheck);

        colorPanel = new JPanel();
        colorPanel.add(new JLabel("Color:"));
        colorPanel.add(new JLabel(" R "));
        colorPanel.add(rField);
        colorPanel.add(new JLabel(" G "));
        colorPanel.add(gField);
        colorPanel.add(new JLabel(" B "));
        colorPanel.add(bField);

        mainPanel.add(xPanel);
        mainPanel.add(yPanel);
        mainPanel.add(diameterPanel);
        mainPanel.add(fillPanel);
        mainPanel.add(colorPanel);

        mainPanel.add(cancel);
        mainPanel.add(create);
        add(mainPanel);
        repaint();
        revalidate();

        cancel.addActionListener(e -> {
            xField.setText("");
            yField.setText("");
            diameterField.setText("");

            rField.setText("");
            gField.setText("");
            bField.setText("");
            setVisible(false);
        });

        create.addActionListener(e -> {
            try {
                int x = Integer.parseInt(xField.getText());
                int y = Integer.parseInt(yField.getText());
                int diameter = Integer.parseInt(diameterField.getText());
                boolean fill = fillCheck.getModel().isSelected();
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                if((x>0) && (x< Lab5.getWindows_w()-diameter) && (y>0) && (y< Lab5.getWindows_h()-diameter) && (diameter>0) && (diameter<Math.min(Lab5.getWindows_w()-x, Lab5.getWindows_h()-y))) {
                    Utils.getFigures().add(new Circle(new Point(x,y), diameter, fill, new Color(r, g, b)));
                }
                xField.setText("");
                yField.setText("");
                diameterField.setText("");

                rField.setText("");
                gField.setText("");
                bField.setText("");

                Lab5.getPicture().repaint();
                Lab5.getPicture().revalidate();

                setVisible(false);
            }catch (NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Неверно введены данные: NumberFormatException", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

        });

        setBounds((Lab5.getWindows_w() -width)/2, (Lab5.getWindows_h()-height)/2,width,height);
    }

}
