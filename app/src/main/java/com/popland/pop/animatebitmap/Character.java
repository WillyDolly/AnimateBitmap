package com.popland.pop.animatebitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by hai on 14/12/2017.
 */

public class Character extends View {
Bitmap character;
float xC , yC;
boolean right;
    public Character(Context c){
        super(c);
        character = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        xC = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        yC = canvas.getHeight() - character.getHeight();
        if(xC == 0)
            right = true;
        if(xC == (canvas.getWidth() - 110))//compiler skip this code if replace specific number with character.getWidth
            right = false;
        if(right)
            xC += 5;
        else
            xC -= 5;
        canvas.drawBitmap(character,xC,yC,new Paint());
        invalidate();
    }
}
