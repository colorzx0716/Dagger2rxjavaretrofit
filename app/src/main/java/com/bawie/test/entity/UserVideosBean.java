package com.bawie.test.entity;

import java.util.List;

/**
 * 获取某个用户的视频作品集bean
 */

public class UserVideosBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151254239806820171206143946.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":146,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542398068video_20171206_143923.mp4","wid":79,"workDesc":"这次"},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151254244560020171206144014.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":146,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542445600video_20171206_143923.mp4","wid":80,"workDesc":"123"},{"commentNum":0,"cover":"https://www.zhaoapi.cn/images/quarter/151254272558420171206144516.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":146,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542725584video_20171206_144430.mp4","wid":81,"workDesc":"这次崩溃了吗？"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : 0
         * cover : https://www.zhaoapi.cn/images/quarter/151254239806820171206143946.jpg
         * createTime : 2017-12-17T19:20:44
         * favoriteNum : 0
         * latitude : 40
         * localUri : null
         * longitude : 116
         * playNum : 0
         * praiseNum : 0
         * uid : 146
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1512542398068video_20171206_143923.mp4
         * wid : 79
         * workDesc : 这次
         */

        public int commentNum;
        public String cover;
        public String createTime;
        public int favoriteNum;
        public String latitude;
        public Object localUri;
        public String longitude;
        public int playNum;
        public int praiseNum;
        public int uid;
        public String videoUrl;
        public int wid;
        public String workDesc;
    }
}
