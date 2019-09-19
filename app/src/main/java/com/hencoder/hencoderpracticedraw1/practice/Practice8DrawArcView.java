package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        canvas.drawArc(cx-200,cy-150,cx+200,cy+150,-90,90,true,paint);

        canvas.drawArc(cx-200,cy-150,cx+200,cy+150,30,120,false,paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(cx-200,cy-150,cx+200,cy+150,-110,-60,false,paint);


    }
}
