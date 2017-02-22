package library.utils;

public class LinkedListMy<T> implements ListMy<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public boolean add(T o) {
        if (head == null) {
            head = new Node<T>(o);
            tail = head;
        } else {
            //linkedList: 1,5,3 ; "o" - 9; head looks for 1, tail looks for 3
            tail.next = new Node<T>(o);// not lose tail ref
            tail.next.previous = tail; //tail.next looks for "o"
            tail = tail.next;// "o" became tail
            tail.next = null;// last element looks on NULL
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T o) {
        boolean canAdd = false;
        //linkedList: 1,5,3 ; index = 2 "o" - 9; head looks for 1, tail looks for 3
        Node<T> iterator = head;
        if (index >= 0 && index <= size) {
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    iterator.next = iterator.previous.next;// not lose ref for 3, 9 looks for 3
                    iterator.previous = iterator.next.previous;// not lose ref for 5, 9 looks for 5
                    iterator.next.previous = iterator;// 3 looks for 9;
                    iterator.previous.next = iterator;// 5 looks for 9;
                    iterator.value = o;
                    size++;
                    canAdd = true;
                    break;
                }
                iterator = iterator.next;
            }
        }
        return canAdd;
    }

    @Override
    public T get(int index) {
        Node<T> iterator = head;
        T object = null;
        if (index >= 0 && index <= size) {
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    object = iterator.value;
                    break;
                }
                iterator = iterator.next;
            }
        }
        return object;
    }

    @Override
    public boolean remove(int index) {
        boolean wasRemoved = false;
        if (index == 0) {
            head.next.previous = null;
            head = head.next;
        } else if (index == size) {
            tail.previous = null;
            tail = tail.previous;
        } else {
            Node<T> iterator = head;
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    iterator.previous.next = iterator.next;
                    iterator.next.previous = iterator.previous;
                    wasRemoved = true;
                    break;
                }
                iterator = iterator.next;
            }
        }
        return wasRemoved;
    }

    @Override
    public boolean remove(T obj) {
        boolean wasRemoved = false;
        Node<T> iterator = head;
        if (obj != null) {
            for (int i = 0; i < size; i++) {
                if (obj.equals(iterator.value)) {
                    iterator.previous.next = iterator.next;
                    iterator.next.previous = iterator.previous;
                    wasRemoved = true;
                    break;
                }
                iterator = iterator.next;
            }
        }
        return wasRemoved;
    }

    @Override
    public boolean set(int index, T obj) {
        boolean canSet = false;
        Node<T> iterator = head;
        if (index >= 0 && index < size && size != 0) {
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    iterator.value = obj;
                    canSet = true;
                    break;
                }
                iterator = iterator.next;
            }
        }
        return canSet;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(T obj) {
        boolean contains = false;
        Node<T> iterator = head;
        if (obj != null) {
            for (int i = 0; i < size; i++) {
                if (iterator.value.equals(obj)) {
                    contains = true;
                    break;
                }
                iterator = iterator.next;
            }
        }
        return contains;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T object) {
            value = object;
        }

        public Node(T object, Node<T> next, Node<T> previous) {
            value = object;
            this.next = next;
            this.previous = previous;
        }
    }
}
