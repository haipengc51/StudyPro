package com.laowu.studypro.Canvas;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LaoWu on 2017/3/2.
 */

public class CustomTrigon extends View {
    private int mWidth;     //画布的宽
    private int mHeight;     //画布的高

    private float mCenterX;     //圆心点x
    private float mCenterY;     //圆心点Y
    PointBean mPointA;
    PointBean mPointB = new PointBean(760, 400);

    public CustomTrigon(Context context) {
        super(context);
    }

    public CustomTrigon(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTrigon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomTrigon(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = canvas.getWidth();
        mHeight = canvas.getHeight();
        mCenterX = mWidth/2;
        mCenterY = mHeight/4;

        mPointA = new PointBean((int)mCenterX, (int)mCenterY);

        Paint paint = new Paint();
        paint.setAntiAlias(true);       // 设置画笔的抗锯齿情况，使画笔更为圆滑
        paint.setStyle(Paint.Style.FILL);// 设置画笔的样式
                                        // Paint.Style.FILL(实心)；
                                        // Paint.Style.STROKE(空心)；
                                        // Paint.Style.FILL_AND_STROKE
        paint.setStrokeWidth(30f);  // 当画笔是空心样式时，设置画笔空心的宽度
        paint.setDither(true);      // 设置清除抖动对图像的影响，会使绘制出来的图片图像更加清晰，颜色更加平滑和饱满.
        paint.setColor(0x12345678);

        getDot2(paint, canvas);
    }

    public void getDot2(Paint paint, Canvas canvas) {
        //求出坐标点P
        double x1 = mPointA.x - 50 * Math.sin(Math.atan((mPointB.y - mPointA.y) / (mPointB.x - mPointA.x)));
        double y1 = mPointA.y + 50 * Math.cos(Math.atan((mPointB.y - mPointA.y) / (mPointB.x - mPointA.x)));

        //求出坐标点P'
        double x2 = mPointA.x + 50 * Math.sin(Math.atan((mPointB.y - mPointA.y) / (mPointB.x - mPointA.x)));
        double y2 = mPointA.y - 50 * Math.cos(Math.atan((mPointB.y - mPointA.y) / (mPointB.x - mPointA.x)));

        //开始画三角形
        Path path = new Path();
        path.moveTo((float)x1, (float)y1);
        path.lineTo((float)(mPointB.x), (float)(mPointB.y));
        path.lineTo((float)x2, (float)y2);
        path.close();
        canvas.drawPath(path, paint);
    }

    public void setData(PointBean pointB) {
        mPointB = pointB;
        invalidate();
    }

}
