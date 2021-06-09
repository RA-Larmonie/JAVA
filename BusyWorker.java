/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbusy;

/**
 *
 * @author Joris
 */
public class BusyWorker {

    private int workToDo = Integer.MAX_VALUE;   // default: very long time...

    BusyWorker(int w) {
        this.workToDo = w;
    }

    BusyWorker() {
    }

    public void busyJob() {
        long endTime = System.currentTimeMillis() + workToDo;

        System.out.println("busy-worker started for " + workToDo + " ms");
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(10); // busy with the job...
            } catch (InterruptedException ex) {
                System.out.println("busy-worker interrupted...");
            }
        }
        System.out.println("busy-worker ready");
    }
}

