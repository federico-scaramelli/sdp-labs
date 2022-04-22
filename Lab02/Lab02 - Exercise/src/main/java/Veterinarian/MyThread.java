package Veterinarian;

import java.util.Random;

public class MyThread extends Thread {
    private Random rnd;
    private WaitingRoom room;
    public boolean isCat;

    MyThread(Random r, WaitingRoom wr) {
        rnd = r; room = wr;
    }

    public void run() {
        int seconds = rnd.nextInt(10) + 1;
        if (seconds < 5) {
            isCat = true;
        } else {
            isCat = false;
        }

        if(isCat)
            System.out.println("A cat want to enter into the waiting room!");
        else
            System.out.println("A dog want to enter into the waiting room!");

        try
        {
            room.enterRoom(this);
            Thread.sleep(seconds * 1000);
            room.exitRoom(this);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        if(isCat)
            System.out.println("A cat has go away!");
        else
            System.out.println("A dog has go away!");

    }
}
