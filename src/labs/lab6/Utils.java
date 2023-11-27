package labs.lab6;

import labs.lab6.contaners.AbstractContainer;
import labs.lab6.contaners.FigureArray;
import labs.lab6.contaners.FigureList;
import labs.lab6.primitives.Point;
import labs.lab6.primitives.*;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Utils {

    static private final ArrayList<AbstractContainer> containers;

    static {
        containers = new ArrayList<>();
        containers.add(new FigureArray("main"));
    }

    //TODO сделать м.б. save

    public static void random(boolean isList, int count,String name){

        if (isList) containers.add(new FigureList(name));
        else containers.add(new FigureArray(name));

        for(int i = 0;i<count;i++){
            getContainer(name).add(randomFigure());
        }

    }

     static Figure randomFigure(){//TODO выход за границы круг или овел
        int num = (int)(Math.random()*8);
        if(num == 8) num--;
        int x,y,x1,x2,x3,y1,y2,y3,width,height;
        switch (num){
            case 0://Circle
                int diameter = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2))/2)+1;// {1,minWinSize}
                x = (int)(diameter/2+1+(Math.random()*(Lab6.getWindows_w()-diameter-2)));// {diameter/2+1,winX-diameter-1}
                y = (int)(diameter/2+1+(Math.random()*(Lab6.getWindows_h()-diameter-2)));// {diameter/2+1,winY-diameter-1}
                return new Circle(new Point(x,y),diameter,Math.random() < 0.5,randomColor());
            case 1://Line
                x1 = (int)(1+(Math.random()*(Lab6.getWindows_w()-2)));// {1,winX-1}
                y1 = (int)(1+(Math.random()*(Lab6.getWindows_h()-2)));// {1,winY-1}
                x2 = (int)(1+(Math.random()*(Lab6.getWindows_w()-2)));
                y2 = (int)(1+(Math.random()*(Lab6.getWindows_h()-2)));
                return new Line(new Point(x1,y1),new Point(x2,y2),randomColor());
            case 2://Oval
                int diameterX = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2-1}
                int diameterY = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2-1}
                x = (int)(diameterX/2+1+(Math.random()*(Lab6.getWindows_w()-diameterX-2)));// {diameterX/2+1,winX-diameterX/2-1}
                y = (int)(diameterY/2+1+(Math.random()*(Lab6.getWindows_h()-diameterY-2)));// {diameterY/2+1,winY-diameterY/2-1}
                return new Oval(new Point(x,y),diameterX,diameterY,Math.random() < 0.5,randomColor());
            case 3://Rect
                width = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2}
                height = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2}
                x = (int)(width/2+1+(Math.random()*(Lab6.getWindows_w()-width-2)));// {width/2+1,winX-width/2-1}
                y = (int)(height/2+1+(Math.random()*(Lab6.getWindows_h()-height-2)));// {height/2+1,winY-height/2-1}
                return new Rect(new Point(x,y),width,height,Math.random() < 0.5,randomColor());
            case 4://Ring
                int diameter1 = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2}
                int diameter2 = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2}
                x = (int)(Math.max(diameter1,diameter2)/2+1+(Math.random()*(Lab6.getWindows_w()-Math.max(diameter1,diameter2)-2)));// {diameterMax/2+1,winX-diameterMax/2-1}
                y = (int)(Math.max(diameter1,diameter2)/2+1+(Math.random()*(Lab6.getWindows_h()-Math.max(diameter1,diameter2)-2)));// {diameterMax/2+1,winY-diameterMax/2-1}
                return new Ring(new Point(x,y),diameter1,diameter2,randomColor());
            case 5://Romb
                width = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2}
                height = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2}
                x = (int)(width/2+1+(Math.random()*(Lab6.getWindows_w()-width-2)));// {width/2+1,winX-width/2-1}
                y = (int)(height/2+1+(Math.random()*(Lab6.getWindows_h()-height-2)));// {height/2+1,winY-height/2-1}
                return  new Romb(new Point(x,y),width,height,Math.random() < 0.5, randomColor());
            case 6://Trapezoid
                int baseUp = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2}
                int baseDown = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2}
                height = (int)((Math.random()*(Math.min(Lab6.getWindows_h(),Lab6.getWindows_w())-2)))/2+1;// {1,minWinSize/2}
                x = (int)(Math.max(baseUp,baseDown)/2+1+(Math.random()*(Lab6.getWindows_w()-Math.max(baseUp,baseDown)-2)));// {baseMax/2+1,winX-baseMax/2-1}
                y = (int)(height/2+1+(Math.random()*(Lab6.getWindows_h()-height-2)));// {height/2+1,winY-height/2-1}
                return new Trapezoid(new Point(x,y),baseUp,baseDown,height,Math.random() < 0.5,randomColor());
            case 7://Triangle
                x1 = (int)(1+(Math.random()*(Lab6.getWindows_w()-2)));// {1,winX-1}
                y1 = (int)(1+(Math.random()*(Lab6.getWindows_h()-2)));// {1,winY-1}
                x2 = (int)(1+(Math.random()*(Lab6.getWindows_w()-2)));
                y2 = (int)(1+(Math.random()*(Lab6.getWindows_h()-2)));
                x3 = (int)(1+(Math.random()*(Lab6.getWindows_w()-2)));
                y3 = (int)(1+(Math.random()*(Lab6.getWindows_h()-2)));
                return new Triangle(new Point(x1,y1),new Point(x2,y2),new Point(x3,y3),Math.random() < 0.5,randomColor());

        }
        return null;
    }

    public static Color randomColor(){
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);
        return new Color(r,g,b);
    }


    public static void load(String name,String file){
        StringBuilder line = new StringBuilder();
        try(FileReader reader = new FileReader(file))
        {
            int c;
            while((c=reader.read())!=-1){
                if(c=='\n'){
                    parse_line(name,line.toString());
                    line = new StringBuilder();
                    continue;
                }
                line.append((char) c);

            }
            parse_line(name,line.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void parse_line(String name,String line){
        try {
            String[] words = line.split(",");
            switch (words[0]) {
                case "t":
                    getContainer(name).add(new Triangle(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            new Point(Integer.parseInt(words[3]), Integer.parseInt(words[4])),
                            new Point(Integer.parseInt(words[5]), Integer.parseInt(words[6])),
                            Boolean.parseBoolean(words[10]),
                            new Color(Integer.parseInt(words[7]), Integer.parseInt(words[8]), Integer.parseInt(words[9]))
                    ));
                    break;
                case "l":
                    getContainer(name).add(new Line(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            new Point(Integer.parseInt(words[3]), Integer.parseInt(words[4])),
                            new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                    ));
                    break;
                case "c":
                    getContainer(name).add(new Circle(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]),
                            Boolean.parseBoolean(words[7]),
                            new Color(Integer.parseInt(words[4]), Integer.parseInt(words[5]), Integer.parseInt(words[6]))
                    ));
                    break;
                case "ri":
                    getContainer(name).add(new Ring(
                                    new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                                    Integer.parseInt(words[3]),
                                    Integer.parseInt(words[4]),
                                    new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                            )
                    );
                    break;
                case "o":
                    getContainer(name).add(new Oval(
                                    new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                                    Integer.parseInt(words[3]),
                                    Integer.parseInt(words[4]),
                                    Boolean.parseBoolean(words[8]),
                                    new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                            )
                    );
                    break;
                case "ro":
                    getContainer(name).add(new Romb(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]), Integer.parseInt(words[4]),
                            Boolean.parseBoolean(words[8]),
                            new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                    ));
                    break;
                case "tr":
                    getContainer(name).add(new Trapezoid(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]), Integer.parseInt(words[4]), Integer.parseInt(words[5]),
                            Boolean.parseBoolean(words[9]),
                            new Color(Integer.parseInt(words[6]), Integer.parseInt(words[7]), Integer.parseInt(words[8]))
                    ));
                    break;
                case "re":
                    getContainer(name).add(new Rect(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]), Integer.parseInt(words[4]),
                            Boolean.parseBoolean(words[8]),
                            new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                    ));
                    break;
            }
        }catch(NumberFormatException err) {
            System.out.println(line);
            err.printStackTrace();
        }
    }

    public static void save(String name,String file) {
        try(FileWriter writer = new FileWriter(file, false)) {
            for (Figure f : getContainer(name).toArray()) {
                String line = "";
                if (f instanceof Circle) {
                    line = "c," +
                            ((Circle) f).getX() + "," +
                            ((Circle) f).getY() + "," +
                            ((Circle) f).getDiameter() + "," +
                            f.getColor().getRed() + "," +
                            f.getColor().getGreen() + "," +
                            f.getColor().getBlue() + "," +
                            f.isFill() + ",";
                } else if (f instanceof Ring) {
                    line = "ri," +
                            ((Ring) f).getX() + "," +
                            ((Ring) f).getY() + "," +
                            ((Ring) f).getDiameterX() + "," +
                            ((Ring) f).getDiameterY() + "," +
                            f.getColor().getRed() + "," +
                            f.getColor().getGreen() + "," +
                            f.getColor().getBlue() + "," +
                            f.isFill() + ",";
                } else if (f instanceof Line) {
                    line = "l," +
                            ((Line) f).getX() + "," +
                            ((Line) f).getY() + "," +
                            ((Line) f).getX1() + "," +
                            ((Line) f).getY1() + "," +
                            f.getColor().getRed() + "," +
                            f.getColor().getGreen() + "," +
                            f.getColor().getBlue() + ",";
                } else if (f instanceof Oval) {
                    line = "o," +
                            ((Oval) f).getX() + "," +
                            ((Oval) f).getY() + "," +
                            ((Oval) f).getDiameterX() + "," +
                            ((Oval) f).getDiameterY() + "," +
                            f.getColor().getRed() + "," +
                            f.getColor().getGreen() + "," +
                            f.getColor().getBlue() + "," +
                            f.isFill() + ",";

                } else if (f instanceof Rect) {
                    line = "re," +
                            ((Rect) f).getX() + "," +
                            ((Rect) f).getY() + "," +
                            ((Rect) f).getWidth() + "," +
                            ((Rect) f).getHeight() + "," +
                            f.getColor().getRed() + "," +
                            f.getColor().getGreen() + "," +
                            f.getColor().getBlue() + "," +
                            f.isFill() + ",";
                } else if (f instanceof Romb) {
                    line = "ro," +
                            ((Romb) f).getX() + "," +
                            ((Romb) f).getY() + "," +
                            ((Romb) f).getWidth() + "," +
                            ((Romb) f).getHeight() + "," +
                            f.getColor().getRed() + "," +
                            f.getColor().getGreen() + "," +
                            f.getColor().getBlue() + "," +
                            f.isFill() + ",";
                } else if (f instanceof Trapezoid) {
                    line = "tr," +
                            ((Trapezoid) f).getX() + "," +
                            ((Trapezoid) f).getY() + "," +
                            ((Trapezoid) f).getWidth() + "," +
                            ((Trapezoid) f).getWidth2() + "," +
                            ((Trapezoid) f).getHeight() + "," +
                            f.getColor().getRed() + "," +
                            f.getColor().getGreen() + "," +
                            f.getColor().getBlue() + "," +
                            f.isFill() + ",";
                } else if (f instanceof Triangle) {
                    line = "t," +
                            ((Triangle) f).getX1() + "," +
                            ((Triangle) f).getY1() + "," +
                            ((Triangle) f).getX2() + "," +
                            ((Triangle) f).getY2() + "," +
                            ((Triangle) f).getX3() + "," +
                            ((Triangle) f).getY3() + "," +
                            f.getColor().getRed() + "," +
                            f.getColor().getGreen() + "," +
                            f.getColor().getBlue() + "," +
                            f.isFill() + ",";
                }
                System.out.println(line);
                writer.write(line);
                writer.append('\n');
                writer.flush();
            }

        }catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void dispose(String name){
        for(AbstractContainer fC:containers) {
            if(Objects.equals(fC.getName(), name)|| Objects.equals(name, "all")) {
                fC.dispose();
            }
        }
    }

    public static AbstractContainer getContainer(String name){
        for(AbstractContainer fC:containers){
            if(Objects.equals(fC.getName(), name)){
                return fC;
            }
        }
        System.out.println("No find container with name: " + name);
        return null;
    }

    public static ArrayList<AbstractContainer> getFigureContainers(){
        return containers;
    }
}
