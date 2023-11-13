package labs.lab5.dialogs.create;

import labs.lab5.Lab4;
import labs.lab5.Utils;
import labs.lab5.primitives.Point;
import labs.lab5.primitives.Rect;

import javax.swing.*;
import java.awt.*;

public class CreateRect extends JDialog {
    JTextField xField,yField, widthField, heightField,rField,gField,bField;
    JPanel mainPanel,xPanel,yPanel, widthPanel, heightPanel,fillPanel,colorPanel;
    JCheckBox fillCheck;
    JButton cancel,create;
    int width = 325;
    int height = 175;

    public CreateRect(){
        super(Lab4.getjFrame(),"Create Rect",true);

        mainPanel = new JPanel();

        xField = new JTextField(5);
        yField = new JTextField(5);
        widthField = new JTextField(5);
        heightField = new JTextField(5);

        rField = new JTextField(3);
        gField = new JTextField(3);
        bField = new JTextField(3);

        fillCheck = new JCheckBox();

        cancel = new JButton("Cancel");
        create = new JButton("Create");

        xPanel = new JPanel();
        xPanel.add(new JLabel("X"));
        xPanel.add(xField);

        yPanel = new JPanel();
        yPanel.add(new JLabel("Y"));
        yPanel.add(yField);

        widthPanel = new JPanel();
        widthPanel.add(new JLabel("DiameterX"));
        widthPanel.add(widthField);

        heightPanel = new JPanel();
        heightPanel.add(new JLabel("DiameterY"));
        heightPanel.add(heightField);

        fillPanel = new JPanel();
        fillPanel.add(new JLabel("Fill "));
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
        mainPanel.add(widthPanel);
        mainPanel.add(heightPanel);
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
            widthField.setText("");
            heightField.setText("");

            rField.setText("");
            gField.setText("");
            bField.setText("");
            setVisible(false);
        });

        create.addActionListener(e -> {
            try {
                int x = Integer.parseInt(xField.getText());
                int y = Integer.parseInt(yField.getText());
                int diameter1 = Integer.parseInt(widthField.getText());
                int diameter2 = Integer.parseInt(heightField.getText());
                boolean fill = fillCheck.isSelected();
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                if((x>0) && (x< Lab4.getWindows_w() - diameter1) && (y>0) && (y< Lab4.getWindows_h()-diameter2) && (diameter1>0)&& (diameter2>0) && (diameter1< Lab4.getWindows_w()-x) && (diameter2< Lab4.getWindows_h()-y)) {
                    Utils.getFigures().add(new Rect(new Point(x,y), diameter1,diameter2, fill, new Color(r, g, b)));
                }
                xField.setText("");
                yField.setText("");
                widthField.setText("");
                heightField.setText("");

                rField.setText("");
                gField.setText("");
                bField.setText("");

                Lab4.getPicture().repaint();
                Lab4.getPicture().revalidate();

                setVisible(false);
            }catch (NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Неверно введены данные: NumberFormatException", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

        });

        setBounds((Lab4.getWindows_w()-width)/2, (Lab4.getWindows_h()-height)/2,width,height);
    }

}
