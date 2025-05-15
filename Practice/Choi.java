package Practice;

public class Choi extends People{
    String name;
    int age;
    int weight;

    public Choi(String name, int age, int weight){
        this.name=name;
        this.age=age;
        this.weight=weight;
    }

    void info(){
        System.out.println(this.name+"님의 나이는 "+this.age+"이고 몸무게는 "+this.weight+"kg 입니다");
    }

    public static void main(String[] args) {
        Choi c = new Choi("wanbeen",26,50);
        c.info();
    }
}
