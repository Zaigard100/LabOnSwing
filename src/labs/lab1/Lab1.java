package labs.lab1;

import labs.lab1.primitives.Circle;
import labs.lab1.primitives.Line;
import labs.lab1.primitives.Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Lab1 {
    static int windows_w = 1500;
    static int windows_h = 800;
    static int screen_w,screen_h;
    public static JFrame jFrame;
    static Utils utils;
    static JPanel jPanel;
    static JMenuBar jMenuBar;
    static JMenu file,edit,create;
    static JMenuItem load,del,exit,cir,lin,tri,a_cir,a_lin,a_tri;

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
        jFrame.setTitle("labs");
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
                Lab1.CreateCircle createCircle = new Lab1.CreateCircle();
                createCircle.setVisible(true);
            }
        });

        a_lin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab1.CreateLine createLine = new Lab1.CreateLine();
                createLine.setVisible(true);
            }
        });

        a_tri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab1.CreateTriangle createTriangle = new Lab1.CreateTriangle();
                createTriangle.setVisible(true);
            }
        });

        cir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab1.TransformCircle transformCircle = new Lab1.TransformCircle();
                transformCircle.c_list = new String[utils.getCircles().size()];
                for(int i = 0;i<utils.getCircles().size();i++){
                    transformCircle.c_list[i] = i+"";
                }
                transformCircle.setVisible(true);
            }
        });

        lin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab1.TransformLine transformLine = new Lab1.TransformLine();
                transformLine.l_list = new String[utils.getLines().size()];
                for(int i = 0;i<utils.getLines().size();i++){
                    transformLine.l_list[i] = i+"";
                }
                transformLine.setVisible(true);
            }
        });

        tri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lab1.TransformTriangle transformTriangle = new Lab1.TransformTriangle();
                transformTriangle.t_list = new String[utils.getTriangles().size()];
                for(int i = 0;i<utils.getTriangles().size();i++){
                    transformTriangle.t_list[i] = i+"";
                    transformTriangle.setVisible(true);
                }
            }
        });

    }

    protected static int parseInt(String string, int def){
        try{
            int i = Integer.parseInt(string);
            return i;
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
        Lab1.windows_w = windows_w;
    }

    public static int getWindows_h() {
        return windows_h;
    }

    public void setWindows_h(int windows_h) {
        Lab1.windows_h = windows_h;
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

                        utils.getCircles().add(new Circle(x, y, diameter,fill, new Color(r, g, b)));

                        xField.setText("");
                        yField.setText("");
                        diameterField.setText("");

                        rField.setText("");
                        gField.setText("");
                        bField.setText("");

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

                        utils.getLines().add(new Line(x, y, x1, y1, new Color(r, g, b)));

                        xField.setText("");
                        yField.setText("");
                        x1Field.setText("");
                        y1Field.setText("");

                        rField.setText("");
                        gField.setText("");
                        bField.setText("");

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

                        utils.getTriangles().add(new Triangle(x1, y1, x2, y2, x3, y3,fill, new Color(r, g, b)));

                        x1Field.setText("");
                        y1Field.setText("");
                        x2Field.setText("");
                        y2Field.setText("");
                        x3Field.setText("");
                        y3Field.setText("");

                        rField.setText("");
                        gField.setText("");
                        bField.setText("");

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
        protected String[] c_list;
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
        protected String[] l_list;
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
        protected String[] t_list;
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
                                utils.getTriangles().get(i).setX3(parseInt(field1.getText(), utils.getTriangles().get(i).getX3()));
                            } else if (item.equals("y3")) {
                                utils.getTriangles().get(i).setY3(parseInt(field1.getText(), utils.getTriangles().get(i).getY3()));
                            } else if (item.equals("fill")) {
                                utils.getTriangles().get(i).setFill(checkBox.isSelected());
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
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setX3(parseInt(field1.getText(), utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getX3()));
                        } else if (item.equals("y3")) {
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setY3(parseInt(field1.getText(), utils.getTriangles().get((int) triangle_list.getSelectedIndex()).getY3()));
                        } else if (item.equals("fill")) {
                            utils.getTriangles().get((int) triangle_list.getSelectedIndex()).setFill(checkBox.isSelected());
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
}
