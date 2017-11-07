package com.jiyun.mvc_03a.model.enity;

import java.util.List;

/**
 * Created by xingge on 2017/10/23.
 */

public class HomeBanner {


    private List<PagelistBean> pagelist;

    public List<PagelistBean> getPagelist() {
        return pagelist;
    }

    public void setPagelist(List<PagelistBean> pagelist) {
        this.pagelist = pagelist;
    }

    public static class PagelistBean {
        /**
         * url : http://panview.ipanda.com/2016/02/26/ARTIwSApLUnYRhzv05Lh6ssd160226.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2016/02/26/2016022609351629257.jpg
         * title : 世界瞩目中国两会
         * id : ARTIwSApLUnYRhzv05Lh6ssd160226
         * daytime : 2016-02-26
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String id;
        private String daytime;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
