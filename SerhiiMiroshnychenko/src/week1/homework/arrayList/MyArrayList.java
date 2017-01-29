package week1.homework.arrayList;

/**
 * Created by serhiim on 27-Jan-17.
 */
public class MyArrayList {
    public int size;
    public static final int DEFAULT_SIZE = 10;
    private Object[] objectArr;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int length) {
        objectArr = new Object[length];
        this.size = 0;
    }


    public boolean add(Object obj) {

        if (size >= objectArr.length) {
            ensureCapacity(5);
        }
        if (size == 0) {
            objectArr[size] = obj;
            size++;
        } else {
            objectArr[size] = obj;
            size++;
        }
        return true;
    }

    public void add(int index, Object obj) {
        if (index >= objectArr.length) {
            ensureCapacity(index);
        }
        objectArr[index] = obj;
        size++;
    }

    private void ensureCapacity(int index) {
        Object[] temp = new Object[objectArr.length + index];
        System.arraycopy(objectArr, 0, temp, 0, objectArr.length);
        objectArr = temp;
    }


    public Object getObject(int index) {
        if (index < 0 || index > objectArr.length) return "Incorrect index";
        return objectArr[index];
    }

    public boolean remove(int index) {
        objectArr[index] = null;
        size--;
        return true;
    }



    public boolean remove(Object object) {
        for (int i = 0; i < objectArr.length; i++) {
            if (objectArr[i] != null && objectArr[i].equals(object)) {
                objectArr[i] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, Object obj) {

    }

    public boolean clear() {
        for (int i = 0; i < objectArr.length; i++) {
            objectArr[i] = 0;
        }
        size = 0;
        return true;
    }

    public int size() {
        return size;
    }

    public Object[] getObjectArr() {
        return objectArr;
    }

    public boolean contains(Object object) {
        for (int i = 0; i < objectArr.length; i++) {
            if (objectArr[i] != null && objectArr[i].equals(object))
                return true;
        }
        return false;
    }

    public void throwException(){
        throw new ArrayIndexOutOfBoundsException();
    }


    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList(5);
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        System.out.println(arr.size());

        arr.add(obj);
        System.out.println(arr.size());
        System.out.println(arr.getObjectArr()[0]);
        System.out.println(arr.getObjectArr()[1]);


        arr.add(obj2);
        System.out.println(arr.size());
        System.out.println(arr.getObjectArr()[0]);
        System.out.println(arr.getObjectArr()[1]);
        arr.add(5, obj3);
        System.out.println(arr.size());
        System.out.println(arr.getObjectArr()[0]);
        System.out.println(arr.getObjectArr()[1]);
        System.out.println(arr.getObjectArr()[2]);
        System.out.println(arr.getObjectArr()[4]);
        System.out.println(arr.getObjectArr()[5]);
        System.out.println();
        System.out.println(arr.getObject(3));


    }
}
