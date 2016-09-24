package com.depromeet.bread.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by 권윤환 on 2016-09-14.
 */
public class MyAdapter extends BaseAdapter {
    ArrayList<ItemData> items = new ArrayList<ItemData>();
    Context mContext;

    public MyAdapter( Context context){
        mContext = context;
    }

    public void add(ItemData item){
        items.add(item);
        notifyDataSetChanged();
    }

    //추상메소드 구현
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position){
        return items.get(position);

    }

    @Override //유니크한 값을 넘겨준다.
    public long getItemId(int position) {
        return position;
    }

    @Override //
    public View getView(int position, View convertView, ViewGroup parent){
        ItemView v;
        if(convertView == null){
            v = new ItemView(mContext);
        } else {
            v = (ItemView)convertView;
        }
        v.setItemData(items.get(position));
        return v;
    }

}
