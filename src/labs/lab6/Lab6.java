package labs.lab6;

import labs.lab6.dialogs.*;

import javax.swing.*;
import java.awt.*;

public class Lab6 {
    static int windows_w = 1200;
    static int windows_h = 600;
    static int screen_w,screen_h;
    public static JFrame jFrame;
    static Utils utils;
    static JPanel jPanel;
    static JMenuBar jMenuBar;
    static JMenu file,transform,create;
    static JMenuItem load,random,del,exit;
    static JMenuItem fig,cnt;
    static JMenuItem createFigureItem,createContainerItem;
    static CreateFigure createFigure = new CreateFigure();
    static CreateContainer createContainer = new CreateContainer();
    static TransformFigure transformFigure = new TransformFigure();
    static TransformContainer transformContainer = new TransformContainer();
    static SaveLoadDialog saveLoadDialog = new SaveLoadDialog();
    static RandomFigures randomFigures = new RandomFigures();
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
        JFrame jFrame = new JFrame() {};
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(windows_w, windows_h+60);
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        screen_w = dimension.width;
        screen_h = dimension.height;
        jFrame.setLocation(screen_w/2- windows_w /2,screen_h/2- windows_h /2);
        jFrame.setTitle("labs6");
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

        load = file.add(new JMenuItem("Save/Load",'S'));
        random = file.add(new JMenuItem("Random",'R'));
        del = file.add(new JMenuItem("Delete all",'D'));
        file.addSeparator();
        exit = file.add(new JMenuItem("Exit"));

        createFigureItem = create.add(new JMenuItem("Figure"));
        createContainerItem = create.add(new JMenuItem("Container"));

        fig = transform.add(new JMenuItem("Figure"));
        cnt = transform.add((new JMenuItem("Container")));

    }
    static void menuBarFunctions(){
        exit.addActionListener(e -> System.exit(0));

        load.addActionListener(e -> {
            saveLoadDialog.updateContainers();
            saveLoadDialog.setVisible(true);
        });

        random.addActionListener(e -> randomFigures.setVisible(true));

        del.addActionListener(e -> {
            Utils.dispose("all");
            picture.repaint();
            picture.revalidate();
            jPanel.repaint();
            jPanel.revalidate();
            jFrame.repaint();
            jFrame.revalidate();
        });

        createFigureItem.addActionListener(actionEvent -> {
            createFigure.updateContainers();
            createFigure.setVisible(true);
        });

        createContainerItem.addActionListener(actionEvent -> createContainer.setVisible(true));

        fig.addActionListener(actionEvent -> {
            transformFigure.updateContainers();
            transformFigure.setVisible(true);
        });
        cnt.addActionListener(actionEvent ->{
            transformContainer.updateContainers();
            transformContainer.setVisible(true);
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
