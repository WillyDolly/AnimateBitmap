package com.popland.pop.animatebitmap;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RelativeLayout RL;
Arrow arrow;
Character character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RL = (RelativeLayout)findViewById(R.id.RL);

        arrow = new Arrow(this);
        RL.addView(arrow);
//        character = new Character(this);
//        RL.addView(character);


        //not working
//        Rect rect1 = new Rect();
//        arrow.getHitRect(rect1);
//        Rect rect2 = new Rect();
//        character.getHitRect(rect2);
//
//        if(rect1.intersect(rect2)){
//            MediaPlayer mp = MediaPlayer.create(this,R.raw.hit);
//            mp.start();
//        }
    }



    public boolean isViewOverlapped(View v1, View v2){
        int[] v1Loc = new int[2];
        int[] v2Loc = new int[2];
        v1.getLocationOnScreen(v1Loc);
        v2.getLocationOnScreen(v2Loc);

        Rect rect1 = new Rect(v1Loc[0], v1Loc[1], v1Loc[0] + v1.getMeasuredWidth(), v1Loc[1] + v1.getMeasuredHeight());
        Rect rect2 = new Rect(v2Loc[0], v2Loc[1], v2Loc[0] + v2.getMeasuredWidth(), v2Loc[1] + v2.getMeasuredHeight());
        return rect1.intersect(rect2);
    }
}
