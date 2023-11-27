package labs.lab6.contaners;

import labs.lab6.primitives.Figure;

import java.awt.*;

public abstract class AbstractContainer {
    String name;
    boolean show = true;

    public AbstractContainer(String name){
        this.name = name;
    }

    public abstract void show(Graphics g);

    public abstract void  add(Figure f);

    public abstract Figure get(int i);

    public abstract void remove(Figure f);

    public abstract int size();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShow() {
        return show;
    }
    public abstract Figure[] toArray();

    public void setShow(boolean show) {
        this.show = show;
    }

    public abstract void dispose();

}
