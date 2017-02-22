package linkedList;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;


    public MyLinkedList() {
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("" + index);
        }
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean add(E e) {
        if (head == null) {
            head = tail = new Node<E>(e);
        } else {
            tail.next = new Node<E>(e);
            tail = tail.next;
        }
        size++;
        return true;
    }

    private Node<E> nodeFinder(E o) {
        Node<E> iterator = head;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (iterator.currentElement == null) {
                    return iterator;
                }
                iterator = iterator.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(iterator.currentElement)) {
                    return iterator;
                }
                iterator = iterator.next;
            }
        }
        return null;
    }

    @Override
    public boolean remove(E o) {
        Node<E> current = nodeFinder(o);
        if (current == null) {
            return false;
        }
        if (current == head) {
            head = current.next;
        } else {
            current.previous = current.next;
        }
        if (current == tail) {
            tail = current.previous;
        } else {
            current.previous = current.next;
        }
        current.currentElement = null;
        size--;
        return true;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> node = search(index);
        return node.currentElement;
    }


    private Node<E> search(int index) {
        Node<E> iterator = head;
        for (int i = 0; i < index; i++) {
            iterator = iterator.next;
        }
        return iterator;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Node<E> n = search(index);
        E value = n.currentElement;
        n.currentElement = element;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(int index, E element) {
        checkIndex(index);
        Node<E> current = search(index);
        if (index == size) {
            add(element);
        } else {
            if (index == 0) {
                head.previous = new Node<E>(element);
                head = head.previous;
            } else {
                current.previous = new Node<E>(element);
                current.next = current.previous;
            }
            size++;
        }
        return true;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> node = search(index);
        if (node == head) {
            head = node.next;
        } else {
            node.previous = node.next;
        }
        if (node == tail) {
            tail = node.previous;
        } else {
            node.previous = node.next;
        }
        node.next = null;
        node.previous = null;
        size--;
        return node.currentElement;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<E> curr = head;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (curr.currentElement == null) {
                    return index;
                }
                curr = curr.next;
                index++;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(curr.currentElement)) {
                    return index;
                }
                curr = curr.next;
                index++;
            }
        }
        return -1;
    }

    private static class Node<E> {
        Node<E> next;
        Node<E> previous;
        E currentElement;

        Node() {
        }

        Node(E element) {
            currentElement = element;
        }

        Node(Node<E> previous, E current, Node<E> next) {
            this.previous = previous;
            currentElement = current;
            this.next = next;
        }
    }
}
