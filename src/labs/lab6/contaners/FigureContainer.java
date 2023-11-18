package labs.lab6.contaners;

import labs.lab6.primitives.Figure;

import java.util.ArrayList;

public class FigureContainer extends AbstractContainer{

    private final ArrayList<Figure> figures;
    Figure iter;

    public FigureContainer(String name){
        super(name);
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

    @Override
    public int size() {
        return figures.size();
    }

    @Override
    public Figure iterator() {
        return iter;
    }

    @Override
    public boolean next() {
        int n = figures.indexOf(iter)+1;
        if(n<figures.size()){
            iter = figures.get(n);
            return true;
        }
        return false;
    }

    @Override
    public void iteratorStart() {
        if(size()!=0) {
            iter = figures.get(0);
        }
    }

    public void  dispose(){
        figures.clear();
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }


}
