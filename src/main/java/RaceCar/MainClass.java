package RaceCar;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(CARS_COUNT / 2);
        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT);


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), barrier);
        }

        for (Car car : cars) {
            new Thread(car).start();
        }
    }
}
