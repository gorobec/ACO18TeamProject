package design_patterns.builder;

/**
 * Created by serhiim on 05-Feb-17.
 */
public class TestMilk {
    public static void main(String[] args) {
        Milk milk = new Milk.MilkBuilder().setProteins(10).setCarbohydrates(25).setFats(20).setVitamins(15).setE(5).setVolume(900).build();
        System.out.println(milk.toString());
    }
}
