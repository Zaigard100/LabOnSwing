package labs.lab6.dialogs;

import labs.lab6.Lab6;
import labs.lab6.Utils;

import javax.swing.*;
import java.awt.*;

public class RandomFigures extends JDialog {

    JPanel panelType,panelCount,panelButton;
    JComboBox<String> containerType;
    JTextField nameField, countField;
    JButton cancel,create;

    public RandomFigures(){
        super(Lab6.jFrame,"Random",true);

        int width = 180;
        int height = 170;

        panelType = new JPanel();
        panelCount = new JPanel();
        panelButton = new JPanel();
        containerType = new JComboBox<>(new String[]{"list","array"});
        countField = new JTextField(5);
        nameField = new JTextField(5);
        cancel = new JButton("Cancel");
        create = new JButton("Create");

        panelType.add(new JLabel("Container type"));
        panelType.add(containerType);
        panelCount.add(new JLabel("Container name"));
        panelCount.add(nameField);
        panelCount.add(new JLabel("Figure count"));
        panelCount.add(countField);
        panelButton.add(cancel);
        panelButton.add(create);

        add(panelType, BorderLayout.NORTH);
        add(panelCount, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);
        setBounds((Lab6.getWindows_w()-width)/2,(Lab6.getWindows_h()-height)/2,width,height);

        cancel.addActionListener(e ->{
            countField.setText("");
            setVisible(false);
        });

        create.addActionListener(e -> {
            boolean isList = containerType.getSelectedItem().equals("list");
            try{
                int count = Integer.parseInt(countField.getText());
                if(count<=0){
                    throw new NumberFormatException();
                }
                Utils.random(isList,count,nameField.getText());
                Lab6.getPicture().repaint();
                Lab6.getPicture().revalidate();
                countField.setText("");
                setVisible(false);
            }catch (NumberFormatException err){
                JOptionPane.showMessageDialog(Lab6.getjFrame(),"Некорректный ввод данных!");
            }
        });

    }

}
