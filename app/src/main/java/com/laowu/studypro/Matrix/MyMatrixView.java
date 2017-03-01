package com.laowu.studypro.Matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

import com.laowu.studypro.R;

/**
 * Created by laowu on 2016/11/23.
 */
public class MyMatrixView extends View {
    private Bitmap bitmap;
    private Matrix matrix = new Matrix();
    private float skew = 0.0f;
    private int width, height;
    private float scale = 1.0f;
    private boolean isScale = false;
    public MyMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);

        bitmap = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.img_1)).getBitmap();
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        this.setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        matrix.reset();
        if(!isScale) {
            matrix.setSkew(skew, 0);
        } else {
            matrix.setScale(scale, scale);
        }
        canvas.drawBitmap(bitmap, matrix, null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_A:
                isScale = false;
                skew += 0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_D:
                isScale = false;
                skew -= 0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_W:
                isScale = true;
                if(scale <2.0) {
                    scale += 0.1;
                }
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_S:
                isScale = true;
                if(scale > 0.5) {
                    scale -= 0.1;
                }
                postInvalidate();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void relece() {
//        if(bitmap != null && !bitmap.isRecycled()) {
//            bitmap.recycle();
//        }
    }
}
