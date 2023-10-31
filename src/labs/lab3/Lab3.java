package labs.lab3;

import labs.lab3.dialogs.transform.*;
import labs.lab3.primitives.Point;
import labs.lab3.primitives.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser("/home/zaigard/IdeaProjects/LabOnSwing/src/labs/primitives.txt");
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

            }
        });

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.dispose();
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

        a_lin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateLine createLine = new CreateLine();
                createLine.setVisible(true);
            }
        });

        a_tri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateTriangle createTriangle = new CreateTriangle();
                createTriangle.setVisible(true);
            }
        });

        a_rin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateRing createRing= new CreateRing();
                createRing.setVisible(true);
            }
        });

        a_ovl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CreateOval createOval = new CreateOval();
                createOval.setVisible(true);
            }
        });

        a_rmb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CreateRomb createRomb = new CreateRomb();
                createRomb.setVisible(true);
            }
        });

        cir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transformCircle.c_list = new String[Utils.getCircles().size()+1];
                for(int i = 0; i< Utils.getCircles().size(); i++){
                    transformCircle.c_list[i] = i+"";
                }
                transformCircle.c_list[Utils.getCircles().size()] = "all";
                transformCircle.setVisible(true);
            }
        });

        lin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transformLine.l_list = new String[Utils.getLines().size()+1];
                for(int i = 0; i< Utils.getLines().size(); i++){
                    transformLine.l_list[i] = i+"";
                }
                transformLine.l_list[Utils.getLines().size()] = "all";
                transformLine.setVisible(true);
            }
        });

        tri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transformTriangle.t_list = new String[Utils.getTriangles().size()+1];
                for(int i = 0; i< Utils.getTriangles().size(); i++){
                    transformTriangle.t_list[i] = i+"";
                }
                transformTriangle.t_list[Utils.getTriangles().size()] = "all";
                transformTriangle.setVisible(true);
            }
        });

        rin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transformRing.r_list = new String[Utils.getRing().size()+1];
                for(int i = 0; i< Utils.getRing().size(); i++){
                    transformRing.r_list[i] = i+"";
                }
                transformRing.r_list[Utils.getRing().size()] = "all";
                transformRing.setVisible(true);
            }
        });

        ovl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                transformOval.o_list = new String[Utils.getOvals().size()+1];
                for(int i = 0; i< Utils.getOvals().size(); i++){
                    transformOval.o_list[i] = i+"";
                }
                transformRomb.r_list[Utils.getOvals().size()] = "all";
                transformOval.setVisible(true);
            }
        });

        rmb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                transformRomb.r_list = new String[Utils.getRombs().size()+1];
                for(int i = 0; i< Utils.getOvals().size(); i++){
                    transformRomb.r_list[i] = i+"";
                }
                transformRomb.r_list[Utils.getRombs().size()] = "all";
                transformRomb.setVisible(true);
            }
        });

    }

    public static int parseInt(String string, int def){
        try{
            return Integer.parseInt(string);
        }catch (NumberFormatException e){
            return  def;
        }
    }

    static void fontsInSystem(){
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String s:fonts){
            System.out.println(s);
        }
    }

    public static int getWindows_w() {
        return windows_w;
    }

    public void setWindows_w(int windows_w) {
        Lab3.windows_w = windows_w;
    }

    public static int getWindows_h() {
        return windows_h;
    }

    public void setWindows_h(int windows_h) {
        Lab3.windows_h = windows_h;
    }

    public static JFrame getjFrame() {
        return jFrame;
    }

    public static Utils getUtils() {
        return utils;
    }

    public static class CreateCircle extends JDialog {

        JTextField xField,yField,diameterField,rField,gField,bField;
        JPanel mainPanel,xPanel,yPanel,diameterPanel,colorPanel,fillPanel;
        JButton cancel,create;
        JCheckBox fillCheck;
        int width = 325;
        int height = 175;

        public CreateCircle(){
            super(jFrame,"Create Circle",true);

            mainPanel = new JPanel();

            xPanel = new JPanel();
            yPanel = new JPanel();
            diameterPanel = new JPanel();

            xField = new JTextField(5);
            yField = new JTextField(5);
            diameterField = new JTextField(5);

            rField = new JTextField(3);
            gField = new JTextField(3);
            bField = new JTextField(3);

            cancel = new JButton("Cancel");
            create = new JButton("Create");

            xPanel = new JPanel();
            xPanel.add(new JLabel("X"));
            xPanel.add(xField);

            fillCheck = new JCheckBox();

            yPanel = new JPanel();
            yPanel.add(new JLabel("Y"));
            yPanel.add(yField);

            diameterPanel = new JPanel();
            diameterPanel.add(new JLabel("Diameter"));
            diameterPanel.add(diameterField);

            fillPanel = new JPanel();
            fillPanel.add(new JLabel("Filled: "));
            fillPanel.add(fillCheck);

            colorPanel = new JPanel();
            colorPanel.add(new JLabel("Color:"));
            colorPanel.add(new JLabel(" R "));
            colorPanel.add(rField);
            colorPanel.add(new JLabel(" G "));
            colorPanel.add(gField);
            colorPanel.add(new JLabel(" B "));
            colorPanel.add(bField);

            mainPanel.add(xPanel);
            mainPanel.add(yPanel);
            mainPanel.add(diameterPanel);
            mainPanel.add(fillPanel);
            mainPanel.add(colorPanel);

            mainPanel.add(cancel);
            mainPanel.add(create);
            add(mainPanel);
            repaint();
            revalidate();

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xField.setText("");
                    yField.setText("");
                    diameterField.setText("");

                    rField.setText("");
                    gField.setText("");
                    bField.setText("");
                    setVisible(false);
                }
            });

            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int x = Integer.parseInt(xField.getText());
                        int y = Integer.parseInt(yField.getText());
                        int diameter = Integer.parseInt(diameterField.getText());
                        boolean fill = fillCheck.getModel().isSelected();
                        int r = Integer.parseInt(rField.getText());
                        int g = Integer.parseInt(gField.getText());
                        int b = Integer.parseInt(bField.getText());
                        if((x>0) && (x<windows_w-diameter) && (y>0) && (y<windows_h-diameter) && (diameter>0) && (diameter<Math.min(windows_w-x,windows_h-y))) {
                            utils.getCircles().add(new Circle(new Point(x,y), diameter, fill, new Color(r, g, b)));
                        }
                        xField.setText("");
                        yField.setText("");
                        diameterField.setText("");

                        rField.setText("");
                        gField.setText("");
                        bField.setText("");

                        picture.repaint();
                        picture.revalidate();
                        jPanel.repaint();
                        jPanel.revalidate();
                        jFrame.repaint();
                        jFrame.revalidate();

                        setVisible(false);
                    }catch (NumberFormatException err){
                        JOptionPane.showMessageDialog(null, "Неверно введены данные: NumberFormatException", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        err.printStackTrace();
                    }

                }
            });

            setBounds((screen_w-width)/2, (screen_h-height)/2,width,height);
        }

    }

    public static class CreateLine extends JDialog {

        JTextField xField,yField,x1Field,y1Field,rField,gField,bField;
        JPanel mainPanel,xPanel,yPanel,x1Panel,y1Panel,colorPanel;
        JButton cancel,create;
        int width = 375;
        int height = 150;

        public CreateLine(){
            super(jFrame,"Create Line",true);

            mainPanel = new JPanel();

            xPanel = new JPanel();
            yPanel = new JPanel();
            x1Panel = new JPanel();
            y1Panel = new JPanel();

            xField = new JTextField(5);
            yField = new JTextField(5);
            x1Field = new JTextField(5);
            y1Field = new JTextField(5);

            rField = new JTextField(3);
            gField = new JTextField(3);
            bField = new JTextField(3);

            cancel = new JButton("Cancel");
            create = new JButton("Create");

            xPanel = new JPanel();
            xPanel.add(new JLabel("X"));
            xPanel.add(xField);

            yPanel = new JPanel();
            yPanel.add(new JLabel("Y"));
            yPanel.add(yField);

            x1Panel = new JPanel();
            x1Panel.add(new JLabel("X1"));
            x1Panel.add(x1Field);

            y1Panel = new JPanel();
            y1Panel.add(new JLabel("Y1"));
            y1Panel.add(y1Field);

            colorPanel = new JPanel();

            colorPanel.add(new JLabel("    Color:    "));
            colorPanel.add(new JLabel("  R  "));
            colorPanel.add(rField);
            colorPanel.add(new JLabel("  G  "));
            colorPanel.add(gField);
            colorPanel.add(new JLabel("  B  "));
            colorPanel.add(bField);

            mainPanel.add(xPanel);
            mainPanel.add(yPanel);
            mainPanel.add(x1Panel);
            mainPanel.add(y1Panel);

            mainPanel.add(colorPanel);

            mainPanel.add(cancel);
            mainPanel.add(create);

            add(mainPanel);

            repaint();
            revalidate();

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xField.setText("");
                    yField.setText("");
                    x1Field.setText("");
                    y1Field.setText("");

                    rField.setText("");
                    gField.setText("");
                    bField.setText("");
                    setVisible(false);
                }
            });

            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int x = Integer.parseInt(xField.getText());
                        int y = Integer.parseInt(yField.getText());
                        int x1 = Integer.parseInt(x1Field.getText());
                        int y1 = Integer.parseInt(y1Field.getText());

                        int r = Integer.parseInt(rField.getText());
                        int g = Integer.parseInt(gField.getText());
                        int b = Integer.parseInt(bField.getText());
                        if((x>0) && (x<windows_w) && (y>0) && (y<windows_h) && (x1>0) && (x1<windows_w) && (y1>0) && (y1<windows_h) && (r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255)) {
                            utils.getLines().add(new Line(new Point(x, y),new Point(x1, y1), new Color(r, g, b)));
                        }

                        xField.setText("");
                        yField.setText("");
                        x1Field.setText("");
                        y1Field.setText("");

                        rField.setText("");
                        gField.setText("");
                        bField.setText("");

                        picture.repaint();
                        picture.revalidate();
                        jPanel.repaint();
                        jPanel.revalidate();
                        jFrame.repaint();
                        jFrame.revalidate();

                        setVisible(false);

                    }catch (NumberFormatException err){

                        JOptionPane.showMessageDialog(null, "Неверно введены данные: NumberFormatException", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        err.printStackTrace();

                    }

                }
            });

            setBounds((screen_w-width)/2, (screen_h-height)/2,width,height);
        }

    }

    public static class CreateTriangle extends JDialog {

        JTextField x1Field,y1Field,x2Field,y2Field,x3Field,y3Field,rField,gField,bField;
        JPanel mainPanel,x1Panel,y1Panel,x2Panel,y2Panel,x3Panel,y3Panel,colorPanel,fillPanel;
        JButton cancel,create;
        JCheckBox fillCheck;
        int width = 325;
        int height = 225;

        public CreateTriangle(){
            super(jFrame,"Create Triangle",true);

            mainPanel = new JPanel();

            x1Panel = new JPanel();
            y1Panel = new JPanel();
            x2Panel = new JPanel();
            y2Panel = new JPanel();
            x3Panel = new JPanel();
            y3Panel = new JPanel();

            x1Field = new JTextField(5);
            y1Field = new JTextField(5);
            x2Field = new JTextField(5);
            y2Field = new JTextField(5);
            x3Field = new JTextField(5);
            y3Field = new JTextField(5);

            fillCheck = new JCheckBox();

            rField = new JTextField(3);
            gField = new JTextField(3);
            bField = new JTextField(3);

            cancel = new JButton("Cancel");
            create = new JButton("Create");

            x1Panel = new JPanel();
            x1Panel.add(new JLabel("X1"));
            x1Panel.add(x1Field);

            y1Panel = new JPanel();
            y1Panel.add(new JLabel("Y1"));
            y1Panel.add(y1Field);

            x2Panel = new JPanel();
            x2Panel.add(new JLabel("X2"));
            x2Panel.add(x2Field);

            y2Panel = new JPanel();
            y2Panel.add(new JLabel("Y2"));
            y2Panel.add(y2Field);

            x3Panel = new JPanel();
            x3Panel.add(new JLabel("X3"));
            x3Panel.add(x3Field);

            y3Panel = new JPanel();
            y3Panel.add(new JLabel("Y3"));
            y3Panel.add(y3Field);

            fillPanel = new JPanel();
            fillPanel.add(new JLabel("Filled "));
            fillPanel.add(fillCheck);

            colorPanel = new JPanel();

            colorPanel.add(new JLabel("    Color:    "));
            colorPanel.add(new JLabel("  R  "));
            colorPanel.add(rField);
            colorPanel.add(new JLabel("  G  "));
            colorPanel.add(gField);
            colorPanel.add(new JLabel("  B  "));
            colorPanel.add(bField);

            mainPanel.add(x1Panel);
            mainPanel.add(y1Panel);
            mainPanel.add(x2Panel);
            mainPanel.add(y2Panel);
            mainPanel.add(x3Panel);
            mainPanel.add(y3Panel);
            mainPanel.add(fillPanel);

            mainPanel.add(colorPanel);

            mainPanel.add(cancel);
            mainPanel.add(create);

            add(mainPanel);

            repaint();
            revalidate();

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x1Field.setText("");
                    y1Field.setText("");
                    x2Field.setText("");
                    y2Field.setText("");
                    x3Field.setText("");
                    y3Field.setText("");

                    rField.setText("");
                    gField.setText("");
                    bField.setText("");
                    setVisible(false);
                }
            });

            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int x1 = Integer.parseInt(x1Field.getText());
                        int y1 = Integer.parseInt(y1Field.getText());
                        int x2 = Integer.parseInt(x2Field.getText());
                        int y2 = Integer.parseInt(y2Field.getText());
                        int x3 = Integer.parseInt(x3Field.getText());
                        int y3 = Integer.parseInt(y3Field.getText());
                        boolean fill = fillCheck.isSelected();

                        int r = Integer.parseInt(rField.getText());
                        int g = Integer.parseInt(gField.getText());
                        int b = Integer.parseInt(bField.getText());
                        if((x1>0) && (x1<windows_w) && (y1>0) && (y1<windows_h) && (x2>0) && (x2<windows_w) && (y2>0) && (y2<windows_h) && (x3>0) && (x3<windows_w) && (y3>0) && (y3<windows_h) && (r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255)) {
                            utils.getTriangles().add(new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), fill, new Color(r, g, b)));
                        }
                        x1Field.setText("");
                        y1Field.setText("");
                        x2Field.setText("");
                        y2Field.setText("");
                        x3Field.setText("");
                        y3Field.setText("");

                        rField.setText("");
                        gField.setText("");
                        bField.setText("");

                        picture.repaint();
                        picture.revalidate();
                        jPanel.repaint();
                        jPanel.revalidate();
                        jFrame.repaint();
                        jFrame.revalidate();

                        setVisible(false);

                    }catch (NumberFormatException err){

                        JOptionPane.showMessageDialog(null, "Неверно введены данные: NumberFormatException", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        err.printStackTrace();

                    }

                }
            });

            setBounds((screen_w-width)/2, (screen_h-height)/2,width,height);
        }

    }

    public static class CreateRing extends JDialog {

        JTextField xField,yField,diameter1Field,diameter2Field,rField,gField,bField;
        JPanel mainPanel,xPanel,yPanel,diameter1Panel,diameter2Panel,colorPanel;
        JButton cancel,create;
        int width = 325;
        int height = 175;

        public CreateRing(){
            super(jFrame,"Create Ring",true);

            mainPanel = new JPanel();

            xPanel = new JPanel();
            yPanel = new JPanel();
            diameter1Panel = new JPanel();
            diameter2Panel = new JPanel();

            xField = new JTextField(5);
            yField = new JTextField(5);
            diameter1Field = new JTextField(5);
            diameter2Field = new JTextField(5);

            rField = new JTextField(3);
            gField = new JTextField(3);
            bField = new JTextField(3);

            cancel = new JButton("Cancel");
            create = new JButton("Create");

            xPanel = new JPanel();
            xPanel.add(new JLabel("X"));
            xPanel.add(xField);

            yPanel = new JPanel();
            yPanel.add(new JLabel("Y"));
            yPanel.add(yField);

            diameter1Panel = new JPanel();
            diameter1Panel.add(new JLabel("Diameter1"));
            diameter1Panel.add(diameter1Field);

            diameter2Panel = new JPanel();
            diameter2Panel.add(new JLabel("Diameter2"));
            diameter2Panel.add(diameter2Field);

            colorPanel = new JPanel();
            colorPanel.add(new JLabel("Color:"));
            colorPanel.add(new JLabel(" R "));
            colorPanel.add(rField);
            colorPanel.add(new JLabel(" G "));
            colorPanel.add(gField);
            colorPanel.add(new JLabel(" B "));
            colorPanel.add(bField);

            mainPanel.add(xPanel);
            mainPanel.add(yPanel);
            mainPanel.add(diameter1Panel);
            mainPanel.add(diameter2Panel);
            mainPanel.add(colorPanel);

            mainPanel.add(cancel);
            mainPanel.add(create);
            add(mainPanel);
            repaint();
            revalidate();

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xField.setText("");
                    yField.setText("");
                    diameter1Field.setText("");
                    diameter2Field.setText("");

                    rField.setText("");
                    gField.setText("");
                    bField.setText("");
                    setVisible(false);
                }
            });

            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int x = Integer.parseInt(xField.getText());
                        int y = Integer.parseInt(yField.getText());
                        int diameter1 = Integer.parseInt(diameter1Field.getText());
                        int diameter2 = Integer.parseInt(diameter2Field.getText());
                        int r = Integer.parseInt(rField.getText());
                        int g = Integer.parseInt(gField.getText());
                        int b = Integer.parseInt(bField.getText());
                        if((x>0) && (x<windows_w-Math.max(diameter1,diameter2)) && (y>0) && (y<windows_h-Math.max(diameter1,diameter2)) && (diameter1>0)&& (diameter2>0) && (Math.max(diameter1,diameter2)<Math.min(windows_w-x,windows_h-y))) {
                            utils.getRing().add(new Ring(new Point(x,y), diameter1,diameter2, new Color(r, g, b)));
                        }
                        xField.setText("");
                        yField.setText("");
                        diameter1Field.setText("");
                        diameter2Field.setText("");

                        rField.setText("");
                        gField.setText("");
                        bField.setText("");

                        picture.repaint();
                        picture.revalidate();
                        jPanel.repaint();
                        jPanel.revalidate();
                        jFrame.repaint();
                        jFrame.revalidate();

                        setVisible(false);
                    }catch (NumberFormatException err){
                        JOptionPane.showMessageDialog(null, "Неверно введены данные: NumberFormatException", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        err.printStackTrace();
                    }

                }
            });

            setBounds((screen_w-width)/2, (screen_h-height)/2,width,height);
        }

    }

    public static class CreateOval extends JDialog {

        JTextField xField,yField,diameter1Field,diameter2Field,rField,gField,bField;
        JPanel mainPanel,xPanel,yPanel,diameter1Panel,diameter2Panel,fillPanel,colorPanel;
        JCheckBox fillCheck;
        JButton cancel,create;
        int width = 325;
        int height = 175;

        public CreateOval(){
            super(jFrame,"Create Oval",true);

            mainPanel = new JPanel();

            xField = new JTextField(5);
            yField = new JTextField(5);
            diameter1Field = new JTextField(5);
            diameter2Field = new JTextField(5);

            rField = new JTextField(3);
            gField = new JTextField(3);
            bField = new JTextField(3);

            fillCheck = new JCheckBox();

            cancel = new JButton("Cancel");
            create = new JButton("Create");

            xPanel = new JPanel();
            xPanel.add(new JLabel("X"));
            xPanel.add(xField);

            yPanel = new JPanel();
            yPanel.add(new JLabel("Y"));
            yPanel.add(yField);

            diameter1Panel = new JPanel();
            diameter1Panel.add(new JLabel("DiameterX"));
            diameter1Panel.add(diameter1Field);

            diameter2Panel = new JPanel();
            diameter2Panel.add(new JLabel("DiameterY"));
            diameter2Panel.add(diameter2Field);

            fillPanel = new JPanel();
            fillPanel.add(new JLabel("Fill "));
            fillPanel.add(fillCheck);

            colorPanel = new JPanel();
            colorPanel.add(new JLabel("Color:"));
            colorPanel.add(new JLabel(" R "));
            colorPanel.add(rField);
            colorPanel.add(new JLabel(" G "));
            colorPanel.add(gField);
            colorPanel.add(new JLabel(" B "));
            colorPanel.add(bField);

            mainPanel.add(xPanel);
            mainPanel.add(yPanel);
            mainPanel.add(diameter1Panel);
            mainPanel.add(diameter2Panel);
            mainPanel.add(fillPanel);
            mainPanel.add(colorPanel);

            mainPanel.add(cancel);
            mainPanel.add(create);
            add(mainPanel);
            repaint();
            revalidate();

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xField.setText("");
                    yField.setText("");
                    diameter1Field.setText("");
                    diameter2Field.setText("");

                    rField.setText("");
                    gField.setText("");
                    bField.setText("");
                    setVisible(false);
                }
            });

            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int x = Integer.parseInt(xField.getText());
                        int y = Integer.parseInt(yField.getText());
                        int diameter1 = Integer.parseInt(diameter1Field.getText());
                        int diameter2 = Integer.parseInt(diameter2Field.getText());
                        boolean fill = fillCheck.isSelected();
                        int r = Integer.parseInt(rField.getText());
                        int g = Integer.parseInt(gField.getText());
                        int b = Integer.parseInt(bField.getText());
                        if((x>0) && (x<windows_w - diameter1) && (y>0) && (y<windows_h-diameter2) && (diameter1>0)&& (diameter2>0) && (diameter1<windows_w-x) && (diameter2<windows_h-y)) {
                            utils.getOvals().add(new Oval(new Point(x,y), diameter1,diameter2, fill, new Color(r, g, b)));
                        }
                        xField.setText("");
                        yField.setText("");
                        diameter1Field.setText("");
                        diameter2Field.setText("");

                        rField.setText("");
                        gField.setText("");
                        bField.setText("");

                        picture.repaint();
                        picture.revalidate();
                        jPanel.repaint();
                        jPanel.revalidate();
                        jFrame.repaint();
                        jFrame.revalidate();

                        setVisible(false);
                    }catch (NumberFormatException err){
                        JOptionPane.showMessageDialog(null, "Неверно введены данные: NumberFormatException", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        err.printStackTrace();
                    }

                }
            });

            setBounds((screen_w-width)/2, (screen_h-height)/2,width,height);
        }

    }

    public static class CreateRomb extends JDialog {

        JTextField xField,yField,diameter1Field,diameter2Field,rField,gField,bField;
        JPanel mainPanel,xPanel,yPanel,diameter1Panel,diameter2Panel,fillPanel,colorPanel;
        JCheckBox fillCheck;
        JButton cancel,create;
        int width = 325;
        int height = 175;

        public CreateRomb(){
            super(jFrame,"Create Romb",true);

            mainPanel = new JPanel();

            xField = new JTextField(5);
            yField = new JTextField(5);
            diameter1Field = new JTextField(5);
            diameter2Field = new JTextField(5);

            rField = new JTextField(3);
            gField = new JTextField(3);
            bField = new JTextField(3);

            fillCheck = new JCheckBox();

            cancel = new JButton("Cancel");
            create = new JButton("Create");

            xPanel = new JPanel();
            xPanel.add(new JLabel("X"));
            xPanel.add(xField);

            yPanel = new JPanel();
            yPanel.add(new JLabel("Y"));
            yPanel.add(yField);

            diameter1Panel = new JPanel();
            diameter1Panel.add(new JLabel("DiameterX"));
            diameter1Panel.add(diameter1Field);

            diameter2Panel = new JPanel();
            diameter2Panel.add(new JLabel("DiameterY"));
            diameter2Panel.add(diameter2Field);

            fillPanel = new JPanel();
            fillPanel.add(new JLabel("Fill "));
            fillPanel.add(fillCheck);

            colorPanel = new JPanel();
            colorPanel.add(new JLabel("Color:"));
            colorPanel.add(new JLabel(" R "));
            colorPanel.add(rField);
            colorPanel.add(new JLabel(" G "));
            colorPanel.add(gField);
            colorPanel.add(new JLabel(" B "));
            colorPanel.add(bField);

            mainPanel.add(xPanel);
            mainPanel.add(yPanel);
            mainPanel.add(diameter1Panel);
            mainPanel.add(diameter2Panel);
            mainPanel.add(fillPanel);
            mainPanel.add(colorPanel);

            mainPanel.add(cancel);
            mainPanel.add(create);
            add(mainPanel);
            repaint();
            revalidate();

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xField.setText("");
                    yField.setText("");
                    diameter1Field.setText("");
                    diameter2Field.setText("");

                    rField.setText("");
                    gField.setText("");
                    bField.setText("");
                    setVisible(false);
                }
            });

            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int x = Integer.parseInt(xField.getText());
                        int y = Integer.parseInt(yField.getText());
                        int diameter1 = Integer.parseInt(diameter1Field.getText());
                        int diameter2 = Integer.parseInt(diameter2Field.getText());
                        boolean fill = fillCheck.isSelected();
                        int r = Integer.parseInt(rField.getText());
                        int g = Integer.parseInt(gField.getText());
                        int b = Integer.parseInt(bField.getText());
                        if((x>0) && (x<windows_w - diameter1) && (y>0) && (y<windows_h-diameter2) && (diameter1>0)&& (diameter2>0) && (diameter1<windows_w-x) && (diameter2<windows_h-y)) {
                            utils.getRombs().add(new Romb(new Point(x,y), diameter1,diameter2, fill, new Color(r, g, b)));
                        }
                        xField.setText("");
                        yField.setText("");
                        diameter1Field.setText("");
                        diameter2Field.setText("");

                        rField.setText("");
                        gField.setText("");
                        bField.setText("");

                        picture.repaint();
                        picture.revalidate();
                        jPanel.repaint();
                        jPanel.revalidate();
                        jFrame.repaint();
                        jFrame.revalidate();

                        setVisible(false);
                    }catch (NumberFormatException err){
                        JOptionPane.showMessageDialog(null, "Неверно введены данные: NumberFormatException", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        err.printStackTrace();
                    }

                }
            });

            setBounds((screen_w-width)/2, (screen_h-height)/2,width,height);
        }

    }

    public static JPanel getjPanel() {
        return jPanel;
    }

    public static Picture getPicture() {
        return picture;
    }
}
