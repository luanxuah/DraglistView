package com.lunger.draglistview_master;

/**
 * @author: luanxu
 * @createTime: on 2017/4/19 15:15
 * @className:
 * @description:
 * @changed by:
 */
public class CompositeData {
    private boolean isTitle;
    private String title;
    private String data;
    private int titlePosition;
    private int itemPosition;
    private int Size;
    private boolean isSpread;

    public boolean isTitle() {
        return isTitle;
    }

    public void setIsTitle(boolean title) {
        isTitle = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTitlePosition() {
        return titlePosition;
    }

    public void setTitlePosition(int titlePosition) {
        this.titlePosition = titlePosition;
    }

    public int getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public boolean isSpread() {
        return isSpread;
    }

    public void setSpread(boolean spread) {
        isSpread = spread;
    }

    @Override
    public String toString() {
        return "CompositeData{" +
                "isTitle=" + isTitle +
                ", title='" + title + '\'' +
                ", data='" + data + '\'' +
                ", titlePosition=" + titlePosition +
                ", itemPosition=" + itemPosition +
                ", Size=" + Size +
                '}';
    }
}
