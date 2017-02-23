package container.IDB;

import exception.InvalidIdException;
import exception.InvalidTokenException;
import model.User;

/**
 * Created by Мастер on 21.02.2017.
 */
public interface IUserDataBase extends IDataBase<User> {
    String createAccessToken(User user) throws InvalidIdException;

    boolean isTokenExisted(String token);

    User getUserByToken(String token) throws InvalidTokenException;
}
