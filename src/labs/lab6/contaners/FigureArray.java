package labs.lab6.contaners;

import labs.lab6.primitives.Figure;

import java.util.Objects;

public class FigureArray extends AbstractContainer{

    Figure[] figures;
    Figure iter;
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
    public void add(Figure f) {
        System.out.println(f);//TODO проверка на входящий элемент
        if(f != null){
            if (figures.length <= count) {
                Figure[] buf = figures.clone();
                figures = new Figure[count + sizeAdd];
                System.arraycopy(buf, 0, figures, 0, buf.length);
            }
            figures[count] = f;
            count++;
        }
    }

    @Override
    public Figure get(int i) {
        return figures[i];
    }

    @Override
    public void remove(Figure f) {
        Figure[] buf = figures.clone();
        figures = new Figure[figures.length];
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
        return iter;
    }

    @Override
    public boolean next() {
        if(numIter+1< figures.length){
            numIter++;
            return true;
        }
        return false;
    }

    @Override
    public void iteratorStart() {
        numIter =0;
    }

    @Override
    public void dispose() {

    }



}
