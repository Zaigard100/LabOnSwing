package labs.lab5.dialogs;

import labs.lab5.Lab5;
import labs.lab5.Utils;
import labs.lab5.primitives.FigureContainer;

import javax.swing.*;
import java.awt.*;

public class CreateContainer extends JDialog {

    JPanel dataPanel,buttonPanel;
    JTextField nameF;

    JButton cancel,create;

    public CreateContainer() {
        super(Lab5.getjFrame(),"Container",true);

        int width = 300;
        int height = 150;

        nameF = new JTextField(10);

        cancel = new JButton("Cancel");
        create = new JButton("Create");

        dataPanel = new JPanel();
        buttonPanel = new JPanel();

        dataPanel.add(new JLabel("Name "));
        dataPanel.add(nameF);

        buttonPanel.add(cancel);
        buttonPanel.add(create);


        add(new JLabel("Create Container"), BorderLayout.NORTH);
        add(dataPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        setBounds((Lab5.getWindows_w()-width)/2,(Lab5.getWindows_h()-height)/2,width,height);

        cancel.addActionListener(e-> {
            nameF.setText("");
            setVisible(false);
        });

        create.addActionListener(e ->{
            if(Utils.getContainer(nameF.getText())==null){
                Utils.getFigureContainers().add(new FigureContainer(nameF.getText()));
            }else {
                JOptionPane.showMessageDialog(this,"Некорректный ввод или такой контейнер уже существует");
            }
        });

    }
}
