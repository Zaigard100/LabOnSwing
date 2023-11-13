package labs.lab5.dialogs.transform;

import labs.lab5.Lab5;
import labs.lab5.Utils;
import labs.lab5.primitives.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TransformFigure extends Dialog {

    JPanel figureChoosing,dataPlain,editPanel;
    JComboBox<String> figureNumber,editParameter;
    TextField field1,field2,field3;
    JCheckBox checkBox;
    JButton cancel,edit,rotate;
    public TransformFigure(){

        super(Lab5.getjFrame(),"Edit",false);

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

        updateFigureList();
        figureNumber.setSelectedIndex(0);
        updateParameters(parse((String) Objects.requireNonNull(figureNumber.getSelectedItem())));
        editParameter.setSelectedIndex(0);
        dataPlainUpdate(
                parse((String) Objects.requireNonNull(figureNumber.getSelectedItem())),
                parse((String) Objects.requireNonNull(editParameter.getSelectedItem()))
        );
        figureNumber.addActionListener(e -> {
            updateParameters(parse((String) Objects.requireNonNull(figureNumber.getSelectedItem())));
            editParameter.setSelectedIndex(0);
            dataPlainUpdate(
                    parse((String) Objects.requireNonNull(figureNumber.getSelectedItem())),
                    parse((String) Objects.requireNonNull(editParameter.getSelectedItem()))
            );

        });
        editParameter.addActionListener(e -> {
            dataPlainUpdate(
                    parse((String) Objects.requireNonNull(figureNumber.getSelectedItem())),
                    parse((String) Objects.requireNonNull(editParameter.getSelectedItem()))
            );
        });

        edit.addActionListener(e -> {
            if(figureNumber.getSelectedItem().equals("all")) {
                edit(
                        Utils.getFigures().get(figureNumber.getSelectedIndex()),
                        parse((String) Objects.requireNonNull(figureNumber.getSelectedItem())),
                        parse((String) Objects.requireNonNull(editParameter.getSelectedItem())),
                        Integer.parseInt(field1.getText()),
                        Integer.parseInt(field2.getText()),
                        Integer.parseInt(field2.getText()),
                        checkBox.isSelected()
                );
            }
        });

        cancel.addActionListener(e -> {
            setVisible(false);
        });

    }

    public void updateFigureList(){
        figureNumber.removeAllItems();
        int i = 0;
        System.out.println(Utils.getFigures().size());//TODO продолжить
        for(Figure figure:Utils.getFigures()){
            if(figure instanceof Line){
                figureNumber.addItem(i+"(Line)");
            }else if(figure instanceof Triangle){
                figureNumber.addItem(i+"(Triangle)");
            }else if(figure instanceof Circle){
                figureNumber.addItem(i+"(Circle)");
            }else if(figure instanceof Ring){
                figureNumber.addItem(i+"(Ring)");
            }else if(figure instanceof Oval){
                figureNumber.addItem(i+"(Oval)");
            }else if(figure instanceof Rect){
                figureNumber.addItem(i+"(Rect)");
            }else if(figure instanceof Romb){
                figureNumber.addItem(i+"(Romb)");
            }else if(figure instanceof Trapezoid){
                figureNumber.addItem(i+"(Trapezoid)");
            }else {
                figureNumber.addItem(i+"(NoAdd)");
            }

            i++;
        }
            figureNumber.addItem("all");
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
                if(figureName.equals("Rect")) {
                    dataPlain.add(new JLabel("Width"));
                    dataPlain.add(field1);
                    dataPlain.add(new JLabel("Height"));
                    dataPlain.add(field2);
                }else if(figureName.equals("Romb")) {
                    dataPlain.add(new JLabel("Width"));
                    dataPlain.add(field1);
                    dataPlain.add(new JLabel("Height"));
                    dataPlain.add(field2);
                }else if(figureName.equals("Trapezoid")) {
                    dataPlain.add(new JLabel("BaseUp"));
                    dataPlain.add(field1);
                    dataPlain.add(new JLabel("BaseDown"));
                    dataPlain.add(field2);
                    dataPlain.add(new JLabel("Height"));
                    dataPlain.add(field3);
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
    }

    public void edit(Figure figure,String figureName,String parameter,int f1,int f2 ,int f3,boolean cB){
        switch (parameter){
            case "move":
                figure.move(f1,f2);
                break;
            case "p":
                figure.getP().setX(f1);
                figure.getP().setY(f2);
                break;
            case "p1":
                if(figureName.equals("Line")) {
                    ((Line) figure).setX1(f1);
                    ((Line) figure).setY1(f2);
                }else if(figureName.equals("Triangle")) {
                    ((Triangle) figure).setX1(f1);
                    ((Triangle) figure).setY1(f2);
                }
                break;
            case "p2":
                ((Triangle) figure).setX1(f1);
                ((Triangle) figure).setY1(f2);
                break;
            case "diameter":
                ((Circle)figure).setDiameter(f1);
                break;
            case "diameters":
                if(figureName.equals("Oval")) {
                    ((Oval) figure).setDiameterX(f1);
                    ((Oval) figure).setDiameterY(f2);
                }else if(figureName.equals("Ring")) {
                    ((Ring) figure).setDiameterX(f1);
                    ((Ring) figure).setDiameterY(f2);
                }
                break;
            case "size":
                switch (figureName) {
                    case "Rect":
                        ((Rect) figure).setWidth(f1);
                        ((Rect) figure).setHeight(f2);
                        break;
                    case "Romb":
                        ((Romb) figure).setWidth(f1);
                        ((Romb) figure).setHeight(f2);
                        break;
                    case "Trapezoid":
                        ((Trapezoid) figure).setWidth(f1);
                        ((Trapezoid) figure).setWidth2(f2);
                        ((Trapezoid) figure).setHeight(f3);
                        break;
                }
                break;
            case "fill":
                figure.setFill(cB);
                break;
            case "color":
                figure.setColor(f1,f2,f3);
                break;
        }
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

}
