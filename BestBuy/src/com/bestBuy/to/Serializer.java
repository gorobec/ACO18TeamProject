package com.bestBuy.to;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.bestBuy.model.Product;
import com.bestBuy.model.Ticket;
import com.bestBuy.model.User;

import java.lang.reflect.Type;
import java.util.Map;

public class Serializer {

    private static Serializer serializer;

    private Serializer(){
    }

    public static Serializer getInstance() {
        if (Serializer.serializer == null) {
            serializer = new Serializer();
        }
        return serializer;
    }

    // any Object to json
    public String convertObjectToJson(Object objects) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(objects);
    }



    // json com.bestBuy.to object
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

    // json com.bestBuy.to object
    public Map<String, Integer> convertJsonIDToObject(String txt) {
        Type type = new TypeToken<Map<String, Integer>>() {
        }.getType();
        return new Gson().fromJson(txt, type);
    }

}