package utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

/**
 * Created by v21k on 22.02.17.
 */
public class DataBaseConverter {

    public static final Gson GSON = new Gson();

    public static <T> T loadFromFile(Path path, Class<T> kl) throws IOException {
        return GSON.fromJson(Files.readAllLines(path)
                .stream()
                .collect(Collectors.joining()), kl);

    }

    public static void saveToFile(Object object, Path path) throws IOException {
        String objectJson = GSON.toJson(object);
        Files.write(path, objectJson.getBytes(), StandardOpenOption.CREATE);
    }

}
