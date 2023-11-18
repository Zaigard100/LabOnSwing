package labs.lab6.dialogs;

import labs.lab6.Lab6;
import labs.lab6.Utils;
import labs.lab6.contaners.AbstractContainer;
import labs.lab6.contaners.FigureContainer;
import labs.lab6.primitives.Point;
import labs.lab6.primitives.*;

import javax.swing.*;
import java.awt.*;

public class CreateFigure extends JDialog {

    JPanel figureChoosing,dataPlain,createPanel;

    JPanel dataP,datas,dataColor;
    JComboBox<String> figureName,containers;

    JButton cancel,create;

    TextField xF, yF, x1F, y1F, x2F, y2F, dwF, dw1F, dhF, rF, gF, bF;

    JCheckBox fillCB;

    public CreateFigure() {

        super(Lab6.getjFrame(),"Create",true);

        int width = 530;
        int height = 250;

        xF = new TextField(5);
        yF = new TextField(5);
        x1F = new TextField(5);
        y1F = new TextField(5);
        x2F = new TextField(5);
        y2F = new TextField(5);
        dwF = new TextField(5);
        dw1F = new TextField(5);
        dhF = new TextField(5);
        rF = new TextField(5);
        gF = new TextField(5);
        bF = new TextField(5);

        fillCB = new JCheckBox("Fill");

        figureName = new JComboBox<>(new String[]{"Circle","Line","Triangle","Oval","Ring","Rect","Romb","Trapezoid"});
        containers = new JComboBox<>();

        figureName.setSelectedIndex(0);

        dataP = new JPanel();
        datas = new JPanel();
        dataColor = new JPanel();

        dataP.add(new JLabel(" X "));
        dataP.add(xF);
        dataP.add(new JLabel(" Y "));
        dataP.add(yF);

        dataColor.add(new JLabel(" R "));
        dataColor.add(rF);
        dataColor.add(new JLabel(" G "));
        dataColor.add(gF);
        dataColor.add(new JLabel(" B "));
        dataColor.add(bF);

        cancel = new JButton(" Cancel");
        create = new JButton(" Create");

        figureChoosing = new JPanel();
        dataPlain = new JPanel();
        createPanel = new JPanel();

        figureChoosing.add(new JLabel(" Figure: "));
        figureChoosing.add(figureName);
        figureChoosing.add(containers);

        dataPlain.add(dataP,BorderLayout.NORTH);
        dataPlain.add(datas,BorderLayout.CENTER);
        dataPlain.add(dataColor,BorderLayout.SOUTH);

        createPanel.add(cancel);
        createPanel.add(create);

        add(figureChoosing,BorderLayout.NORTH);
        add(dataPlain,BorderLayout.CENTER);
        add(createPanel,BorderLayout.SOUTH);

        setBounds((Lab6.getWindows_w()-width)/2,(Lab6.getWindows_h()-height)/2,width,height);

        repaint();
        revalidate();

        figureName.addActionListener(e -> updateData());

        cancel.addActionListener(e -> {
            clearFields();
            setVisible(false);
        });

        create.addActionListener(e -> {
            createFigure();
            clearFields();
        });

    }

    public void updateContainers(){
        containers.removeAllItems();
        for (AbstractContainer fC: Utils.getFigureContainers()){
            containers.addItem(fC.getName());
        }
        containers.setSelectedIndex(0);
        updateData();
    }

    public void updateData() {
        datas.removeAll();
        switch ((String) figureName.getSelectedItem()){

            case "Circle":
                datas.add(new JLabel(" Diameter "));
                datas.add(dwF);
                datas.add(fillCB);
                break;
            case "Line":
                datas.add(new JLabel(" X1 "));
                datas.add(x1F);
                datas.add(new JLabel(" Y1 "));
                datas.add(y1F);
                break;
            case "Triangle":
                datas.add(new JLabel(" X1 "));
                datas.add(x1F);
                datas.add(new JLabel(" Y1 "));
                datas.add(y1F);
                datas.add(new JLabel(" X2 "));
                datas.add(x2F);
                datas.add(new JLabel(" Y2 "));
                datas.add(y2F);
                datas.add(fillCB);
                break;
            case "Oval":
                datas.add(new JLabel(" DiameterX "));
                datas.add(dwF);
                datas.add(new JLabel(" DiameterY "));
                datas.add(dhF);
                datas.add(fillCB);
                break;
            case "Ring":
                datas.add(new JLabel(" Diameter1 "));
                datas.add(dwF);
                datas.add(new JLabel(" Diameter2 "));
                datas.add(dhF);
                break;
            case "Rect":
            case "Romb":
                datas.add(new JLabel(" Width "));
                datas.add(dwF);
                datas.add(new JLabel(" Height "));
                datas.add(dhF);
                datas.add(fillCB);
                break;
            case "Trapezoid":
                datas.add(new JLabel(" Base "));
                datas.add(dwF);
                datas.add(dw1F);
                datas.add(new JLabel(" Height "));
                datas.add(dhF);
                datas.add(fillCB);
                break;
        }

        datas.repaint();
        datas.revalidate();

    }

    public void createFigure() {
        int x = Lab6.parseInt(xF.getText(),-1);
        int y = Lab6.parseInt(yF.getText(),-1);
        int x1 = Lab6.parseInt(x1F.getText(),-1);
        int y1 = Lab6.parseInt(y1F.getText(),-1);
        int x2 = Lab6.parseInt(x2F.getText(),-1);
        int y2 = Lab6.parseInt(y2F.getText(),-1);
        int dw = Lab6.parseInt(dwF.getText(),-1);
        int dw1 = Lab6.parseInt(dw1F.getText(),-1);
        int dh = Lab6.parseInt(dhF.getText(),-1);
        int r = Lab6.parseInt(rF.getText(),-1);
        int g = Lab6.parseInt(gF.getText(),-1);
        int b = Lab6.parseInt(bF.getText(),-1);
        boolean fill = fillCB.isSelected();
        switch ((String) figureName.getSelectedItem()){
            case "Circle":
                if((x>0) && (x< Lab6.getWindows_w()-dw) && (y>0) && (y< Lab6.getWindows_h()-dw) && (dw>0) && (dw<Math.min(Lab6.getWindows_w()-x, Lab6.getWindows_h()-y))) {
                    Utils.getContainer(containers.getSelectedItem().toString()).add(new Circle(new Point(x, y), dw, fill, new Color(r, g, b)));
                }
                break;
            case "Line":
                if((x>0) && (x< Lab6.getWindows_w()) && (y>0) && (y< Lab6.getWindows_h()) && (x1>0) && (x1< Lab6.getWindows_w()) && (y1>0) && (y1< Lab6.getWindows_h()) && (r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255)) {
                    Utils.getContainer(containers.getSelectedItem().toString()).add(new Line(new Point(x, y),new Point(x1, y1), new Color(r, g, b)));
                }
                break;
            case "Triangle":
                if((x>0) && (x< Lab6.getWindows_w()) && (y>0) && (y< Lab6.getWindows_h()) && (x1>0) && (x1< Lab6.getWindows_w()) && (y1>0) && (y1< Lab6.getWindows_h()) && (x2>0) && (x2< Lab6.getWindows_w()) && (y2>0) && (y2< Lab6.getWindows_h()) && (r>=0&&g>=0&&b>=0&&r<=255&&g<=255&&b<=255)) {
                    Utils.getContainer(containers.getSelectedItem().toString()).add(new Triangle(new Point(x, y), new Point(x1, y1), new Point(x2, y2), fill, new Color(r, g, b)));
                }
                break;
            case "Oval":
                if((x>0) && (x< Lab6.getWindows_w() - dw) && (y>0) && (y< Lab6.getWindows_h()-dh) && (dw>0)&& (dh>0) && (dw< Lab6.getWindows_w()-x) && (dh< Lab6.getWindows_h()-y)) {
                    Utils.getContainer(containers.getSelectedItem().toString()).add(new Oval(new Point(x,y), dw,dh, fill, new Color(r, g, b)));
                }
                break;
            case "Ring":
                if((x>0) && (x< Lab6.getWindows_w()-Math.max(dw,dh)) && (y>0) && (y< Lab6.getWindows_h()-Math.max(dw,dh)) && (dw>0)&& (dh>0) && (Math.max(dw,dh)<Math.min(Lab6.getWindows_w()-x, Lab6.getWindows_h()-y))) {
                    Utils.getContainer(containers.getSelectedItem().toString()).add(new Ring(new Point(x,y), dw,dh, new Color(r, g, b)));
                }
                break;
            case "Rect":
                if((x>0) && (x< Lab6.getWindows_w() - dw) && (y>0) && (y< Lab6.getWindows_h()-dh) && (dw>0)&& (dh>0) && (dw< Lab6.getWindows_w()-x) && (dh< Lab6.getWindows_h()-y)) {
                    Utils.getContainer(containers.getSelectedItem().toString()).add(new Rect(new Point(x,y), dw,dh, fill, new Color(r, g, b)));
                }
                break;
            case "Romb":
                if((x>0) && (x< Lab6.getWindows_w() - dw) && (y>0) && (y< Lab6.getWindows_h()-dh) && (dw>0)&& (dh>0) && (dw< Lab6.getWindows_w()-x) && (dh< Lab6.getWindows_h()-y)) {
                    Utils.getContainer(containers.getSelectedItem().toString()).add(new Romb(new Point(x,y), dw,dh, fill, new Color(r, g, b)));
                }
                break;
            case "Trapezoid":
                if((x-Math.max(dw,dw1)>0)&&(y-dh>0)&&(x+Math.max(dw,dw1)< Lab6.getWindows_w())&&(y+dh< Lab6.getWindows_h())){
                Utils.getContainer(containers.getSelectedItem().toString()).add(new Trapezoid(new Point(x,y), dw,dw1,dh,fill, new Color(r, g, b)));
                }
                break;
        }

        Lab6.getPicture().repaint();
        Lab6.getPicture().revalidate();

    }

    private void clearFields(){
        xF.setText("");
        yF.setText("");
        x1F.setText("");
        y1F.setText("");
        x2F.setText("");
        y2F.setText("");
        dwF.setText("");
        dw1F.setText("");
        dhF.setText("");
        rF.setText("");
        gF.setText("");
        bF.setText("");
    }

}
