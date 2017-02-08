/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Stas
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Добро пожаловать. Ваша задача перевести пассажиров");
        Scanner scan = new Scanner(System.in);
        System.out.println("В гараже две машины. Выберите:");
        System.out.println("1-автобус. Максимальная скорость 80, количество пассажиров 20");
        System.out.println("2-микроавтобус. Максимальная скорость 110, количество пассажиров 14");
        int numberOfPassengers = (int) (15 + Math.random() * 16);
        System.out.println("Нужно перевезти из пункта А в пункт Б " + numberOfPassengers + " пасажиров.");
        int transportType = scan.nextInt();
        while (true) {
            if (transportType == 1) {
                Bus bus = new Bus(numberOfPassengers);
                bus.move();
                break;
            } else if (transportType == 2) {
                MicroBus microBus = new MicroBus(numberOfPassengers);
                microBus.move();
                break;
            } else {
                System.out.println("Ошибка ввода, попробуйте еще");
                transportType = scan.nextInt();
            }
        }
    }
}