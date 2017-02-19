package week4;

import java.util.List;

public class Pets {
    String name;
    int age;
    int petType;

    public Pets() {
    }

    public Pets(String name, int age, int petType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
    }

    List generate(List list){
        for (int i = 0; i < 20; i++) {
            Pets pets = new Pets();
            list.add(pets);
        }
        return list;
    }
}
