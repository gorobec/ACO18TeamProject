package library;

public interface Publication {
    PublicationType getPublicationType();
    void printPublicationType();
    void printFullInfo();
    boolean give(int readerID);
}