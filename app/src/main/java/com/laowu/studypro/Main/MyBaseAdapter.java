package com.laowu.studypro.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by laowu on 2016/11/10.
 */
public abstract class MyBaseAdapter extends android.widget.BaseAdapter {
    private Context context;
    public List mdata;
    public LayoutInflater mInflater;

    protected class BaseViewHolder {

    }
    protected abstract View createAdapterView();
    protected abstract BaseViewHolder createrViewHolder(View view);
    protected abstract void buildData(BaseViewHolder viewHolder, int position);

    public MyBaseAdapter(Context context, List mdata) {
        this.context = context;
        this.mdata = mdata;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public Object getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder viewHolder;
        if(convertView == null) {
            convertView = createAdapterView();
            viewHolder = createrViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (BaseViewHolder) convertView.getTag();
        }
        buildData(viewHolder, position);
        return convertView;
    }
}
