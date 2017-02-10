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
        if (index >= size){
            System.out.println("Такого индекса нет");
            return false;
        }

        return false;
    }

    public T get(int index) {
        return null;
    }

    public T remove(int index) {
        return null;
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

    public Node<T> findNode(int i){
        Node<T> node = head;
        System.out.println(node.toString());

        return head;
    }

    public void trimToSize() {

    }

    public T set(int index, T object) {
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object object) {
        return false;
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
