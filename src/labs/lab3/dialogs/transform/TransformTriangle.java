package labs.lab3.dialogs.transform;

import labs.lab3.Lab3;
import labs.lab3.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TransformTriangle extends JDialog {
    JComboBox jcb,triangle_list;
    TextField field1,field2,field3;
    JButton cancel,edit;
    JCheckBox checkBox;
    JPanel jPanel1,jPanel2,jPanel3;
    public String[] t_list;
    public TransformTriangle(){
        t_list = new String[Utils.getTriangles().size()+1];
        for(int i = 0;i<Utils.getTriangles().size();i++){
            t_list[i] = i+"";
        }
        t_list[Utils.getTriangles().size()]="all";
        triangle_list = new JComboBox(t_list);
        jcb = new JComboBox(new String[]{"move","x1","y1","x2","y2","x3","y3","fill","color"});
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

        jPanel1.add(new JLabel("Triangle № "));
        jPanel1.add(triangle_list);
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
                }else if(item.equals("x1")){
                    jPanel2.add(new JLabel(" X1 "));
                    jPanel2.add(field1);
                }else if(item.equals("y1")){
                    jPanel2.add(new JLabel(" Y1 "));
                    jPanel2.add(field1);
                }else if(item.equals("x2")){
                    jPanel2.add(new JLabel(" X2 "));
                    jPanel2.add(field1);
                }else if(item.equals("y2")){
                    jPanel2.add(new JLabel(" Y2 "));
                    jPanel2.add(field1);
                }else if(item.equals("x3")){
                    jPanel2.add(new JLabel(" X3 "));
                    jPanel2.add(field1);
                }else if(item.equals("y3")){
                    jPanel2.add(new JLabel(" Y3 "));
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
                if(Objects.equals(triangle_list.getSelectedItem(), "all")) {
                    for (int i = 0; i < Utils.getTriangles().size(); i++) {
                        if (item.equals("move")) {
                            Utils.getTriangles().get(i).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                        } else if (item.equals("x1")) {
                            Utils.getTriangles().get(i).setX1(Lab3.parseInt(field1.getText(), Utils.getTriangles().get(i).getX1()));
                        } else if (item.equals("y1")) {
                            Utils.getTriangles().get(i).setY1(Lab3.parseInt(field1.getText(), Utils.getTriangles().get(i).getY1()));
                        } else if (item.equals("x2")) {
                            Utils.getTriangles().get(i).setX2(Lab3.parseInt(field1.getText(), Utils.getTriangles().get(i).getX2()));
                        } else if (item.equals("y2")) {
                            Utils.getTriangles().get(i).setY2(Lab3.parseInt(field1.getText(), Utils.getTriangles().get(i).getY2()));
                        } else if (item.equals("x3")){
                            Utils.getTriangles().get(i).setX3(Lab3.parseInt(field1.getText(), Utils.getTriangles().get(i).getX3()));
                        } else if (item.equals("y3")) {
                            Utils.getTriangles().get(i).setY3(Lab3.parseInt(field1.getText(), Utils.getTriangles().get(i).getY3()));
                        } else if (item.equals("color")) {
                            Utils.getTriangles().get(i).setColor(
                                    Lab3.parseInt(field1.getText(), Utils.getTriangles().get(i).getColor().getRed()),
                                    Lab3.parseInt(field2.getText(), Utils.getTriangles().get(i).getColor().getGreen()),
                                    Lab3.parseInt(field3.getText(), Utils.getTriangles().get(i).getColor().getBlue())
                            );
                        }
                    }
                }else {
                    if (item.equals("move")) {
                        Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                    } else if (item.equals("x1")) {
                        Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setX1(Lab3.parseInt(field1.getText(), Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getX1()));
                    } else if (item.equals("y1")) {
                        Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setY1(Lab3.parseInt(field1.getText(), Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getY1()));
                    } else if (item.equals("x2")) {
                        Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setX2(Lab3.parseInt(field1.getText(), Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getX2()));
                    } else if (item.equals("y2")) {
                        Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setY2(Lab3.parseInt(field1.getText(), Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getY2()));
                    } else if (item.equals("x3")){
                        Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setX3(Lab3.parseInt(field1.getText(), Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getX3()));
                    } else if (item.equals("y3")) {
                        Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setY3(Lab3.parseInt(field1.getText(), Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getY3()));
                    } else if (item.equals("color")) {
                        Utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setColor(
                                Lab3.parseInt(field1.getText(), Utils.getTriangles().get(((int) triangle_list.getSelectedIndex())).getColor().getRed()),
                                Lab3.parseInt(field2.getText(), Utils.getTriangles().get(((int) triangle_list.getSelectedIndex())).getColor().getGreen()),
                                Lab3.parseInt(field3.getText(), Utils.getTriangles().get(((int) triangle_list.getSelectedIndex())).getColor().getBlue())
                        );
                    }

                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    Lab3.getPicture().repaint();
                    Lab3.getPicture().revalidate();
                    jPanel2.repaint();
                    jPanel2.revalidate();
                    Lab3.getjPanel().repaint();
                    Lab3.getjPanel().revalidate();
                    Lab3.getjFrame().repaint();
                    Lab3.getjFrame().revalidate();
                }
            }
        });

    }

}
