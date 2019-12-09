package Animals;

import Animals.Animal;

public class Fish extends Animal implements ISwimming {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(this.name + "正在用尾巴游泳");
    }
}
