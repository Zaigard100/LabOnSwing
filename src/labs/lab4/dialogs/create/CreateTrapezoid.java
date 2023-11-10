package labs.lab4.dialogs.create;

import labs.lab4.Lab4;
import labs.lab4.Utils;
import labs.lab4.primitives.Point;
import labs.lab4.primitives.Trapezoid;

import javax.swing.*;
import java.awt.*;

public class CreateTrapezoid extends JDialog {
    JTextField xField,yField, base1Field, base2Field,heightField,rField,gField,bField;
    JPanel mainPanel,xPanel,yPanel, base1Panel, base2Panel,heightPanel,fillPanel,colorPanel;
    JCheckBox fillCheck;
    JButton cancel,create;
    int width = 325;
    int height = 175;

    public CreateTrapezoid(){
        super(Lab4.getjFrame(),"Create Trapezoid",true);

        mainPanel = new JPanel();

        xField = new JTextField(5);
        yField = new JTextField(5);
        base1Field = new JTextField(5);
        base2Field = new JTextField(5);
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

        base1Panel = new JPanel();
        base1Panel.add(new JLabel("Base1"));
        base1Panel.add(base1Field);

        base2Panel = new JPanel();
        base2Panel.add(new JLabel("Base2"));
        base2Panel.add(base2Field);

        heightPanel = new JPanel();
        heightPanel.add(new JLabel("Height"));
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
        mainPanel.add(base1Panel);
        mainPanel.add(base2Panel);
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
            base1Field.setText("");
            base2Field.setText("");

            rField.setText("");
            gField.setText("");
            bField.setText("");
            setVisible(false);
        });

        create.addActionListener(e -> {
            try {
                int x = Integer.parseInt(xField.getText());
                int y = Integer.parseInt(yField.getText());
                int width = Integer.parseInt(base1Field.getText());
                int width2 = Integer.parseInt(base2Field.getText());
                int height = Integer.parseInt(heightField.getText());
                boolean fill = fillCheck.isSelected();
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                if((x>0) && (x< Lab4.getWindows_w() - width) && (y>0) && (y< Lab4.getWindows_h()-width2) && (width>0)&& (width2>0) && (width< Lab4.getWindows_w()-x) && (width2< Lab4.getWindows_h()-y)) {
                    Utils.getTrapezoids().add(new Trapezoid(new Point(x,y), width,width2,height,fill, new Color(r, g, b)));
                }
                xField.setText("");
                yField.setText("");
                base1Field.setText("");
                base2Field.setText("");
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
