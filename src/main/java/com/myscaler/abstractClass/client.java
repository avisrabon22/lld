package com.myscaler.abstractClass;

import com.myscaler.abstractClass.abs_interface.dogClas;

public class client{
    
    public static void main(String[] args) {
         childClass child = new childClass(); 
         child.makeSound();
         child.eat();
         child.nature();
         child.walk();

         System.out.println(dogClas.name);
}
}
