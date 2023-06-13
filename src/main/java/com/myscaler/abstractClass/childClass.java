package com.myscaler.abstractClass;

import com.myscaler.abstractClass.abs_interface.absClass;

public class childClass extends absClass{
    
    @Override
    public void makeSound() {
        System.out.println("Pauuuuuuuuuuuuuu");  
          
    }

    @Override
    public void eat() 
    {
        System.out.println("Dog eat chicken");
    }

    @Override
    public void nature()
     {
        System.out.println("Cat a type of syyyyyy");
        
     }

    @Override
    protected void walk() {
        
    }  

     
}
