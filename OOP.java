/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author Stas
 */
import java.util.Scanner;
public class OOP {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // TODO code application logic here
        car ford = new car();
        System.out.println(ford.Speed);
                car toyota = new car(60,30);
        System.out.println(toyota.Speed);
                     taxi honda = new taxi(60,30);
        System.out.println(honda.doors);
        Scanner in=new Scanner(System.in);
        System.out.println("Введите - для уменшения скорости или + для увеличения");
        String a=in.nextLine();
            if ("-".equals(a)){
            ford.Speed = ford.Speed - ford.turbo; 
            System.out.println(ford.Speed);
            }
            else if("+".equals(a)){
            ford.Speed = ford.Speed + ford.turbo;
            System.out.println(ford.Speed);
            }
        }
    }
    
    /*
Приклади парадигм ООП показав
Вибачаюсь за таку безцільну "програму"
     */
       
