package com.example.justinekoa.realcorgislots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.graphics.Color;

import static android.R.id.input;

public class MainActivity extends AppCompatActivity {
    private Wheel wheel1, wheel2, wheel3;
    //private int DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button spin = (Button) findViewById(R.id.spin);
        Button cashOut = (Button) findViewById(R.id.cashOut);
        final ImageView slot1 = (ImageView) findViewById(R.id.slot1);
        final ImageView slot2 = (ImageView) findViewById(R.id.slot2);
        final ImageView slot3 = (ImageView) findViewById(R.id.slot3);
        final TextView result = (TextView) findViewById(R.id.result);
        final TextView score = (TextView) findViewById(R.id.score);
        final TextView cashOutAmt = (TextView) findViewById(R.id.cashOutAmt);
        final int[] pics = {R.drawable.bagel, R.drawable.maki, R.drawable.phoebe, R.drawable.pudge, R.drawable.scrout, R.drawable.ventus};
        final Random randomGenerator = new Random();

        cashOut.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View V)
            {
                String cashOut = score.getText().toString();
                int cash = Integer.parseInt(cashOut);

                if (cash > 0){
                    cashOutAmt.setText("YOU WON " + cashOut);
                    score.setText("0");
                }
                else
                {
                    cashOutAmt.setText("You didn't win anything!");
                    score.setText("0");
                }
            }
        });

        spin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View V)
            {
                cashOutAmt.setText("");
                String cash = score.getText().toString();
                int points = Integer.parseInt(cash);

                int a = randomGenerator.nextInt(6);
                int b = pics[a];
                slot1.setImageResource(b);

                /*
                int currentPos1 = 0;
                if (wheel1 != null)
                    currentPos1 = wheel1.getCurrentImage();

                wheel1 = new Wheel(new Wheel.WheelListener(){
                    @Override
                    public void newImage(final int image)
                    {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {slot1.setImageResource(pics[image]);}
                        });
                    }
                },currentPos1);
                wheel1.start();
                */


                int c = randomGenerator.nextInt(6);
                int d = pics[c];
                slot2.setImageResource(d);

                /*
                int currentPos2 = 0;
                if (wheel2 != null)
                    currentPos2 = wheel2.getCurrentImage();

                wheel2 = new Wheel(new Wheel.WheelListener(){
                    @Override
                    public void newImage(final int image)
                    {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {slot2.setImageResource(pics[image]);}
                        });
                    }
                },currentPos2);
                wheel2.start();
                */


                int e = randomGenerator.nextInt(6);
                int f = pics[e];
                slot3.setImageResource(f);

                /*
                int currentPos3 = 0;
                if (wheel3 != null)
                    currentPos3 = wheel3.getCurrentImage();

                wheel3 = new Wheel(new Wheel.WheelListener(){
                    @Override
                    public void newImage(final int image)
                    {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {slot3.setImageResource(pics[image]);}
                        });
                    }
                },currentPos3);
                wheel3.start();
                */


                //try {Thread.sleep(5000);} catch (InterruptedException ex) {}

                /*if (wheel1.getCurrentImage()  == wheel2.getCurrentImage() && wheel2.getCurrentImage() == wheel3.getCurrentImage()){
                    result.setText("WINNER!!!");
                }

                else {
                    result.setText("YOU SUCK!");
                }
                */

                if (a==c && c==e && e==0)
                {
                    result.setText("JACKPOT!");
                    points = 10000;
                    score.setText(Integer.toString(points));
                }
                else if(a==c && c==e)
                {
                    result.setText("WINNER!");
                    points = win(points, 3);
                    score.setText(Integer.toString(points));
                }
                else if(a==c || a==e || c==e)
                {
                    result.setText("YOU'RE ALRIGHT");
                    points = win(points, 2);
                    score.setText(Integer.toString(points));
                }
                else
                {
                    result.setText("YOU SUCK!");
                    points = lose(points);
                    score.setText(Integer.toString(points));
                }

            }

        });

    }

    public int win(int point, int n)
    {
        EditText betAmt = (EditText) findViewById(R.id.betAmt);
        String value = betAmt.getText().toString();
        int bet = Integer.parseInt(value);

        return point + (bet * n);
    }

    public int lose(int point)
    {
        EditText betAmt = (EditText) findViewById(R.id.betAmt);
        String value = betAmt.getText().toString();
        int bet = Integer.parseInt(value);

        return point - bet;
    }


}
