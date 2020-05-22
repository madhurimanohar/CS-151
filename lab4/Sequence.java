package lab4;

import java.util.*;
import java.util.Iterator;

public class Sequence<E> implements Iterable<E> {   

    private int current;    
    private E[] items;    

    public Sequence(E[] items) {              
        this.items = items;    
        this.current = items.length;  
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E next() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            private int key = 0;

            @Override
            public boolean hasNext() {
                return key < current;   
            }

            @Override
            public E next() {
                return items[key++];
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5};

        Sequence<Integer> sequenceInteger = new Sequence<Integer>(ints);

        Iterator<Integer> i = sequenceInteger.iterator();

        System.out.println("Elements in list :");

        while(i.hasNext()) {
            Integer elements = i.next();

            if(i.hasNext()) {
                System.out.print(elements + ", ");
            }
            else {
                System.out.println(elements);
            }
        }
    }
}