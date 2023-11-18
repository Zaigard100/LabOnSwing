package labs.lab6.dialogs;

import labs.lab6.Lab6;
import labs.lab6.Utils;
import labs.lab6.contaners.FigureArray;
import labs.lab6.contaners.FigureContainer;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CreateContainer extends JDialog {

    JPanel dataPanel,buttonPanel;
    JTextField nameF;

    JPanel typeChoice;

    JButton cancel,create;

    JComboBox<String> type;

    public CreateContainer() {
        super(Lab6.getjFrame(),"Container",true);

        int width = 300;
        int height = 150;

        nameF = new JTextField(10);

        type = new JComboBox<>(new String[]{"list","array"});
        typeChoice = new JPanel();

        cancel = new JButton("Cancel");
        create = new JButton("Create");

        dataPanel = new JPanel();
        buttonPanel = new JPanel();

        typeChoice.add(new JLabel("Create Container"));
        typeChoice.add(type);

        dataPanel.add(new JLabel("Name "));
        dataPanel.add(nameF);

        buttonPanel.add(cancel);
        buttonPanel.add(create);


        add(typeChoice, BorderLayout.NORTH);
        add(dataPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        setBounds((Lab6.getWindows_w()-width)/2,(Lab6.getWindows_h()-height)/2,width,height);

        cancel.addActionListener(e-> {
            nameF.setText("");
            setVisible(false);
        });

        create.addActionListener(e ->{
            if(Utils.getContainer(nameF.getText())==null){
                if(Objects.equals((String) type.getSelectedItem(), "list")) {
                    Utils.getFigureContainers().add(new FigureContainer(nameF.getText()));
                }else if (Objects.equals((String) type.getSelectedItem(), "array")){
                    Utils.getFigureContainers().add(new FigureArray(nameF.getText()));
                }
            }else {
                JOptionPane.showMessageDialog(this,"Некорректный ввод или такой контейнер уже существует");
            }
        });

    }
}
