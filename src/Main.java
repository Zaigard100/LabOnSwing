import labs.lab1.Picture;
import labs.lab1.Utils;
import labs.lab1.primitives.Circle;
import labs.lab1.primitives.Line;
import labs.lab1.primitives.Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static int windows_w = 1500;
    static int windows_h = 800;
    static int screen_w,screen_h;
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
        jFrame.setSize(windows_w, windows_h);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        screen_w = dimension.width;
        screen_h = dimension.height;
        jFrame.setLocation(screen_w/2- windows_w /2,screen_h/2- windows_h /2);
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

        cir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransformCircle transformCircle = new TransformCircle();
                transformCircle.setVisible(true);
            }
        });

        lin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        tri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

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

    public static void setWindows_w(int windows_w) {
        Main.windows_w = windows_w;
    }

    public static int getWindows_h() {
        return windows_h;
    }

    public static void setWindows_h(int windows_h) {
        Main.windows_h = windows_h;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public static Utils getUtils() {
        return utils;
    }

    public static class CreateCircle extends JDialog {

        JTextField xField,yField,diameterField,rField,gField,bField;
        JPanel mainPanel,xPanel,yPanel,diameterPanel,colorPanel;
        JButton cancel,create;
        int width = 325;
        int height = 150;

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

            yPanel = new JPanel();
            yPanel.add(new JLabel("Y"));
            yPanel.add(yField);

            diameterPanel = new JPanel();
            diameterPanel.add(new JLabel("Diameter"));
            diameterPanel.add(diameterField);

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

            mainPanel.add(colorPanel);

            mainPanel.add(cancel);
            mainPanel.add(create);
            add(mainPanel);
            repaint();
            revalidate();

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int x = Integer.parseInt(xField.getText());
                        int y = Integer.parseInt(yField.getText());
                        int radius = Integer.parseInt(diameterField.getText());

                        int r = Integer.parseInt(rField.getText());
                        int g = Integer.parseInt(gField.getText());
                        int b = Integer.parseInt(bField.getText());

                        utils.getCircles().add(new Circle(x, y, radius, new Color(r, g, b)));

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
        JPanel mainPanel,x1Panel,y1Panel,x2Panel,y2Panel,x3Panel,y3Panel,colorPanel;
        JButton cancel,create;
        int width = 325;
        int height = 200;

        public CreateTriangle(){
            super(jFrame,"Create Line",true);

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

            mainPanel.add(colorPanel);

            mainPanel.add(cancel);
            mainPanel.add(create);

            add(mainPanel);

            repaint();
            revalidate();

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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

                        int r = Integer.parseInt(rField.getText());
                        int g = Integer.parseInt(gField.getText());
                        int b = Integer.parseInt(bField.getText());

                        utils.getTriangles().add(new Triangle(x1, y1, x2, y2, x3, y3, new Color(r, g, b)));

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
        JComboBox jcb;

        //

        JButton cancel,edit,ok;
        JPanel jPanel1,jPanel2,jPanel3;
        public TransformCircle(){

            jcb = new JComboBox(new String[]{"move", "x", "y", "diameter", "color"});
            //TODO Центор доделать
            cancel = new JButton("Cancel");
            edit = new JButton("Edit");
            ok = new JButton("Ok");

            jPanel1 = new JPanel();
            jPanel2 = new JPanel();
            jPanel3 = new JPanel();

            jPanel1.add(jcb);
            jPanel1.add(ok);
            jPanel1.setBounds(0,0,325,75);

            jPanel2.setBounds(0,75,325,75);

            jPanel3.add(cancel);
            jPanel3.add(edit);
            jPanel3.setBounds(0,150,325,75);

            add(jPanel1,BorderLayout.NORTH);
            add(jPanel2,BorderLayout.CENTER);
            add(jPanel3,BorderLayout.SOUTH);

            setSize(325,225);

        }

    }

}