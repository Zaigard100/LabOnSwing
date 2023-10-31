package labs.lab3.dialogs.transform;

import labs.lab3.Lab3;
import labs.lab3.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public  class TransformCircle extends JDialog {
    JComboBox jcb,circle_list;
    TextField field1,field2,field3;
    JCheckBox checkBox;
    JButton cancel,edit;
    JPanel jPanel1,jPanel2,jPanel3;
    public String[] c_list;
    public TransformCircle(){
        c_list = new String[Utils.getCircles().size()+1];
        for(int i = 0;i<Utils.getCircles().size();i++){
            c_list[i] = i+"";
        }
        c_list[Utils.getCircles().size()]="all";
        circle_list = new JComboBox(c_list);
        jcb = new JComboBox(new String[]{"move", "x", "y", "diameter","fill", "color"});
        cancel = new JButton("Cancel");
        edit = new JButton("Edit");

        int width = 300;
        int hight = 150;

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();

        field1 = new TextField(5);
        field2 = new TextField(5);
        field3 = new TextField(5);

        checkBox = new JCheckBox();

        jPanel1.add(new JLabel("Circle № "));
        jPanel1.add(circle_list);
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

        setBounds((Lab3.getWindows_w()-width)/2,(Lab3.getWindows_h()-hight)/2,width,hight);
        jcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel2.removeAll();

                String item = (String)jcb.getSelectedItem();

                field1.setText("");
                field2.setText("");
                field3.setText("");

                if(item.equals("move")){
                    jPanel2.add(new JLabel(" DX "));
                    jPanel2.add(field1);
                    jPanel2.add(new JLabel(" DY "));
                    jPanel2.add(field2);
                }else if(item.equals("x")){
                    jPanel2.add(new JLabel(" X "));
                    jPanel2.add(field1);
                }else if(item.equals("y")){
                    jPanel2.add(new JLabel(" Y "));
                    jPanel2.add(field1);
                }else if(item.equals("diameter")){
                    jPanel2.add(new JLabel(" Diameter "));
                    jPanel2.add(field1);
                }else if(item.equals("fill")){
                    jPanel2.add(new JLabel(" Filed  "));
                    jPanel2.add(checkBox);
                }else if(item.equals("color")){
                    jPanel2.add(new JLabel(" R "));
                    jPanel2.add(field1);
                    jPanel2.add(new JLabel(" G "));
                    jPanel2.add(field2);
                    jPanel2.add(new JLabel(" B "));
                    jPanel2.add(field3);
                }

                jPanel2.repaint();
                jPanel2.revalidate();

            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field1.setText("");
                field2.setText("");
                field3.setText("");
                setVisible(false);
            }
        });

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String item = (String)jcb.getSelectedItem();

                if(Objects.equals(circle_list.getSelectedItem(), "all")) {
                    for (int i = 0; i < Utils.getCircles().size(); i++) {
                        if (item.equals("move")){
                            Utils.getCircles().get(i).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                        } else if (item.equals("x")) {
                            Utils.getCircles().get(i).setX(Lab3.parseInt(field1.getText(), Utils.getCircles().get(i).getX()));
                        } else if (item.equals("y")) {
                            Utils.getCircles().get(i).setY(Lab3.parseInt(field1.getText(), Utils.getCircles().get(i).getY()));
                        } else if (item.equals("diameter")) {
                            Utils.getCircles().get(i).setDiameter(Lab3.parseInt(field1.getText(), Utils.getCircles().get(i).getDiameter()));
                        } else if (item.equals("fill")) {
                            Utils.getCircles().get(i).setFill(checkBox.isSelected());
                        } else if (item.equals("color")) {
                            Utils.getCircles().get(i).setColor(
                                    Lab3.parseInt(field1.getText(), Utils.getCircles().get(i).getColor().getRed()),
                                    Lab3.parseInt(field2.getText(), Utils.getCircles().get(i).getColor().getGreen()),
                                    Lab3.parseInt(field3.getText(), Utils.getCircles().get(i).getColor().getBlue())
                            );
                        }
                    }
                }else {
                    if (item.equals("move")) {
                        Utils.getCircles().get((int) circle_list.getSelectedIndex()).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                    } else if (item.equals("x")) {
                        Utils.getCircles().get((int) circle_list.getSelectedIndex()).setX(Lab3.parseInt(field1.getText(), Utils.getCircles().get(((int) circle_list.getSelectedIndex())).getX()));
                    } else if (item.equals("y")) {
                        Utils.getCircles().get((int) circle_list.getSelectedIndex()).setY(Lab3.parseInt(field1.getText(), Utils.getCircles().get(((int) circle_list.getSelectedIndex())).getY()));
                    }  else if (item.equals("fill")) {
                        Utils.getCircles().get((int) circle_list.getSelectedIndex()).setFill(checkBox.isSelected());
                    }else if (item.equals("diameter")) {
                        int di = Lab3.parseInt(field1.getText(), Utils.getCircles().get(((int) circle_list.getSelectedIndex())).getDiameter());
                        if(di>0) {
                            Utils.getCircles().get((int) circle_list.getSelectedIndex()).setDiameter(di);
                        }
                    } else if (item.equals("color")) {
                        Utils.getCircles().get((int) circle_list.getSelectedIndex()).setColor(
                                Lab3.parseInt(field1.getText(), Utils.getCircles().get(((int) circle_list.getSelectedIndex())).getColor().getRed()),
                                Lab3.parseInt(field2.getText(), Utils.getCircles().get(((int) circle_list.getSelectedIndex())).getColor().getGreen()),
                                Lab3.parseInt(field3.getText(), Utils.getCircles().get(((int) circle_list.getSelectedIndex())).getColor().getBlue())
                        );
                    }
                }
                field1.setText("");
                field2.setText("");
                field3.setText("");

                Lab3.getPicture().repaint();
                Lab3.getPicture().revalidate();
                jPanel2.repaint();
                jPanel2.revalidate();
                //Lab3.getjPanel().repaint();
                //Lab3.getjPanel().revalidate();
                //Lab3.getjFrame().repaint();
                //Lab3.getjFrame().revalidate();
            }
        });

    }

}
