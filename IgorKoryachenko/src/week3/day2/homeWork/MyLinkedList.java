package week3.day2.homeWork;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public boolean add(T object) {
        if(head == null){
            head = tail = new Node<>(object);
        } else {
            tail.next = new Node<>(object, tail);
            tail = tail.next;
        }
        size++;
        return true;
    }

    public boolean add(int index, T object) {
        if (index >= size || index < 0){
            System.out.println("Такого индекса нет");
            return false;
        }
        Node<T> forAdd = new Node<T>(object);
        Node<T> old = findNode(index);
        if (index != 0 && index < size() - 1){
            forAdd.next = old;
            forAdd.previous = old.previous;
            old.previous.next = forAdd;
            old.previous = forAdd;
            size++;
            return true;
        }
        if (index == 0){
            head.previous = forAdd;
            forAdd.next = head;
            head = forAdd;
        }else {
            tail.next = forAdd;
            forAdd.previous = tail;
            tail = forAdd;

            //add(object);
        }

        size++;
        return true;
    }

    public T get(int index) {
        return findNode(index).value;
    }

    public boolean remove(int index) {
        if (index >= size || index < 0) {
            System.out.println("Такого индекса нет");
            return false;
        }
        Node<T> forDelete = findNode(index);
        if(forDelete != head){
            forDelete.previous.next = forDelete.next;
        } else {
            head = forDelete.next;
        }
        if(forDelete != tail){
            forDelete.next.previous = forDelete.previous;
        } else{
            tail = forDelete.previous;
        }
        size--;
        return true;
    }

    public boolean remove(T object) {
        Node<T> forDelete = findNode(object);
        if(forDelete == null) return false;
        if(forDelete != head){
            forDelete.previous.next = forDelete.next;
        } else {
            head = forDelete.next;
        }
        if(forDelete != tail){
            forDelete.next.previous = forDelete.previous;
        } else{
            tail = forDelete.previous;
        }
        size--;
        return true;
    }

    private Node<T> findNode(T object) {
        Node<T> iterator = head;
        if(object == null){
            for (int i = 0; i < size; i++) {
                if (object == iterator.value) {

                    return iterator;
                }
                iterator = iterator.next;
            }

        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(iterator.value)) {

                    return iterator;
                }
                iterator = iterator.next;
            }
        }
        return null;
    }

    private Node<T> findNode(int j){
        Node<T> node = head;
        for (int i = 0; i < j; i++) {
            node = node.next;
        }

        return node;
    }

    public void trimToSize() {

    }

    public boolean set(int index, T object) {
        if (index >= size || index < 0) {
            System.out.println("Такого индекса нет");
            return false;
        }

        if (object != null){
            Node<T> node = findNode(index);
            node.value = object;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T object) {
        return findNode(object) != null;
    }

    public void clear() {

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;
            int position = 0;
            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public T next() {
                if (size == 0) return null;
                System.out.println(head.value.toString());
                T result = current.value;
                System.out.println("44444");
                current = current.next;
                position++;
                return result;


            }
        };
    }

   /* public  class Iter implements Iterator{
         Node<T> iterator;
         Node<T> current = (Node<T>) head;

        @Override
        public boolean hasNext() {
            return iterator.next == null;
        }

        @Override
        public T next() {
            if (size == 0) return null;
            T result = current.value;
            current = current.next;
            return result;
        }
    }*/
}
