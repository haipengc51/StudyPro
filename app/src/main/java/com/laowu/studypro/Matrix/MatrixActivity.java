package com.laowu.studypro.Matrix;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.laowu.studypro.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by laowu on 2016/11/23.
 */
public class MatrixActivity extends Activity {
    @InjectView(R.id.myview_matrix)
    MyMatrixView myviewMatrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        ButterKnife.inject(this);

        init();
    }

    private void init() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myviewMatrix.relece();
        Log.i("liu", "MatrixActivity onDestroy");
    }
}
