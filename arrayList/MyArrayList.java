package week1.homework.arrayList;

/**
 * Created by serhiim on 27-Jan-17.
 */
public class MyArrayList implements MyList{
    private int size;
    private static final int DEFAULT_SIZE = 10;
    private Object[] objectArr;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int length) {
        objectArr = new Object[length];
        this.size = 0;
    }

    public Object[] getObjectArr() {
        return objectArr;
    }

    public boolean isEmpty() {
        return size == 0;
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

    public boolean add(int index, Object obj) {
        if (index >= objectArr.length) {
            ensureCapacity(index);
        }
        objectArr[index] = obj;
        size++;
        return true;
    }


    public Object getObject(int index) {
        if (index < 0 || index > objectArr.length) return "Incorrect index";
        return objectArr[index];
    }

    public boolean remove(int index) {
        if (index < 0 && index < size) return false;
        objectArr[index] = null;
        System.arraycopy(objectArr, index + 1, objectArr, index, size - index - 1);
        size--;
        return true;
    }


    public boolean remove(Object object) {
        int index;
        for (int i = 0; i < objectArr.length; i++) {
            if (objectArr[i] != null && objectArr[i].equals(object)) {
                objectArr[i] = null;
                index = i;
                System.arraycopy(objectArr, index + 1, objectArr, index, size - index - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean set(int index, Object obj) {
        if (index < 0 && index > objectArr.length) return false;
        objectArr[index] = obj;
        return true;
    }

    public boolean clear() {
        for (int i = 0; i < objectArr.length; i++) {
            objectArr[i] = null;
        }
        size = 0;
        return true;
    }

    public boolean contains(Object object) {
        for (Object anObjectArr : objectArr) {
            if (anObjectArr != null && anObjectArr.equals(object))
                return true;
        }
        return false;
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < objectArr.length; i++) {
            if (objectArr[i] != null) {
                count++;
            }
        }
        return count;
    }

    private void ensureCapacity(int index) {
        Object[] temp = new Object[objectArr.length + index];
        System.arraycopy(objectArr, 0, temp, 0, objectArr.length);
        objectArr = temp;
    }

    public void throwException() {
        throw new ArrayIndexOutOfBoundsException();
    }


    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList(5);
        Object obj = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        System.out.println(arr.size());

        arr.add(obj);
//        System.out.println(arr.size());
//        System.out.println(arr.getObjectArr()[0]);
//        System.out.println(arr.getObjectArr()[1]);


        arr.add(obj2);
        System.out.println(arr.size());
//        System.out.println(arr.getObjectArr()[0]);
//        System.out.println(arr.getObjectArr()[1]);
        arr.add(5, obj3);
        System.out.println(arr.size());
//        System.out.println(arr.getObjectArr()[0]);
//        System.out.println(arr.getObjectArr()[1]);
//        System.out.println(arr.getObjectArr()[2]);
//        System.out.println(arr.getObjectArr()[4]);
//        System.out.println(arr.getObjectArr()[5]);
//        System.out.println();
//        System.out.println(arr.getObject(3));
        arr.add(2, obj3);
        System.out.println(arr.getObjectArr()[0]);
        System.out.println(arr.getObjectArr()[1]);
        System.out.println(arr.getObjectArr()[2]);
        System.out.println();
        arr.remove(1);
        System.out.println(arr.size());
        System.out.println(arr.getObjectArr()[0]);
        System.out.println(arr.getObjectArr()[1]);
        System.out.println(arr.getObjectArr()[2]);
        System.out.println();
        arr.remove(obj3);
        System.out.println(arr.getObjectArr()[0]);
        System.out.println(arr.getObjectArr()[1]);
        System.out.println(arr.getObjectArr()[2]);

    }
}
