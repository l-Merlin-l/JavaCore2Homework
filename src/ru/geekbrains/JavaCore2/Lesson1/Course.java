package ru.geekbrains.JavaCore2.Lesson1;

import ru.geekbrains.JavaCore2.Lesson1.Obstacles.Interface.Obstacle;
import ru.geekbrains.JavaCore2.Lesson1.Obstacles.Treadmill;
import ru.geekbrains.JavaCore2.Lesson1.Obstacles.Wall;

import java.util.Random;

public class Course {

    private static Random random = new Random();
    private Obstacle[] obstacles;

    public Course(int quantity) {
        this.obstacles = createObstacles(quantity);
    }

    public void overcoming(Team team) {
        for (int i = 0; i < team.teamLength(); i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (!obstacles[j].overcome(team.getPersonage(i))) {
                    System.out.println(team.getPersonage(i) + " сходит с дистанции");
                    break;
                }
                if (j == obstacles.length - 1) {
                    team.setPersonageFinish(i);
                    System.out.println(team.getPersonage(i) + " прошел всю полосу препятствий");
                }
            }
        }
        team.finished();
    }

    private static Obstacle[] createObstacles(int quantity) {
        Obstacle[] obstacles = new Obstacle[quantity];
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = randomObstacle();
        }
        return obstacles;
    }

    private static Obstacle randomObstacle() {
        switch (random.nextInt(2)) {
            case 0:
                return new Treadmill(random.nextInt(30));
            case 1:
                return new Wall(random.nextInt(3));
            default:
                return null;
        }
    }
}
