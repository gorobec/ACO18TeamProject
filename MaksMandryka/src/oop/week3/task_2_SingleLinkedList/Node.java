package oop.week3.task_2_SingleLinkedList;

public final class Node<T> implements A<T> {

    private T value;
    private A<T> next;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

    public void setNext(A<T> next) {
        this.next = next;
    }

    public A<T> getNext() {
        return next;
    }

//    public A<T> getLast() {
//
//        A<T> a;
//        A<T> b = this;
//
//        while (true) {
//            a = this.getNext();
//            if (a == null) {
//                return b;
//            }
//            b = a;
//        }
//
//    }

    public void showValue() {
        System.out.print(value);
    }

    public void showList() {
        Node<T> iterator = this;
        while (iterator != null) {
            System.out.print(iterator.value + " -> ");
            iterator = (Node<T>) iterator.getNext();
        }
        System.out.print("Tail\n");
    }

}
