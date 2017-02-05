package data_structures;

/**
 * Created by gorobec on 04.02.17.
 */
public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public boolean add(T object) {
        if(head == null){
            head = tail = new Node<>(object);
        } else {
            tail.next = new Node<>(object, tail);
//            tail.next.previous = tail; instead use constructor
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T object) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
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

    @Override
    public void trimToSize() {

    }

    @Override
    public T set(int index, T object) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public void clear() {

    }
}
