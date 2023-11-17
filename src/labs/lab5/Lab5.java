package labs.lab5;

import labs.lab5.dialogs.CreateContainer;
import labs.lab5.dialogs.CreateFigure;
import labs.lab5.dialogs.TransformFigure;

import javax.swing.*;
import java.awt.*;

public class Lab5 {
    static int windows_w = 1200;
    static int windows_h = 600;
    static int screen_w,screen_h;
    public static JFrame jFrame;
    static Utils utils;
    static JPanel jPanel;
    static JMenuBar jMenuBar;
    static JMenu file, transform,create;
    static JMenuItem load,del,exit;
    static JMenuItem fig;
    static JMenuItem a_fig,a_cnt;
    static CreateFigure createFigure = new CreateFigure();
    static CreateContainer createContainer = new CreateContainer();
    static TransformFigure transformFigure = new TransformFigure();
    public static Toolkit toolkit;
    public static Dimension dimension;
    public static Picture picture;

    public void start() {

        picture = new Picture();
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
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(windows_w, windows_h+60);
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        screen_w = dimension.width;
        screen_h = dimension.height;
        jFrame.setLocation(screen_w/2- windows_w /2,screen_h/2- windows_h /2);
        jFrame.setTitle("labs5");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        return jFrame;
    }

    static void menu(){

        file = new JMenu("File");
        transform = new JMenu("Edit");
        create =new JMenu("Create");

        jMenuBar.add(file);
        jMenuBar.add(transform);
        jMenuBar.add(create);

        load = file.add(new JMenuItem("Load",'L'));
        del = file.add(new JMenuItem("Delete all",'D'));
        file.addSeparator();
        exit = file.add(new JMenuItem("Exit"));

        a_fig = create.add(new JMenuItem("Figure"));
        a_cnt = create.add(new JMenuItem("Container"));

        fig = transform.add(new JMenuItem("TransformFigure"));

    }
    static void menuBarFunctions(){
        exit.addActionListener(e -> System.exit(0));

        load.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser("/home/zaigard/Projects/LabOnSwing/src/labs");
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = jFileChooser.showOpenDialog(jPanel);
            if(result == JFileChooser.APPROVE_OPTION){
                System.out.println(jFileChooser.getSelectedFile().getAbsolutePath());
                Utils.load(jFileChooser.getSelectedFile().getAbsolutePath());
            }
            jPanel.repaint();
            jPanel.revalidate();
            jFrame.repaint();
            jFrame.revalidate();
        });

        del.addActionListener(e -> {
            Utils.dispose("all");
            picture.repaint();
            picture.revalidate();
            jPanel.repaint();
            jPanel.revalidate();
            jFrame.repaint();
            jFrame.revalidate();
        });

        a_fig.addActionListener(actionEvent -> {
            createFigure.updateContainers();
            createFigure.setVisible(true);
        });

        a_cnt.addActionListener(actionEvent ->{
            createContainer.setVisible(true);
        });

        fig.addActionListener(actionEvent -> {
            transformFigure.updateContainers();
            transformFigure.setVisible(true);
        });

    }

    public static int parseInt(String string, int def){
        try{
            return Integer.parseInt(string);
        }catch (NumberFormatException e){
            return  def;
        }
    }

    public static int getWindows_w() {
        return windows_w;
    }

    public static int getWindows_h() {
        return windows_h;
    }

    public static JFrame getjFrame() {
        return jFrame;
    }

    public static Utils getUtils() {
        return utils;
    }

    public static Picture getPicture() {
        return picture;
    }
}
