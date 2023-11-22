package labs.lab6.contaners;

import labs.lab6.primitives.Figure;

import java.awt.*;

public abstract class AbstractContainer {
    String name;
    boolean visible = true;

    public AbstractContainer(String name){
        this.name = name;
    }

    public abstract void show(Graphics g);

    public abstract void  add(Figure f);

    public abstract Figure get(int i);

    public abstract void remove(Figure f);

    public abstract int size();

    public abstract Figure iterator();
    public abstract boolean next();
    public abstract boolean iteratorStart();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public abstract void dispose();

}
