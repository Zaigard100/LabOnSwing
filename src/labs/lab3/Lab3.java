package labs.lab3;

import labs.lab3.dialogs.create.*;
import labs.lab3.dialogs.transform.*;

import javax.swing.*;
import java.awt.*;

public class Lab3 {
    static int windows_w = 1500;
    static int windows_h = 800;
    static int screen_w,screen_h;
    public static JFrame jFrame;
    static Utils utils;
    static JPanel jPanel;
    static JMenuBar jMenuBar;
    static JMenu file,edit,create;
    static JMenuItem load,del,exit,cir,lin,rin,ovl,tri,rmb,a_cir,a_lin,a_tri,a_rin,a_ovl,a_rmb;
    static CreateCircle createCircle = new CreateCircle();
    static CreateLine createLine = new CreateLine();
    static CreateTriangle createTriangle = new CreateTriangle();
    static CreateRing createRing= new CreateRing();
    static CreateOval createOval = new CreateOval();
    static CreateRomb createRomb = new CreateRomb();
    static TransformCircle transformCircle = new TransformCircle();
    static TransformLine transformLine = new TransformLine();
    static TransformTriangle transformTriangle = new TransformTriangle();
    static TransformRing transformRing = new TransformRing();
    static TransformOval transformOval = new TransformOval();
    static TransformRomb transformRomb = new TransformRomb();
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
        jFrame.setTitle("labs3");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        return jFrame;
    }



    static void menu(){

        file = new JMenu("File");
        edit = new JMenu("Edit");
        jMenuBar.add(file);
        jMenuBar.add(edit);

        load = file.add(new JMenuItem("Load",'L'));
        del = file.add(new JMenuItem("Delete all",'D'));
        file.addSeparator();
        exit = file.add(new JMenuItem("Exit"));

        create =new JMenu("Create");
        edit.add(create);
        a_cir = create.add(new JMenuItem("Circle"));
        a_lin = create.add(new JMenuItem("Line"));
        a_tri = create.add(new JMenuItem("Triangle"));
        a_rin = create.add(new JMenuItem("Ring"));
        a_ovl = create.add(new JMenuItem("Oval"));
        a_rmb = create.add(new JMenuItem("Romb"));
        edit.addSeparator();
        cir = edit.add(new JMenuItem("Circle"));
        lin = edit.add(new JMenuItem("Line"));
        tri = edit.add(new JMenuItem("Triangle"));
        rin = edit.add(new JMenuItem("Ring"));
        ovl = edit.add(new JMenuItem("Oval"));
        rmb = edit.add(new JMenuItem("Romb"));

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

        a_cir.addActionListener(e -> createCircle.setVisible(true));

        a_lin.addActionListener(e -> createLine.setVisible(true));

        a_tri.addActionListener(e -> createTriangle.setVisible(true));

        a_rin.addActionListener(e -> createRing.setVisible(true));

        a_ovl.addActionListener(actionEvent -> createOval.setVisible(true));

        a_rmb.addActionListener(actionEvent -> createRomb.setVisible(true));

        cir.addActionListener(e -> {
            transformCircle.reload();
            transformCircle.repaint();
            transformCircle.revalidate();
            transformCircle.setVisible(true);
        });

        lin.addActionListener(e -> {
            transformLine.reload();
            transformLine.setVisible(true);
        });

        tri.addActionListener(e -> {
            transformTriangle.reload();
            transformTriangle.setVisible(true);
        });

        rin.addActionListener(e -> {
            transformRing.reload();
            transformRing.setVisible(true);
        });

        ovl.addActionListener(actionEvent -> {

            transformOval.reload();
            transformOval.setVisible(true);
        });

        rmb.addActionListener(actionEvent -> {
            transformRomb.reload();
            transformRomb.setVisible(true);
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
