package week1.dynamicArray;

public class NewArrayList<E> {
    private int size;
    private int capasity;
    private E[] data;

    public NewArrayList() {
        capasity = 10;
    }

    public NewArrayList(int initialCapasity) {
        capasity = initialCapasity;
        data = (E[]) new Object[capasity];
    }

    public NewArrayList(int size, int capasity, E[] data) {
        this.size = size;
        this.capasity = capasity;
        this.data = data;
    }

//    public boolean contains(Object o) {
//        return indexOf(o) >= 0;
//    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        NewArrayList<E> localList = (NewArrayList<E>) o;
        if (size != localList.size) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if(!(localList.equals(data[i]))){
                return false;
            }
        }
        return true;
    }

    public E get(int index){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("Illegal argument " + index);
        }
        return data[index];
    }

    public int size(){
        return data.length;
    }

    public void clear(){
        capasity = 0;
        data = (E[]) new Object[capasity];
        size = 0;
    }

    public E set(int index, E element){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("Illegal argument " + index);
        }
        E old = data[index];
        data[index] = element;
        return old;
    }

//    public boolean add(E element){
//        if(element == null){
//            throw new NullPointerException();
//        }
//            data[size++] = element;
//        return true;
//    }

    public void add(int index, E element){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("Illegel argument " + index);
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[index] = element;
        size++;
    }
}
