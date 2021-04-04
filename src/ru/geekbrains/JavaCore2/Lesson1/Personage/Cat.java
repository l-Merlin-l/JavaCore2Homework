package ru.geekbrains.JavaCore2.Lesson1.Personage;

import ru.geekbrains.JavaCore2.Lesson1.Personage.Interface.Jumpable;
import ru.geekbrains.JavaCore2.Lesson1.Personage.Interface.Runnable;

public class Cat implements Jumpable, Runnable {
    public static String entity = "Кот";
    private String name;
    private int heightJump;
    private int distanceRun;

    public Cat(String name, int heightJump, int distanceRun) {
        this.name = name;
        this.heightJump = heightJump;
        this.distanceRun = distanceRun;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return entity + " " + name;
    }

    @Override
    public boolean jump(int height) {
        if(height <= heightJump) {
            System.out.println(entity + " " + name + " прыгнул");
            return true;
        }else {
            System.out.println(entity + " " + name + " не смог прыгнуть");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if(distance <= distanceRun) {
            System.out.println(entity + " " + name + " побежал");
            return true;
        }else {
            System.out.println(entity + " " + name + " не смог пробежать");
            return false;
        }
    }
}