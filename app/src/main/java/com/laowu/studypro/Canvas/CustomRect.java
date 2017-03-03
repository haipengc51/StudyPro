package com.laowu.studypro.Canvas;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by LaoWu on 2017/3/3.
 */

public class CustomRect extends View {
    private ArrayList<String> mPointList;
    private int mWidth;
    private int mHeight;
    private int mRectWidth;
    private int mRectHeight;
    private Paint mPint;
    private int[] colors = new int[]{0x12345678, 0x11111111, 0x22222222, 0x33333333, 0x44444444, 0x55555555};
    //圆角柱状体4个角的值
    private float[] radii = { 12f, 12f, 12f, 12f, 0f, 0f, 0f, 0f };
    private String mLevel;  //画的L1-L3 字样
    private String mName;   //画的初级，高级，专家字样
    private static float mToY = 15f; //小于1,整体往下移动;大于1，整体往上移动
    private static float mRectY = 4;//往1方向，矩形长度拉长，往10方向，矩形长度缩短

    public CustomRect(Context context) {
        super(context);
    }

    public CustomRect(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomRect(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPointList = new ArrayList<String>();
        mWidth = canvas.getWidth();
        mHeight = canvas.getHeight();
        mRectWidth = (int) (mWidth/9.5);
        mRectHeight = mHeight/2;
        for (int i=0; i<6; i++) {
            initBitmaps(canvas, i);
        }
    }

    private void initBitmaps(Canvas canvas, int index) {
        mPint = new Paint();
        mPint.setAntiAlias(true);
        mPint.setStyle(Paint.Style.FILL);
        mPint.setStrokeWidth(30f);
        mPint.setDither(true);
        mPint.setColor(colors[index]);

        Path path = new Path();
        int width = (int) (mRectWidth / 2 + (index * mRectWidth * 1.5));
        int height_top = (int) (mRectHeight + (mRectHeight / 15) * (6 - index) + mRectWidth * 1.5);
        int height_bootom = height_top - mRectHeight / 10 + (mRectHeight / 15) * index;
        height_top = (int) (height_top - mRectHeight / mRectY);
        path.addRoundRect(new RectF(width, height_top, width + mRectWidth, height_bootom), radii
                , Path.Direction.CCW);

        canvas.drawPath(path, mPint);

        String RectX = String.valueOf(width + mRectWidth / 2);
        String RectY = String.valueOf(height_top);
        mPointList.add(RectX + "-" + RectY);

        Path path1 = new Path();
        path1.addRoundRect(new RectF(width, height_bootom + 10, width + mRectWidth, height_bootom + 12), radii,
                Path.Direction.CCW);
        switch (index) {
            case 0:
                mLevel = "L1-L3";
                mName = "入门";
                break;
            case 1:
                mLevel = "L4-L6";
                mName = "初级";
                break;
            case 2:
                mLevel = "L7-L9";
                mName = "中级";
                break;
            case 3:
                mLevel = "L10-12";
                mName = "中高级";
                break;
            case 4:
                mLevel = "L13-L15";
                mName = "高级";
                break;
            case 5:
                mLevel = "L16";
                mName = "专家";
                break;
            default:
                break;
        }
        drawLevel(canvas, index, width, height_bootom, mLevel);
        drawText(canvas, index, width, height_bootom, mName);
    }

    private void drawText(Canvas canvas, int index, int width, int height_bootom, String name) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);
        paint.setStrokeWidth(30f);
        paint.setColor(0x66666666);
        paint.setTextSize(30);
        canvas.drawText(name, width+mRectWidth/5, height_bootom+100, paint);
    }

    private void drawLevel(Canvas canvas, int index, int width, int height_bottom, String level) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(30f);
        paint.setColor(0x77777777);
        paint.setTextSize(30);
        if(index ==5){
            canvas.drawText(level , width+mRectWidth/4, height_bottom+60, paint);
        }else if(index == 4 || index ==3 ){
            canvas.drawText(level , width+mRectWidth/20, height_bottom+60, paint);
        }else{
            canvas.drawText(level , width+mRectWidth/6, height_bottom+60, paint);
        }
    }

    public ArrayList<String> getPointList() {
        return mPointList;
    }

    public void setPointList(ArrayList<String> mPointList) {
        this.mPointList = mPointList;
    }
}
