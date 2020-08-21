package level2.homeWork1;

public class Main {
    public static void main(String[] args) {

        //  1.Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
        //  Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).

        //        Cat cat = new Cat("Кокося");
        //        Human human = new Human("Аня");
        //        Robot robot = new Robot("С3PO");
        //
        //        cat.run(5);
        //        cat.jump(10);
        //
        //        human.run(6);
        //        human.jump(15);
        //
        //        robot.run(7);
        //        robot.jump(200);

        // 2.Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать),
        // результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).

        //        Cat cat = new Cat("Кокося", 15, 5);
        //        Human human = new Human("Аня", 50, 15);
        //        Robot robot = new Robot("С3PO", 100, 100);
        //
        //        Wall smallWall = new Wall(10);
        //        smallWall.getInfo();
        //        smallWall.pass(cat);
        //        smallWall.pass(human);
        //        smallWall.pass(robot);
        //
        //        Wall bigWall = new Wall(100);
        //        bigWall.getInfo();
        //        bigWall.pass(cat);
        //        bigWall.pass(human);
        //        bigWall.pass(robot);
        //
        //        Track smallTrack = new Track(10);
        //        smallTrack.getInfo();
        //        smallTrack.pass(cat);
        //        smallTrack.pass(human);
        //        smallTrack.pass(robot);
        //
        //        Track bigTrack = new Track(50);
        //        bigTrack.getInfo();
        //        bigTrack.pass(cat);
        //        bigTrack.pass(human);
        //        bigTrack.pass(robot);

        // 3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

        //        Difficulty[] difficulties = {
        //            new Track(5),
        //            new Wall(10),
        //            new Track(15)
        //        };
        //
        //        Runner[] runners = {
        //            new Robot("First", 10, 20),
        //            new Robot("Second", 30, 100),
        //        };
        //
        //        for (Difficulty diff : difficulties) {
        //            diff.getInfo();
        //            for (Runner runner : runners) {
        //                diff.pass(runner);
        //            }
        //        }

        // 4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
        // Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

        Passable[] difficulties = {
            new Track(25),
            new Wall(10),
            new Track(15)
        };

        Runnable[] runners = {
            new Human("Human", 10, 20),
            new Robot("First", 20, 50),
            new Robot("Second", 30, 100),
        };

        for (Runnable runner : runners) {
            for (Passable diff : difficulties) {
                diff.getInfo();
                if (!diff.pass(runner)) {
                    System.out.printf("%s is leaving\n", runner.getName());
                    break;
                }
            }
        }
    }
}
