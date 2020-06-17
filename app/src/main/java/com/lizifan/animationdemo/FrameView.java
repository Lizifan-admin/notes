package com.lizifan.animationdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.lang.reflect.Field;

public class FrameView extends ImageView {
    private AnimationDrawable animationDrawable;

    public FrameView(Context context) {
        super(context);
    }
    public FrameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FrameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setAnim(AnimationDrawable anim){
        this.animationDrawable = anim;
    }
    public void setLocation(int top,int left){
        this.setFrame(left,top,left+200,top+200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        try {
            Field field = AnimationDrawable.class.getDeclaredField("mCurFrame");
            field.setAccessible(true);
            int curFrame = field.getInt(animationDrawable);
            if (curFrame == animationDrawable.getNumberOfFrames()-1){
                setVisibility(View.INVISIBLE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        super.onDraw(canvas);
    }
}
