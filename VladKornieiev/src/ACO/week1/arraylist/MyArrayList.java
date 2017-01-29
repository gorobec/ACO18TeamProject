package ACO.week1.arraylist;

/**
 * Created by v21k on 25.01.17.
 */
public class MyArrayList {
    // for default constructor
    private static final int DEFAULT_SIZE = 5;
    private static final Object[] DEFAULT = new Object[DEFAULT_SIZE];

    private Object[] objects;
    private int size = 0;
    private int count = 0;

    public MyArrayList() {
        this.objects = DEFAULT;
        size = DEFAULT_SIZE;
    }

    public MyArrayList(Object[] objects) {
        this.objects = objects;
        size = objects.length;
    }

    public MyArrayList(int size) {
        if (size > 0) {
            objects = new Object[size];
            this.size = size;
        } else if (size == 0) {
            this.objects = DEFAULT;
            size = DEFAULT_SIZE;
        } else {
            System.out.println("Wrong input, index must be positive number.");
            throw new IllegalArgumentException();
        }
    }

    public boolean add(Object o){
        if(count == size){
            ensureCapacity(5);
            objects[count++] = o;
        } else {
            objects[count++] = o;
        }
        return true;
    }

    public void add(int index, Object o){
        indexCheckForAdd(index);

        ensureCapacity(1);
        System.arraycopy(objects,index,objects, index+1,size - index-1);
        objects[index] = o;
        count++;
    }

    public Object remove(int index){
        checkIndex(index);
        Object tmp = objects[index];
        System.arraycopy(objects, index+1, objects, index,size - index - 1);
        objects[count--] = null;
        return tmp;
    }

    public boolean remove(Object o){
        if (indexOf(o) >= 0){
            remove(indexOf(o));
            return true;
        }
        return false;
    }

    public int size(){
        return count;
    }

    public Object get(int index){
        checkIndex(index);
        return objects[index];
    }

    public Object set(int index, Object o){
        checkIndex(index);
        Object tmp = objects[index];
        objects[index] = o;
        return tmp;
    }

    public void clear(){
        for (int i = 0; i < count; i++) {
            objects[i] = null;
        }
        count = 0;
    }

    public boolean contains(Object o){
        if (indexOf(o) >= 0){
            return true;
        }
        return false;
    }

    public int indexOf(Object o){
        if (o == null) {
            for (int i = 0; i < count; i++) {
                if (objects[i] == null){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (objects[i].equals(o)){
                    return i;
                }
            }
        }
        return -1;
    }

    private void ensureCapacity(int number){
        Object[] tmp = new Object[size + number];
        System.arraycopy(objects,0,tmp,0,size);
        objects = tmp;
        size += number;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
    }

    private void indexCheckForAdd(int index){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
    }

    // for test purposes
    public void showAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(objects[i]);
        }
        System.out.println();
    }
}
