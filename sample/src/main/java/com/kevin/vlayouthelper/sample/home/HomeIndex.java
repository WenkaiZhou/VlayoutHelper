package com.kevin.vlayouthelper.sample.home;

import com.kevin.loopview.internal.LoopData;

import java.util.List;

/**
 * Created by zhouwenkai on 2017/5/1.
 */

public class HomeIndex {
    public LoopData loopData;

    public List<HotPoint> hotPoint;

    public RecommendTitle recommendTitle;

    public List<Recommend> recommend;


    public class HotPoint {
        public String imgUrl;
        public String name;
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

