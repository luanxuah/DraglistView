package com.lunger.draglistview_master;

import java.util.List;

/**
 * @author: luanxu
 * @createTime: on 2017/4/19 15:04
 * @className:
 * @description:
 * @changed by:
 */
public class TitleData {
    private String titie;
    private List<ItemData> itemDataList;

    private boolean isSpread;

    public String getTitie() {
        return titie;
    }

    public void setTitie(String titie) {
        this.titie = titie;
    }

    public List<ItemData> getItemDataList() {
        return itemDataList;
    }

    public void setItemDataList(List<ItemData> itemDataList) {
        this.itemDataList = itemDataList;
    }

    public boolean isSpread() {
        return isSpread;
    }

    public void setSpread(boolean spread) {
        isSpread = spread;
    }
}
