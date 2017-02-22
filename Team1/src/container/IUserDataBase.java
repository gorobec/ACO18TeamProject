package container;

import exception.InvalidIdException;
import model.User;

/**
 * Created by Мастер on 21.02.2017.
 */
public interface IUserDataBase extends IDataBase{
    String createAccessToken(User user) throws InvalidIdException;
}
