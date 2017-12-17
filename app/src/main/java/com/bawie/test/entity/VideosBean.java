package com.bawie.test.entity;

import java.util.List;

/**
 * 获取视频列表作品
 */

public class VideosBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151332147980820171215150428.jpg","createTime":"2017-12-15T15:04:39","favoriteNum":0,"latitude":"40.040443","localUri":null,"longitude":"116.300159","playNum":null,"praiseNum":1,"uid":188,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/188.jpg","nickname":"muzi","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513321479808video_20171215_150419.mp4","wid":220,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1513320695418avator_thump.jpg","createTime":"2017-12-15T14:51:35","favoriteNum":1,"latitude":"40.040438843506415","localUri":null,"longitude":"116.30001389784546","playNum":null,"praiseNum":1,"uid":148,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512179089975avator_thump.jpg","nickname":"李灿灿","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513320695418PictureSelector_20171206_115353.mp4","wid":219,"workDesc":"cc"},{"commentNum":1,"comments":[{"cid":50,"content":"亚麻得","createTime":"2017-12-15T14:52:37","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":218}],"cover":"https://www.zhaoapi.cn/images/quarter/1513248624521cover.jpg","createTime":"2017-12-14T18:50:24","favoriteNum":1,"latitude":"101","localUri":null,"longitude":"102","playNum":null,"praiseNum":3,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/154.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513248624521PictureSelector_20171214_184937.mp4","wid":218,"workDesc":"111"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1513248516975cover.jpg","createTime":"2017-12-14T18:48:36","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":null,"praiseNum":0,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/154.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513248516975VID20171209110001.mp4","wid":217,"workDesc":"111"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1513248485631cover.jpg","createTime":"2017-12-14T18:48:05","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":null,"praiseNum":1,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/154.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513248485631VID20171209110001.mp4","wid":216,"workDesc":"111"},{"commentNum":5,"comments":[{"cid":27,"content":"nihao","createTime":"2017-12-14T15:54:58","jid":null,"mvp":null,"nickname":"muzi","praiseNum":0,"uid":188,"wid":215},{"cid":28,"content":"nihao","createTime":"2017-12-14T15:55:04","jid":null,"mvp":null,"nickname":"muzi","praiseNum":0,"uid":188,"wid":215},{"cid":29,"content":"%E7%9C%9F%E6%A3%92","createTime":"2017-12-14T16:05:27","jid":null,"mvp":null,"nickname":"beautiful","praiseNum":0,"uid":170,"wid":215},{"cid":33,"content":"%E7%9C%9F%E6%A3%92","createTime":"2017-12-14T16:07:16","jid":null,"mvp":null,"nickname":"beautiful","praiseNum":0,"uid":170,"wid":215},{"cid":36,"content":"%E3%80%82%E3%80%82%E3%80%82","createTime":"2017-12-14T16:51:49","jid":null,"mvp":null,"nickname":"nnnnnn","praiseNum":0,"uid":195,"wid":215}],"cover":"https://www.zhaoapi.cn/images/quarter/151323769211520171214154759.jpg","createTime":"2017-12-14T15:48:12","favoriteNum":0,"latitude":"100","localUri":null,"longitude":"100","playNum":null,"praiseNum":1,"uid":195,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512470827115mo.jpg","nickname":"nnnnnn","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513237692115video_20171214_154742.mp4","wid":215,"workDesc":""},{"commentNum":7,"comments":[{"cid":24,"content":"%0A%0A1123","createTime":"2017-12-14T15:32:01","jid":null,"mvp":null,"nickname":"beautiful","praiseNum":0,"uid":170,"wid":214},{"cid":25,"content":"123","createTime":"2017-12-14T15:34:59","jid":null,"mvp":null,"nickname":"beautiful","praiseNum":0,"uid":170,"wid":214},{"cid":26,"content":"%E7%9C%9F%E6%A3%92","createTime":"2017-12-14T15:46:19","jid":null,"mvp":null,"nickname":"beautiful","praiseNum":0,"uid":170,"wid":214},{"cid":34,"content":"11111","createTime":"2017-12-14T16:09:55","jid":null,"mvp":null,"nickname":"%E6%9E%97","praiseNum":0,"uid":114,"wid":214},{"cid":37,"content":"我叫李英杰","createTime":"2017-12-14T19:30:28","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":214},{"cid":39,"content":"可以","createTime":"2017-12-14T19:40:58","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":214},{"cid":40,"content":"你好","createTime":"2017-12-14T19:43:45","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":214}],"cover":"https://www.zhaoapi.cn/images/quarter/1513234411506cover.jpg","createTime":"2017-12-14T14:53:31","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":null,"praiseNum":4,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/154.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15132344115061512641947426.mp4","wid":214,"workDesc":"  "},{"commentNum":7,"comments":[{"cid":30,"content":"%E7%9C%9F%E6%A3%92","createTime":"2017-12-14T16:05:36","jid":null,"mvp":null,"nickname":"beautiful","praiseNum":0,"uid":170,"wid":213},{"cid":35,"content":"傻屌发的！！！！！","createTime":"2017-12-14T16:10:15","jid":null,"mvp":null,"nickname":"%E6%9E%97","praiseNum":0,"uid":114,"wid":213},{"cid":38,"content":"好了","createTime":"2017-12-14T19:37:35","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":213},{"cid":41,"content":"你好","createTime":"2017-12-14T19:45:57","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":213},{"cid":42,"content":"你好","createTime":"2017-12-14T19:49:11","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":213},{"cid":43,"content":"你好","createTime":"2017-12-14T19:51:30","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":213},{"cid":49,"content":"我爱你","createTime":"2017-12-15T14:51:21","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":213}],"cover":"https://www.zhaoapi.cn/images/quarter/1513234294943cover.jpg","createTime":"2017-12-14T14:51:34","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":null,"praiseNum":3,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/154.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15132342949431512641561189.mp4","wid":213,"workDesc":"   "},{"commentNum":2,"comments":[{"cid":19,"content":"%E7%9C%9F%E6%A3%92","createTime":"2017-12-13T16:52:08","jid":null,"mvp":null,"nickname":"beautiful","praiseNum":0,"uid":170,"wid":212},{"cid":31,"content":"qqqqqq","createTime":"2017-12-14T16:06:37","jid":null,"mvp":null,"nickname":"beautiful","praiseNum":0,"uid":170,"wid":212}],"cover":"https://www.zhaoapi.cn/images/quarter/151314875206820171213150520.jpg","createTime":"2017-12-13T15:05:52","favoriteNum":1,"latitude":"40.040602","localUri":null,"longitude":"116.300029","playNum":null,"praiseNum":3,"uid":3028,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513148630412image.jpg","nickname":"14","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513148752068sccvideo.mp4","wid":212,"workDesc":null},{"commentNum":1,"comments":[{"cid":21,"content":"%E7%9C%9F%E6%A3%92","createTime":"2017-12-13T16:56:14","jid":null,"mvp":null,"nickname":"beautiful","praiseNum":0,"uid":170,"wid":211}],"cover":"https://www.zhaoapi.cn/images/quarter/151314874774020171213150520.jpg","createTime":"2017-12-13T15:05:47","favoriteNum":0,"latitude":"40.040602","localUri":null,"longitude":"116.300029","playNum":null,"praiseNum":1,"uid":3028,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513148630412image.jpg","nickname":"14","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513148747740sccvideo.mp4","wid":211,"workDesc":null}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/151332147980820171215150428.jpg
         * createTime : 2017-12-15T15:04:39
         * favoriteNum : 0
         * latitude : 40.040443
         * localUri : null
         * longitude : 116.300159
         * playNum : null
         * praiseNum : 1
         * uid : 188
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/188.jpg","nickname":"muzi","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1513321479808video_20171215_150419.mp4
         * wid : 220
         * workDesc :
         */

        public int commentNum;
        public String cover;
        public String createTime;
        public int favoriteNum;
        public String latitude;
        public Object localUri;
        public String longitude;
        public Object playNum;
        public int praiseNum;
        public int uid;
        public UserBean user;
        public String videoUrl;
        public int wid;
        public String workDesc;
        public List<?> comments;

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/188.jpg
             * nickname : muzi
             * praiseNum : null
             */

            public Object age;
            public String fans;
            public boolean follow;
            public String icon;
            public String nickname;
            public String praiseNum;
        }
    }
}
