package Test202105;

/**
 * ClassName: Java20210531
 * Description:
 * date: 2021/5/31 10:55
 *
 * @author wt
 * @since JDK 1.8
 */


class Animal {
    public void shout() {
        //啥也不干
    }
}
class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("喵喵喵");
    }
}
class  Dog extends Animal {
    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }
}
/////////////////////////////我是分割线//////////////////////
public class Java20210531 {
    public static void main(String[] args) {
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();
        animalShout(animal1);
        animalShout(animal2);
    }

    public static void animalShout(Animal animal) {
        animal.shout();
    }
}
