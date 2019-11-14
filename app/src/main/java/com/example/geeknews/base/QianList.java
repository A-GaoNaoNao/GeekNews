package com.example.geeknews.base;

import java.util.List;

public class QianList {

    /**
     * error : false
     * results : [{"_id":"5da7df089d212267f5ba606a","createdAt":"2019-10-17T03:24:56.217Z","desc":"类似微信(WeChat)表情选择的React-Native库","publishedAt":"2019-11-08T02:54:39.163Z","source":"web","type":"前端","url":"https://github.com/hewking/react-native-sticker-picker","used":true,"who":"bym"}]
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
         * _id : 5da7df089d212267f5ba606a
         * createdAt : 2019-10-17T03:24:56.217Z
         * desc : 类似微信(WeChat)表情选择的React-Native库
         * publishedAt : 2019-11-08T02:54:39.163Z
         * source : web
         * type : 前端
         * url : https://github.com/hewking/react-native-sticker-picker
         * used : true
         * who : bym
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
