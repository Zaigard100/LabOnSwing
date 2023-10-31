package labs.lab3.dialogs.create;

import labs.lab3.Lab3;
import labs.lab3.Utils;
import labs.lab3.primitives.Point;
import labs.lab3.primitives.Romb;

import javax.swing.*;
import java.awt.*;

public class CreateRomb extends JDialog {

    JTextField xField,yField,diameter1Field,diameter2Field,rField,gField,bField;
    JPanel mainPanel,xPanel,yPanel,diameter1Panel,diameter2Panel,fillPanel,colorPanel;
    JCheckBox fillCheck;
    JButton cancel,create;
    int width = 325;
    int height = 175;

    public CreateRomb(){
        super(Lab3.getjFrame(),"Create Romb",true);

        mainPanel = new JPanel();

        xField = new JTextField(5);
        yField = new JTextField(5);
        diameter1Field = new JTextField(5);
        diameter2Field = new JTextField(5);

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

        diameter1Panel = new JPanel();
        diameter1Panel.add(new JLabel("DiameterX"));
        diameter1Panel.add(diameter1Field);

        diameter2Panel = new JPanel();
        diameter2Panel.add(new JLabel("DiameterY"));
        diameter2Panel.add(diameter2Field);

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
        mainPanel.add(diameter1Panel);
        mainPanel.add(diameter2Panel);
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
                boolean fill = fillCheck.isSelected();
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                if((x>0) && (x<Lab3.getWindows_w() - diameter1) && (y>0) && (y<Lab3.getWindows_h()-diameter2) && (diameter1>0)&& (diameter2>0) && (diameter1<Lab3.getWindows_w()-x) && (diameter2<Lab3.getWindows_h()-y)) {
                    Utils.getRombs().add(new Romb(new Point(x,y), diameter1,diameter2, fill, new Color(r, g, b)));
                }
                xField.setText("");
                yField.setText("");
                diameter1Field.setText("");
                diameter2Field.setText("");

                rField.setText("");
                gField.setText("");
                bField.setText("");

                Lab3.getPicture().repaint();
                Lab3.getPicture().revalidate();

                setVisible(false);
            }catch (NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Неверно введены данные: NumberFormatException", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

        });

        setBounds((Lab3.getWindows_w()-width)/2, (Lab3.getWindows_h()-height)/2,width,height);
    }

}
