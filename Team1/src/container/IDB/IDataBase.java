package container.IDB;

import java.util.List;

/**
 * Created by Игорь on 19.02.2017.
 */
public interface IDataBase<T> {

    boolean add(T t);

    T remove(int i);

    T get(int i);

    List<T> getAll();

}
