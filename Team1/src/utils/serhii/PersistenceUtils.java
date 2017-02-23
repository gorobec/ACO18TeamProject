package utils.serhii;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public final class PersistenceUtils {

    private static Gson gSon = new Gson();

    private PersistenceUtils() {
    }

    public static String convertToJson(Object object) {
        return gSon.toJson(object);
    }

    public static <T> T convertFromJson(Class<T> type, String json) {
        return gSon.fromJson(json, type);
    }

    public static boolean saveIntoFile(String path, String json) {
        try (PrintWriter pw = new PrintWriter(path)) {
            pw.println(json);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String loadFromFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path)).stream().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{}";
    }


}
