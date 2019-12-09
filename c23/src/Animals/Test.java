package Animals;

import Animals.Cat;
import Animals.Frog;
import Animals.IRunning;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("小猫");
        walk(cat);

        Frog frog = new Frog("青蛙");
        walk(frog);
    }

    public static void walk(IRunning running) {
        System.out.println("我带着伙伴去散步");
        running.run();
    }
}
