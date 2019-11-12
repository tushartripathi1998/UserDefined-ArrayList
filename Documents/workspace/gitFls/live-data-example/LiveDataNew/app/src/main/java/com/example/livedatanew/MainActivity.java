package com.example.livedatanew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn_enter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoomActivity.class);
                startActivity(intent);
            }
        });

        //animate test
        Button btnAnimate = (Button)findViewById(R.id.btn_animate);
        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout r = (RelativeLayout)findViewById(R.id.activity_main);
                r.setBackgroundResource(R.drawable.android_anim);
                AnimationDrawable animationDrawable = (AnimationDrawable) r.getBackground();
                animationDrawable.start();
            }
        });

    }
}
