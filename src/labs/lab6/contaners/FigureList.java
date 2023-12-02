package labs.lab6.contaners;

import labs.lab6.primitives.Figure;

import java.awt.*;
import java.util.ArrayList;

public class FigureList extends AbstractContainer{

    private final ArrayList<Figure> list;

    public FigureList(String name){
        super(name);
        list = new ArrayList<>();
    }

    @Override
    public void show(Graphics g) {
        for (Figure f: list){
            f.show(g);
        }
    }

    public void add(Figure f){
        if(f != null) {
            list.add(f);
        }
    }

    public Figure get(int i){
        return list.get(i);
    }

    public void remove(Figure f){
        list.remove(f);
    }

    @Override
    public int size() {
        return list.size();
    }


    @Override
    public Figure[] toArray() {
        Figure[] c = new Figure[list.size()];
        for(int i = 0; i< list.size(); i++){
            c[i] = list.get(i);
        }
        return c;
    }

    public void  dispose(){
        list.clear();
    }


}
