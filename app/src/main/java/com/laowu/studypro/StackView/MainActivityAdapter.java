package com.laowu.studypro.StackView;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.laowu.studypro.Main.MainListItem;
import com.laowu.studypro.Main.MyBaseAdapter;
import com.laowu.studypro.R;

import java.util.List;

/**
 * Created by laowu on 2016/11/10.
 */
public class MainActivityAdapter extends MyBaseAdapter {

    public MainActivityAdapter(Context context, List mdata) {
        super(context, mdata);
    }

    @Override
    protected View createAdapterView() {
        return mInflater.inflate(R.layout.adapter_main, null);
    }

    private class MyViewHolder extends BaseViewHolder {
        TextView name;
        TextView info;
    }

    @Override
    protected BaseViewHolder createrViewHolder(View view) {
        MyViewHolder viewHolder = new MyViewHolder();
        viewHolder.name = (TextView) view.findViewById(R.id.name);
        viewHolder.info = (TextView) view.findViewById(R.id.info);
        return viewHolder;
    }

    @Override
    protected void buildData(BaseViewHolder viewHolder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        MainListItem item = (MainListItem) mdata.get(position);
        myViewHolder.name.setText(item.getName());
        myViewHolder.info.setText(item.getInfo());
    }
}
