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
public class car {
    
    public int Speed ;
    public int turbo ;

    public int doors = 4;
    public car (){
    Speed=0;
    turbo=10;
    }
    public car (int _Speed, int _turbo){
    Speed=_Speed;
    turbo=_turbo;
    }
    
}
