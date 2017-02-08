package program;

import java.util.Scanner;

class MicroBus implements Transport {
    private int speed = 0;
    private int numberOfPassengers = 0;
    private int traveledDistance = 0;
    private int numberOfSeats = 14;
    private boolean isNitroAvailable = true;

    MicroBus(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public void move() {
        Scanner scanner = new Scanner(System.in);
        int finishDistance = 500;
        while (traveledDistance < finishDistance && numberOfPassengers > 0) {
            int obstacle = (int) (1 + Math.random() * 16);
            int trafficJam = (int) (1 + Math.random() * 16);
            int sign60 = (int) (1 + Math.random() * 16);
            int sign80 = (int) (1 + Math.random() * 16);
            System.out.println("Введите 1: для ускорения на 20км   " +
                    "2: для замедления на 20 км   3: для использования нитро");
            int choose = scanner.nextInt();
            if (trafficJam == 1) {
                System.out.println("Пробка, пропуск 2 ходов");
                speed = 0;
                continue;
            }
            if (sign60 == 1) {
                handleSign60();
            }
            else if (sign80 == 1) {
                handleSign80();
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
            else if (choose == 3) {
                useNitro();
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

    private void useNitro() {
        int maxSpeed = 110;
        if (speed < maxSpeed)
            speed += 30;
        traveledDistance += speed;
        isNitroAvailable = false;
    }

    public void reduceSpeed() {
        if (speed > 0) {
            speed -= 20;
            traveledDistance += speed;
        }
        else if (speed == 10) {
            speed = 0;
        }
        else
            System.out.println("Невозможно замедлиться - скорость 0 км/ч");
    }

    public void accelerate() {
        int maxSpeed = 110;
        if (speed == 100 || speed == maxSpeed)
            speed = maxSpeed;
        else
            speed += 20;
        traveledDistance += speed;
    }

    private void handleSign60() {
        System.out.println("Ограничение скорости 60 км/ч");
        if (speed > 60)
            speed = 60;
        else if (speed + 20 > 60)
            speed = 60;
        else
            speed += 20;
        traveledDistance += speed;
    }

    private void handleSign80() {
        System.out.println("Ограничение скорости 80 км/ч");
        if (speed > 80)
            speed = 80;
        else if (speed + 20 > 80)
            speed = 80;
        else
            speed += 20;
        traveledDistance += speed;
    }
}