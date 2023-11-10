package labs.lab4;

import labs.lab4.dialogs.create.*;
import labs.lab4.dialogs.transform.*;

import javax.swing.*;
import java.awt.*;

public class Lab4 {
    static int windows_w = 1500;
    static int windows_h = 800;
    static int screen_w,screen_h;
    public static JFrame jFrame;
    static Utils utils;
    static JPanel jPanel;
    static JMenuBar jMenuBar;
    static JMenu file, transform,create;
    static JMenuItem load,del,exit;
    static JMenuItem cir,lin,rin,ovl,tri,rmb,trp,rct;
    static JMenuItem a_cir,a_lin,a_tri,a_rin,a_ovl,a_rmb,a_trp,a_rct;
    static CreateCircle createCircle = new CreateCircle();
    static CreateLine createLine = new CreateLine();
    static CreateTriangle createTriangle = new CreateTriangle();
    static CreateRing createRing= new CreateRing();
    static CreateOval createOval = new CreateOval();
    static CreateRomb createRomb = new CreateRomb();
    static CreateTrapezoid createTrapezoid = new CreateTrapezoid();
    static CreateRect createRect = new CreateRect();
    static TransformCircle transformCircle = new TransformCircle();
    static TransformLine transformLine = new TransformLine();
    static TransformTriangle transformTriangle = new TransformTriangle();
    static TransformRing transformRing = new TransformRing();
    static TransformOval transformOval = new TransformOval();
    static TransformRomb transformRomb = new TransformRomb();
    static TransformTrapezoid transformTrapezoid = new TransformTrapezoid();
    static TransformRect transformRect = new TransformRect();
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

        cir = transform.add(new JMenuItem("Circle"));
        lin = transform.add(new JMenuItem("Line"));
        tri = transform.add(new JMenuItem("Triangle"));
        rin = transform.add(new JMenuItem("Ring"));
        ovl = transform.add(new JMenuItem("Oval"));
        rmb = transform.add(new JMenuItem("Romb"));
        trp = transform.add(new JMenuItem("Trapezoid"));
        rct = transform.add(new JMenuItem("Rect"));

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

        cir.addActionListener(actionEvent -> {
            transformCircle.reload();
            transformCircle.setVisible(true);
        });

        lin.addActionListener(actionEvent -> {
            transformLine.reload();
            transformLine.setVisible(true);
        });

        tri.addActionListener(actionEvent -> {
            transformTriangle.reload();
            transformTriangle.setVisible(true);
        });

        rin.addActionListener(actionEvent -> {
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

        trp.addActionListener(actionEvent -> {
            transformTrapezoid.reload();
            transformTrapezoid.setVisible(true);
        });

        rct.addActionListener(actionEvent -> {
            transformRect.reload();
            transformRect.setVisible(true);
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
