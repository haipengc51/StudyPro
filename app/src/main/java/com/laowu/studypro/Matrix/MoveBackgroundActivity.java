package com.laowu.studypro.Matrix;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.laowu.studypro.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by laowu on 2016/11/23.
 */
public class MoveBackgroundActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MoveView(this));
    }
    class MoveView extends View{
        final int BACK_HEIGHT = 1700;
        private Bitmap back;
        private Bitmap plane;
        final int WIDTH = 640;
        final int HEIGHT = 880;
        private Matrix matrix = new Matrix();
        private int startY = BACK_HEIGHT - HEIGHT;
        public MoveView(Context context) {
            super(context);

            back = BitmapFactory.decodeResource(getResources(), R.drawable.img_6);
            WindowManager windowManager = getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            float screenWidth = metrics.widthPixels;
            float scale = screenWidth / WIDTH;
            matrix.setScale(scale, scale);
            plane = BitmapFactory.decodeResource(getResources(), R.drawable.img_2);
            final Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if(msg.what == 0x123) {
                        if(startY <1) {
                            startY = BACK_HEIGHT - HEIGHT;
                        }
                        startY -=1;
                    }
                    invalidate();
                }
            };
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0x123);
                }
            }, 0, 5);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap bitmap2 = Bitmap.createBitmap(back, 0, startY, WIDTH, HEIGHT, matrix, false);
            canvas.drawBitmap(bitmap2, 0, 0, null);
            canvas.drawBitmap(plane, 320, 760, null);
            super.onDraw(canvas);
        }
    }
}
