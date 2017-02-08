package program;

import java.util.Scanner;

class Bus implements Transport {
    private int speed = 0;
    private int numberOfSeats = 20;
    private int numberOfPassengers = 0;
    private int traveledDistance = 0;

    Bus(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public void move() {
        Scanner scanner = new Scanner(System.in);
        int finishDistance = 500;
        while (traveledDistance < finishDistance && numberOfPassengers > 0) {
            int obstacle = (int) (1 + Math.random() * 16);
            int sign60 = (int) (1 + Math.random() * 16);
            System.out.println("Введите 1: для ускорения на 10км   " +
                    "2: для замедления на 10 км");
            int choose = scanner.nextInt();
            if (sign60 == 1) {
                handleSign60();
            }
            else if (obstacle == 1 && speed != 0) {
                System.out.println("Препятствие, пропуск хода");
                speed = 0;
            }
            else if (choose == 1) {
                accelerate();
            }
            else if (choose == 2) {
                reduceSpeed();
            }
            else
                System.out.println("Ошибка ввода");
            if (traveledDistance >= finishDistance) {
                traveledDistance = 0;
                speed = 0;
                if (numberOfSeats > numberOfPassengers)
                    System.out.println(numberOfPassengers + " пассажиров было доставлено");
                else
                    System.out.println(numberOfSeats + " пассажиров было доставлено");
                numberOfPassengers -= numberOfSeats;
            }
            System.out.println("Пройдено " + traveledDistance + " километров из "
                    + finishDistance + "\nТекущая скорость: " + speed + " км/ч");
        }
        System.out.println("Все пассажиры доставлены");
    }

    @Override
    public void reduceSpeed() {
        if (speed > 0) {
            speed -= 10;
            traveledDistance += speed;
        }
        else
            System.out.println("Невозможно замедлиться - скорость 0 км/ч");
    }

    @Override
    public void accelerate() {
        int maxSpeed = 80;
        if (speed + 10 < maxSpeed)
            speed += 10;
        traveledDistance += speed;
    }

    private void handleSign60() {
        System.out.println("Ограничение скорости 60 км/ч");
        if (speed > 60)
            speed = 60;
        else if (speed + 10 > 60)
            speed = 60;
        else
            speed += 10;
        traveledDistance += speed;
    }

}