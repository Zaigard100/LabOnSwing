package labs.lab5.dialogs;

import labs.lab5.Lab5;
import labs.lab5.Utils;
import labs.lab5.primitives.*;

import javax.swing.*;
import java.awt.*;

public class TransformFigure extends Dialog {
    JPanel figureChoosing,dataPlain,editPanel;
    JComboBox<String> figureNumber,editParameter;
    TextField field1,field2,field3;
    JCheckBox checkBox;
    JButton cancel,edit,rotate;
    public TransformFigure(){

        super(Lab5.getjFrame(),"Edit",true);

        int width = 300;
        int height = 150;

        figureChoosing = new JPanel();
        dataPlain = new JPanel();
        editPanel = new JPanel();

        figureNumber = new JComboBox<>();
        editParameter = new JComboBox<>();

        field1 = new TextField(5);
        field2 = new TextField(5);
        field3 = new TextField(5);

        checkBox = new JCheckBox();

        cancel = new JButton("Cancel");
        edit = new JButton("Edit");
        rotate = new JButton("Rotate");

        figureChoosing.add(new JLabel("Figure:"));
        figureChoosing.add(figureNumber);
        figureChoosing.add(editParameter);

        dataPlain.add(new JLabel("Nothing"));

        editPanel.add(cancel);
        editPanel.add(edit);

        add(figureChoosing,BorderLayout.NORTH);
        add(dataPlain,BorderLayout.CENTER);
        add(editPanel,BorderLayout.SOUTH);

        setBounds((Lab5.getWindows_w()-width)/2,(Lab5.getWindows_h()-height)/2,width,height);

        figureNumber.addActionListener(e -> {

            updateParameters(parse(noNull((String) figureNumber.getSelectedItem())));
            editParameter.setSelectedIndex(0);
            clearFields();
        });
        editParameter.addActionListener(e -> {

            dataPlainUpdate(
                    parse(noNull((String) figureNumber.getSelectedItem())),
                    noNull((String) editParameter.getSelectedItem())
            );
            clearFields();
        });

        edit.addActionListener(e -> {
                if(noNull((String) figureNumber.getSelectedItem()).equals("all")){
                    for(Figure figure:Utils.getFigures()) {
                        edit(
                                figure,
                                parse(noNull((String) figureNumber.getSelectedItem())),
                                noNull((String) editParameter.getSelectedItem()),
                                field1.getText(),
                                field2.getText(),
                                field3.getText(),
                                checkBox.isSelected()
                        );
                    }
                }else {
                    edit(
                            Utils.getFigures().get(figureNumber.getSelectedIndex()),
                            parse(noNull((String) figureNumber.getSelectedItem())),
                            noNull((String) editParameter.getSelectedItem()),
                            field1.getText(),
                            field2.getText(),
                            field3.getText(),
                            checkBox.isSelected()
                    );
                }
        });

        cancel.addActionListener(e -> {
            clearFields();
            setVisible(false);

        });



    }

    public void updateFigureList(){
        if(figureNumber.getItemCount()!=0) {
            figureNumber.removeAllItems();
        }
        int i = 0;
        for(Figure figure:Utils.getFigures()){
            if(figure instanceof Line){
                figureNumber.addItem((i+1)+"(Line)");
            }else if(figure instanceof Triangle){
                figureNumber.addItem((i+1)+"(Triangle)");
            }else if(figure instanceof Circle){
                figureNumber.addItem((i+1)+"(Circle)");
            }else if(figure instanceof Ring){
                figureNumber.addItem((i+1)+"(Ring)");
            }else if(figure instanceof Oval){
                figureNumber.addItem((i+1)+"(Oval)");
            }else if(figure instanceof Rect){
                figureNumber.addItem((i+1)+"(Rect)");
            }else if(figure instanceof Romb){
                figureNumber.addItem((i+1)+"(Romb)");
            }else if(figure instanceof Trapezoid){
                figureNumber.addItem((i+1)+"(Trapezoid)");
            }else {
                figureNumber.addItem((i+1)+"(NoAdd)");
            }

            i++;
        }
            figureNumber.addItem("all");

        figureNumber.setSelectedIndex(0);
        updateParameters(parse(noNull((String) figureNumber.getSelectedItem())));

        repaint();
        revalidate();
    }

    public void updateParameters(String figureName){
        editParameter.removeAllItems();
        editParameter.addItem("move");
        editParameter.addItem("p");
        switch (figureName){
            case "Line":
                editParameter.addItem("p1");
                break;
            case "Triangle":
                editParameter.addItem("p1");
                editParameter.addItem("p2");
                editParameter.addItem("fill");
                break;
            case "Circle":
                editParameter.addItem("diameter");
                editParameter.addItem("fill");
                break;
            case "Oval":
                editParameter.addItem("rotate90");
                editParameter.addItem("fill");
            case "Ring":
                editParameter.addItem("diameters");
                editParameter.addItem("fill");
                break;
            case "Rect":
            case "Romb":
            case "Trapezoid":
                editParameter.addItem("size");
                editParameter.addItem("fill");
                break;
            case "NoAdd":
                editParameter.addItem("NoAdd");
                break;

        }
        editParameter.addItem("color");

        editParameter.setSelectedIndex(0);


        dataPlainUpdate(
                parse(noNull((String) figureNumber.getSelectedItem())),
                noNull((String) editParameter.getSelectedItem())
        );

        field1.setText("");
        field2.setText("");
        field3.setText("");

    }

    public void dataPlainUpdate(String figureName,String parameter){
        dataPlain.removeAll();
        switch (parameter){
            case "move":
                dataPlain.add(new JLabel("DX"));
                dataPlain.add(field1);
                dataPlain.add(new JLabel("DY"));
                dataPlain.add(field2);
                break;
            case "p":
                dataPlain.add(new JLabel("X"));
                dataPlain.add(field1);
                dataPlain.add(new JLabel("Y"));
                dataPlain.add(field2);
                break;
            case "p1":
                dataPlain.add(new JLabel("X1"));
                dataPlain.add(field1);
                dataPlain.add(new JLabel("Y1"));
                dataPlain.add(field2);
                break;
            case "p2":
                dataPlain.add(new JLabel("X2"));
                dataPlain.add(field1);
                dataPlain.add(new JLabel("Y2"));
                dataPlain.add(field2);
                break;
            case "diameter":
                dataPlain.add(new JLabel("Diameter"));
                dataPlain.add(field1);
                break;
            case "diameters":
                if(figureName.equals("Oval")) {
                    dataPlain.add(new JLabel("DiametersX"));
                    dataPlain.add(field1);
                    dataPlain.add(new JLabel("DiameterY"));
                    dataPlain.add(field2);
                }else if(figureName.equals("Ring")) {
                    dataPlain.add(new JLabel("Diameters1"));
                    dataPlain.add(field1);
                    dataPlain.add(new JLabel("Diameter2"));
                    dataPlain.add(field2);
                }
                break;
            case "size":
                switch (figureName) {
                    case "Rect":
                    case "Romb":
                        dataPlain.add(new JLabel("Width"));
                        dataPlain.add(field1);
                        dataPlain.add(new JLabel("Height"));
                        dataPlain.add(field2);
                        break;
                    case "Trapezoid":
                        dataPlain.add(new JLabel("BaseUp"));
                        dataPlain.add(field1);
                        dataPlain.add(field2);
                        dataPlain.add(new JLabel("Height"));
                        dataPlain.add(field3);
                        break;
                }
                break;
            case "fill":
                dataPlain.add(checkBox);
                break;
            case "color":
                dataPlain.add(field1);
                dataPlain.add(field2);
                dataPlain.add(field3);
                break;
            case  "rotate":
                dataPlain.add(rotate);
        }

        dataPlain.repaint();
        dataPlain.revalidate();

    }

    public void edit(Figure figure,String figureName,String parameter,String f1,String f2 ,String f3,boolean cB){
        try {
            switch (parameter) {
                case "move":
                    figure.move(Lab5.parseInt(f1,0), Lab5.parseInt(f2,0));
                    break;
                case "p":
                    figure.getP().setX(Lab5.parseInt(f1, figure.getP().getX()));
                    figure.getP().setY(Lab5.parseInt(f2, figure.getP().getY()));
                    break;
                case "p1":
                    if (figureName.equals("Line")) {
                        ((Line) figure).setX1(Lab5.parseInt(f1, ((Line) figure).getX1()));
                        ((Line) figure).setY1(Lab5.parseInt(f2, ((Line) figure).getY1()));
                    } else if (figureName.equals("Triangle")) {
                        ((Triangle) figure).setX1(Lab5.parseInt(f1, ((Triangle) figure).getX1()));
                        ((Triangle) figure).setY1(Lab5.parseInt(f2, ((Triangle) figure).getY1()));
                    }
                    break;
                case "p2":
                    ((Triangle) figure).setX2(Lab5.parseInt(f1, ((Triangle) figure).getX2()));
                    ((Triangle) figure).setY2(Lab5.parseInt(f2, ((Triangle) figure).getY2()));
                    break;
                case "diameter":
                    ((Circle) figure).setDiameter(Lab5.parseInt(f1, ((Circle) figure).getDiameter()));
                    break;
                case "diameters":
                    if (figureName.equals("Oval")) {
                        ((Oval) figure).setDiameterX(Lab5.parseInt(f1, ((Oval) figure).getDiameterX()));
                        ((Oval) figure).setDiameterY(Lab5.parseInt(f2, ((Oval) figure).getDiameterY()));
                    } else if (figureName.equals("Ring")) {
                        ((Ring) figure).setDiameterX(Lab5.parseInt(f1, ((Ring) figure).getDiameterX()));
                        ((Ring) figure).setDiameterY(Lab5.parseInt(f2, ((Ring) figure).getDiameterY()));
                    }
                    break;
                case "size":
                    switch (figureName) {
                        case "Rect":
                            ((Rect)  figure).setWidth(Lab5.parseInt(f1, ((Rect) figure).getWidth()) );
                            ((Rect) figure).setHeight(Lab5.parseInt(f2, ((Rect) figure).getHeight()));
                            break;
                        case "Romb":
                            ((Romb)  figure).setWidth(Lab5.parseInt(f1, ((Romb) figure).getWidth()) );
                            ((Romb) figure).setHeight(Lab5.parseInt(f2, ((Romb) figure).getHeight()));
                            break;
                        case "Trapezoid":
                            ((Trapezoid)  figure).setWidth(Lab5.parseInt(f1, ((Trapezoid) figure).getWidth()) );
                            ((Trapezoid) figure).setWidth2(Lab5.parseInt(f2, ((Trapezoid) figure).getWidth2()));
                            ((Trapezoid) figure).setHeight(Lab5.parseInt(f3, ((Trapezoid) figure).getHeight()));
                            break;
                    }
                    break;
                case "fill":
                    figure.setFill(cB);
                    break;
                case "color":
                    figure.setColor(
                            Lab5.parseInt(f1,figure.getColor().getRed()),
                            Lab5.parseInt(f2,figure.getColor().getGreen()),
                            Lab5.parseInt(f3,figure.getColor().getBlue())
                    );
                    break;
            }
        }catch (NumberFormatException err){
            err.printStackTrace();
        }

        Lab5.getPicture().repaint();
        Lab5.getPicture().revalidate();

    }
    private String parse(String name) {
        StringBuilder figureName = new StringBuilder();
        boolean s = false;
        for(char c:name.toCharArray()){
            if( c=='(' || c==')' ){
                s = !s;
            }
            if( s && !(c=='(' || c==')') ){
                figureName.append(c);
            }
        }
        return figureName.toString();
    }

    private String noNull(String s){
        if(s == null){
            return "";
        }
        return  s;
    }

    private void clearFields(){
        field1.setText("");
        field2.setText("");
        field3.setText("");
    }

}
