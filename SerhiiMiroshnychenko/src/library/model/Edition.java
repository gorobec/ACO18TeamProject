package library.model;

/**
 * Created by serhiim on 29-Jan-17.
 */
public abstract class Edition {
    private String editionName;
    private String editionAddress;

    public Edition() {
    }

    public Edition(String editionName, String editionAddress) {
        this.editionName = editionName;
        this.editionAddress = editionAddress;
    }

    public String getEditionName() {
        return editionName;
    }

    public String getEditionAdress() {
        return editionAddress;
    }
}
