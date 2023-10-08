import labs.lab1.Picture;
import labs.lab1.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static int screen_w = 1500;
    static int screen_h = 800;
    static JFrame jFrame;
    static Utils utils;
    static JPanel jPanel;
    static JMenuBar jMenuBar;
    static JMenu file,edit,create;
    static JMenuItem load,del,exit,cir,lin,tri,a_cir,a_lin,a_tri;

    static Picture picture;

    public static void main(String[] args) {

        utils = new Utils();

        picture = new Picture(utils);
        jFrame = getFrame();
        jMenuBar = new JMenuBar();
        jPanel = new JPanel();

        menu();
        menuBarFunctions();

        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(picture);

        jPanel.repaint();
        jPanel.revalidate();
        jFrame.repaint();
        jFrame.revalidate();
    }

    static JFrame getFrame(){
        //создание окна
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(screen_w,screen_h);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setLocation(dimension.width/2-screen_w/2,dimension.height/2-screen_h/2);
        //jFrame.setResizable(false);
        jFrame.setTitle("labs");
        return jFrame;
    }



    static void menu(){

        file = new JMenu("File");
        edit = new JMenu("Edit");
        jMenuBar.add(file);
        jMenuBar.add(edit);

        load = file.add(new JMenuItem("Load",'L'));
        del = file.add(new JMenuItem("Delete all",'D'));
        del.setEnabled(false);
        file.addSeparator();
        exit = file.add(new JMenuItem("Exit"));

        create =new JMenu("Create");
        edit.add(create);
        a_cir = create.add(new JMenuItem("Circle"));
        a_lin = create.add(new JMenuItem("Line"));
        a_tri = create.add(new JMenuItem("Triangle"));
        edit.addSeparator();
        cir = edit.add(new JMenuItem("Circle"));
        lin = edit.add(new JMenuItem("Line"));
        tri = edit.add(new JMenuItem("Triangle"));

    }
    static void menuBarFunctions(){
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = jFileChooser.showOpenDialog(jPanel);
                if(result == JFileChooser.APPROVE_OPTION){
                    System.out.println(jFileChooser.getSelectedFile().getAbsolutePath());
                    utils.load(jFileChooser.getSelectedFile().getAbsolutePath());
                }
                del.setEnabled(true);
                jPanel.repaint();
                jPanel.revalidate();
                jFrame.repaint();
                jFrame.revalidate();

            }
        });

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.dispose();
                del.setEnabled(false);
                jPanel.repaint();
                jPanel.revalidate();
                jFrame.repaint();
                jFrame.revalidate();
            }
        });

        a_cir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateCircle createCircle = new CreateCircle();
                createCircle.setVisible(true);
            }
        });

    }

    static void fontsInSystem(){
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String s:fonts){
            System.out.println(s);
        }
    }

    public static int getScreen_w() {
        return screen_w;
    }

    public static void setScreen_w(int screen_w) {
        Main.screen_w = screen_w;
    }

    public static int getScreen_h() {
        return screen_h;
    }

    public static void setScreen_h(int screen_h) {
        Main.screen_h = screen_h;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public static Utils getUtils() {
        return utils;
    }

    public static class CreateCircle extends JDialog {

        JTextField xField,yField,radiusField;
        JPanel mainPanel,jPanel1,jPanel2,jPanel3;

        public CreateCircle(){
            super(jFrame,"Create Circle",true);

            mainPanel = new JPanel();

            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();

            xField = new JTextField(5);
            yField = new JTextField(5);
            radiusField = new JTextField(5);

            jPanel1 = new JPanel();
            jPanel1.add(new JLabel("X"));
            jPanel1.add(xField);

            jPanel2 = new JPanel();
            jPanel2.add(new JLabel("Y"));
            jPanel2.add(yField);

            jPanel3 = new JPanel();
            jPanel3.add(new JLabel("Radius"));
            jPanel3.add(radiusField);

            mainPanel.add(jPanel1);
            mainPanel.add(jPanel2);
            mainPanel.add(jPanel3);
            add(mainPanel);

            setBounds(750,400,450,240);
        }

    }

}