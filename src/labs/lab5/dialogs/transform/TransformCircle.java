package labs.lab5.dialogs.transform;

import labs.lab5.Lab4;
import labs.lab5.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TransformCircle extends JDialog {
    JComboBox jcb, list;
    TextField field1,field2,field3;
    JCheckBox checkBox;
    JButton cancel,edit;
    JPanel jPanel1,jPanel2,jPanel3;
    public TransformCircle(){
        list = new JComboBox<>();
        reload();
        jcb = new JComboBox(new String[]{"move", "x", "y", "diameter","fill", "color"});
        cancel = new JButton("Cancel");
        edit = new JButton("Edit");

        int width = 300;
        int height = 150;

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();

        field1 = new TextField(5);
        field2 = new TextField(5);
        field3 = new TextField(5);

        checkBox = new JCheckBox();

        jPanel1.add(new JLabel("Circle № "));
        jPanel1.add(list);
        jPanel1.add(jcb);
        jPanel1.setBounds(0,0,325,75);

        jPanel2.add(new JLabel(" DX "));
        jPanel2.add(field1);
        jPanel2.add(new JLabel(" DY "));
        jPanel2.add(field2);
        jPanel2.setBounds(0,75,325,75);

        jPanel3.add(cancel);
        jPanel3.add(edit);
        jPanel3.setBounds(0,150,325,75);

        add(jPanel1,BorderLayout.NORTH);
        add(jPanel2,BorderLayout.CENTER);
        add(jPanel3,BorderLayout.SOUTH);

        setBounds((Lab4.getWindows_w()-width)/2,(Lab4.getWindows_h()-height)/2,width,height);

        jcb.addActionListener(e -> {
            jPanel2.removeAll();

            String item = (String)jcb.getSelectedItem();

            field1.setText("");
            field2.setText("");
            field3.setText("");

            switch (Objects.requireNonNull(item)) {
                case "move":
                    jPanel2.add(new JLabel(" DX "));
                    jPanel2.add(field1);
                    jPanel2.add(new JLabel(" DY "));
                    jPanel2.add(field2);
                    break;
                case "x":
                    jPanel2.add(new JLabel(" X "));
                    jPanel2.add(field1);
                    break;
                case "y":
                    jPanel2.add(new JLabel(" Y "));
                    jPanel2.add(field1);
                    break;
                case "diameter":
                    jPanel2.add(new JLabel(" Diameter "));
                    jPanel2.add(field1);
                    break;
                case "fill":
                    jPanel2.add(new JLabel(" Filed  "));
                    jPanel2.add(checkBox);
                    break;
                case "color":
                    jPanel2.add(new JLabel(" R "));
                    jPanel2.add(field1);
                    jPanel2.add(new JLabel(" G "));
                    jPanel2.add(field2);
                    jPanel2.add(new JLabel(" B "));
                    jPanel2.add(field3);
                    break;
            }

            jPanel2.repaint();
            jPanel2.revalidate();

        });

        cancel.addActionListener(e -> {
            field1.setText("");
            field2.setText("");
            field3.setText("");
            setVisible(false);
        });

        edit.addActionListener(e -> {

            String item = (String)jcb.getSelectedItem();

            if(Objects.equals(list.getSelectedItem(), "all")) {
                for (int i = 0; i < Utils.getCircles().size(); i++) {
                    switch (Objects.requireNonNull(item)) {
                        case "move":
                            Utils.getCircles().get(i).move(Lab4.parseInt(field1.getText(), 0), Lab4.parseInt(field2.getText(), 0));
                            break;
                        case "x":
                            Utils.getCircles().get(i).setX(Lab4.parseInt(field1.getText(), Utils.getCircles().get(i).getX()));
                            break;
                        case "y":
                            Utils.getCircles().get(i).setY(Lab4.parseInt(field1.getText(), Utils.getCircles().get(i).getY()));
                            break;
                        case "diameter":
                            Utils.getCircles().get(i).setDiameter(Lab4.parseInt(field1.getText(), Utils.getCircles().get(i).getDiameter()));
                            break;
                        case "fill":
                            Utils.getCircles().get(i).setFill(checkBox.isSelected());
                            break;
                        case "color":
                            Utils.getCircles().get(i).setColor(
                                    Lab4.parseInt(field1.getText(), Utils.getCircles().get(i).getColor().getRed()),
                                    Lab4.parseInt(field2.getText(), Utils.getCircles().get(i).getColor().getGreen()),
                                    Lab4.parseInt(field3.getText(), Utils.getCircles().get(i).getColor().getBlue())
                            );
                            break;
                    }
                }
            }else {
                switch (Objects.requireNonNull(item)) {
                    case "move":
                        Utils.getCircles().get(list.getSelectedIndex()).move(Lab4.parseInt(field1.getText(), 0), Lab4.parseInt(field2.getText(), 0));
                        break;
                    case "x":
                        Utils.getCircles().get(list.getSelectedIndex()).setX(Lab4.parseInt(field1.getText(), Utils.getCircles().get((list.getSelectedIndex())).getX()));
                        break;
                    case "y":
                        Utils.getCircles().get(list.getSelectedIndex()).setY(Lab4.parseInt(field1.getText(), Utils.getCircles().get((list.getSelectedIndex())).getY()));
                        break;
                    case "fill":
                        Utils.getCircles().get(list.getSelectedIndex()).setFill(checkBox.isSelected());
                        break;
                    case "diameter":
                        int di = Lab4.parseInt(field1.getText(), Utils.getCircles().get((list.getSelectedIndex())).getDiameter());
                        if (di > 0) {
                            Utils.getCircles().get(list.getSelectedIndex()).setDiameter(di);
                        }
                        break;
                    case "color":
                        Utils.getCircles().get(list.getSelectedIndex()).setColor(
                                Lab4.parseInt(field1.getText(), Utils.getCircles().get((list.getSelectedIndex())).getColor().getRed()),
                                Lab4.parseInt(field2.getText(), Utils.getCircles().get((list.getSelectedIndex())).getColor().getGreen()),
                                Lab4.parseInt(field3.getText(), Utils.getCircles().get((list.getSelectedIndex())).getColor().getBlue())
                        );
                        break;
                }
            }
            field1.setText("");
            field2.setText("");
            field3.setText("");

            Lab4.getPicture().repaint();
            Lab4.getPicture().revalidate();
            jPanel2.repaint();
            jPanel2.revalidate();
        });

    }

    public void  reload(){
        list.removeAllItems();
        for(int i = 0; i< Utils.getCircles().size(); i++){
            list.addItem(i+"");
        }
        list.addItem("all");

    }

}
