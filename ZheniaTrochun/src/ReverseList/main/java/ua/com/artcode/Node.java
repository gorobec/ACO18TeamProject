package main.java.ua.com.artcode;

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

    public void showValue(){
        System.out.print(value);
    }

    public void showList(){
        Node<T> iterator = this;
        while (iterator != null){
            System.out.print(iterator.value + " -> ");
            iterator = (Node<T>)iterator.getNext();
        }
        System.out.print("Tail\n");
    }

}
