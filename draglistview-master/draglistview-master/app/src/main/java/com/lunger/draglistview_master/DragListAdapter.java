package com.lunger.draglistview_master;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/**
 * Created by Lunger on 8/17 2016 11:21
 */
public class DragListAdapter extends BaseAdapter {
    private List mDatas;

    private Context context;

    public DragListAdapter(Context context, List arrayTitles) {
        this.context = context;
        this.mDatas = arrayTitles;
    }

    public void setData(List arrayTitles){
        this.mDatas = arrayTitles;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        return null;
    }

    /***
     * 动态修改ListVIiw的方位.（数据移位）
     * 子类不要复写改方法
     * @param start 点击移动的position
     * @param end   松开时候的position
     */
    public <T> void update(int start, int end) {
        T data = (T) mDatas.get(start);
        mDatas.remove(start);// ???????
        mDatas.add(end, data);// ????????
        notifyDataSetChanged();// ???ListView
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
