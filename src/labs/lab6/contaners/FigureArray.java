package labs.lab6.contaners;

import labs.lab6.primitives.Figure;

import java.awt.*;
import java.util.Arrays;

public class FigureArray extends AbstractContainer{

    Figure[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 4;

    public FigureArray(String name,int count) {
        super(name);
        array = new Figure[count];
    }

    public FigureArray(String name){
        this(name,DEFAULT_CAPACITY);
    }

    @Override
    public void show(Graphics g) {
        if (size()>0) {
            for (int i = 0;i<size();i++) {
                if(array[i] == null) return;
                array[i].show(g);
            }
        }
    }

    public int size() {
        return size;
    }

    @Override
    public void add(Figure f) {
        ensureCapacity();
        array[size++] = f;
    }

    @Override
    public Figure get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    @Override
    public void remove(Figure f) {
        remove(indexOf(f));
    }

    public void remove(int index) {
        if(index == -1){
            throw new NullPointerException("Object is not found");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null; // Очистка последнего элемента
    }

    public int indexOf(Figure element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1; // Элемент не найден
    }
    @Override
    public void dispose() {
        Arrays.fill(array, null);
        size = 0;
    }

    public Figure[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}




