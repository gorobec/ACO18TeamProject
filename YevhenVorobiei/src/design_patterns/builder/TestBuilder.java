package design_patterns.builder;

/**
 * Created by gorobec on 05.02.17.
 */
public class TestBuilder {
    public static void main(String[] args) {
        Milk milk = new Milk.MilkBuilder()
                .setProteins(10)
                    .setFats(15)
                        /*.setVolume(900)
                            .setCarbohydrates(25)
                                .setVitamins(15)
                                    .setE(235)*/
                                            .build();

        System.out.println(milk);
    }
}
