package labs.lab3;

import labs.lab3.primitives.Point;
import labs.lab3.primitives.*;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    static private ArrayList<Triangle> triangles;
    static private ArrayList<Line> lines;
    static private ArrayList<Circle> circles;
    static private ArrayList<Ring> ring;
    static private ArrayList<Oval> ovals;
    static private ArrayList<Romb> rombs;
    static private ArrayList<Trapezoids> trapezoids;
    static private  ArrayList<Rect> rects;


    public Utils(){
        triangles = new ArrayList<>();
        lines = new ArrayList<>();
        circles = new ArrayList<>();
        ring = new ArrayList<>();
        ovals = new ArrayList<>();
        rombs = new ArrayList<>();
        trapezoids = new ArrayList<>();
        rects = new ArrayList<>();
    }

    public  void load(String file){
        String line = "";
        try(FileReader reader = new FileReader(file))
        {

            int c;
            while((c=reader.read())!=-1){

                if(c=='\n'){
                    parse_line(line);
                    line = "";
                    continue;
                }
                line += (char)c;

            }
            parse_line(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void parse_line(String line){
        String[] words = line.split(",");
        if(words[0].equals("t")){
            triangles.add(new Triangle(
                    new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                    new Point(Integer.parseInt(words[3]), Integer.parseInt(words[4])),
                    new Point(Integer.parseInt(words[5]), Integer.parseInt(words[6])),
                    Boolean.parseBoolean(words[10]),
                    new Color(Integer.parseInt(words[7]),Integer.parseInt(words[8]),Integer.parseInt(words[9]))
            ));
        }else if(words[0].equals("l")){
            lines.add(new Line(
                    new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                    new Point(Integer.parseInt(words[3]), Integer.parseInt(words[4])),
                    new Color(Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]))
            ));
        }else if(words[0].equals("c")){
            circles.add(new Circle(
                    new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                    Integer.parseInt(words[3]),
                    Boolean.parseBoolean(words[7]),
                    new Color(Integer.parseInt(words[4]),Integer.parseInt(words[5]),Integer.parseInt(words[6]))
            ));
        }else if(words[0].equals("ri")){
            ring.add(new Ring(
                        new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                        Integer.parseInt(words[3]),
                        Integer.parseInt(words[4]),
                        new Color(Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]))
                    )
            );
        }else if(words[0].equals("o")){
            ovals.add(new Oval(
                            new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                            Integer.parseInt(words[3]),
                            Integer.parseInt(words[4]),
                            Boolean.parseBoolean(words[8]),
                            new Color(Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]))
                    )
            );
        } else if (words[0].equals("ro")) {
            rombs.add(new Romb(
                    new Point(Integer.parseInt(words[1]),Integer.parseInt(words[2])),
                    Integer.parseInt(words[3]),Integer.parseInt(words[4]),
                    Boolean.parseBoolean(words[8]),
                    new Color(Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]))
            ));
        } else if (words[0].equals("tr")) {
            trapezoids.add(new Trapezoids(
                    new Point(Integer.parseInt(words[1]),Integer.parseInt(words[2])),
                    Integer.parseInt(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5]),
                    Boolean.parseBoolean(words[9]),
                    new Color(Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]))
            ));
        } else if (words[0].equals("re")) {
            rects.add(new Rect(
                    new Point(Integer.parseInt(words[1]),Integer.parseInt(words[2])),
                    Integer.parseInt(words[3]),Integer.parseInt(words[4]),
                    Boolean.parseBoolean(words[8]),
                    new Color(Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]))
            ));
        }
    }

    public void dispose(){
        triangles.clear();
        lines.clear();
        circles.clear();
        ring.clear();
        ovals.clear();
        rombs.clear();
    }


    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    public ArrayList<Ring> getRing() {
        return ring;
    }

    public ArrayList<Oval> getOvals() {
        return ovals;
    }
    public ArrayList<Romb> getRombs(){
        return  rombs;
    }
    public ArrayList<Trapezoids> getTrapezoids() {
        return trapezoids;
    }

    public ArrayList<Rect> getRects() {
        return rects;
    }
}
