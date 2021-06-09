/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbusy;

import javafx.application.Platform;
import javafxbusy.BusyApplication.UpdateLabel;

/**
 *
 * @author Joris
 */
public class BusyWorker implements Runnable {

    private int workToDo = Integer.MAX_VALUE;   // default: very long time...
    private UpdateLabel updatelb;

    BusyWorker(int w) {
        this.workToDo = w;
    }

    BusyWorker() {
        
    }

    public void busyJob(UpdateLabel uplbl) {
        long endTime = System.currentTimeMillis() + workToDo;
        this.updatelb = uplbl;

        System.out.println("busy-worker started for " + workToDo + " ms");        
            try {
				while (System.currentTimeMillis() < endTime) {
                Thread.sleep(10); // busy with the job...
                Platform.runLater(this.updatelb);
				}
            } catch (InterruptedException ex) {
                System.out.println("busy-worker interrupted...");
            }        
        System.out.println("busy-worker ready");
    }

    @Override
    public void run() {
        this.busyJob(this.updatelb);
    }
}

