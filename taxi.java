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
public class taxi extends car {
    public int passengers = 5;
       public taxi (){
    Speed=0;
    turbo=10;
    }
    public taxi (int _Speed, int _turbo){
    Speed=_Speed;
    turbo=_turbo;
    }

}
