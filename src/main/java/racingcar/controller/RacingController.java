package racingcar.controller;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    public void startRace(String names, int attempts) {
        String[] nameList = names.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : nameList) {
            cars.add(new Car(carName.trim()));
        }

        System.out.println("\n실행결과");

        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getStatus());
            }
            System.out.println();
        }

        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
