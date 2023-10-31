package labs.lab3.dialogs.transform;

import labs.lab3.Lab3;
import labs.lab3.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TransformOval extends JDialog {
    JComboBox jcb, oval_list;
    TextField field1,field2,field3;
    JCheckBox checkBox;
    JButton cancel,edit,rotate;
    JPanel jPanel1,jPanel2,jPanel3;
    public String[] o_list;
    public TransformOval(){
        o_list = new String[Utils.getCircles().size()+1];
        for(int i = 0;i<Utils.getCircles().size();i++){
            o_list[i] = i+"";
        }
        o_list[Utils.getCircles().size()]="all";
        oval_list = new JComboBox(o_list);
        jcb = new JComboBox(new String[]{"move", "x", "y", "diameter","rotate90","fill", "color"});
        cancel = new JButton("Cancel");
        edit = new JButton("Edit");
        rotate = new JButton("Rotate");

        int width = 300;
        int hight = 150;

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();

        field1 = new TextField(5);
        field2 = new TextField(5);
        field3 = new TextField(5);

        checkBox = new JCheckBox();

        jPanel1.add(new JLabel("Oval № "));
        jPanel1.add(oval_list);
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

        setBounds((Lab3.getWindows_w() -width)/2,(Lab3.getWindows_h()-hight)/2,width,hight);
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
                    jPanel2.add(new JLabel(" DiameterX "));
                    jPanel2.add(field1);
                    jPanel2.add(new JLabel(" DiameterY "));
                    jPanel2.add(field2);
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
                } else if (item.equals("rotate90")) {
                    jPanel2.add(rotate);
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

        rotate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Objects.equals(oval_list.getSelectedItem(), "all")) {
                    for (int i = 0; i < Utils.getOvals().size(); i++) {
                        Utils.getOvals().get(i).rotate90();
                    }
                }else {
                    Utils.getOvals().get((int) oval_list.getSelectedIndex()).rotate90();
                }
                Lab3.getPicture().repaint();
                Lab3.getPicture().revalidate();
            }

        });

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String item = (String)jcb.getSelectedItem();

                if(Objects.equals(oval_list.getSelectedItem(), "all")) {
                    for (int i = 0; i < Utils.getOvals().size(); i++) {
                        if (item.equals("move")){
                            Utils.getOvals().get(i).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                        } else if (item.equals("x")) {
                            Utils.getOvals().get(i).setX(Lab3.parseInt(field1.getText(), Utils.getOvals().get(i).getX()));
                        } else if (item.equals("y")) {
                            Utils.getOvals().get(i).setY(Lab3.parseInt(field1.getText(), Utils.getOvals().get(i).getY()));
                        } else if (item.equals("diameter")) {
                            Utils.getOvals().get(i).setDiameter(Lab3.parseInt(field1.getText(), Utils.getOvals().get(i).getDiameter()));
                            Utils.getOvals().get(i).setDiameter2(Lab3.parseInt(field2.getText(), Utils.getOvals().get(i).getDiameter2()));
                        } else if (item.equals("fill")) {
                            Utils.getOvals().get(i).setFill(checkBox.isSelected());
                        } else if (item.equals("color")) {
                            Utils.getOvals().get(i).setColor(
                                    Lab3.parseInt(field1.getText(), Utils.getOvals().get(i).getColor().getRed()),
                                    Lab3.parseInt(field2.getText(), Utils.getOvals().get(i).getColor().getGreen()),
                                    Lab3.parseInt(field3.getText(), Utils.getOvals().get(i).getColor().getBlue())
                            );
                        }
                    }
                }else {
                    if (item.equals("move")) {
                        Utils.getOvals().get((int) oval_list.getSelectedIndex()).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                    } else if (item.equals("x")) {
                        Utils.getOvals().get((int) oval_list.getSelectedIndex()).setX(Lab3.parseInt(field1.getText(), Utils.getOvals().get(((int) oval_list.getSelectedIndex())).getX()));
                    } else if (item.equals("y")) {
                        Utils.getOvals().get((int) oval_list.getSelectedIndex()).setY(Lab3.parseInt(field1.getText(), Utils.getOvals().get(((int) oval_list.getSelectedIndex())).getY()));
                    }  else if (item.equals("fill")) {
                        Utils.getOvals().get((int) oval_list.getSelectedIndex()).setFill(checkBox.isSelected());
                    }else if (item.equals("diameter")) {
                        Utils.getOvals().get((int) oval_list.getSelectedIndex()).setDiameter(Lab3.parseInt(field1.getText(), Utils.getOvals().get(((int) oval_list.getSelectedIndex())).getDiameter()));
                        Utils.getOvals().get((int) oval_list.getSelectedIndex()).setDiameter2(Lab3.parseInt(field2.getText(), Utils.getOvals().get(((int) oval_list.getSelectedIndex())).getDiameter2()));
                    } else if (item.equals("color")) {
                        Utils.getOvals().get((int) oval_list.getSelectedIndex()).setColor(
                                Lab3.parseInt(field1.getText(), Utils.getOvals().get(((int) oval_list.getSelectedIndex())).getColor().getRed()),
                                Lab3.parseInt(field2.getText(), Utils.getOvals().get(((int) oval_list.getSelectedIndex())).getColor().getGreen()),
                                Lab3.parseInt(field3.getText(), Utils.getOvals().get(((int) oval_list.getSelectedIndex())).getColor().getBlue())
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
