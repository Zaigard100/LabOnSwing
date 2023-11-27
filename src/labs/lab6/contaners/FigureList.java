package labs.lab6.contaners;

import labs.lab6.primitives.Figure;

import java.awt.*;
import java.util.ArrayList;

public class FigureList extends AbstractContainer{

    private final ArrayList<Figure> figures;

    public FigureList(String name){
        super(name);
        figures = new ArrayList<>();
    }

    @Override
    public void show(Graphics g) {
        for (Figure f:figures){
            f.show(g);
        }
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

    @Override
    public int size() {
        return figures.size();
    }


    @Override
    public Figure[] toArray() {
        Figure[] c = new Figure[figures.size()];
        for(int i = 0; i< figures.size();i++){
            c[i] = figures.get(i);
        }
        return c;
    }

    public void  dispose(){
        figures.clear();
    }


}
