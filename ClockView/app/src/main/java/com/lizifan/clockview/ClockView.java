package com.lizifan.clockview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Calendar;

public class ClockView extends View {
    private Paint paint = new Paint();   //画笔
    private Rect rect = new Rect();      //矩形文字框
    private int clockHeight;  //view的高度
    private int clockWidth;    //view的宽度
    private int radiu = 300;   //时钟表盘半径
    private int circleWidth = 10;  //时钟表盘宽度
    private int longLine = 50;   //时钟长刻度的长度
    private int shortLine = 30;   //时钟短刻度的长度
    private int numberSpace = 20;  //数字到刻度的距离
    public ClockView(Context context) {
        super(context);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        clockWidth = getMeasureSize(widthMeasureSpec);
        clockHeight = getMeasureSize(heightMeasureSpec);
        setMeasuredDimension(clockWidth,clockHeight); //该方法保存计算好的宽高
    }
    private int getMeasureSize(int measureSpec){
        int specSize = 0;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode){
            case MeasureSpec.EXACTLY:  //当父布局为match_parent或具体值时
                specSize = size;
                break;
                case MeasureSpec.AT_MOST: //当父布局为wrap_content时
                    specSize = radiu*2 + circleWidth*2;
                    break;
        }
        return specSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = clockWidth/2;
        int centerY = clockHeight/2;
        canvas.translate(centerX,centerY);
       drawCircle(canvas);
       drawLine(canvas);
       drawPoint(canvas);
        postInvalidateDelayed(1000);
    }
    private void drawCircle(Canvas canvas){
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(circleWidth);
        canvas.drawCircle(0,0,radiu,paint);
    }
    private void drawLine(Canvas canvas){
        for (int i = 60; i > 0; i--) {
            if (i%5 == 0){
                paint.setStrokeWidth(7f);
                canvas.drawLine(0,-radiu,0,-radiu+longLine,paint);
                canvas.save();
                paint.setStrokeWidth(5f);
                paint.setStyle(Paint.Style.FILL);
                paint.setTextSize(35F);
                String text = String.valueOf(i/5);
                paint.getTextBounds(text,0,text.length(),rect);
                canvas.translate(0,-radiu+longLine+numberSpace+rect.height()/2);
                canvas.rotate(i*-6);  //将矩形文本框旋转至竖直
                canvas.drawText(text,-rect.width()/2,rect.height()/2,paint);
                canvas.restore();  //还原至上一个save的状态,在这期间绘制的位置不变
            }else {
                paint.setStrokeWidth(4f);
                canvas.drawLine(0,-radiu,0,-radiu+shortLine,paint);
            }
            canvas.rotate(-6F,0,0); //旋转的时候只有坐标轴旋转，旋转之前的绘制内容不变
        }
    }
    private void drawPoint(Canvas canvas){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        float hourAngle =hour*30+ minute*30/60 + second*30/3600;
        float minuteAngle = (second*6/60 +minute*6);
        float secondAngle = second * 6;

        canvas.save();
        canvas.rotate(hourAngle,0,0);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(9f);
        paint.setColor(Color.BLACK);
        canvas.drawLine(0,0,0,-100,paint);
        canvas.restore();

        canvas.save();
        canvas.rotate(minuteAngle,0,0);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(7f);
        paint.setColor(Color.BLUE);
        canvas.drawLine(0,0,0,-150,paint);
        canvas.restore();

        canvas.save();
        canvas.rotate(secondAngle,0,0);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5f);
        paint.setColor(Color.RED);
        canvas.drawLine(0,0,0,-260,paint);
        canvas.restore();

        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(0,0,10f,paint);
    }
}
