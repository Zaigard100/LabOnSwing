package labs.lab5.dialogs.create;

import labs.lab5.Lab5;
import labs.lab5.Utils;
import labs.lab5.primitives.Point;
import labs.lab5.primitives.Ring;

import javax.swing.*;
import java.awt.*;

public class CreateRing extends JDialog {

    JTextField xField,yField,diameter1Field,diameter2Field,rField,gField,bField;
    JPanel mainPanel,xPanel,yPanel,diameter1Panel,diameter2Panel,colorPanel;
    JButton cancel,create;
    int width = 325;
    int height = 175;

    public CreateRing(){
        super(Lab5.getjFrame(),"Create Ring",true);

        mainPanel = new JPanel();

        xPanel = new JPanel();
        yPanel = new JPanel();
        diameter1Panel = new JPanel();
        diameter2Panel = new JPanel();

        xField = new JTextField(5);
        yField = new JTextField(5);
        diameter1Field = new JTextField(5);
        diameter2Field = new JTextField(5);

        rField = new JTextField(3);
        gField = new JTextField(3);
        bField = new JTextField(3);

        cancel = new JButton("Cancel");
        create = new JButton("Create");

        xPanel = new JPanel();
        xPanel.add(new JLabel("X"));
        xPanel.add(xField);

        yPanel = new JPanel();
        yPanel.add(new JLabel("Y"));
        yPanel.add(yField);

        diameter1Panel = new JPanel();
        diameter1Panel.add(new JLabel("Diameter1"));
        diameter1Panel.add(diameter1Field);

        diameter2Panel = new JPanel();
        diameter2Panel.add(new JLabel("Diameter2"));
        diameter2Panel.add(diameter2Field);

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
        mainPanel.add(diameter1Panel);
        mainPanel.add(diameter2Panel);
        mainPanel.add(colorPanel);

        mainPanel.add(cancel);
        mainPanel.add(create);
        add(mainPanel);
        repaint();
        revalidate();

        cancel.addActionListener(e -> {
            xField.setText("");
            yField.setText("");
            diameter1Field.setText("");
            diameter2Field.setText("");

            rField.setText("");
            gField.setText("");
            bField.setText("");
            setVisible(false);
        });

        create.addActionListener(e -> {
            try {

                int x = Integer.parseInt(xField.getText());
                int y = Integer.parseInt(yField.getText());
                int diameter1 = Integer.parseInt(diameter1Field.getText());
                int diameter2 = Integer.parseInt(diameter2Field.getText());
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                if((x>0) && (x< Lab5.getWindows_w()-Math.max(diameter1,diameter2)) && (y>0) && (y< Lab5.getWindows_h()-Math.max(diameter1,diameter2)) && (diameter1>0)&& (diameter2>0) && (Math.max(diameter1,diameter2)<Math.min(Lab5.getWindows_w()-x, Lab5.getWindows_h()-y))) {
                    Utils.getFigures().add(new Ring(new Point(x,y), diameter1,diameter2, new Color(r, g, b)));
                }
                xField.setText("");
                yField.setText("");
                diameter1Field.setText("");
                diameter2Field.setText("");

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
