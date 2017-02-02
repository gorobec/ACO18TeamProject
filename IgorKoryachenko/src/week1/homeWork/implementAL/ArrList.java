package week1.homeWork.implementAL;

public class ArrList {
    int size = 4;
    int count = 0;
    Object[] arr = new Object[size];


    public boolean add(Object object) {
        if (size <= count) arr = newArrSize();
        arr[count] = object;
        count++;
        return true;
    }

    public boolean add(int i, Object object) {
        if (size <= count) arr = newArrSize();
        Object[] ar = new Object[arr.length];
        System.arraycopy(arr, 0, ar, 0, i);
        System.arraycopy(arr, i, ar, i + 1, ar.length - i - 1);
        ar[i] = object;
        arr = ar;
        count++;

        return true;
    }

    public Object get(int i) {
        return arr[i];
    }

    public boolean set(int i, Object object) {
        if (i >= count || i < 0)
            throw new IllegalArgumentException();
        // or return false
        arr[i] = object;
        return true;
    }

    private Object[] newArrSize() {
        Object[] ar = new Object[arr.length + 1];
        System.arraycopy(arr, 0, ar, 0, arr.length);

        return ar;
    }

    public int size() {
        return count;
    }

    public boolean remove(int i) {

        if (i > count || i < 0) return false;
        Object[] ar = new Object[arr.length - 1];
        System.arraycopy(arr, 0, ar, 0, i);
        System.arraycopy(arr, i + 1, ar, i, arr.length - i - 1);
        arr = ar;
        return true;
    }

    public boolean remove(Object object) {
        for (int i = 0; i < arr.length  /* Возможно сюда можно поставить метод size()*/; i++) {

            if (arr[i] == null) {
                System.out.println("Пойман null в ячейке" + i);
                return false;
            }
            if (arr[i].equals(object)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean contains(Object object) {
        for (int i = 0; i < arr.length  /* Возможно сюда можно поставить метод size()*/; i++) {
            if (arr[i] == null) {
                System.out.println("Пойман null в ячейке" + i);
                return false;
            }

            if (arr[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    public boolean clear() {
        arr = new ArrList[size];
        //Возможно, надо было сделать через удаление каждого элемента
        //Пока специально не заглядываю в реализацию ArrayList
        return true;
    }

    public Object[] toArray(ArrList list) {
        Object[] array = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    //метод сделан для проверок и отладки
    public void printString() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
