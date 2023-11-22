package labs.lab6.contaners;

import labs.lab6.primitives.Figure;

import java.awt.*;
import java.util.Arrays;

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
                if(figures[i] != null);
                figures[i].show(g);
            }
        }
    }

    @Override
    public void add(Figure f) {
        for(int i = 0;i < figures.length;i++){
            if(figures[i] == null){
                figures[i] = f;
                count++;
                return;
            }
        }
            figures = Arrays.copyOf(figures, figures.length + sizeAdd);
            figures[figures.length-sizeAdd] = f;
            count++;

    }

    @Override
    public Figure get(int i) {
        return figures[i];
    }

    @Override
    public void remove(Figure f) { //TODO проблема при удалении объектов
        for(int i = 0;i < figures.length;i++){
            if(figures[i] == f){
                figures[i] = null;
            }
        }
        count--;
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
        while(figures[numIter]==null){
            if(numIter+1< figures.length) return false;
            numIter++;
        }
        return true;
    }

    @Override
    public boolean iteratorStart() {
        if(size()== 0) return false;
        numIter = 0;
        return true;
    }

    @Override
    public void dispose() {
        figures = new Figure[sizeAdd];
        count = 0;
    }



}
