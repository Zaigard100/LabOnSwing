package labs.lab6.contaners;

import labs.lab6.primitives.Figure;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class FigureArray extends AbstractContainer{

    Figure[] figures;
    int numIter = 0;

    final int sizeAdd = 2;
    int count = 0;

    public FigureArray(String name,int count) {
        super(name);
        figures = new Figure[count];
    }

    public FigureArray(String name){
        this(name,2);
    }

    @Override
    public void show(Graphics g) {
        if (count>0) {
            for (int i = 0;i<count;i++) {
                figures[i].show(g);
            }
        }
    }

    @Override
    public void add(Figure f) {
        if (count >= figures.length) {
            figures = Arrays.copyOf(figures,count+sizeAdd);
        }
        figures[count] = f;
        count++;
    }

    @Override
    public Figure get(int i) {
        return figures[i];
    }

    @Override
    public void remove(Figure f) { //TODO проблема при удалении объектов
        Figure[] buf = figures.clone();
        figures = new Figure[figures.length];
        count = 0;
        for (Figure figure : buf) {
            if (figure != f) {
                add(figure);
            }
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Figure iterator() {
        if(count ==0) return null;
        return figures[numIter];
    }

    @Override
    public boolean next() {
        if(numIter+1< count){
            numIter++;
            return true;
        }
        return false;
    }

    @Override
    public void iteratorStart() {
        numIter = 0;
    }

    @Override
    public void dispose() {
        figures = new Figure[sizeAdd];
        count = 0;
    }



}
