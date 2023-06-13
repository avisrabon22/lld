package com.myscaler.abstractClass.abs_interface;

public abstract class absClass implements dogClas,catClass{
    //  private int age;
    protected void walk()
    {
        System.out.println("Walk");
        
    }
    public abstract void makeSound();
}
