package com.laowu.studypro.ActionBar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.laowu.studypro.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by laowu on 2016/11/21.
 */
public class ActionBarActivity extends Activity {
    @InjectView(R.id.show_actionbar)
    Button showActionbar;
    @InjectView(R.id.hide_actionbar)
    Button hideActionbar;

    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);
        ButterKnife.inject(this);

        actionBar = getActionBar();
    }

    @OnClick({R.id.show_actionbar, R.id.hide_actionbar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_actionbar:
                actionBar.show();
                break;
            case R.id.hide_actionbar:
                actionBar.hide();
                break;
        }
    }
}
