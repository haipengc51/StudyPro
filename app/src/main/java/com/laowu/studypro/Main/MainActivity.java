package com.laowu.studypro.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.laowu.studypro.R;
import com.laowu.studypro.StackView.MainActivityAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by laowu on 2016/11/10.
 */
public class MainActivity extends Activity {
    @InjectView(R.id.list)
    ListView list;

    private MainActivityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        adapter = new MainActivityAdapter(this, MainListItemManager.getListItem());
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                MainListItem item = (MainListItem) ((MainActivityAdapter)parent.getAdapter()).mdata.get(position);
                Class myClass = item.getMyClass();
                intent.setClass(MainActivity.this, myClass);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
