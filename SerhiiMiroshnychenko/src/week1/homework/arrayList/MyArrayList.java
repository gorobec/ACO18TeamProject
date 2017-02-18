package week1.homework.arrayList;

/**
 * Created by serhiim on 27-Jan-17.
 */
public class MyArrayList<T> implements MyList {
    private int size;
    private static final int DEFAULT_SIZE = 10;
    private Object[] objectArr = new Object[DEFAULT_SIZE];


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

    @Override
    public boolean add(Object obj) {
        if (size >= objectArr.length) {
            ensureCapacity(5);
        }
        objectArr[size] = obj;
        size++;

        return true;
    }

    public boolean add(int index, Object obj) {
        if (index >= objectArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        objectArr[index] = obj;
        size++;
        return true;
    }


    public Object getObject(int index) {
        if (index < 0 || index > objectArr.length) return "Incorrect index";
        return objectArr[index];
    }

    public Object remove(int index) {
        if (index < 0 && index < size) throw new ArrayIndexOutOfBoundsException();
        Object temp = objectArr[index];
        objectArr[index] = null;
        System.arraycopy(objectArr, index + 1, objectArr, index, size - index);
        size--;
        return temp;
    }


    public boolean remove(Object object) {
        int index;
        for (int i = 0; i < objectArr.length; i++) {
            if (objectArr[i].equals(object)) {
                objectArr[i] = null;
                index = i;
                System.arraycopy(objectArr, index + 1, objectArr, index, size - index);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean set(int index, Object obj) {
        if (index < 0 && index > objectArr.length) throw new ArrayIndexOutOfBoundsException();
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
        if (object == null) {
            for (Object anObjectArr : objectArr) {
                if (anObjectArr == null) {
                    return true;
                }
            }
        }
        for (Object anObjectArr : objectArr) {
            if (anObjectArr != null && anObjectArr.equals(object)) {
                return true;
            }
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
}
