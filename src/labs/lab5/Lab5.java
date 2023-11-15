package labs.lab5;

import labs.lab5.dialogs.create.*;
import labs.lab5.dialogs.transform.*;

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
    static JMenuItem a_cir,a_lin,a_tri,a_rin,a_ovl,a_rmb,a_trp,a_rct,a_fig;
    static CreateCircle createCircle = new CreateCircle();
    static CreateLine createLine = new CreateLine();
    static CreateTriangle createTriangle = new CreateTriangle();
    static CreateRing createRing= new CreateRing();
    static CreateOval createOval = new CreateOval();
    static CreateRomb createRomb = new CreateRomb();
    static CreateTrapezoid createTrapezoid = new CreateTrapezoid();
    static CreateRect createRect = new CreateRect();
    static CreateFigure createFigure = new CreateFigure();
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

        a_cir = create.add(new JMenuItem("Circle"));
        a_lin = create.add(new JMenuItem("Line"));
        a_tri = create.add(new JMenuItem("Triangle"));
        a_rin = create.add(new JMenuItem("Ring"));
        a_ovl = create.add(new JMenuItem("Oval"));
        a_rmb = create.add(new JMenuItem("Romb"));
        a_trp = create.add(new JMenuItem("Trapezoid"));
        a_rct = create.add(new JMenuItem("Rect"));
        a_fig = create.add(new JMenuItem("Figure"));

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
            Utils.dispose();
            picture.repaint();
            picture.revalidate();
            jPanel.repaint();
            jPanel.revalidate();
            jFrame.repaint();
            jFrame.revalidate();
        });

        a_cir.addActionListener(actionEvent -> createCircle.setVisible(true));

        a_lin.addActionListener(actionEvent -> createLine.setVisible(true));

        a_tri.addActionListener(actionEvent -> createTriangle.setVisible(true));

        a_rin.addActionListener(actionEvent -> createRing.setVisible(true));

        a_ovl.addActionListener(actionEvent -> createOval.setVisible(true));

        a_rmb.addActionListener(actionEvent -> createRomb.setVisible(true));

        a_trp.addActionListener(actionEvent -> createTrapezoid.setVisible(true));

        a_rct.addActionListener(actionEvent -> createRect.setVisible(true));

        a_fig.addActionListener(actionEvent -> createFigure.setVisible(true));

        fig.addActionListener(actionEvent -> {
            transformFigure.updateFigureList();
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
