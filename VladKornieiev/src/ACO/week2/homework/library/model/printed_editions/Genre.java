package ACO.week2.homework.library.model.printed_editions;

/**
 * Created by v21k on 31.01.17.
 */
public enum Genre {
    DRAMA, ROMANCE, SCIENCE, JOURNAL, FANTASY;

    public static String showAll() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Genre genre : Genre.values()) {
            sb.append(i++).append(": ").append(genre).append("\n");
        }
        return sb.toString();
    }

    public static boolean contains(String genreName) {
        for (Genre genre : Genre.values()) {
            if (genre.equals(genreName.toUpperCase())) {
                return true;
            }
        }
        return false;
    }


}
