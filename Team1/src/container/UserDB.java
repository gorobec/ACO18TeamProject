package container;

import exception.InvalidIdException;
import exception.InvalidInputParameters;
import exception.InvalidTokenException;
import model.User;
import java.util.*;

public class UserDB implements IUserDataBase{

    Map<Integer, User> userMap = new TreeMap<>();
    Map<String, User> tokenMap = new HashMap<>();

    public UserDB() {}

    public UserDB(Map<Integer, User> userMap, Map<String, User> tokenMap) {
        this.userMap = userMap;
        this.tokenMap = tokenMap;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, User> getTokenMap() {
        return tokenMap;
    }

    public void setTokenMap(Map<String, User> tokenMap) {
        this.tokenMap = tokenMap;
    }

    public User getUserByToken(String token)throws InvalidTokenException {
        User find =
                tokenMap.values()
                        .stream()
                        .filter(t -> t.equals(token))
                        .findFirst().orElse(null);

        if (find == null) {
            throw new InvalidTokenException("Invalid token");
        }

        return find;
    }

    @Override
    public String createAccessToken(User user) throws InvalidIdException {
        User find =
                userMap.values()
                        .stream()
                        .filter(u -> u.getName().equals(user.getName()))
                        .filter(u -> u.getPass().equals(user.getPass()))
                        .findFirst().orElse(null);

        if (find == null) {
            throw new InvalidIdException("invalid login or pass");
        } else {
            String accessKey = UUID.randomUUID().toString();
            tokenMap.put(accessKey, find);
            return accessKey;
        }
    }

    @Override
    public boolean add(User user) {
        userMap.put(user.getId(), user);
        return true;
    }

    @Override
    public User remove(int id) {
        User user = userMap.get(id);
        userMap.remove(id);
        return user;
    }

    @Override
    public User get(int id) {
        return userMap.get(id);
    }

    @Override
    public List getAll() {
        return (List) userMap.values();
    }

}
