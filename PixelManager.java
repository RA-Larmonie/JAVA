/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmandelbrot;

import java.util.Arrays;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Joris
 */
public class PixelManager implements Runnable{

    private final GraphicsContext gc;
    private Pixel[] pixelArray;

    PixelManager(GraphicsContext gc, int size) {
        this.gc = gc;
        pixelArray = new Pixel[size];
    }

    public void add(Pixel p) {        
        // TODO: add p to pixelArray
        int check = 0;
        for(int i = 0; i < this.pixelArray.length; i++)
        {
            if (check > 0 ) {
                break;
            }
            else if ( this.pixelArray[i] == null ) {
                this.pixelArray[i]= p;
                check = 1;
            }
        }
    }

    
    public void show() {
        // TODO: display all pixels in pixelArray[], and empty the array afterwards

            // hint: 
            // one pixel, displayed as a 1x1 rectangle
            
        for(int i = 0; i < this.pixelArray.length; i++)
        {
            Pixel p = this.pixelArray[i];
            if (p != null) {
                gc.setFill(p.getColor());
                gc.fillRect(p.getX(), p.getY(), 1, 1);
                Platform.runLater(this);
            }
        }
        
        this.pixelArray = null;
        //Arrays.fill(this.pixelArray, null);
    }

    @Override
    public void run() {
        // this.show();
        if (Thread.currentThread().isInterrupted() == false){            
            for(int i = 0; i < this.pixelArray.length; i++)
            {
                Pixel p = this.pixelArray[i];
                if (p != null) {                                    
                    gc.setFill(p.getColor());
                    gc.fillRect(p.getX(), p.getY(), 1, 1);
                    Platform.runLater(this);
                }
            }
            this.pixelArray = null;
        }
    }
}

