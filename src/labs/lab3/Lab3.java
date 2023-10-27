package labs.lab3;

import labs.lab3.primitives.Point;
import labs.lab3.primitives.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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

    public static Toolkit toolkit;
    public static Dimension dimension;
    static Picture picture;

    public void start() {

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
                    utils.load(jFileChooser.getSelectedFile().getAbsolutePath());
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
                TransformCircle transformCircle = new TransformCircle();
                TransformCircle.c_list = new String[utils.getCircles().size()];
                for(int i = 0;i<utils.getCircles().size();i++){
                    TransformCircle.c_list[i] = i+"";
                }
                transformCircle.setVisible(true);
            }
        });

        lin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransformLine transformLine = new TransformLine();
                TransformLine.l_list = new String[utils.getLines().size()];
                for(int i = 0;i<utils.getLines().size();i++){
                    TransformLine.l_list[i] = i+"";
                }
                transformLine.setVisible(true);
            }
        });

        tri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransformTriangle transformTriangle = new TransformTriangle();
                TransformTriangle.t_list = new String[utils.getTriangles().size()];
                for(int i = 0;i<utils.getTriangles().size();i++){
                    TransformTriangle.t_list[i] = i+"";
                    transformTriangle.setVisible(true);
                }
            }
        });

        rin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransformRing transformRing = new TransformRing();
                TransformRing.r_list = new String[utils.getRing().size()];
                for(int i = 0;i<utils.getRing().size();i++){
                    TransformRing.r_list[i] = i+"";
                    transformRing.setVisible(true);
                }
            }
        });

        ovl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TransformOval transformOval = new TransformOval();
                TransformOval.o_list = new String[utils.getOvals().size()];
                for(int i = 0;i<utils.getOvals().size();i++){
                    TransformOval.o_list[i] = i+"";
                }
                transformOval.setVisible(true);
            }
        });

        rmb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TransformRomb transformRomb = new TransformRomb();
                TransformRomb.r_list = new String[utils.getRombs().size()];
                for(int i = 0;i<utils.getOvals().size();i++){
                    TransformRomb.r_list[i] = i+"";
                }
                transformRomb.setVisible(true);
            }
        });

    }

    protected static int parseInt(String string, int def){
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

    public JFrame getjFrame() {
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


    public static class TransformCircle extends JDialog{
        JComboBox jcb,circle_list;
        TextField field1,field2,field3;
        JCheckBox checkBox;
        JButton cancel,edit;
        JPanel jPanel1,jPanel2,jPanel3;
        protected static String[] c_list;
        public TransformCircle(){
            c_list = new String[utils.getCircles().size()+1];
            for(int i = 0;i<utils.getCircles().size();i++){
                c_list[i] = i+"";
            }
            c_list[utils.getCircles().size()]="all";
            circle_list = new JComboBox(c_list);
            jcb = new JComboBox(new String[]{"move", "x", "y", "diameter","fill", "color"});
            cancel = new JButton("Cancel");
            edit = new JButton("Edit");

            int width = 300;
            int hight = 150;

            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();

            field1 = new TextField(5);
            field2 = new TextField(5);
            field3 = new TextField(5);

            checkBox = new JCheckBox();

            jPanel1.add(new JLabel("Circle № "));
            jPanel1.add(circle_list);
            jPanel1.add(jcb);
            jPanel1.setBounds(0,0,325,75);

            jPanel2.add(new JLabel(" DX "));
            jPanel2.add(field1);
            jPanel2.add(new JLabel(" DY "));
            jPanel2.add(field2);
            jPanel2.setBounds(0,75,325,75);

            jPanel3.add(cancel);
            jPanel3.add(edit);
            jPanel3.setBounds(0,150,325,75);

            add(jPanel1,BorderLayout.NORTH);
            add(jPanel2,BorderLayout.CENTER);
            add(jPanel3,BorderLayout.SOUTH);

            setBounds((screen_w-width)/2,(screen_h-hight)/2,width,hight);
            jcb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jPanel2.removeAll();

                    String item = (String)jcb.getSelectedItem();

                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    if(item.equals("move")){
                        jPanel2.add(new JLabel(" DX "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" DY "));
                        jPanel2.add(field2);
                    }else if(item.equals("x")){
                        jPanel2.add(new JLabel(" X "));
                        jPanel2.add(field1);
                    }else if(item.equals("y")){
                        jPanel2.add(new JLabel(" Y "));
                        jPanel2.add(field1);
                    }else if(item.equals("diameter")){
                        jPanel2.add(new JLabel(" Diameter "));
                        jPanel2.add(field1);
                    }else if(item.equals("fill")){
                        jPanel2.add(new JLabel(" Filed  "));
                        jPanel2.add(checkBox);
                    }else if(item.equals("color")){
                        jPanel2.add(new JLabel(" R "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" G "));
                        jPanel2.add(field2);
                        jPanel2.add(new JLabel(" B "));
                        jPanel2.add(field3);
                    }

                    jPanel2.repaint();
                    jPanel2.revalidate();

                }
            });

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    setVisible(false);
                }
            });

            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String item = (String)jcb.getSelectedItem();

                    if(Objects.equals(circle_list.getSelectedItem(), "all")) {
                        for (int i = 0; i < utils.getCircles().size(); i++) {
                            if (item.equals("move")){
                                utils.getCircles().get(i).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                            } else if (item.equals("x")) {
                                utils.getCircles().get(i).setX(parseInt(field1.getText(), utils.getCircles().get(i).getX()));
                            } else if (item.equals("y")) {
                                utils.getCircles().get(i).setY(parseInt(field1.getText(), utils.getCircles().get(i).getY()));
                            } else if (item.equals("diameter")) {
                                utils.getCircles().get(i).setDiameter(parseInt(field1.getText(), utils.getCircles().get(i).getDiameter()));
                            } else if (item.equals("fill")) {
                                utils.getCircles().get(i).setFill(checkBox.isSelected());
                            } else if (item.equals("color")) {
                                utils.getCircles().get(i).setColor(
                                        parseInt(field1.getText(), utils.getCircles().get(i).getColor().getRed()),
                                        parseInt(field2.getText(), utils.getCircles().get(i).getColor().getGreen()),
                                        parseInt(field3.getText(), utils.getCircles().get(i).getColor().getBlue())
                                );
                            }
                        }
                    }else {
                        if (item.equals("move")) {
                            utils.getCircles().get((int) circle_list.getSelectedIndex()).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                        } else if (item.equals("x")) {
                            utils.getCircles().get((int) circle_list.getSelectedIndex()).setX(parseInt(field1.getText(), utils.getCircles().get(((int) circle_list.getSelectedIndex())).getX()));
                        } else if (item.equals("y")) {
                            utils.getCircles().get((int) circle_list.getSelectedIndex()).setY(parseInt(field1.getText(), utils.getCircles().get(((int) circle_list.getSelectedIndex())).getY()));
                        }  else if (item.equals("fill")) {
                            utils.getCircles().get((int) circle_list.getSelectedIndex()).setFill(checkBox.isSelected());
                        }else if (item.equals("diameter")) {
                            int di = parseInt(field1.getText(), utils.getCircles().get(((int) circle_list.getSelectedIndex())).getDiameter());
                            if(di>0) {
                                utils.getCircles().get((int) circle_list.getSelectedIndex()).setDiameter(di);
                            }
                        } else if (item.equals("color")) {
                            utils.getCircles().get((int) circle_list.getSelectedIndex()).setColor(
                                    parseInt(field1.getText(), utils.getCircles().get(((int) circle_list.getSelectedIndex())).getColor().getRed()),
                                    parseInt(field2.getText(), utils.getCircles().get(((int) circle_list.getSelectedIndex())).getColor().getGreen()),
                                    parseInt(field3.getText(), utils.getCircles().get(((int) circle_list.getSelectedIndex())).getColor().getBlue())
                            );
                        }
                    }
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    picture.repaint();
                    picture.revalidate();
                    jPanel2.repaint();
                    jPanel2.revalidate();
                    jPanel.repaint();
                    jPanel.revalidate();
                    jFrame.repaint();
                    jFrame.revalidate();
                }
            });

        }

    }

    public static class TransformLine extends JDialog{
        JComboBox jcb,line_list;
        TextField field1,field2,field3;
        JButton cancel,edit;
        JPanel jPanel1,jPanel2,jPanel3;
        protected static String[] l_list;
        public TransformLine(){
            l_list = new String[utils.getLines().size()+1];
            for(int i = 0;i<utils.getLines().size();i++){
                l_list[i] = i+"";
            }
            l_list[utils.getLines().size()]="all";
            line_list = new JComboBox(l_list);
            jcb = new JComboBox(new String[]{"move", "x", "y", "x1","y1","color"});
            cancel = new JButton("Cancel");
            edit = new JButton("Edit");

            int width = 300;
            int hight = 150;

            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();

            field1 = new TextField(5);
            field2 = new TextField(5);
            field3 = new TextField(5);

            jPanel1.add(new JLabel("Line № "));
            jPanel1.add(line_list);
            jPanel1.add(jcb);
            jPanel1.setBounds(0,0,325,75);

            jPanel2.add(new JLabel(" DX "));
            jPanel2.add(field1);
            jPanel2.add(new JLabel(" DY "));
            jPanel2.add(field2);
            jPanel2.setBounds(0,75,325,75);

            jPanel3.add(cancel);
            jPanel3.add(edit);
            jPanel3.setBounds(0,150,325,75);

            add(jPanel1,BorderLayout.NORTH);
            add(jPanel2,BorderLayout.CENTER);
            add(jPanel3,BorderLayout.SOUTH);

            setBounds((screen_w-width)/2,(screen_h-hight)/2,width,hight);
            jcb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jPanel2.removeAll();

                    String item = (String)jcb.getSelectedItem();

                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    if(item.equals("move")){
                        jPanel2.add(new JLabel(" DX "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" DY "));
                        jPanel2.add(field2);
                    }else if(item.equals("x")){
                        jPanel2.add(new JLabel(" X "));
                        jPanel2.add(field1);
                    }else if(item.equals("y")){
                        jPanel2.add(new JLabel(" Y "));
                        jPanel2.add(field1);
                    }else if(item.equals("x1")){
                        jPanel2.add(new JLabel(" X1 "));
                        jPanel2.add(field1);
                    }else if(item.equals("y1")){
                        jPanel2.add(new JLabel(" Y1 "));
                        jPanel2.add(field1);
                    }else if(item.equals("color")){
                        jPanel2.add(new JLabel(" R "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" G "));
                        jPanel2.add(field2);
                        jPanel2.add(new JLabel(" B "));
                        jPanel2.add(field3);
                    }

                    jPanel2.repaint();
                    jPanel2.revalidate();

                }
            });

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    setVisible(false);
                }
            });

            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String item = (String)jcb.getSelectedItem();
                    if(Objects.equals(line_list.getSelectedItem(), "all")) {
                        for(int i = 0;i<utils.getLines().size();i++) {
                            if (item.equals("move")) {
                                utils.getLines().get(i).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                            } else if (item.equals("x")) {
                                utils.getLines().get(i).setX(parseInt(field1.getText(), utils.getLines().get(i).getX()));
                            } else if (item.equals("y")) {
                                utils.getLines().get(i).setY(parseInt(field1.getText(), utils.getLines().get(i).getY()));
                            } else if (item.equals("x1")) {
                                utils.getLines().get(i).setX1(parseInt(field1.getText(), utils.getLines().get(i).getX1()));
                            } else if (item.equals("y1")) {
                                utils.getLines().get(i).setY1(parseInt(field1.getText(), utils.getLines().get(i).getY1()));
                            } else if (item.equals("color")) {
                                utils.getLines().get(i).setColor(
                                        parseInt(field1.getText(), utils.getLines().get(i).getColor().getRed()),
                                        parseInt(field2.getText(), utils.getLines().get(i).getColor().getGreen()),
                                        parseInt(field3.getText(), utils.getLines().get(i).getColor().getBlue())
                                );
                            }
                        }
                    }else{
                        if (item.equals("move")) {

                            utils.getLines().get((int) line_list.getSelectedIndex()).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                        } else if (item.equals("x")) {
                            utils.getLines().get((int) line_list.getSelectedIndex()).setX(parseInt(field1.getText(), utils.getLines().get(((int) line_list.getSelectedIndex())).getX()));
                        } else if (item.equals("y")) {
                            utils.getLines().get((int) line_list.getSelectedIndex()).setY(parseInt(field1.getText(), utils.getLines().get(((int) line_list.getSelectedIndex())).getY()));
                        } else if (item.equals("x1")) {
                            utils.getLines().get((int) line_list.getSelectedIndex()).setX1(parseInt(field1.getText(), utils.getLines().get(((int) line_list.getSelectedIndex())).getX1()));
                        } else if (item.equals("y1")) {
                            utils.getLines().get((int) line_list.getSelectedIndex()).setY1(parseInt(field1.getText(), utils.getLines().get(((int) line_list.getSelectedIndex())).getY1()));
                        } else if (item.equals("color")) {
                            utils.getLines().get((int) line_list.getSelectedIndex()).setColor(
                                    parseInt(field1.getText(), utils.getLines().get(((int) line_list.getSelectedIndex())).getColor().getRed()),
                                    parseInt(field2.getText(), utils.getLines().get(((int) line_list.getSelectedIndex())).getColor().getGreen()),
                                    parseInt(field3.getText(), utils.getLines().get(((int) line_list.getSelectedIndex())).getColor().getBlue())
                            );
                        }
                    }
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    picture.repaint();
                    picture.revalidate();
                    jPanel2.repaint();
                    jPanel2.revalidate();
                    jPanel.repaint();
                    jPanel.revalidate();
                    jFrame.repaint();
                    jFrame.revalidate();
                }
            });

        }

    }

    public static class TransformTriangle extends JDialog{
        JComboBox jcb,triangle_list;
        TextField field1,field2,field3;
        JButton cancel,edit;
        JCheckBox checkBox;
        JPanel jPanel1,jPanel2,jPanel3;
        protected static String[] t_list;
        public TransformTriangle(){
            t_list = new String[utils.getTriangles().size()+1];
            for(int i = 0;i<utils.getTriangles().size();i++){
                t_list[i] = i+"";
            }
            t_list[utils.getTriangles().size()]="all";
            triangle_list = new JComboBox(t_list);
            jcb = new JComboBox(new String[]{"move","x1","y1","x2","y2","x3","y3","fill","color"});
            cancel = new JButton("Cancel");
            edit = new JButton("Edit");

            int width = 300;
            int hight = 150;

            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();

            field1 = new TextField(5);
            field2 = new TextField(5);
            field3 = new TextField(5);

            checkBox = new JCheckBox();

            jPanel1.add(new JLabel("Triangle № "));
            jPanel1.add(triangle_list);
            jPanel1.add(jcb);
            jPanel1.setBounds(0,0,325,75);

            jPanel2.add(new JLabel(" DX "));
            jPanel2.add(field1);
            jPanel2.add(new JLabel(" DY "));
            jPanel2.add(field2);
            jPanel2.setBounds(0,75,325,75);

            jPanel3.add(cancel);
            jPanel3.add(edit);
            jPanel3.setBounds(0,150,325,75);

            add(jPanel1,BorderLayout.NORTH);
            add(jPanel2,BorderLayout.CENTER);
            add(jPanel3,BorderLayout.SOUTH);

            setBounds((screen_w-width)/2,(screen_h-hight)/2,width,hight);
            jcb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jPanel2.removeAll();

                    String item = (String)jcb.getSelectedItem();

                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    if(item.equals("move")){
                        jPanel2.add(new JLabel(" DX "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" DY "));
                        jPanel2.add(field2);
                    }else if(item.equals("x1")){
                        jPanel2.add(new JLabel(" X1 "));
                        jPanel2.add(field1);
                    }else if(item.equals("y1")){
                        jPanel2.add(new JLabel(" Y1 "));
                        jPanel2.add(field1);
                    }else if(item.equals("x2")){
                        jPanel2.add(new JLabel(" X2 "));
                        jPanel2.add(field1);
                    }else if(item.equals("y2")){
                        jPanel2.add(new JLabel(" Y2 "));
                        jPanel2.add(field1);
                    }else if(item.equals("x3")){
                        jPanel2.add(new JLabel(" X3 "));
                        jPanel2.add(field1);
                    }else if(item.equals("y3")){
                        jPanel2.add(new JLabel(" Y3 "));
                        jPanel2.add(field1);
                    }else if(item.equals("fill")){
                        jPanel2.add(new JLabel(" Filed  "));
                        jPanel2.add(checkBox);
                    }else if(item.equals("color")){
                        jPanel2.add(new JLabel(" R "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" G "));
                        jPanel2.add(field2);
                        jPanel2.add(new JLabel(" B "));
                        jPanel2.add(field3);
                    }

                    jPanel2.repaint();
                    jPanel2.revalidate();

                }
            });

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    setVisible(false);
                }
            });

            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String item = (String)jcb.getSelectedItem();
                    if(Objects.equals(triangle_list.getSelectedItem(), "all")) {
                        for (int i = 0; i < utils.getTriangles().size(); i++) {
                            if (item.equals("move")) {
                                utils.getTriangles().get(i).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                            } else if (item.equals("x1")) {
                                utils.getTriangles().get(i).setX1(parseInt(field1.getText(), utils.getTriangles().get(i).getX1()));
                            } else if (item.equals("y1")) {
                                utils.getTriangles().get(i).setY1(parseInt(field1.getText(), utils.getTriangles().get(i).getY1()));
                            } else if (item.equals("x2")) {
                                utils.getTriangles().get(i).setX2(parseInt(field1.getText(), utils.getTriangles().get(i).getX2()));
                            } else if (item.equals("y2")) {
                                utils.getTriangles().get(i).setY2(parseInt(field1.getText(), utils.getTriangles().get(i).getY2()));
                            } else if (item.equals("x3")){
                                utils.getTriangles().get(i).setX3(parseInt(field1.getText(), utils.getTriangles().get(i).getX3()));
                            } else if (item.equals("y3")) {
                                utils.getTriangles().get(i).setY3(parseInt(field1.getText(), utils.getTriangles().get(i).getY3()));
                            } else if (item.equals("color")) {
                                utils.getTriangles().get(i).setColor(
                                        parseInt(field1.getText(), utils.getTriangles().get(i).getColor().getRed()),
                                        parseInt(field2.getText(), utils.getTriangles().get(i).getColor().getGreen()),
                                        parseInt(field3.getText(), utils.getTriangles().get(i).getColor().getBlue())
                                );
                            }
                        }
                    }else {
                        if (item.equals("move")) {
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                        } else if (item.equals("x1")) {
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setX1(parseInt(field1.getText(), utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getX1()));
                        } else if (item.equals("y1")) {
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setY1(parseInt(field1.getText(), utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getY1()));
                        } else if (item.equals("x2")) {
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setX2(parseInt(field1.getText(), utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getX2()));
                        } else if (item.equals("y2")) {
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setY2(parseInt(field1.getText(), utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getY2()));
                        } else if (item.equals("x3")){
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setX3(parseInt(field1.getText(), utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getX3()));
                        } else if (item.equals("y3")) {
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setY3(parseInt(field1.getText(), utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getY3()));
                        } else if (item.equals("color")) {
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setColor(
                                    parseInt(field1.getText(), utils.getTriangles().get(((int) triangle_list.getSelectedIndex())).getColor().getRed()),
                                    parseInt(field2.getText(), utils.getTriangles().get(((int) triangle_list.getSelectedIndex())).getColor().getGreen()),
                                    parseInt(field3.getText(), utils.getTriangles().get(((int) triangle_list.getSelectedIndex())).getColor().getBlue())
                            );
                        }

                        field1.setText("");
                        field2.setText("");
                        field3.setText("");

                        picture.repaint();
                        picture.revalidate();
                        jPanel2.repaint();
                        jPanel2.revalidate();
                        jPanel.repaint();
                        jPanel.revalidate();
                        jFrame.repaint();
                        jFrame.revalidate();
                    }
                }
            });

        }

    }

    public static class TransformRing extends JDialog{
        JComboBox jcb,circle_list;
        TextField field1,field2,field3;
        JButton cancel,edit;
        JPanel jPanel1,jPanel2,jPanel3;
        static protected String[] r_list;
        public TransformRing(){
            r_list = new String[utils.getRing().size()+1];
            for(int i = 0;i<utils.getRing().size();i++){
                r_list[i] = i+"";
            }
            r_list[utils.getRing().size()]="all";
            circle_list = new JComboBox(r_list);
            jcb = new JComboBox(new String[]{"move", "x", "y", "diameter1", "diameter2", "color"});
            cancel = new JButton("Cancel");
            edit = new JButton("Edit");

            int width = 300;
            int height = 150;

            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();

            field1 = new TextField(5);
            field2 = new TextField(5);
            field3 = new TextField(5);

            jPanel1.add(new JLabel("Ring № "));
            jPanel1.add(circle_list);
            jPanel1.add(jcb);
            jPanel1.setBounds(0,0,325,75);

            jPanel2.add(new JLabel(" DX "));
            jPanel2.add(field1);
            jPanel2.add(new JLabel(" DY "));
            jPanel2.add(field2);
            jPanel2.setBounds(0,75,325,75);

            jPanel3.add(cancel);
            jPanel3.add(edit);
            jPanel3.setBounds(0,150,325,75);

            add(jPanel1,BorderLayout.NORTH);
            add(jPanel2,BorderLayout.CENTER);
            add(jPanel3,BorderLayout.SOUTH);

            setBounds((screen_w-width)/2,(screen_h-height)/2,width,height);
            jcb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jPanel2.removeAll();

                    String item = (String)jcb.getSelectedItem();

                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    if(item.equals("move")){
                        jPanel2.add(new JLabel(" DX "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" DY "));
                        jPanel2.add(field2);
                    }else if(item.equals("x")){
                        jPanel2.add(new JLabel(" X "));
                        jPanel2.add(field1);
                    }else if(item.equals("y")){
                        jPanel2.add(new JLabel(" Y "));
                        jPanel2.add(field1);
                    }else if(item.equals("diameter1")){
                        jPanel2.add(new JLabel(" Diameter1 "));
                        jPanel2.add(field1);
                    }else if(item.equals("diameter2")){
                        jPanel2.add(new JLabel(" Diameter2 "));
                        jPanel2.add(field1);
                    }else if(item.equals("color")){
                        jPanel2.add(new JLabel(" R "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" G "));
                        jPanel2.add(field2);
                        jPanel2.add(new JLabel(" B "));
                        jPanel2.add(field3);
                    }

                    jPanel2.repaint();
                    jPanel2.revalidate();

                }
            });

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    setVisible(false);
                }
            });

            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String item = (String)jcb.getSelectedItem();

                    if(Objects.equals(circle_list.getSelectedItem(), "all")) {
                        for (int i = 0; i < utils.getCircles().size(); i++) {
                            if (item.equals("move")){
                                utils.getRing().get(i).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                            } else if (item.equals("x")) {
                                utils.getRing().get(i).setX(parseInt(field1.getText(), utils.getRing().get(i).getX()));
                            } else if (item.equals("y")) {
                                utils.getRing().get(i).setY(parseInt(field1.getText(), utils.getRing().get(i).getY()));
                            } else if (item.equals("diameter1")) {
                                utils.getRing().get(i).setDiameter1(parseInt(field1.getText(), utils.getRing().get(i).getDiameter1()));
                            } else if (item.equals("diameter2")) {
                                utils.getRing().get(i).setDiameter2(parseInt(field1.getText(), utils.getRing().get(i).getDiameter2()));
                            } else if (item.equals("color")) {
                                utils.getRing().get(i).setColor(
                                        parseInt(field1.getText(), utils.getRing().get(i).getColor().getRed()),
                                        parseInt(field2.getText(), utils.getRing().get(i).getColor().getGreen()),
                                        parseInt(field3.getText(), utils.getRing().get(i).getColor().getBlue())
                                );
                            }
                        }
                    }else {
                        if (item.equals("move")) {
                            utils.getRing().get((int) circle_list.getSelectedIndex()).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                        } else if (item.equals("x")) {
                            utils.getRing().get((int) circle_list.getSelectedIndex()).setX(parseInt(field1.getText(), utils.getRing().get(((int) circle_list.getSelectedIndex())).getX()));
                        } else if (item.equals("y")) {
                            utils.getRing().get((int) circle_list.getSelectedIndex()).setY(parseInt(field1.getText(), utils.getRing().get(((int) circle_list.getSelectedIndex())).getY()));
                        }else if (item.equals("diameter1")) {
                            utils.getRing().get((int) circle_list.getSelectedIndex()).setDiameter1(parseInt(field1.getText(), utils.getRing().get(((int) circle_list.getSelectedIndex())).getDiameter1()));
                        } else if (item.equals("diameter2")) {
                            utils.getRing().get((int) circle_list.getSelectedIndex()).setDiameter2(parseInt(field1.getText(), utils.getRing().get(((int) circle_list.getSelectedIndex())).getDiameter2()));
                        } else if (item.equals("color")) {
                            utils.getRing().get((int) circle_list.getSelectedIndex()).setColor(
                                    parseInt(field1.getText(), utils.getRing().get(((int) circle_list.getSelectedIndex())).getColor().getRed()),
                                    parseInt(field2.getText(), utils.getRing().get(((int) circle_list.getSelectedIndex())).getColor().getGreen()),
                                    parseInt(field3.getText(), utils.getRing().get(((int) circle_list.getSelectedIndex())).getColor().getBlue())
                            );
                        }
                    }
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    picture.repaint();
                    picture.revalidate();
                    jPanel2.repaint();
                    jPanel2.revalidate();
                    jPanel.repaint();
                    jPanel.revalidate();
                    jFrame.repaint();
                    jFrame.revalidate();
                }
            });

        }

    }

    public static class TransformOval extends JDialog{
        JComboBox jcb, oval_list;
        TextField field1,field2,field3;
        JCheckBox checkBox;
        JButton cancel,edit,rotate;
        JPanel jPanel1,jPanel2,jPanel3;
        protected static String[] o_list;
        public TransformOval(){
            o_list = new String[utils.getCircles().size()+1];
            for(int i = 0;i<utils.getCircles().size();i++){
                o_list[i] = i+"";
            }
            o_list[utils.getCircles().size()]="all";
            oval_list = new JComboBox(o_list);
            jcb = new JComboBox(new String[]{"move", "x", "y", "diameter","rotate90","fill", "color"});
            cancel = new JButton("Cancel");
            edit = new JButton("Edit");
            rotate = new JButton("Rotate");

            int width = 300;
            int hight = 150;

            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();

            field1 = new TextField(5);
            field2 = new TextField(5);
            field3 = new TextField(5);

            checkBox = new JCheckBox();

            jPanel1.add(new JLabel("Oval № "));
            jPanel1.add(oval_list);
            jPanel1.add(jcb);
            jPanel1.setBounds(0,0,325,75);

            jPanel2.add(new JLabel(" DX "));
            jPanel2.add(field1);
            jPanel2.add(new JLabel(" DY "));
            jPanel2.add(field2);
            jPanel2.setBounds(0,75,325,75);

            jPanel3.add(cancel);
            jPanel3.add(edit);
            jPanel3.setBounds(0,150,325,75);

            add(jPanel1,BorderLayout.NORTH);
            add(jPanel2,BorderLayout.CENTER);
            add(jPanel3,BorderLayout.SOUTH);

            setBounds((screen_w-width)/2,(screen_h-hight)/2,width,hight);
            jcb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jPanel2.removeAll();

                    String item = (String)jcb.getSelectedItem();

                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    if(item.equals("move")){
                        jPanel2.add(new JLabel(" DX "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" DY "));
                        jPanel2.add(field2);
                    }else if(item.equals("x")){
                        jPanel2.add(new JLabel(" X "));
                        jPanel2.add(field1);
                    }else if(item.equals("y")){
                        jPanel2.add(new JLabel(" Y "));
                        jPanel2.add(field1);
                    }else if(item.equals("diameter")){
                        jPanel2.add(new JLabel(" DiameterX "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" DiameterY "));
                        jPanel2.add(field2);
                    }else if(item.equals("fill")){
                        jPanel2.add(new JLabel(" Filed  "));
                        jPanel2.add(checkBox);
                    }else if(item.equals("color")){
                        jPanel2.add(new JLabel(" R "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" G "));
                        jPanel2.add(field2);
                        jPanel2.add(new JLabel(" B "));
                        jPanel2.add(field3);
                    } else if (item.equals("rotate90")) {
                        jPanel2.add(rotate);
                    }

                    jPanel2.repaint();
                    jPanel2.revalidate();

                }
            });

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    setVisible(false);
                }
            });

            rotate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(Objects.equals(oval_list.getSelectedItem(), "all")) {
                        for (int i = 0; i < utils.getOvals().size(); i++) {
                            utils.getOvals().get(i).rotate90();
                        }
                    }else {
                        utils.getOvals().get((int) oval_list.getSelectedIndex()).rotate90();
                    }
                    picture.repaint();
                    picture.revalidate();
                }

            });

            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String item = (String)jcb.getSelectedItem();

                    if(Objects.equals(oval_list.getSelectedItem(), "all")) {
                        for (int i = 0; i < utils.getOvals().size(); i++) {
                            if (item.equals("move")){
                                utils.getOvals().get(i).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                            } else if (item.equals("x")) {
                                utils.getOvals().get(i).setX(parseInt(field1.getText(), utils.getOvals().get(i).getX()));
                            } else if (item.equals("y")) {
                                utils.getOvals().get(i).setY(parseInt(field1.getText(), utils.getOvals().get(i).getY()));
                            } else if (item.equals("diameter")) {
                                utils.getOvals().get(i).setDiameter(parseInt(field1.getText(), utils.getOvals().get(i).getDiameter()));
                                utils.getOvals().get(i).setDiameter2(parseInt(field2.getText(), utils.getOvals().get(i).getDiameter2()));
                            } else if (item.equals("fill")) {
                                utils.getOvals().get(i).setFill(checkBox.isSelected());
                            } else if (item.equals("color")) {
                                utils.getOvals().get(i).setColor(
                                        parseInt(field1.getText(), utils.getOvals().get(i).getColor().getRed()),
                                        parseInt(field2.getText(), utils.getOvals().get(i).getColor().getGreen()),
                                        parseInt(field3.getText(), utils.getOvals().get(i).getColor().getBlue())
                                );
                            }
                        }
                    }else {
                        if (item.equals("move")) {
                            utils.getOvals().get((int) oval_list.getSelectedIndex()).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                        } else if (item.equals("x")) {
                            utils.getOvals().get((int) oval_list.getSelectedIndex()).setX(parseInt(field1.getText(), utils.getOvals().get(((int) oval_list.getSelectedIndex())).getX()));
                        } else if (item.equals("y")) {
                            utils.getOvals().get((int) oval_list.getSelectedIndex()).setY(parseInt(field1.getText(), utils.getOvals().get(((int) oval_list.getSelectedIndex())).getY()));
                        }  else if (item.equals("fill")) {
                            utils.getOvals().get((int) oval_list.getSelectedIndex()).setFill(checkBox.isSelected());
                        }else if (item.equals("diameter")) {
                            utils.getOvals().get((int) oval_list.getSelectedIndex()).setDiameter(parseInt(field1.getText(), utils.getOvals().get(((int) oval_list.getSelectedIndex())).getDiameter()));
                            utils.getOvals().get((int) oval_list.getSelectedIndex()).setDiameter2(parseInt(field2.getText(), utils.getOvals().get(((int) oval_list.getSelectedIndex())).getDiameter2()));
                        } else if (item.equals("color")) {
                            utils.getOvals().get((int) oval_list.getSelectedIndex()).setColor(
                                    parseInt(field1.getText(), utils.getOvals().get(((int) oval_list.getSelectedIndex())).getColor().getRed()),
                                    parseInt(field2.getText(), utils.getOvals().get(((int) oval_list.getSelectedIndex())).getColor().getGreen()),
                                    parseInt(field3.getText(), utils.getOvals().get(((int) oval_list.getSelectedIndex())).getColor().getBlue())
                            );
                        }
                    }
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    picture.repaint();
                    picture.revalidate();
                    jPanel2.repaint();
                    jPanel2.revalidate();
                    jPanel.repaint();
                    jPanel.revalidate();
                    jFrame.repaint();
                    jFrame.revalidate();
                }
            });

        }

    }

    public static class TransformRomb extends JDialog{
        JComboBox jcb, oval_list;
        TextField field1,field2,field3;
        JCheckBox checkBox;
        JButton cancel,edit;
        JPanel jPanel1,jPanel2,jPanel3;
        protected static String[] r_list;
        public TransformRomb(){
            r_list = new String[utils.getCircles().size()+1];
            for(int i = 0;i<utils.getCircles().size();i++){
                r_list[i] = i+"";
            }
            r_list[utils.getCircles().size()]="all";
            oval_list = new JComboBox(r_list);
            jcb = new JComboBox(new String[]{"move", "x", "y", "size","fill", "color"});
            cancel = new JButton("Cancel");
            edit = new JButton("Edit");

            int width = 300;
            int hight = 150;

            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();

            field1 = new TextField(5);
            field2 = new TextField(5);
            field3 = new TextField(5);

            checkBox = new JCheckBox();

            jPanel1.add(new JLabel("Romb № "));
            jPanel1.add(oval_list);
            jPanel1.add(jcb);
            jPanel1.setBounds(0,0,325,75);

            jPanel2.add(new JLabel(" DX "));
            jPanel2.add(field1);
            jPanel2.add(new JLabel(" DY "));
            jPanel2.add(field2);
            jPanel2.setBounds(0,75,325,75);

            jPanel3.add(cancel);
            jPanel3.add(edit);
            jPanel3.setBounds(0,150,325,75);

            add(jPanel1,BorderLayout.NORTH);
            add(jPanel2,BorderLayout.CENTER);
            add(jPanel3,BorderLayout.SOUTH);

            setBounds((screen_w-width)/2,(screen_h-hight)/2,width,hight);
            jcb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jPanel2.removeAll();

                    String item = (String)jcb.getSelectedItem();

                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    if(item.equals("move")){
                        jPanel2.add(new JLabel(" DX "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" DY "));
                        jPanel2.add(field2);
                    }else if(item.equals("x")){
                        jPanel2.add(new JLabel(" X "));
                        jPanel2.add(field1);
                    }else if(item.equals("y")){
                        jPanel2.add(new JLabel(" Y "));
                        jPanel2.add(field1);
                    }else if(item.equals("size")){
                        jPanel2.add(new JLabel(" Widht "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" Height "));
                        jPanel2.add(field2);
                    }else if(item.equals("fill")){
                        jPanel2.add(new JLabel(" Filed  "));
                        jPanel2.add(checkBox);
                    }else if(item.equals("color")){
                        jPanel2.add(new JLabel(" R "));
                        jPanel2.add(field1);
                        jPanel2.add(new JLabel(" G "));
                        jPanel2.add(field2);
                        jPanel2.add(new JLabel(" B "));
                        jPanel2.add(field3);
                    }

                    jPanel2.repaint();
                    jPanel2.revalidate();

                }
            });

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    setVisible(false);
                }
            });

            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String item = (String)jcb.getSelectedItem();

                    if(Objects.equals(oval_list.getSelectedItem(), "all")) {
                        for (int i = 0; i < utils.getOvals().size(); i++) {
                            if (item.equals("move")){
                                utils.getRombs().get(i).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                            } else if (item.equals("x")) {
                                utils.getRombs().get(i).setX(parseInt(field1.getText(), utils.getRombs().get(i).getX()));
                            } else if (item.equals("y")) {
                                utils.getRombs().get(i).setY(parseInt(field1.getText(), utils.getRombs().get(i).getY()));
                            } else if (item.equals("size")) {
                                utils.getRombs().get(i).setWidth(parseInt(field1.getText(), utils.getRombs().get(i).getWidth()));
                                utils.getRombs().get(i).setHeight(parseInt(field2.getText(), utils.getRombs().get(i).getHeight()));
                            } else if (item.equals("fill")) {
                                utils.getRombs().get(i).setFill(checkBox.isSelected());
                            } else if (item.equals("color")) {
                                utils.getRombs().get(i).setColor(
                                        parseInt(field1.getText(), utils.getRombs().get(i).getColor().getRed()),
                                        parseInt(field2.getText(), utils.getRombs().get(i).getColor().getGreen()),
                                        parseInt(field3.getText(), utils.getRombs().get(i).getColor().getBlue())
                                );
                            }
                        }
                    }else {
                        if (item.equals("move")) {
                            utils.getRombs().get((int) oval_list.getSelectedIndex()).move(parseInt(field1.getText(), 0), parseInt(field2.getText(), 0));
                        } else if (item.equals("x")) {
                            utils.getRombs().get((int) oval_list.getSelectedIndex()).setX(parseInt(field1.getText(), utils.getRombs().get(((int) oval_list.getSelectedIndex())).getX()));
                        } else if (item.equals("y")) {
                            utils.getRombs().get((int) oval_list.getSelectedIndex()).setY(parseInt(field1.getText(), utils.getRombs().get(((int) oval_list.getSelectedIndex())).getY()));
                        }  else if (item.equals("fill")) {
                            utils.getRombs().get((int) oval_list.getSelectedIndex()).setFill(checkBox.isSelected());
                        }else if (item.equals("size")) {
                            utils.getRombs().get((int) oval_list.getSelectedIndex()).setWidth(parseInt(field1.getText(), utils.getRombs().get(((int) oval_list.getSelectedIndex())).getWidth()));
                            utils.getRombs().get((int) oval_list.getSelectedIndex()).setHeight(parseInt(field2.getText(), utils.getRombs().get(((int) oval_list.getSelectedIndex())).getHeight()));
                        } else if (item.equals("color")) {
                            utils.getRombs().get((int) oval_list.getSelectedIndex()).setColor(
                                    parseInt(field1.getText(), utils.getRombs().get(((int) oval_list.getSelectedIndex())).getColor().getRed()),
                                    parseInt(field2.getText(), utils.getRombs().get(((int) oval_list.getSelectedIndex())).getColor().getGreen()),
                                    parseInt(field3.getText(), utils.getRombs().get(((int) oval_list.getSelectedIndex())).getColor().getBlue())
                            );
                        }
                    }
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");

                    picture.repaint();
                    picture.revalidate();
                    jPanel2.repaint();
                    jPanel2.revalidate();
                    jPanel.repaint();
                    jPanel.revalidate();
                    jFrame.repaint();
                    jFrame.revalidate();
                }
            });

        }

    }


}
