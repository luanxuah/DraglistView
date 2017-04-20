package com.lunger.draglistview_master;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/**
 * @author: luanxu
 * @createTime: on 2017/4/19 14:59
 * @className:
 * @description:
 * @changed by:
 */
class MyAdapter extends DragListAdapter {

    private int TITLE = 111;

    private int ITEM = 222;

    private MainActivity context;

    private List<CompositeData> compositeDataList;

    public MyAdapter(MainActivity context,List<CompositeData> compositeDataList){
        super(context, compositeDataList);
        this.context = context;
        this.compositeDataList = compositeDataList;
    }

    @Override
    public void setData(List arrayTitles) {
        super.setData(arrayTitles);
        this.compositeDataList = arrayTitles;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.drag_list_item, null);
            viewHolder.ll_title = (LinearLayout) convertView.findViewById(R.id.ll_title);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.size = (TextView) convertView.findViewById(R.id.size);
            viewHolder.ll_item = (LinearLayout) convertView.findViewById(R.id.ll_item);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.iv_item = (ImageView) convertView.findViewById(R.id.iv_item);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final CompositeData compositeData = compositeDataList.get(position);
        if (compositeData.isTitle()){
            viewHolder.ll_title.setVisibility(View.VISIBLE);
            viewHolder.ll_item.setVisibility(View.GONE);
            viewHolder.iv_item.setVisibility(View.GONE);
            viewHolder.title.setText(compositeData.getTitle());
            viewHolder.size.setText(compositeData.getSize()+"");
        }else{
            viewHolder.ll_title.setVisibility(View.GONE);
            viewHolder.ll_item.setVisibility(View.VISIBLE);
            viewHolder.iv_item.setVisibility(View.VISIBLE);
            viewHolder.tv_name.setText(compositeData.getData());
        }
        return convertView;
    }

    static class ViewHolder{
        LinearLayout ll_title;
        TextView title;
        TextView size;
        LinearLayout ll_item;
        TextView tv_name;
        ImageView iv_item;
    }

    @Override
    public int getCount() {
        return compositeDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return compositeDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
