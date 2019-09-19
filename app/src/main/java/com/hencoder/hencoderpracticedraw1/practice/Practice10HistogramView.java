package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();

    int x = 150;//起始点
    int y = 600;//起始点

    int divider = 20;
    int width = 80;
    int color = Color.GREEN;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        //坐标系
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        canvas.drawLine(x, y, x, y - 500, paint);

        canvas.drawLine(x, y, x + 800, y, paint);


        //坐标系y轴坐标
        drawY(canvas,y,500,30);

        itemCount = 0;

        drawItem(canvas, "Froyo", 0);
        drawItem(canvas, "GB", 10);
        drawItem(canvas, "ICS", 10);
        drawItem(canvas, "JB", 60);
        drawItem(canvas, "KitKat", 60);
        drawItem(canvas, "L", 150);
        drawItem(canvas, "M", 120);

    }

    private void drawY(Canvas canvas, int y, int totalHeight, int percent) {
        int currentHeight=0;
        while (currentHeight<totalHeight){

            paint.reset();
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(6);

            canvas.drawPoint(x-4,y-currentHeight-3,paint);

            paint.reset();
            paint.setColor(Color.WHITE);
            paint.setTextSize(22);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(currentHeight/3+"",x-40,y-currentHeight+3,paint);


            currentHeight+=percent*3;

        }
    }


    private int itemCount = 0;

    private void drawItem(Canvas canvas, String text, int i) {
        drawItemText(canvas, text);
        drawItemHeight(canvas, i);

        itemCount++;
    }

    private void drawItemText(Canvas canvas, String text) {
        paint.reset();
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(22);
        canvas.drawText(text, x + divider * (itemCount+1) + width * itemCount  + width / 2, y + 30, paint);

    }

    private void drawItemHeight(Canvas canvas, int i) {
        int itemx = x + divider * (itemCount + 1 )+ width *itemCount;
        int itemx2 = itemx + width;
        int h=y-2-i*3;
        paint.reset();
        paint.setColor(color);
        canvas.drawRect(itemx,h,itemx2,y-2,paint);

        paint.reset();
        paint.setColor(Color.WHITE);

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(26);
        canvas.drawText(i+"",itemx+width/2,h-26,paint);


    }


}
