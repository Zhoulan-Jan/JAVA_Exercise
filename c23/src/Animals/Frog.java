package Animals;

import Animals.Animal;

public class Frog extends Animal implements ISwimming, IRunning {
    public Frog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在往前跳");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "正在蹬腿游泳");
    }
}
