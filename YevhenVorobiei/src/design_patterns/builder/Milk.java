package design_patterns.builder;

/**
 * Created by gorobec on 05.02.17.
 */
public class Milk {
    private final int proteins;
    private final int fats;
    private final int carbohydrates;
    private final int vitamins;
    private final int e;
    private final int volume;

    private Milk(MilkBuilder milkBuilder) {
        this.proteins = milkBuilder.proteins;
        this.fats = milkBuilder.fats;
        this.carbohydrates = milkBuilder.carbohydrates;
        this.vitamins = milkBuilder.vitamins;
        this.e = milkBuilder.e;
        this.volume = milkBuilder.volume;
    }


    public static class MilkBuilder{
        private int proteins;
        private int fats;
        private int carbohydrates;
        private int vitamins;
        private int e;
        private int volume;


        public MilkBuilder setProteins(int proteins) {
            this.proteins = proteins;
            return this;
        }

        public MilkBuilder setFats(int fats) {
            this.fats = fats;
            return this;


        }

        public MilkBuilder setCarbohydrates(int carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;

        }

        public MilkBuilder setVitamins(int vitamins) {
            this.vitamins = vitamins;
            return this;

        }

        public MilkBuilder setE(int e) {
            this.e = e;
            return this;

        }

        public MilkBuilder setVolume(int volume) {
            this.volume = volume;
            return this;

        }

        public Milk build(){
            return new Milk(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Milk{");
        sb.append("proteins=").append(proteins);
        sb.append(", fats=").append(fats);
        sb.append(", carbohydrates=").append(carbohydrates);
        sb.append(", vitamins=").append(vitamins);
        sb.append(", e=").append(e);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
