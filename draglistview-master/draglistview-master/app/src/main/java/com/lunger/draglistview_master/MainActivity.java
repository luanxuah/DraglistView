package com.lunger.draglistview_master;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lunger on 8/17 2016 11:21
 */
public class MainActivity extends AppCompatActivity {

    private DragListView mDragListView;
    private List<TitleData> titleDataList;
    private List<CompositeData> compositeDataList;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initData();
        initDragListView();

    }

    private void findView() {
        mDragListView = (DragListView) findViewById(R.id.lv);
    }

    private void initData() {
        titleDataList = new ArrayList<TitleData>();
        for (int i=0;i<5;i++){
            TitleData titleData = new TitleData();
            List<ItemData> itemDataList = new ArrayList<ItemData>();
            for (int j=0; j<3; j++){
                ItemData itemData = new ItemData();
                itemData.setData("item            "+j);
                itemDataList.add(itemData);
            }
            titleData.setTitie("title      "+i);
            titleData.setItemDataList(itemDataList);
            titleData.setSpread(true);
            titleDataList.add(titleData);
        }

        changeData();
    }

    private void setSpread(int titlePosition){
        TitleData titleData = titleDataList.get(titlePosition);
        titleDataList.get(titlePosition).setSpread(!titleData.isSpread());
        changeData();
    }

    private void changeData(){
        compositeDataList = new ArrayList<CompositeData>();
        for (int i=0; i<titleDataList.size(); i++){
            TitleData titleData = titleDataList.get(i);
            CompositeData compositetitle = new CompositeData();
            compositetitle.setTitle(titleData.getTitie());
            compositetitle.setIsTitle(true);
            compositetitle.setTitlePosition(i);
            compositetitle.setItemPosition(-1);
            compositetitle.setSize(titleData.getItemDataList().size());
            compositeDataList.add(compositetitle);

            List<ItemData> itemDataList = titleData.getItemDataList();
            if (titleData.isSpread() && itemDataList!=null && itemDataList.size()>0){
                for (int j=0; j<itemDataList.size(); j++){
                    ItemData itemData = itemDataList.get(j);
                    CompositeData compositeItem = new CompositeData();
                    compositeItem.setData(itemData.getData());
                    compositeItem.setIsTitle(false);
                    compositeItem.setTitlePosition(i);
                    compositeItem.setItemPosition(j);
                    compositeDataList.add(compositeItem);
                }
            }
        }
        if (adapter != null){
            adapter.setData(compositeDataList);
        }
    }
    private void initDragListView() {
        adapter = new MyAdapter(this, compositeDataList);
        mDragListView.setDragListAdapter(adapter);
        //设置点击item哪个部位可触发拖拽（可不设置，默认是item任意位置长按可拖拽）
        mDragListView.setDragger(R.id.iv_item);
        //设置item悬浮背景色
        mDragListView.setItemFloatColor(R.color.color_dcdcdc, Color.WHITE);
        //设置item悬浮透明度
        mDragListView.setItemFloatAlpha(0.65f);
        //设置拖拽响应回调
        mDragListView.setMyDragListener(new DragListView.MyDragListener() {
            @Override
            public void onDragFinish(int srcPositon, int finalPosition) {
                if (finalPosition!=0){
                    Log.i("doctorlog","list=                    "+compositeDataList.toString());
                    CompositeData compositeData = compositeDataList.get(finalPosition);
                    CompositeData topCompositionData = compositeDataList.get(finalPosition-1);
                    int startTitlePosition = compositeData.getTitlePosition();
                    int startItemPosition = compositeData.getItemPosition();

                    int endTitlePositon = topCompositionData.getTitlePosition();
                    int endItemPosition = topCompositionData.getItemPosition()+1;

                    ItemData titleData = titleDataList.get(startTitlePosition).getItemDataList().get(startItemPosition);

                    if (srcPositon>finalPosition){
                        //向上移动
                        titleDataList.get(startTitlePosition).getItemDataList().remove(startItemPosition);
                        titleDataList.get(endTitlePositon).getItemDataList().add(endItemPosition, titleData);
                        changeData();
                    }else if (srcPositon<finalPosition){
                        //向下移动
                        titleDataList.get(endTitlePositon).getItemDataList().add(endItemPosition, titleData);
                        titleDataList.get(startTitlePosition).getItemDataList().remove(startItemPosition);
                        changeData();
                    }
                }else{
                    changeData();
                }
            }
        });

        mDragListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CompositeData compositeData = compositeDataList.get(i);
                if (compositeData.isTitle()){
                    setSpread(compositeData.getTitlePosition());
                }
            }
        });
    }


}
