package com.myscaler.thread;

public class client {
    

    public static void main(String[] args) {
    
         evenClas even = new evenClas();
         oddClass odd = new oddClass();

         Thread th1 = new Thread(even);
         th1.start();
         System.out.println();
         Thread th2 =new Thread(odd);
         th2.start();
         System.out.println();
    }
}
