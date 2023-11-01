package labs.lab3.dialogs.transform;

import labs.lab3.Lab3;
import labs.lab3.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TransformRing extends JDialog {
    JComboBox jcb, list;
    TextField field1,field2,field3;
    JButton cancel,edit;
    JPanel jPanel1,jPanel2,jPanel3;
    public TransformRing(){
        list = new JComboBox<>();
       reload();
       jcb = new JComboBox(new String[]{"move", "x", "y", "diameter1", "diameter2", "color"});
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

       jPanel1.add(new JLabel("Ring № "));
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

       setBounds((Lab3.getWindows_w()-width)/2,(Lab3.getWindows_h()-height)/2,width,height);
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
                case "diameter1":
                    jPanel2.add(new JLabel(" Diameter1 "));
                    jPanel2.add(field1);
                    break;
                case "diameter2":
                    jPanel2.add(new JLabel(" Diameter2 "));
                    jPanel2.add(field1);
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
                            Utils.getRing().get(i).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                            break;
                        case "x":
                            Utils.getRing().get(i).setX(Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getX()));
                            break;
                        case "y":
                            Utils.getRing().get(i).setY(Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getY()));
                            break;
                        case "diameter1":
                            Utils.getRing().get(i).setDiameter1(Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getDiameter1()));
                            break;
                        case "diameter2":
                            Utils.getRing().get(i).setDiameter2(Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getDiameter2()));
                            break;
                        case "color":
                            Utils.getRing().get(i).setColor(
                                    Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getColor().getRed()),
                                    Lab3.parseInt(field2.getText(), Utils.getRing().get(i).getColor().getGreen()),
                                    Lab3.parseInt(field3.getText(), Utils.getRing().get(i).getColor().getBlue())
                            );
                            break;
                    }
                }
            }else {
                switch (Objects.requireNonNull(item)) {
                    case "move":
                        Utils.getRing().get(list.getSelectedIndex()).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                        break;
                    case "x":
                        Utils.getRing().get(list.getSelectedIndex()).setX(Lab3.parseInt(field1.getText(), Utils.getRing().get((list.getSelectedIndex())).getX()));
                        break;
                    case "y":
                        Utils.getRing().get(list.getSelectedIndex()).setY(Lab3.parseInt(field1.getText(), Utils.getRing().get((list.getSelectedIndex())).getY()));
                        break;
                    case "diameter1":
                        Utils.getRing().get(list.getSelectedIndex()).setDiameter1(Lab3.parseInt(field1.getText(), Utils.getRing().get((list.getSelectedIndex())).getDiameter1()));
                        break;
                    case "diameter2":
                        Utils.getRing().get(list.getSelectedIndex()).setDiameter2(Lab3.parseInt(field1.getText(), Utils.getRing().get((list.getSelectedIndex())).getDiameter2()));
                        break;
                    case "color":
                        Utils.getRing().get(list.getSelectedIndex()).setColor(
                                Lab3.parseInt(field1.getText(), Utils.getRing().get((list.getSelectedIndex())).getColor().getRed()),
                                Lab3.parseInt(field2.getText(), Utils.getRing().get((list.getSelectedIndex())).getColor().getGreen()),
                                Lab3.parseInt(field3.getText(), Utils.getRing().get((list.getSelectedIndex())).getColor().getBlue())
                        );
                        break;
                }
            }
            field1.setText("");
            field2.setText("");
            field3.setText("");

            Lab3.getPicture().repaint();
            Lab3.getPicture().revalidate();
            jPanel2.repaint();
            jPanel2.revalidate();
        });

    }

    public void reload() {
        list.removeAllItems();
        for(int i = 0;i<Utils.getRing().size();i++){
            list.addItem(i+"");
        }
        list.addItem("all");
    }

}
