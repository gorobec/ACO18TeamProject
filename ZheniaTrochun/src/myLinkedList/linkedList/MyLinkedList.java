package linkedList;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by zhenia on 15.02.17.
 */
public class MyLinkedList <T> implements List<T> {

    private class Node <T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    public MyLinkedList(T[] arr){
        size = 0;
        head = null;
        tail = null;

        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
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
    public boolean contains(Object o) {
        return !(indexOf(o) == -1);
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedListIterator<T>(head);
    }

    @Override
    public Object[] toArray() {
        T arr[] = (T[])(new Object[size]);

        return arr;
    }

    @Override
    public boolean add(T o) {
        Node<T> tmp = new Node<>(o, null, null);

        if(size == 0){
            head = tmp;
            tail = tmp;

            size++;

            return true;
        }

        tail.next = tmp;
        tmp.prev = tail;
        tail = tmp;

        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Iterator<T> i = new MyLinkedListIterator<>(head);

        while (i.hasNext()){
            if(i.next().equals(o)){
                i.remove();

                size--;

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T item : collection){
            add(item);
        }

        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {

        int j = 0;
        for (T item : collection){
            if(i == j) break;

            add(item);
            j++;
        }

        return true;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public T get(int i) {
        if(i < 0 || i >= size) return null;

        Node<T> tmp = head;

        for(int j = 0; j < i; j++){
            tmp = tmp.next;
        }

        return tmp.data;
    }

    @Override
    public T set(int i, T o) {
        if(i > size) return null;

        if(i == size){
            add(o);
            size++;

            return get(size - 1);
        }

        Node<T> tmp = new Node<>(null, head, null);

        for (int j = 0; j <= i; j++) {
            tmp = tmp.next;
        }

        tmp.data = o;

        return get(i);
    }

    @Override
    public void add(int i, T o) {
        if(i < 0 || i > size) return;

        if(i == size){
            add(o);

            return;
        }

        if(i == 0){
            Node<T> tmp = new Node<>(o, head, null);
            head.prev = tmp;
            head = tmp;
            size++;

            return;
        }

        Node<T> tmp = head;

        for (int j = 1; j < i; j++) {
            tmp = tmp.next;
        }

        Node<T> curr = new Node<>(o, tmp.next, tmp);
        tmp.next.prev = curr;
        tmp.next = curr;

        size++;
    }

    @Override
    public T remove(int i) {
        if(i < 0 || i > size) return null;

        if(i == 0){
            Node<T> tmp = head;
            head = tmp.next;

            tmp.next = null;
            head.prev = null;

            size--;
            return tmp.data;
        }

        if(i == size - 1){
            Node<T> tmp = tail;
            tail = tmp.prev;

            tmp.prev = null;
            tail.next = null;

            size--;
            return tmp.data;
        }

        Node<T> curr = new Node<>(null, head, null);

        for (int j = 0; j <= i; j++) {
            curr = curr.next;
        }

        if(curr == null) throw new NullPointerException("Unexpected Null");

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        curr.next = null;
        curr.prev = null;

        return curr.data;
    }

    @Override
    public int indexOf(Object o) {
        if(o == null) return -1;

        Node<T> tmp = head;

        for(int i = 0; i < size; i++){
            if(tmp.data.equals(o)) return i;

            tmp = tmp.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(o == null) return -1;

        Node<T> tmp = tail;

        for(int i = size - 1; i >= 0; i--){
            if(tmp.equals(o)) return i;

            tmp = tmp.prev;
        }

        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
        if(i < 0 || i1 >= size || i > i1) return null;

        MyLinkedList<T> sublist = new MyLinkedList<T>();

        Iterator<T> iter = iterator();

        for(int j = 0; j < i; j++){
            iter.next();
        }

        for(int j = i; j < i1; j++){
            if(!iter.hasNext()) return null;

            sublist.add(iter.next());
        }

        return sublist;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        for (Object o : collection) {
            int i = indexOf(o);

            if(i != -1){
                remove(i);
            }
        }

        return true;
    }

    @Override
    public boolean containsAll(Collection collection) {
        for (Object o : collection) {
            if(!contains(o)){
                return false;
            }
        }

        return true;
    }

    @Override
    public T[] toArray(Object[] objects) {
        return (T[])(new Object[0]);
    }

    private class MyLinkedListIterator<T> implements Iterator<T>{

        private Node<T> curr;

        public MyLinkedListIterator(Node<T> head){
            curr = new Node<>(null, head, null);
        }

        @Override
        public boolean hasNext() {
            if (curr == null) return false;

            return !(curr.next == null);
        }

        @Override
        public T next() {
            curr = curr.next;

            return curr.data;
        }

        @Override
        public void remove(){
            if(curr == null) throw new NullPointerException("Unexpected Null");

            if(curr.prev == null){
                Node<T> tmp = curr;
                curr = tmp.next;

                tmp.next = null;
                curr.prev = null;

                return;
            }

            if(curr.next == null){
                Node<T> tmp = curr;
                curr = tmp.prev;

                tmp.prev = null;
                curr.next = null;

                return;
            }


            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            curr.next = null;
            curr.prev = null;
        }
    }
}
