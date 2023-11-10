package labs.lab4.dialogs.create;

import labs.lab4.Lab4;
import labs.lab4.Utils;
import labs.lab4.primitives.Line;
import labs.lab4.primitives.Point;

import javax.swing.*;
import java.awt.*;

public class CreateLine extends JDialog {
    JTextField xField,yField,x1Field,y1Field,rField,gField,bField;
    JPanel mainPanel,xPanel,yPanel,x1Panel,y1Panel,colorPanel;
    JButton cancel,create;
    int width = 375;
    int height = 150;

    public CreateLine(){
        super(Lab4.getjFrame(),"Create Line",true);

        mainPanel = new JPanel();

        xPanel = new JPanel();
        yPanel = new JPanel();
        x1Panel = new JPanel();
        y1Panel = new JPanel();

        xField = new JTextField(5);
        yField = new JTextField(5);
        x1Field = new JTextField(5);
        y1Field = new JTextField(5);

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

        x1Panel = new JPanel();
        x1Panel.add(new JLabel("X1"));
        x1Panel.add(x1Field);

        y1Panel = new JPanel();
        y1Panel.add(new JLabel("Y1"));
        y1Panel.add(y1Field);

        colorPanel = new JPanel();

        colorPanel.add(new JLabel("    Color:    "));
        colorPanel.add(new JLabel("  R  "));
        colorPanel.add(rField);
        colorPanel.add(new JLabel("  G  "));
        colorPanel.add(gField);
        colorPanel.add(new JLabel("  B  "));
        colorPanel.add(bField);

        mainPanel.add(xPanel);
        mainPanel.add(yPanel);
        mainPanel.add(x1Panel);
        mainPanel.add(y1Panel);

        mainPanel.add(colorPanel);

        mainPanel.add(cancel);
        mainPanel.add(create);

        add(mainPanel);

        repaint();
        revalidate();

        cancel.addActionListener(e -> {
            xField.setText("");
            yField.setText("");
            x1Field.setText("");
            y1Field.setText("");

            rField.setText("");
            gField.setText("");
            bField.setText("");
            setVisible(false);
        });

        create.addActionListener(e -> {
            try {
                int x = Integer.parseInt(xField.getText());
                int y = Integer.parseInt(yField.getText());
                int x1 = Integer.parseInt(x1Field.getText());
                int y1 = Integer.parseInt(y1Field.getText());

                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                if((x>0) && (x< Lab4.getWindows_w()) && (y>0) && (y< Lab4.getWindows_h()) && (x1>0) && (x1< Lab4.getWindows_w()) && (y1>0) && (y1< Lab4.getWindows_h()) && (r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255)) {
                    Utils.getLines().add(new Line(new Point(x, y),new Point(x1, y1), new Color(r, g, b)));
                }

                xField.setText("");
                yField.setText("");
                x1Field.setText("");
                y1Field.setText("");

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
