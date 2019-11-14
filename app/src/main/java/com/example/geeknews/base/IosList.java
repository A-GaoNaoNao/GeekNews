package com.example.geeknews.base;

import java.util.List;

public class IosList {

    /**
     * error : false
     * results : [{"_id":"5d3565f99d21220321462172","createdAt":"2019-07-22T07:30:01.656Z","desc":"一个uber推出的UI截图unit test的framework","publishedAt":"2019-07-22T08:09:35.536Z","source":"web","type":"iOS","url":"https://github.com/uber/ios-snapshot-test-case/","used":true,"who":"SwiftyWang"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5d3565f99d21220321462172
         * createdAt : 2019-07-22T07:30:01.656Z
         * desc : 一个uber推出的UI截图unit test的framework
         * publishedAt : 2019-07-22T08:09:35.536Z
         * source : web
         * type : iOS
         * url : https://github.com/uber/ios-snapshot-test-case/
         * used : true
         * who : SwiftyWang
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
