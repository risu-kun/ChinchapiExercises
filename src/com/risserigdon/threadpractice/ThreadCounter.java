package com.risserigdon.threadpractice;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCounter implements Runnable {
    static final int MAX = 100;
    static int counter = 0; 

    static ReentrantLock counterLock = new ReentrantLock(true);
    static ReentrantLock printingCountedNumsLock = new ReentrantLock();

    static int incrementCounter(){
        counterLock.lock();
        int countedNum;

        try{
            counter++;
            System.out.println(counter);
            countedNum = counter;
        }finally{
            counterLock.unlock();
        }
        return countedNum;
    }

    @Override
    public void run() {
        ArrayList<Integer> countedNums = new ArrayList<Integer>();

        while(counter < MAX){
            countedNums.add(incrementCounter());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        
        printCountedNums(countedNums);
               
    }
    
    private void printCountedNums(ArrayList<Integer> countedNums){
        printingCountedNumsLock.lock();
        try {
            System.out.println("Counted by " + Thread.currentThread().getName() + ":");
            for (int i = 0; i < countedNums.size(); i++) {
                System.out.println(countedNums.get(i));
            }
        }finally {
            printingCountedNumsLock.unlock();
        } 
    }

    public static void main(String[] args) {
        ThreadCounter tc = new ThreadCounter();
        Thread a = new Thread(tc, "A");
        Thread b = new Thread(tc, "B");
        Thread c = new Thread(tc, "C");

        a.start();
        b.start();          
        c.start();
    }
}