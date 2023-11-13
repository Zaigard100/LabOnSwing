package labs.lab5;

import labs.lab5.primitives.Point;
import labs.lab5.primitives.*;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    //TODO удалить лишние массивы
    static private final ArrayList<Triangle> triangles;
    static private final ArrayList<Line> lines;
    static private final ArrayList<Circle> circles;
    static private final ArrayList<Ring> ring;
    static private final ArrayList<Oval> ovals;
    static private final ArrayList<Romb> rombs;
    static private final ArrayList<Trapezoid> trapezoids;
    static private final ArrayList<Rect> rects;
    static private final ArrayList<Figure> figures;



    static {
        triangles = new ArrayList<>();
        lines = new ArrayList<>();
        circles = new ArrayList<>();
        ring = new ArrayList<>();
        ovals = new ArrayList<>();
        rombs = new ArrayList<>();
        trapezoids = new ArrayList<>();
        rects = new ArrayList<>();
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
        triangles.clear();
        lines.clear();
        circles.clear();
        ring.clear();
        ovals.clear();
        rombs.clear();
    }


    public static ArrayList<Figure> getFigures(){
        return figures;
    }
    public static ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public static ArrayList<Line> getLines() {
        return lines;
    }

    public static ArrayList<Circle> getCircles() {
        return circles;
    }

    public static ArrayList<Ring> getRing() {
        return ring;
    }

    public static ArrayList<Oval> getOvals() {
        return ovals;
    }
    public static ArrayList<Romb> getRombs(){
        return  rombs;
    }
    public static ArrayList<Trapezoid> getTrapezoids() {
        return trapezoids;
    }

    public static ArrayList<Rect> getRects() {
        return rects;
    }
}
