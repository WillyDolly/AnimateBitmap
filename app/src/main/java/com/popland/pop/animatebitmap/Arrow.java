package com.popland.pop.animatebitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * Created by hai on 14/12/2017.
 */

public class Arrow extends View {
Bitmap arrow, character;
float xA, yA , xC, yC;
Paint rectPaint;
Context context;
boolean lock = true, right;
    MediaPlayer mp;

    Arrow(Context c){
        super(c);
        context = c;
        arrow = BitmapFactory.decodeResource(getResources(),R.drawable.arrow);
        character = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        yA = 0;

//        rectPaint = new Paint();
//        rectPaint.setColor(Color.RED);
//        rectPaint.setStyle(Paint.Style.FILL);
        xC = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // draw bitmap arrow
        xA = canvas.getWidth()/2 - arrow.getWidth()/2;
        if(yA<canvas.getHeight())
            yA += 10;//adjust speed
        else {
            yA = 0;
            lock = true;
        }
        canvas.drawBitmap(arrow,xA,yA,new Paint());

        //draw bitmap character
        yC = canvas.getHeight() - character.getHeight();
        if(xC == 0) {
            right = true;
            lock = true;
        }
        if(xC == (canvas.getWidth() - 100)) {
            right = false;
            lock = true;
        }
        if(right)
            xC += 5;
        else
            xC -= 5;
        canvas.drawBitmap(character,xC,yC,new Paint());

        //collision detection
        RectF rect1 = new RectF(xA, yA, xA+arrow.getWidth(), yA+arrow.getHeight());
        RectF rect2 = new RectF(xC, yC, xC+character.getWidth(), yC+character.getHeight());
        if(RectF.intersects(rect1,rect2)) {
            if(lock) {
                Toast.makeText(context, "Hit", Toast.LENGTH_SHORT).show();
                mp = MediaPlayer.create(context,R.raw.hit);
                mp.start();
                lock = false;
            }
        }
        invalidate();
    }
}
