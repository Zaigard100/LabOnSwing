package labs.lab4.dialogs.create;

import labs.lab4.Lab4;
import labs.lab4.Utils;
import labs.lab4.primitives.Point;
import labs.lab4.primitives.Triangle;

import javax.swing.*;
import java.awt.*;

public class CreateTriangle extends JDialog {
    JTextField x1Field,y1Field,x2Field,y2Field,x3Field,y3Field,rField,gField,bField;
    JPanel mainPanel,x1Panel,y1Panel,x2Panel,y2Panel,x3Panel,y3Panel,colorPanel,fillPanel;
    JButton cancel,create;
    JCheckBox fillCheck;
    int width = 325;
    int height = 225;

    public CreateTriangle(){
        super(Lab4.getjFrame(),"Create Triangle",true);

        mainPanel = new JPanel();

        x1Panel = new JPanel();
        y1Panel = new JPanel();
        x2Panel = new JPanel();
        y2Panel = new JPanel();
        x3Panel = new JPanel();
        y3Panel = new JPanel();

        x1Field = new JTextField(5);
        y1Field = new JTextField(5);
        x2Field = new JTextField(5);
        y2Field = new JTextField(5);
        x3Field = new JTextField(5);
        y3Field = new JTextField(5);

        fillCheck = new JCheckBox();

        rField = new JTextField(3);
        gField = new JTextField(3);
        bField = new JTextField(3);

        cancel = new JButton("Cancel");
        create = new JButton("Create");

        x1Panel = new JPanel();
        x1Panel.add(new JLabel("X1"));
        x1Panel.add(x1Field);

        y1Panel = new JPanel();
        y1Panel.add(new JLabel("Y1"));
        y1Panel.add(y1Field);

        x2Panel = new JPanel();
        x2Panel.add(new JLabel("X2"));
        x2Panel.add(x2Field);

        y2Panel = new JPanel();
        y2Panel.add(new JLabel("Y2"));
        y2Panel.add(y2Field);

        x3Panel = new JPanel();
        x3Panel.add(new JLabel("X3"));
        x3Panel.add(x3Field);

        y3Panel = new JPanel();
        y3Panel.add(new JLabel("Y3"));
        y3Panel.add(y3Field);

        fillPanel = new JPanel();
        fillPanel.add(new JLabel("Filled "));
        fillPanel.add(fillCheck);

        colorPanel = new JPanel();

        colorPanel.add(new JLabel("    Color:    "));
        colorPanel.add(new JLabel("  R  "));
        colorPanel.add(rField);
        colorPanel.add(new JLabel("  G  "));
        colorPanel.add(gField);
        colorPanel.add(new JLabel("  B  "));
        colorPanel.add(bField);

        mainPanel.add(x1Panel);
        mainPanel.add(y1Panel);
        mainPanel.add(x2Panel);
        mainPanel.add(y2Panel);
        mainPanel.add(x3Panel);
        mainPanel.add(y3Panel);
        mainPanel.add(fillPanel);

        mainPanel.add(colorPanel);

        mainPanel.add(cancel);
        mainPanel.add(create);

        add(mainPanel);

        repaint();
        revalidate();

        cancel.addActionListener(e -> {
            x1Field.setText("");
            y1Field.setText("");
            x2Field.setText("");
            y2Field.setText("");
            x3Field.setText("");
            y3Field.setText("");

            rField.setText("");
            gField.setText("");
            bField.setText("");
            setVisible(false);
        });

        create.addActionListener(e -> {
            try {
                int x1 = Integer.parseInt(x1Field.getText());
                int y1 = Integer.parseInt(y1Field.getText());
                int x2 = Integer.parseInt(x2Field.getText());
                int y2 = Integer.parseInt(y2Field.getText());
                int x3 = Integer.parseInt(x3Field.getText());
                int y3 = Integer.parseInt(y3Field.getText());
                boolean fill = fillCheck.isSelected();

                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                if((x1>0) && (x1< Lab4.getWindows_w()) && (y1>0) && (y1< Lab4.getWindows_h()) && (x2>0) && (x2< Lab4.getWindows_w()) && (y2>0) && (y2< Lab4.getWindows_h()) && (x3>0) && (x3< Lab4.getWindows_w()) && (y3>0) && (y3< Lab4.getWindows_h()) && (r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255)) {
                    Utils.getTriangles().add(new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), fill, new Color(r, g, b)));
                }
                x1Field.setText("");
                y1Field.setText("");
                x2Field.setText("");
                y2Field.setText("");
                x3Field.setText("");
                y3Field.setText("");

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

        setBounds((Lab4.getWindows_w() -width)/2, (Lab4.getWindows_h()-height)/2,width,height);
    }

}
