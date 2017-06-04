package com.example.owner.deltatask1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button red,green,blue,reset;

    int r1,b1,g1;
    TextView T1,T2,T3;

    ConstraintLayout rellay;

    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button red = (Button)findViewById(R.id.button);
        Button green = (Button)findViewById(R.id.button2);
        Button blue = (Button)findViewById(R.id.button3);
        Button reset=(Button)findViewById(R.id.button4);

        final TextView T1= (TextView)findViewById(R.id.textView);
        final TextView T2= (TextView)findViewById(R.id.textView2);
        final TextView T3= (TextView)findViewById(R.id.textView3);


                r1=getRedColor();
                g1=getGreenColor();
                b1=getBlueColor();





        final ConstraintLayout rellay= (ConstraintLayout) findViewById(R.id.you);

        rellay.setBackgroundColor(Color.argb(255,r1,g1,b1));

        T1.setText(Integer.toString(r1/17));
        T2.setText(Integer.toString(g1/17));
        T3.setText(Integer.toString(b1/17));



        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(r1+17<=255)
                r1+=17;
                else
                    r1=0;

                T1.setText(Integer.toString(r1/17));

                rellay.setBackgroundColor(Color.argb(255,r1,g1,b1));

                saveColor();



            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(g1+17<=255)
                g1+=17;
                else
                    g1=0;

                T2.setText(Integer.toString(g1/17));

                rellay.setBackgroundColor(Color.argb(255,r1,g1,b1));

                saveColor();


            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b1+17<=255)
                b1+=17;
                else
                    b1=0;

                T3.setText(Integer.toString(b1/17));

                rellay.setBackgroundColor(Color.argb(255,r1,g1,b1));

                saveColor();



            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                r1=0;g1=0;b1=0;

                rellay.setBackgroundColor(Color.argb(255,r1,g1,b1));

                T1.setText(Integer.toString(r1/17));
                T2.setText(Integer.toString(g1/17));
                T3.setText(Integer.toString(b1/17));

                saveColor();



            }
        });

    }



    public void saveColor()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();



        editor.putInt("red",r1);
        editor.putInt("green",g1);
        editor.putInt("blue",b1);
        editor.apply();

    }

    private int getRedColor()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int redC;

        redC=sharedPreferences.getInt("red",0);

        return redC;

    }

    private int getGreenColor()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int greenC;

        greenC=sharedPreferences.getInt("green",0);

        return greenC;

    }

    private int getBlueColor()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int blueC;

        blueC=sharedPreferences.getInt("blue",0);

        return blueC;

    }

}
