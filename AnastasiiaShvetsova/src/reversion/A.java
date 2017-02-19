package reversion;

public interface A<T> {
    void setNext(A<T> next);
    A<T> getNext();
}
