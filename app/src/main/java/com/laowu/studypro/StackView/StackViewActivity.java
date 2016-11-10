package com.laowu.studypro.StackView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;

import com.laowu.studypro.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class StackViewActivity extends Activity {
    private final static String KEY = "image";
    @InjectView(R.id.stack_view)
    android.widget.StackView stackView;
    @InjectView(R.id.btn_1)
    Button btn1;
    @InjectView(R.id.btn2)
    Button btn2;
    @InjectView(R.id.btn3)
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        int[] imgs = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4
                , R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8,
                R.drawable.img_9, R.drawable.img_10};
        List<Map<String, Integer>> items = new ArrayList<Map<String, Integer>>();
        for (int i = 0; i < imgs.length; i++) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put(KEY, imgs[i]);
            items.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, items,
                R.layout.adapter_stack_view, new String[]{KEY}, new int[]{R.id.stack_view_img});
        stackView.setAdapter(adapter);

        btn1.setOnClickListener(lisen);
        btn2.setOnClickListener(lisen);
        btn3.setOnClickListener(lisen);
    }
    private View.OnClickListener lisen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == btn1) {
                stackView.showPrevious();
            } else if (v == btn2) {

            } else if (v == btn3) {
                stackView.showNext();
            }
        }
    };
}
