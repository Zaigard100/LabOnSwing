package labs.lab2;

import labs.lab2.primitives.*;
import labs.lab2.primitives.Point;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    static private ArrayList<Triangle> triangles;
    static private ArrayList<Line> lines;
    static private ArrayList<Circle> circles;
    static private ArrayList<Ring> ring;


    public Utils(){
        triangles = new ArrayList<>();
        lines = new ArrayList<>();
        circles = new ArrayList<>();
        ring = new ArrayList<>();
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
        }else if(words[0].equals("r")){
            ring.add(new Ring(
                        new Point(Integer.parseInt(words[1]), Integer.parseInt(words[2])),
                        Integer.parseInt(words[3]),
                        Integer.parseInt(words[4]),
                        new Color(Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]))
                    )
            );
        }
    }

    public void dispose(){
        triangles.clear();
        lines.clear();
        circles.clear();
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
}
