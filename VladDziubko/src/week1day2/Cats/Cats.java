package week1day2.Cats;

public class Cats {
    private String name;
    private int age;
    private int weight;

    Cats(String name, int age, int weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        if(name == null || name.isEmpty()){
            return;
        }
        this.name = name;
    }

    public void setAge(int age){
        if(age == 0){
            return;
        }
        this.age = age;
    }

    public String asString(){
        return String.format("Cat`s name is -> %s, age is -> %d, weight is -> %d", name, age, weight);
    }
}