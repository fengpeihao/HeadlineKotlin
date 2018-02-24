package com.fph.headlinekotlin.ui.usercenter.bean;

import java.util.List;

/**
 * Created by fengpeihao on 2018/1/12.
 */

public class test {

    private String stat;
    private String info;
    private String endkey;
    private String newkey;
    private List<DataBean> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEndkey() {
        return endkey;
    }

    public void setEndkey(String endkey) {
        this.endkey = endkey;
    }

    public String getNewkey() {
        return newkey;
    }

    public void setNewkey(String newkey) {
        this.newkey = newkey;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * additional : {}
         * bigpic : 0
         * comment_count : 1
         * content :
         * date : 2018-01-12 17:16
         * desc :
         * dfh_headpic : http://00.imgmini.eastday.com/dcminisite/portrait/cf879afda911ce605b550dc97fa57709.jpg
         * dfh_nickname : 一日不读书
         * dfh_uid : 200000000034144
         * duanzi : 0
         * filesize : 0
         * hiddendate : 0
         * hotnews : 1
         * isJian : 0
         * isactivity : 0
         * isadv : 0
         * isliveshow : 0
         * islunb : 0
         * isnxw : 0
         * isoriginal : 0
         * ispicnews : 0
         * isrecom : 0
         * issptopic : 0
         * istuji : 0
         * isvideo : 0
         * kwds : []
         * lbimg : [{"alt":"","describe":"","imgheight":275,"imgname":"20180112_e25f6767948808dccb7b3d2650d18e68_mwpl_05500201.jpg","imgwidth":550,"src":"http://09.imgmini.eastday.com/mobile/20180112/20180112_e25f6767948808dccb7b3d2650d18e68_mwpl_05500201.jpg"}]
         * miniimg : [{"alt":"","describe":"","imgheight":240,"imgname":"20180112_e25f6767948808dccb7b3d2650d18e68_mwpm_03200403.jpg","imgwidth":320,"src":"http://09.imgmini.eastday.com/mobile/20180112/20180112_e25f6767948808dccb7b3d2650d18e68_mwpm_03200403.jpg"},{"alt":"","describe":"","imgheight":240,"imgname":"20180112_197adce9c0790f5bfe45e2794225621d_mwpm_03200403.jpg","imgwidth":320,"src":"http://09.imgmini.eastday.com/mobile/20180112/20180112_197adce9c0790f5bfe45e2794225621d_mwpm_03200403.jpg"},{"alt":"","describe":"","imgheight":240,"imgname":"20180112_78f13ea9ef4b5bfe45ae8e68f829f7ff_mwpm_03200403.jpg","imgwidth":320,"src":"http://09.imgmini.eastday.com/mobile/20180112/20180112_78f13ea9ef4b5bfe45ae8e68f829f7ff_mwpm_03200403.jpg"}]
         * miniimg_size : 3
         * newsidx : 0
         * nodownvote : 0
         * noupvote : 0
         * npvtype : 0
         * pageidx : 0
         * picnums : 4
         * praisecnt : 9
         * preload : 1
         * quality : 0
         * recommendtype : -1_163eb17f2aa18778_1_1
         * recommendurl :
         * rowkey : 9223370521124977591
         * shareurl : https://mini.eastday.com/wechat/180112120318216.html
         * source : 一日不读书
         * subtype : shehuiqiwen
         * suptop : 0001
         * timeliness : -1
         * titledisplay : 000000010
         * topic : 男子在宠物店偷到蟒蛇后，居然藏在了裤裆中，店主称蟒蛇刚吃饱！
         * tramplecnt : 7
         * type : shehui
         * url : https://mini.eastday.com/mobile/180112120318216.html
         * urlfrom : dongfanghao
         * urlpv : 35527
         * video_link :
         * videoalltime : 0
         * videonews : 0
         */

        private AdditionalBean additional;
        private String bigpic;
        private String comment_count;
        private String content;
        private String date;
        private String desc;
        private String dfh_headpic;
        private String dfh_nickname;
        private String dfh_uid;
        private String duanzi;
        private String filesize;
        private String hiddendate;
        private String hotnews;
        private String isJian;
        private String isactivity;
        private String isadv;
        private String isliveshow;
        private String islunb;
        private String isnxw;
        private String isoriginal;
        private String ispicnews;
        private String isrecom;
        private String issptopic;
        private String istuji;
        private String isvideo;
        private String miniimg_size;
        private String newsidx;
        private String nodownvote;
        private String noupvote;
        private String npvtype;
        private String pageidx;
        private String picnums;
        private String praisecnt;
        private String preload;
        private String quality;
        private String recommendtype;
        private String recommendurl;
        private String rowkey;
        private String shareurl;
        private String source;
        private String subtype;
        private String suptop;
        private String timeliness;
        private String titledisplay;
        private String topic;
        private String tramplecnt;
        private String type;
        private String url;
        private String urlfrom;
        private String urlpv;
        private String video_link;
        private String videoalltime;
        private String videonews;
        private List<?> kwds;
        private List<LbimgBean> lbimg;
        private List<MiniimgBean> miniimg;

        public AdditionalBean getAdditional() {
            return additional;
        }

        public void setAdditional(AdditionalBean additional) {
            this.additional = additional;
        }

        public String getBigpic() {
            return bigpic;
        }

        public void setBigpic(String bigpic) {
            this.bigpic = bigpic;
        }

        public String getComment_count() {
            return comment_count;
        }

        public void setComment_count(String comment_count) {
            this.comment_count = comment_count;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDfh_headpic() {
            return dfh_headpic;
        }

        public void setDfh_headpic(String dfh_headpic) {
            this.dfh_headpic = dfh_headpic;
        }

        public String getDfh_nickname() {
            return dfh_nickname;
        }

        public void setDfh_nickname(String dfh_nickname) {
            this.dfh_nickname = dfh_nickname;
        }

        public String getDfh_uid() {
            return dfh_uid;
        }

        public void setDfh_uid(String dfh_uid) {
            this.dfh_uid = dfh_uid;
        }

        public String getDuanzi() {
            return duanzi;
        }

        public void setDuanzi(String duanzi) {
            this.duanzi = duanzi;
        }

        public String getFilesize() {
            return filesize;
        }

        public void setFilesize(String filesize) {
            this.filesize = filesize;
        }

        public String getHiddendate() {
            return hiddendate;
        }

        public void setHiddendate(String hiddendate) {
            this.hiddendate = hiddendate;
        }

        public String getHotnews() {
            return hotnews;
        }

        public void setHotnews(String hotnews) {
            this.hotnews = hotnews;
        }

        public String getIsJian() {
            return isJian;
        }

        public void setIsJian(String isJian) {
            this.isJian = isJian;
        }

        public String getIsactivity() {
            return isactivity;
        }

        public void setIsactivity(String isactivity) {
            this.isactivity = isactivity;
        }

        public String getIsadv() {
            return isadv;
        }

        public void setIsadv(String isadv) {
            this.isadv = isadv;
        }

        public String getIsliveshow() {
            return isliveshow;
        }

        public void setIsliveshow(String isliveshow) {
            this.isliveshow = isliveshow;
        }

        public String getIslunb() {
            return islunb;
        }

        public void setIslunb(String islunb) {
            this.islunb = islunb;
        }

        public String getIsnxw() {
            return isnxw;
        }

        public void setIsnxw(String isnxw) {
            this.isnxw = isnxw;
        }

        public String getIsoriginal() {
            return isoriginal;
        }

        public void setIsoriginal(String isoriginal) {
            this.isoriginal = isoriginal;
        }

        public String getIspicnews() {
            return ispicnews;
        }

        public void setIspicnews(String ispicnews) {
            this.ispicnews = ispicnews;
        }

        public String getIsrecom() {
            return isrecom;
        }

        public void setIsrecom(String isrecom) {
            this.isrecom = isrecom;
        }

        public String getIssptopic() {
            return issptopic;
        }

        public void setIssptopic(String issptopic) {
            this.issptopic = issptopic;
        }

        public String getIstuji() {
            return istuji;
        }

        public void setIstuji(String istuji) {
            this.istuji = istuji;
        }

        public String getIsvideo() {
            return isvideo;
        }

        public void setIsvideo(String isvideo) {
            this.isvideo = isvideo;
        }

        public String getMiniimg_size() {
            return miniimg_size;
        }

        public void setMiniimg_size(String miniimg_size) {
            this.miniimg_size = miniimg_size;
        }

        public String getNewsidx() {
            return newsidx;
        }

        public void setNewsidx(String newsidx) {
            this.newsidx = newsidx;
        }

        public String getNodownvote() {
            return nodownvote;
        }

        public void setNodownvote(String nodownvote) {
            this.nodownvote = nodownvote;
        }

        public String getNoupvote() {
            return noupvote;
        }

        public void setNoupvote(String noupvote) {
            this.noupvote = noupvote;
        }

        public String getNpvtype() {
            return npvtype;
        }

        public void setNpvtype(String npvtype) {
            this.npvtype = npvtype;
        }

        public String getPageidx() {
            return pageidx;
        }

        public void setPageidx(String pageidx) {
            this.pageidx = pageidx;
        }

        public String getPicnums() {
            return picnums;
        }

        public void setPicnums(String picnums) {
            this.picnums = picnums;
        }

        public String getPraisecnt() {
            return praisecnt;
        }

        public void setPraisecnt(String praisecnt) {
            this.praisecnt = praisecnt;
        }

        public String getPreload() {
            return preload;
        }

        public void setPreload(String preload) {
            this.preload = preload;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getRecommendtype() {
            return recommendtype;
        }

        public void setRecommendtype(String recommendtype) {
            this.recommendtype = recommendtype;
        }

        public String getRecommendurl() {
            return recommendurl;
        }

        public void setRecommendurl(String recommendurl) {
            this.recommendurl = recommendurl;
        }

        public String getRowkey() {
            return rowkey;
        }

        public void setRowkey(String rowkey) {
            this.rowkey = rowkey;
        }

        public String getShareurl() {
            return shareurl;
        }

        public void setShareurl(String shareurl) {
            this.shareurl = shareurl;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getSuptop() {
            return suptop;
        }

        public void setSuptop(String suptop) {
            this.suptop = suptop;
        }

        public String getTimeliness() {
            return timeliness;
        }

        public void setTimeliness(String timeliness) {
            this.timeliness = timeliness;
        }

        public String getTitledisplay() {
            return titledisplay;
        }

        public void setTitledisplay(String titledisplay) {
            this.titledisplay = titledisplay;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getTramplecnt() {
            return tramplecnt;
        }

        public void setTramplecnt(String tramplecnt) {
            this.tramplecnt = tramplecnt;
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

        public String getUrlfrom() {
            return urlfrom;
        }

        public void setUrlfrom(String urlfrom) {
            this.urlfrom = urlfrom;
        }

        public String getUrlpv() {
            return urlpv;
        }

        public void setUrlpv(String urlpv) {
            this.urlpv = urlpv;
        }

        public String getVideo_link() {
            return video_link;
        }

        public void setVideo_link(String video_link) {
            this.video_link = video_link;
        }

        public String getVideoalltime() {
            return videoalltime;
        }

        public void setVideoalltime(String videoalltime) {
            this.videoalltime = videoalltime;
        }

        public String getVideonews() {
            return videonews;
        }

        public void setVideonews(String videonews) {
            this.videonews = videonews;
        }

        public List<?> getKwds() {
            return kwds;
        }

        public void setKwds(List<?> kwds) {
            this.kwds = kwds;
        }

        public List<LbimgBean> getLbimg() {
            return lbimg;
        }

        public void setLbimg(List<LbimgBean> lbimg) {
            this.lbimg = lbimg;
        }

        public List<MiniimgBean> getMiniimg() {
            return miniimg;
        }

        public void setMiniimg(List<MiniimgBean> miniimg) {
            this.miniimg = miniimg;
        }

        public static class AdditionalBean {
        }

        public static class LbimgBean {
            /**
             * alt :
             * describe :
             * imgheight : 275
             * imgname : 20180112_e25f6767948808dccb7b3d2650d18e68_mwpl_05500201.jpg
             * imgwidth : 550
             * src : http://09.imgmini.eastday.com/mobile/20180112/20180112_e25f6767948808dccb7b3d2650d18e68_mwpl_05500201.jpg
             */

            private String alt;
            private String describe;
            private int imgheight;
            private String imgname;
            private int imgwidth;
            private String src;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getImgheight() {
                return imgheight;
            }

            public void setImgheight(int imgheight) {
                this.imgheight = imgheight;
            }

            public String getImgname() {
                return imgname;
            }

            public void setImgname(String imgname) {
                this.imgname = imgname;
            }

            public int getImgwidth() {
                return imgwidth;
            }

            public void setImgwidth(int imgwidth) {
                this.imgwidth = imgwidth;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }
        }

        public static class MiniimgBean {
            /**
             * alt :
             * describe :
             * imgheight : 240
             * imgname : 20180112_e25f6767948808dccb7b3d2650d18e68_mwpm_03200403.jpg
             * imgwidth : 320
             * src : http://09.imgmini.eastday.com/mobile/20180112/20180112_e25f6767948808dccb7b3d2650d18e68_mwpm_03200403.jpg
             */

            private String alt;
            private String describe;
            private int imgheight;
            private String imgname;
            private int imgwidth;
            private String src;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getImgheight() {
                return imgheight;
            }

            public void setImgheight(int imgheight) {
                this.imgheight = imgheight;
            }

            public String getImgname() {
                return imgname;
            }

            public void setImgname(String imgname) {
                this.imgname = imgname;
            }

            public int getImgwidth() {
                return imgwidth;
            }

            public void setImgwidth(int imgwidth) {
                this.imgwidth = imgwidth;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }
        }
    }
}
