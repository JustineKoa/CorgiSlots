package com.example.justinekoa.realcorgislots;

import android.os.AsyncTask;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by justinekoa on 8/2/17.
 */

public class Wheel extends Thread {
    final int[] pics = {R.drawable.bagel, R.drawable.maki, R.drawable.phoebe, R.drawable.pudge, R.drawable.scrout, R.drawable.ventus};
    final Random randomGenerator = new Random();
    private WheelListener wheelListener;
    private int currentImage;
    final int DELAY = 500;
    private int a;

    interface WheelListener{
        void newImage(int image);
    }

    public int getCurrentImage()
    {
        return currentImage;
    }

    /*public Wheel(WheelListener wheelListener,int currentPos, int a)
    {
        this.wheelListener = wheelListener;
        currentImage = currentPos;
        this.a = a;
    }
    */

    public Wheel(WheelListener wheelListener, int currentPos)
    {
        this.wheelListener = wheelListener;
        currentImage = currentPos;
    }

    @Override
    public void run()
    {

        for(int i = 0; i<6; i++){
            try{
                Thread.sleep(DELAY);
            } catch(Exception ex){}

            /*if(currentImage == pics.length)
            {
                currentImage = 0;
            }*/

            currentImage = randomGenerator.nextInt(5 - 0 + 1) + 0;

            if (wheelListener != null){
                wheelListener.newImage(currentImage);
            }
        }



        /*while(currentImage != a)
        {
            try {
                Thread.sleep(DELAY);
            } catch (Exception ex) {
            }

            if (currentImage == pics.length){
                currentImage = 0;
            }

            if (wheelListener != null)
                wheelListener.newImage(currentImage);

            currentImage++;
        }
        */


    }

}
