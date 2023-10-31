package labs.lab3.dialogs.transform;

import labs.lab3.Lab3;
import labs.lab3.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TransformRing extends JDialog {
    JComboBox jcb,circle_list;
    TextField field1,field2,field3;
    JButton cancel,edit;
    JPanel jPanel1,jPanel2,jPanel3;
    public String[] r_list;
    public TransformRing(){
        r_list = new String[Utils.getRing().size()+1];
        for(int i = 0;i<Utils.getRing().size();i++){
            r_list[i] = i+"";
        }
        r_list[Utils.getRing().size()]="all";
        circle_list = new JComboBox(r_list);
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

        setBounds((Lab3.getWindows_w()-width)/2,(Lab3.getWindows_h()-height)/2,width,height);
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
                }else if(item.equals("diameter1")){
                    jPanel2.add(new JLabel(" Diameter1 "));
                    jPanel2.add(field1);
                }else if(item.equals("diameter2")){
                    jPanel2.add(new JLabel(" Diameter2 "));
                    jPanel2.add(field1);
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
                            Utils.getRing().get(i).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                        } else if (item.equals("x")) {
                            Utils.getRing().get(i).setX(Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getX()));
                        } else if (item.equals("y")) {
                            Utils.getRing().get(i).setY(Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getY()));
                        } else if (item.equals("diameter1")) {
                            Utils.getRing().get(i).setDiameter1(Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getDiameter1()));
                        } else if (item.equals("diameter2")) {
                            Utils.getRing().get(i).setDiameter2(Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getDiameter2()));
                        } else if (item.equals("color")) {
                            Utils.getRing().get(i).setColor(
                                    Lab3.parseInt(field1.getText(), Utils.getRing().get(i).getColor().getRed()),
                                    Lab3.parseInt(field2.getText(), Utils.getRing().get(i).getColor().getGreen()),
                                    Lab3.parseInt(field3.getText(), Utils.getRing().get(i).getColor().getBlue())
                            );
                        }
                    }
                }else {
                    if (item.equals("move")) {
                        Utils.getRing().get((int) circle_list.getSelectedIndex()).move(Lab3.parseInt(field1.getText(), 0), Lab3.parseInt(field2.getText(), 0));
                    } else if (item.equals("x")) {
                        Utils.getRing().get((int) circle_list.getSelectedIndex()).setX(Lab3.parseInt(field1.getText(), Utils.getRing().get(((int) circle_list.getSelectedIndex())).getX()));
                    } else if (item.equals("y")) {
                        Utils.getRing().get((int) circle_list.getSelectedIndex()).setY(Lab3.parseInt(field1.getText(), Utils.getRing().get(((int) circle_list.getSelectedIndex())).getY()));
                    }else if (item.equals("diameter1")) {
                        Utils.getRing().get((int) circle_list.getSelectedIndex()).setDiameter1(Lab3.parseInt(field1.getText(), Utils.getRing().get(((int) circle_list.getSelectedIndex())).getDiameter1()));
                    } else if (item.equals("diameter2")) {
                        Utils.getRing().get((int) circle_list.getSelectedIndex()).setDiameter2(Lab3.parseInt(field1.getText(), Utils.getRing().get(((int) circle_list.getSelectedIndex())).getDiameter2()));
                    } else if (item.equals("color")) {
                        Utils.getRing().get((int) circle_list.getSelectedIndex()).setColor(
                                Lab3.parseInt(field1.getText(), Utils.getRing().get(((int) circle_list.getSelectedIndex())).getColor().getRed()),
                                Lab3.parseInt(field2.getText(), Utils.getRing().get(((int) circle_list.getSelectedIndex())).getColor().getGreen()),
                                Lab3.parseInt(field3.getText(), Utils.getRing().get(((int) circle_list.getSelectedIndex())).getColor().getBlue())
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
