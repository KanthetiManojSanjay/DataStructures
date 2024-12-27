package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Car {

    private String id;
    private int x;
    private int y;

    public Car(String id, int x, int y) {
        super();
        this.id = id;
        this.x = x;
        this.y = y;
    }

    private int distance() {
        return x * x + y * y;

    }

    public static void nearestCars(List<Car> carsList, int k) {

        // MaxHeap based on distance
        PriorityQueue<Car> queue = new PriorityQueue<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.distance() - o1.distance();
            }
        });

        // Add only k cars into priortityQueue
        for (int i = 0; i < k; i++) {
            queue.add(carsList.get(i));
        }

        // iterate over remaining cars
        for (int i = k; i < carsList.size(); i++) {
            Car car = carsList.get(i);
            //Add if the distance of car is less than top car distance
            if (car.distance() < queue.peek().distance()) {
                queue.poll(); //removes root node
                queue.add(car);
            }
        }

        List<Car> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            resList.add(queue.peek());
            queue.poll();
        }

        // To get sorted output
        resList.sort(Comparator.comparing(Car::distance));
        resList.forEach(car -> System.out.print(car.id + " "));

    }


    public static void main(String[] args) {

        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("C1", 1, 1));
        carsList.add(new Car("C2", 2, 1));
        carsList.add(new Car("C3", 3, 2));
        carsList.add(new Car("C4", 0, 1));
        carsList.add(new Car("C5", 2, 3));
        int k = 3;
        nearestCars(carsList, k);

    }

}
