package lab4;

import java.util.Iterator;

public interface Iterable<E> {

    boolean hasNext();
    E next();
    void remove();
    Iterator<E> iterator();
}
