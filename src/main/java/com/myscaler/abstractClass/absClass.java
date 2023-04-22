package com.myscaler.abstractClass;

public abstract class absClass implements dogClas,catClass{
    //  private String name;
    //  private int age;
    void walk()
    {
        System.out.println("Walk");
    }

    public abstract void makeSound();
}
