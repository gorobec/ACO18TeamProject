package week1.edition;

public class Run {
    public static void main(String[] args) {
        ReferenceBook referenceBook = new ReferenceBook("Java 8", "programming",
                "G. Shildt", "science", true);
        System.out.println(referenceBook.toString());
        System.out.println(referenceBook.info());
        System.out.println(referenceBook.publishedBy());
        Encyclopedia encyclopedia = new Encyclopedia("Encyclopedia Britannica", "knowledge", "Andrew Bell");
        System.out.println(encyclopedia.toString());
        System.out.println(encyclopedia.publishedBy());
    }
}
