package com.kevin.vlayouthelper.sample.home;

import com.google.gson.annotations.SerializedName;
import com.kevin.loopview.internal.LoopData;

import java.util.List;

/**
 * Created by zhouwenkai on 2017/5/1.
 */

public class HomeIndex {

    @SerializedName("loop_data")
    public LoopData loopData;

    public Broadcast broadcast;

    @SerializedName("hot_point")
    public List<HotPoint> hotPoint;

    @SerializedName("divider_line")
    public DividerLine dividerLine;



    public RecommendTitle recommendTitle;

    public List<Recommend> recommend;


    public class Broadcast {
        @SerializedName("title_logo_url")
        public String titleLogoUrl;

        public List<News> items;

        public class News {
            @SerializedName("news_title")
            public String newsTitle;

            public String path;
        }
    }

    public class HotPoint {
        @SerializedName("img_url")
        public String imgUrl;
        public String name;
        public String path;
    }

    public class DividerLine {
        @SerializedName("line_color")
        public String lineColor;
        @SerializedName("line_height")
        public int lineHeight;
    }

    public class RecommendTitle {
        public String imgUrl;
    }

    public class Recommend {
        public String imgUrl;
        public String title;
        public String subTitle;
        public int height;
    }
}

