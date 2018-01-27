package com.mvvm.gionee.mvvmdemo.data;

import android.widget.ImageView;

import java.util.List;

/**
 * Created by sulc on 2018/1/17.
 */

public class GirlsData {

    private String tag1;
    private String tag2;
    private int totalNum;
    private int start_index;
    private int return_number;
    private List<ResultsBean> data;

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getStart_index() {
        return start_index;
    }

    public void setStart_index(int start_index) {
        this.start_index = start_index;
    }

    public int getReturn_number() {
        return return_number;
    }

    public void setReturn_number(int return_number) {
        this.return_number = return_number;
    }

    public List<ResultsBean> getData() {
        return data;
    }

    public void setData(List<ResultsBean> data) {
        this.data = data;
    }

    public  class ResultsBean{
        private String id;
        private String setId;
        private int pn;
        private String abs;
        private String desc;
       // private String tags;
        private String tag;
        private String date;
        private String image_url;
        private int image_width;
        private int image_height;
        private String download_url;
        private String thumbnail_url;
        private int thumbnail_width;
        private int thumbnail_height;
        private int thumb_large_width;
        private int thumb_large_height;
        private String thumb_large_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSetId() {
            return setId;
        }

        public void setSetId(String setId) {
            this.setId = setId;
        }

        public int getPn() {
            return pn;
        }

        public void setPn(int pn) {
            this.pn = pn;
        }

        public String getAbs() {
            return abs;
        }

        public void setAbs(String abs) {
            this.abs = abs;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }



        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public int getImage_width() {
            return image_width;
        }

        public void setImage_width(int image_width) {
            this.image_width = image_width;
        }

        public int getImage_height() {
            return image_height;
        }

        public void setImage_height(int image_height) {
            this.image_height = image_height;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public String getThumbnail_url() {
            return thumbnail_url;
        }

        public void setThumbnail_url(String thumbnail_url) {
            this.thumbnail_url = thumbnail_url;
        }

        public int getThumbnail_width() {
            return thumbnail_width;
        }

        public void setThumbnail_width(int thumbnail_width) {
            this.thumbnail_width = thumbnail_width;
        }

        public int getThumbnail_height() {
            return thumbnail_height;
        }

        public void setThumbnail_height(int thumbnail_height) {
            this.thumbnail_height = thumbnail_height;
        }

        public int getThumb_large_width() {
            return thumb_large_width;
        }

        public void setThumb_large_width(int thumb_large_width) {
            this.thumb_large_width = thumb_large_width;
        }

        public int getThumb_large_height() {
            return thumb_large_height;
        }

        public void setThumb_large_height(int thumb_large_height) {
            this.thumb_large_height = thumb_large_height;
        }

        public String getThumb_large_url() {
            return thumb_large_url;
        }

        public void setThumb_large_url(String thumb_large_url) {
            this.thumb_large_url = thumb_large_url;
        }
    }

    @Override
    public String toString() {
        return "GirlsData{" +
                "tag1='" + tag1 + '\'' +
                ", tag2='" + tag2 + '\'' +
                ", totalNum=" + totalNum +
                ", start_index=" + start_index +
                ", return_number=" + return_number +
                ", data=" + data +
                '}';
    }
}
