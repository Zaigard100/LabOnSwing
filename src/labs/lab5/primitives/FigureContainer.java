package labs.lab5.primitives;

import java.util.ArrayList;

public class FigureContainer {

    String name;

    boolean visible = true;

    private final ArrayList<Figure> figures;

    public FigureContainer(String name){
        this.name = name;
        figures = new ArrayList<>();
    }

    public void add(Figure f){
        if(f != null) {
            figures.add(f);
        }
    }

    public Figure get(int i){
        return figures.get(i);
    }

    public void remove(Figure f){
        figures.remove(f);
    }

    public void  dispose(){
        figures.clear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
