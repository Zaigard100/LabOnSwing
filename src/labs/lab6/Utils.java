package labs.lab6;

import labs.lab6.contaners.AbstractContainer;
import labs.lab6.contaners.FigureArray;
import labs.lab6.primitives.Point;
import labs.lab6.primitives.*;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Utils {
    static private final ArrayList<AbstractContainer> containers;

    static {
        containers = new ArrayList<>();
        containers.add(new FigureArray("main"));
    }

    public static void load(String file){
        StringBuilder line = new StringBuilder();
        try(FileReader reader = new FileReader(file))
        {
            int c;
            while((c=reader.read())!=-1){
                if(c=='\n'){
                    parse_line(line.toString());
                    line = new StringBuilder();
                    continue;
                }
                line.append((char) c);

            }
            parse_line(line.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void parse_line(String line){
        try {
            String[] words = line.split(",");
            switch (words[0]) {
                case "t":
                    containers.get(0).add(new Triangle(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            new Point(Integer.parseInt(words[3]), Integer.parseInt(words[4])),
                            new Point(Integer.parseInt(words[5]), Integer.parseInt(words[6])),
                            Boolean.parseBoolean(words[10]),
                            new Color(Integer.parseInt(words[7]), Integer.parseInt(words[8]), Integer.parseInt(words[9]))
                    ));
                    break;
                case "l":
                    containers.get(0).add(new Line(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            new Point(Integer.parseInt(words[3]), Integer.parseInt(words[4])),
                            new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                    ));
                    break;
                case "c":
                    containers.get(0).add(new Circle(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]),
                            Boolean.parseBoolean(words[7]),
                            new Color(Integer.parseInt(words[4]), Integer.parseInt(words[5]), Integer.parseInt(words[6]))
                    ));
                    break;
                case "ri":
                    containers.get(0).add(new Ring(
                                    new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                                    Integer.parseInt(words[3]),
                                    Integer.parseInt(words[4]),
                                    new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                            )
                    );
                    break;
                case "o":
                    containers.get(0).add(new Oval(
                                    new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                                    Integer.parseInt(words[3]),
                                    Integer.parseInt(words[4]),
                                    Boolean.parseBoolean(words[8]),
                                    new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                            )
                    );
                    break;
                case "ro":
                    containers.get(0).add(new Romb(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]), Integer.parseInt(words[4]),
                            Boolean.parseBoolean(words[8]),
                            new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                    ));
                    break;
                case "tr":
                    containers.get(0).add(new Trapezoid(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]), Integer.parseInt(words[4]), Integer.parseInt(words[5]),
                            Boolean.parseBoolean(words[9]),
                            new Color(Integer.parseInt(words[6]), Integer.parseInt(words[7]), Integer.parseInt(words[8]))
                    ));
                    break;
                case "re":
                    containers.get(0).add(new Rect(
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
