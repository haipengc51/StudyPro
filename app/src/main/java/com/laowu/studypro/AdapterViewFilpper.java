package com.laowu.studypro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterViewFlipper;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by laowu on 2016/11/7.
 */
public class AdapterViewFilpper extends Activity {
    private final static String KEY = "image";

    @InjectView(R.id.adapter_view_flipper)
    AdapterViewFlipper adapterViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapterviewfilpper);
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
        adapterViewFlipper.setAdapter(adapter);
    }
}
