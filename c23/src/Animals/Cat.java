package Animals;

import Animals.Animal;

public class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在用四条腿跑步");
    }
}
