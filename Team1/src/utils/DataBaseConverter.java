package utils;

import com.google.gson.Gson;
import container.*;
import model.Product;
import model.Ticket;
import model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by v21k on 22.02.17.
 */
public class DataBaseConverter {

    public static final Gson GSON = new Gson();

    public Object loadFromFile(Path path, Class kl) throws IOException {
        return GSON.fromJson(Files.readAllLines(path)
                .stream()
                .collect(Collectors.joining()), kl);

    }

    public void saveToFile(Object object, Path path) throws IOException {
        String objectJson = GSON.toJson(object);
        Files.write(path, objectJson.getBytes(), StandardOpenOption.CREATE);
    }

}
