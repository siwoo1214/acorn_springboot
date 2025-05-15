package Practice;

public class People {
    String name;
    int age;

    public People(){

    }

    public People(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
