package labs.lab6.dialogs;

import labs.lab6.Lab6;
import labs.lab6.Utils;
import labs.lab6.contaners.AbstractContainer;

import javax.swing.*;
import java.awt.*;

public class SaveLoadDialog extends JDialog {

    JPanel containerChoose,buttonPanel;
    JComboBox<String> containers;
    JButton cancel,save,load;
    public SaveLoadDialog(){
        super(Lab6.getjFrame(),"Save/Load",true);
        int width = 280;
        int height = 110;

        containerChoose = new JPanel();
        buttonPanel = new JPanel();
        containers = new JComboBox<>();
        updateContainers();
        cancel = new JButton("Cancel");
        save = new JButton("Save");
        load = new JButton("Load");

        containerChoose.add(new JLabel("Container"));
        containerChoose.add(containers);
        buttonPanel.add(cancel);
        buttonPanel.add(save);
        buttonPanel.add(load);

        add(containerChoose, BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);

        setBounds((Lab6.getWindows_w()-width)/2,(Lab6.getWindows_h()-height)/2,width,height);

        cancel.addActionListener(e->setVisible(false));
        save.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = jFileChooser.showOpenDialog(Lab6.getjFrame());
            if(result == JFileChooser.APPROVE_OPTION){
                System.out.println(jFileChooser.getSelectedFile().getAbsolutePath()+" save");
                Utils.save((String) containers.getSelectedItem(),jFileChooser.getSelectedFile().getAbsolutePath() );
            }

        });
        load.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = jFileChooser.showOpenDialog(Lab6.getjFrame());
            if(result == JFileChooser.APPROVE_OPTION){
                System.out.println(jFileChooser.getSelectedFile().getAbsolutePath()+" load");
                Utils.load((String) containers.getSelectedItem(),jFileChooser.getSelectedFile().getAbsolutePath());
            }
            Lab6.getPicture().repaint();
            Lab6.getPicture().revalidate();
        });

    }

    public void updateContainers(){
        containers.removeAllItems();
        for (AbstractContainer fC: Utils.getFigureContainers()){
            containers.addItem(fC.getName());
        }
        containers.setSelectedIndex(0);
    }

}
