package to;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Product;
import model.Ticket;

import java.lang.reflect.Type;
import java.util.Map;

public class Serializer {
    // map to json
    public String convertProductToJson(Map<Integer, Product> map) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(map);
    }

    // json to object
    public Map<Integer, Product> convertJsonToObject(String txt) {
        GsonBuilder builder = new GsonBuilder();
        Type type = new TypeToken<Map<Integer, Product>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }


    //FOR TICKETS
    // to json
    public String ticketToJson(Map<Integer, Ticket> map) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(map);
    }


    // to object
    public Map<Integer, Ticket> ticketToObject(String txt) {
        GsonBuilder builder = new GsonBuilder();
        Type type = new TypeToken<Map<Integer, Ticket>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }


}
