package labs.lab4.dialogs.transform;

import labs.lab4.Lab4;
import labs.lab4.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TransformTriangle extends JDialog {
    JComboBox jcb, list;
    TextField field1,field2,field3;
    JButton cancel,edit;
    JCheckBox checkBox;
    JPanel jPanel1,jPanel2,jPanel3;
    public TransformTriangle(){
        list = new JComboBox<>();
        reload();
        jcb = new JComboBox(new String[]{"move","x1","y1","x2","y2","x3","y3","fill","color"});
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

        jPanel1.add(new JLabel("Triangle № "));
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

        setBounds((Lab4.getWindows_w() -width)/2,(Lab4.getWindows_h()-height)/2,width,height);
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
                case "x1":
                    jPanel2.add(new JLabel(" X1 "));
                    jPanel2.add(field1);
                    break;
                case "y1":
                    jPanel2.add(new JLabel(" Y1 "));
                    jPanel2.add(field1);
                    break;
                case "x2":
                    jPanel2.add(new JLabel(" X2 "));
                    jPanel2.add(field1);
                    break;
                case "y2":
                    jPanel2.add(new JLabel(" Y2 "));
                    jPanel2.add(field1);
                    break;
                case "x3":
                    jPanel2.add(new JLabel(" X3 "));
                    jPanel2.add(field1);
                    break;
                case "y3":
                    jPanel2.add(new JLabel(" Y3 "));
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
                for (int i = 0; i < Utils.getTriangles().size(); i++) {
                    switch (Objects.requireNonNull(item)) {
                        case "move":
                            Utils.getTriangles().get(i).move(Lab4.parseInt(field1.getText(), 0), Lab4.parseInt(field2.getText(), 0));
                            break;
                        case "x1":
                            Utils.getTriangles().get(i).setX1(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(i).getX1()));
                            break;
                        case "y1":
                            Utils.getTriangles().get(i).setY1(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(i).getY1()));
                            break;
                        case "x2":
                            Utils.getTriangles().get(i).setX2(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(i).getX2()));
                            break;
                        case "y2":
                            Utils.getTriangles().get(i).setY2(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(i).getY2()));
                            break;
                        case "x3":
                            Utils.getTriangles().get(i).setX3(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(i).getX3()));
                            break;
                        case "y3":
                            Utils.getTriangles().get(i).setY3(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(i).getY3()));
                            break;
                        case "color":
                            Utils.getTriangles().get(i).setColor(
                                    Lab4.parseInt(field1.getText(), Utils.getTriangles().get(i).getColor().getRed()),
                                    Lab4.parseInt(field2.getText(), Utils.getTriangles().get(i).getColor().getGreen()),
                                    Lab4.parseInt(field3.getText(), Utils.getTriangles().get(i).getColor().getBlue())
                            );
                            break;
                    }
                }
            }else {
                switch (Objects.requireNonNull(item)) {
                    case "move":
                        Utils.getTriangles().get(list.getSelectedIndex()).move(Lab4.parseInt(field1.getText(), 0), Lab4.parseInt(field2.getText(), 0));
                        break;
                    case "x1":
                        Utils.getTriangles().get(list.getSelectedIndex()).setX1(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(list.getSelectedIndex()).getX1()));
                        break;
                    case "y1":
                        Utils.getTriangles().get(list.getSelectedIndex()).setY1(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(list.getSelectedIndex()).getY1()));
                        break;
                    case "x2":
                        Utils.getTriangles().get(list.getSelectedIndex()).setX2(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(list.getSelectedIndex()).getX2()));
                        break;
                    case "y2":
                        Utils.getTriangles().get(list.getSelectedIndex()).setY2(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(list.getSelectedIndex()).getY2()));
                        break;
                    case "x3":
                        Utils.getTriangles().get(list.getSelectedIndex()).setX3(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(list.getSelectedIndex()).getX3()));
                        break;
                    case "y3":
                        Utils.getTriangles().get(list.getSelectedIndex()).setY3(Lab4.parseInt(field1.getText(), Utils.getTriangles().get(list.getSelectedIndex()).getY3()));
                        break;
                    case "color":
                        Utils.getTriangles().get(list.getSelectedIndex()).setColor(
                                Lab4.parseInt(field1.getText(), Utils.getTriangles().get((list.getSelectedIndex())).getColor().getRed()),
                                Lab4.parseInt(field2.getText(), Utils.getTriangles().get((list.getSelectedIndex())).getColor().getGreen()),
                                Lab4.parseInt(field3.getText(), Utils.getTriangles().get((list.getSelectedIndex())).getColor().getBlue())
                        );
                        break;
                }

                field1.setText("");
                field2.setText("");
                field3.setText("");

                Lab4.getPicture().repaint();
                Lab4.getPicture().revalidate();
                jPanel2.repaint();
                jPanel2.revalidate();
            }
        });

    }

    public void reload() {
        list.removeAllItems();
        for(int i = 0; i< Utils.getTriangles().size(); i++){
            list.addItem(i+"");
        }
        list.addItem("all");
    }

}
