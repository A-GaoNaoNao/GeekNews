package com.example.geeknews.base;

import java.util.List;

public class BannerList {

    /**
     * date : 20191105
     * stories : [{"image_hue":"0x554027","title":"《少年的你》中陈念和小北按照法律应该判几年刑？","url":"https://daily.zhihu.com/story/9717030","hint":"蔡思斌 · 3 分钟阅读","ga_prefix":"110509","images":["https://pic1.zhimg.com/v2-4d5b2489026d07c2958db75bf889b090.jpg"],"type":0,"id":9717030},{"image_hue":"0x4f515c","title":"四大泳姿是人类游泳的最优姿势吗？","url":"https://daily.zhihu.com/story/9716797","hint":"蓝星上的喵 · 1 分钟阅读","ga_prefix":"110507","images":["https://pic1.zhimg.com/v2-a8745cefb27d53268187ff985b7aacd0.jpg"],"type":0,"id":9716797},{"image_hue":"0xcec591","title":"瞎扯 · 如何正确地吐槽","url":"https://daily.zhihu.com/story/9717020","hint":"VOL.2254","ga_prefix":"110506","images":["https://pic2.zhimg.com/v2-d2da3981b3e904ea66dd3621bfb7f219.jpg"],"type":0,"id":9717020}]
     * top_stories : [{"image_hue":"0x97a4ae","hint":"作者 / 陈大可","url":"https://daily.zhihu.com/story/9716567","image":"https://pic3.zhimg.com/v2-3458c80a7eaa1f47f3869e30848f0dc6.jpg","title":"如何看待非全日制研究生受到的就业歧视？","ga_prefix":"110320","type":0,"id":9716567},{"image_hue":"0xe0ddc6","hint":"作者 / Jianfeng","url":"https://daily.zhihu.com/story/9716793","image":"https://pic1.zhimg.com/v2-db3d89c7c4b8025d25895d293f90c7fc.jpg","title":"未来 20 年，中国能否成为向世界提供平价药品的主要国家？","ga_prefix":"110307","type":0,"id":9716793},{"image_hue":"0xe1e1e1","hint":"作者 / Cecilia","url":"https://daily.zhihu.com/story/9717009","image":"https://pic3.zhimg.com/v2-b31c56ec6f512cf19f0246a4d1a371d6.jpg","title":"「30 岁，买个 AirPods Pro 要纠结好久」","ga_prefix":"110116","type":0,"id":9717009},{"image_hue":"0x9c9b42","hint":"作者 / Mr-HH","url":"https://daily.zhihu.com/story/9716617","image":"https://pic4.zhimg.com/v2-b1663d2b817b9c228d171c0db7b5f5fb.jpg","title":"除了视觉，动物界还有哪些用来感知周围世界的奇妙能力？","ga_prefix":"103109","type":0,"id":9716617},{"image_hue":"0x5d5972","hint":"作者 / 司马懿","url":"https://daily.zhihu.com/story/9716757","image":"https://pic3.zhimg.com/v2-8aaba25dc02350f445218f08377988ee.jpg","title":"区块链如何发挥国家战略层面的核心技术作用，将带来哪些利好？","ga_prefix":"102816","type":0,"id":9716757}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * image_hue : 0x554027
         * title : 《少年的你》中陈念和小北按照法律应该判几年刑？
         * url : https://daily.zhihu.com/story/9717030
         * hint : 蔡思斌 · 3 分钟阅读
         * ga_prefix : 110509
         * images : ["https://pic1.zhimg.com/v2-4d5b2489026d07c2958db75bf889b090.jpg"]
         * type : 0
         * id : 9717030
         */

        private String image_hue;
        private String title;
        private String url;
        private String hint;
        private String ga_prefix;
        private int type;
        private int id;
        private List<String> images;

        public String getImage_hue() {
            return image_hue;
        }

        public void setImage_hue(String image_hue) {
            this.image_hue = image_hue;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image_hue : 0x97a4ae
         * hint : 作者 / 陈大可
         * url : https://daily.zhihu.com/story/9716567
         * image : https://pic3.zhimg.com/v2-3458c80a7eaa1f47f3869e30848f0dc6.jpg
         * title : 如何看待非全日制研究生受到的就业歧视？
         * ga_prefix : 110320
         * type : 0
         * id : 9716567
         */

        private String image_hue;
        private String hint;
        private String url;
        private String image;
        private String title;
        private String ga_prefix;
        private int type;
        private int id;

        public String getImage_hue() {
            return image_hue;
        }

        public void setImage_hue(String image_hue) {
            this.image_hue = image_hue;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

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

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
