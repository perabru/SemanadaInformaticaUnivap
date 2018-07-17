package com.brunopera.semanadainformaticaunivap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton btnStart = (ImageButton) findViewById(R.id.btnStart);
        TextView txtBlink = findViewById(R.id.textView2);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(900); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        txtBlink.startAnimation(anim);


        btnStart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Intent intent = new Intent(getApplicationContext(), Game.class);
                    startActivityForResult(intent, 0);
                    btnStart.setImageResource(R.drawable.victorypressed);
                }else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnStart.setImageResource(R.drawable.victory);
                }
                // TODO Auto-generated method stub
                return false;

            }
        });
    }
}
