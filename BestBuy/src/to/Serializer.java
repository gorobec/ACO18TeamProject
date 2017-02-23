package to;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Product;
import model.Ticket;
import model.User;

import java.lang.reflect.Type;
import java.util.Map;

public class Serializer<K,T> {
    // map to json
    public String convertObjectToJson(Map<K, T> map) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(map);
    }

    // json to object
    public Map<Integer, Product> convertJsonToProduct(String txt) {
        Type type = new TypeToken<Map<Integer, Product>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }

    public Map<Integer, Ticket> convertJsonToTicket(String txt) {
        Type type = new TypeToken<Map<Integer, Ticket>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }

    public Map<String,User> convertJsonToUser(String txt) {
        Type type = new TypeToken<Map<String, User>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }
}