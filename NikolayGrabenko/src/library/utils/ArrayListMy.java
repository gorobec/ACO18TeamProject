package library.utils;

/**
 * add(Object)
 * add(index, Object)
 * get(index)
 * remove(index)
 * remove(index, Object)
 * set(index, Object)
 * clear()
 * contains(Object)
 * size()
 */
public class ArrayListMy<T> implements ListMy {

    private int capacity = 10;
    private int size = 0;
    private Object[] arrayListBody;

    public ArrayListMy() {
        arrayListBody = new Object[capacity];
    }

    public ArrayListMy(int capacity) {
        if (capacity == 0) {
            arrayListBody = new Object[0];
        } else if (capacity > 0) {
            arrayListBody = new Object[capacity];
        } else {
            System.out.println("You've entered wrong capacity (it should be >= 0)");
        }
    }

    private int getCapacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Object o;
        if (index >= 0 && index <= size)
            o = arrayListBody[index];
        else
            o = null;
        return o;
    }

    private void increaseCapacity() {

        capacity = capacity * 3 / 2 + 1;
        Object[] temp = new Object[capacity];
        System.arraycopy(arrayListBody, 0, temp, 0, size);
        arrayListBody = temp;

    }

    public boolean add(Object o) {
        if (size < arrayListBody.length) {
            for (int i = 0; i < arrayListBody.length; i++) {
                if (arrayListBody[i] == null) {
                    arrayListBody[i] = o;
                    size++;
                    break;
                }
            }
        } else {
            increaseCapacity();
            add(o);
        }
        return true;

    }

    public boolean add(int index, Object o) {
        if (index < arrayListBody.length - 1) {
            System.arraycopy(arrayListBody, index, arrayListBody, index + 1, arrayListBody.length - 1 - index);
            arrayListBody[index] = o;
            size++;
        } else {
            increaseCapacity();
            add(index, o);
        }
        return true;
    }

    public boolean remove(int index) {
        boolean isRemoved = false;
        if (index <= size) {
            System.arraycopy(arrayListBody, index + 1, arrayListBody, index, size - index);
            arrayListBody[size] = null;
            size--;
            isRemoved = true;
        } else
            System.out.println("You've entered wrong index");
        return isRemoved;
    }

    public boolean remove(Object obj) {
        boolean isRemoved = false;
        for (int i = 0; i < arrayListBody.length; i++) {
            if (obj.equals(arrayListBody[i])) {
                System.arraycopy(arrayListBody, i + 1, arrayListBody, i, size - i);
                arrayListBody[size] = null;
                size--;
                isRemoved = true;
            } else
                continue;
        }
        return isRemoved;
    }

    public boolean set(int index, Object obj) {
        boolean isSet = false;
        if (index >= 0 && index <= size) {
            for (int i = 0; i < arrayListBody.length; i++) {
                if (i == index) {
                    arrayListBody[i] = obj;
                    isSet = true;
                }
            }
        }
        return isSet;
    }

    public void clear() {

        for (int i = 0; i < arrayListBody.length; i++) {
            arrayListBody[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object obj) {
        boolean flag = false;
        for (int i = 0; i < arrayListBody.length; i++) {
            if (obj.equals(arrayListBody[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
