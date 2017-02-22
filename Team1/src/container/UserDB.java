package container;

import exception.InvalidIdException;
import model.User;

import java.util.*;

/**
 * Created by Мастер on 21.02.2017.
 */
public class UserDB implements IUserDataBase {

    Map<Integer, User> userMap = new TreeMap<>();
    Map<String, User> tokenMap = new HashMap<>();


    @Override
    public String createAccessToken(User user) throws InvalidIdException {
        User found =
                userMap.values()
                        .stream()
                        .filter(u -> u.getName().equals(user.getName()))
                        .filter(u -> u.getPass().equals(user.getPass()))
                        .findFirst().orElse(null);

        if (found == null) {
            throw new InvalidIdException("invalid login or pass");
        } else {
            String accessKey = UUID.randomUUID().toString();
            tokenMap.put(accessKey, found);
            return accessKey;
        }
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    public boolean add(User user, int id){
        userMap.put(id, user);
        return true;
    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }
   /* private User findUser(int id){
       // User find =
                userMap.values()
                        .stream()
                        .filter(u -> u.getName().equals(user.getName()))
                        .filter(u -> u.getPass().equals(user.getPass()))
                        .findFirst().orElse(null);

    }*/
}
