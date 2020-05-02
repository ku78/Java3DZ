package lesson5;

import java.util.concurrent.CountDownLatch;

/**Организуем гонки:
 Все участники должны стартовать одновременно, несмотря на то, что на подготовку
 у каждого из них уходит разное время.
 В туннель не может заехать одновременно больше половины участников (условность).
 Попробуйте всё это синхронизировать.
 Только после того как все завершат гонку, нужно выдать объявление об окончании.
 Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.
 Пример выполнения кода до корректировки:*/
public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Thread [] th = new Thread[CARS_COUNT];

        CountDownLatch cd = new CountDownLatch(CARS_COUNT);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cd);
        }
        for (int i = 0; i < cars.length; i++) {
            th[i] = new Thread(cars[i]);
            th[i].start();
        }

        try {
            cd.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

            for (int i = 0; i < cars.length; i++) {
                th[i].join();
            }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

