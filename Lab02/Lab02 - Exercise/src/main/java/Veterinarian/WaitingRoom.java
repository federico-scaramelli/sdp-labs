package Veterinarian;

import java.util.ArrayList;
import java.util.Random;

public class WaitingRoom {

    int dogAmount = 0;
    boolean thereIsACat = false;
    static ArrayList<MyThread> threads = new ArrayList<MyThread>();

    public void openWaitingRoom() {
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            MyThread mt = new MyThread(r, this);
            threads.add(mt);
        }
        System.out.println("All threads created.");
        for (MyThread t : threads) {
            t.start();
        }

//        for (MyThread t: threads) {
//            t.join();
//        }

        System.out.println("No more patient.");
    }

    synchronized void enterRoom(MyThread animal) {
        if (animal.isCat) {
            while (thereIsACat || dogAmount > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            thereIsACat = true;
            System.out.println("A cat entered into the waiting room!");
            notifyAll();
        } else {
            try {
                while (dogAmount >= 4 || thereIsACat) {
                    wait();
                }
                if (dogAmount < 4) {
                    dogAmount++;
                    System.out.println("A dog entered into the waiting room! Now there are " + dogAmount + " dogs.");
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //check if the thread represents a dog or a cat and use a while until the condition is satisfied
        //when a thread enter, sleep for a random time
    }

    synchronized void exitRoom(MyThread animal) {
        //threads.remove(animal);
        if(animal.isCat) {
            System.out.println("A cat exited the waiting room!");
            thereIsACat = false;
        }
        else {
            dogAmount--;
            System.out.println("A dog exited the waiting room!");
        }
        notifyAll();
    }
}
