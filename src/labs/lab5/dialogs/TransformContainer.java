package labs.lab5.dialogs;

import labs.lab5.Lab5;
import labs.lab5.Utils;
import labs.lab5.primitives.FigureContainer;

import javax.swing.*;
import java.awt.*;

public class TransformContainer extends JDialog {

    JComboBox<String> containers;

    JTextField nameF;

    JCheckBox visibleCb;

    JButton delete, cancel, edit;

    JPanel containerPanel,dataPanel,buttonPanel;

    public TransformContainer() {

        super(Lab5.getjFrame(), "Transform Container", true);

        int width = 300;
        int height = 200;

        nameF = new JTextField(10);

        visibleCb = new JCheckBox("Visible");

        containers = new JComboBox<>();

        delete = new JButton("Delete");
        cancel = new JButton("Cancel");
        edit = new JButton("Edit");

        containerPanel = new JPanel();
        dataPanel = new JPanel();
        buttonPanel = new JPanel();

        containerPanel.add(new JLabel("Container "));
        containerPanel.add(containers);

        dataPanel.add(new JLabel("Name "));
        dataPanel.add(nameF);
        dataPanel.add(visibleCb);

        buttonPanel.add(delete);
        buttonPanel.add(cancel);
        buttonPanel.add(edit);

        add(containerPanel,BorderLayout.NORTH);
        add(dataPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        setBounds((Lab5.getWindows_w()-width)/2,(Lab5.getWindows_h()-height)/2,width,height);

        visibleCb.addActionListener(e -> {
            Utils.getContainer((String) containers.getSelectedItem()).setVisible(visibleCb.isSelected());

            Lab5.getPicture().repaint();
            Lab5.getPicture().revalidate();

        });

        containers.addActionListener(e ->{
            updateData();
        });

        delete.addActionListener(e ->{
            if(Utils.getFigureContainers().size() == 1){
                JOptionPane.showMessageDialog(this,"У вас только один контейнер вы не можете его удалить");
                return;
            }
            if(Utils.getContainer((String) containers.getSelectedItem())!=null){
                Utils.getFigureContainers().remove(Utils.getContainer((String) containers.getSelectedItem()));
            }
            updateContainers();

            Lab5.getPicture().repaint();
            Lab5.getPicture().revalidate();

        });

        cancel.addActionListener(e -> {
            setVisible(false);
        });
        edit.addActionListener(e -> {
            if(Utils.getContainer((String) containers.getSelectedItem())!=null){
                Utils.getContainer((String) containers.getSelectedItem()).setName(nameF.getText());
            }
            updateContainers();

            Lab5.getPicture().repaint();
            Lab5.getPicture().revalidate();

        });
    }

    public void updateContainers(){
        containers.removeAllItems();
        for (FigureContainer fC:Utils.getFigureContainers()){
            containers.addItem(fC.getName());
        }
        containers.setSelectedIndex(0);
        updateData();
    }

    public void updateData(){
        if(Utils.getContainer((String) containers.getSelectedItem())!=null) {
            nameF.setText(Utils.getContainer((String) containers.getSelectedItem()).getName());
            visibleCb.setSelected(Utils.getContainer((String) containers.getSelectedItem()).isVisible());
        }
    }

}
