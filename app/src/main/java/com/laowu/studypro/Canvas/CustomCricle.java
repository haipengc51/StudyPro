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
 * Created by LaoWu on 2017/3/3.
 */

public class CustomCricle extends View {
    private float mCenterX;
    private float mCenterY;
    private float mCircleSize;
    private int mWidth;
    private int mHeight;

    public CustomCricle(Context context) {
        super(context);
    }

    public CustomCricle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCricle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomCricle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = canvas.getWidth();
        mHeight = canvas.getHeight();
        mCenterX = mWidth/2;
        mCenterY = mHeight/4;
        mCircleSize = mHeight/6;

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30f);
        paint.setDither(true);
        paint.setColor(0xffffffff);

        Path path = new Path();
        path.addCircle(mCenterX, mCenterY, mCircleSize, Path.Direction.CCW);
        canvas.drawPath(path, paint);

        Paint paint_white = new Paint();
        Path path_white = new Path();
        paint_white.setAntiAlias(true);
        paint_white.setStyle(Paint.Style.FILL);
        paint_white.setDither(true);
        paint_white.setColor(0xff000000);
        path_white.addCircle(mCenterX, mCenterY, 5, Path.Direction.CCW);
        canvas.drawPath(path_white, paint_white);

        Paint paint_stroke = new Paint();
        Path path_stroke = new Path();
        paint_stroke.setAntiAlias(true);
        paint_stroke.setStyle(Paint.Style.STROKE);
        paint_stroke.setDither(true);
        paint_stroke.setStrokeWidth(5f);
        paint_stroke.setColor(0xff654321);
        path_stroke.addCircle(mCenterX, mCenterY, mCircleSize - 25, Path.Direction.CCW);
        canvas.drawPath(path, paint);
    }
}
