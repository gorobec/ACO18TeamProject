package ua.com.artcode;

public interface A<T> {
    void setNext(A<T> next);
    A<T> getNext();
}
