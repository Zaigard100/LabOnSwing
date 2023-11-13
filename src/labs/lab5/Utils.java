package labs.lab5;

import labs.lab5.primitives.Point;
import labs.lab5.primitives.*;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    static private ArrayList<Figure> figures; //TODO создать свой контейнер

    static {
        figures = new ArrayList<>();
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
                    figures.add(new Triangle(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            new Point(Integer.parseInt(words[3]), Integer.parseInt(words[4])),
                            new Point(Integer.parseInt(words[5]), Integer.parseInt(words[6])),
                            Boolean.parseBoolean(words[10]),
                            new Color(Integer.parseInt(words[7]), Integer.parseInt(words[8]), Integer.parseInt(words[9]))
                    ));
                    break;
                case "l":
                    figures.add(new Line(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            new Point(Integer.parseInt(words[3]), Integer.parseInt(words[4])),
                            new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                    ));
                    break;
                case "c":
                    figures.add(new Circle(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]),
                            Boolean.parseBoolean(words[7]),
                            new Color(Integer.parseInt(words[4]), Integer.parseInt(words[5]), Integer.parseInt(words[6]))
                    ));
                    break;
                case "ri":
                    figures.add(new Ring(
                                    new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                                    Integer.parseInt(words[3]),
                                    Integer.parseInt(words[4]),
                                    new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                            )
                    );
                    break;
                case "o":
                    figures.add(new Oval(
                                    new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                                    Integer.parseInt(words[3]),
                                    Integer.parseInt(words[4]),
                                    Boolean.parseBoolean(words[8]),
                                    new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                            )
                    );
                    break;
                case "ro":
                    figures.add(new Romb(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]), Integer.parseInt(words[4]),
                            Boolean.parseBoolean(words[8]),
                            new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                    ));
                    break;
                case "tr":
                    figures.add(new Trapezoid(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]), Integer.parseInt(words[4]), Integer.parseInt(words[5]),
                            Boolean.parseBoolean(words[9]),
                            new Color(Integer.parseInt(words[6]), Integer.parseInt(words[7]), Integer.parseInt(words[8]))
                    ));
                    break;
                case "re":
                    figures.add(new Rect(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]), Integer.parseInt(words[4]),
                            Boolean.parseBoolean(words[8]),
                            new Color(Integer.parseInt(words[5]), Integer.parseInt(words[6]), Integer.parseInt(words[7]))
                    ));
                    break;
            }
            words = new String[0];
        }catch(NumberFormatException err) {
            System.out.println(line);
            err.printStackTrace();
        }
    }

    public static void dispose(){
        figures.clear();
    }


    public static ArrayList<Figure> getFigures(){
        return figures;
    }
}
