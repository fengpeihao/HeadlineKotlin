package com.fph.headlinekotlin.ui.news.bean

import java.io.Serializable

/**
 * Created by fengpeihao on 2018/1/12.
 */

class NewsListBean : Serializable {

    var stat: String? = null
    var info: String? = null
    var endkey: String? = null
    var newkey: String? = null
    var data: List<DataBean>? = null

    class DataBean : Serializable {
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

        var bigpic: String? = null
        var comment_count: String? = null
        var content: String? = null
        var date: String? = null
        var desc: String? = null
        var dfh_headpic: String? = null
        var dfh_nickname: String? = null
        var dfh_uid: String? = null
        var duanzi: String? = null
        var filesize: String? = null
        var hiddendate: String? = null
        var hotnews: String? = null
        var isJian: String? = null
        var isactivity: String? = null
        var isadv: String? = null
        var isliveshow: String? = null
        var islunb: String? = null
        var isnxw: String? = null
        var isoriginal: String? = null
        var ispicnews: String? = null
        var isrecom: String? = null
        var issptopic: String? = null
        var istuji: String? = null
        var isvideo: String? = null
        var miniimg_size: String? = null
        var newsidx: String? = null
        var nodownvote: String? = null
        var noupvote: String? = null
        var npvtype: String? = null
        var pageidx: String? = null
        var picnums: String? = null
        var praisecnt: String? = null
        var preload: String? = null
        var quality: String? = null
        var recommendtype: String? = null
        var recommendurl: String? = null
        var rowkey: String? = null
        var shareurl: String? = null
        var source: String? = null
        var subtype: String? = null
        var suptop: String? = null
        var timeliness: String? = null
        var titledisplay: String? = null
        var topic: String? = null
        var tramplecnt: String? = null
        var type: String? = null
        var url: String? = null
        var urlfrom: String? = null
        var urlpv: String? = null
        var video_link: String? = null
        var videoalltime: String? = null
        var videonews: String? = null
        var kwds: List<*>? = null
        var lbimg: List<LbimgBean>? = null
        var miniimg: List<MiniimgBean>? = null

        class LbimgBean : Serializable {
            /**
             * alt :
             * describe :
             * imgheight : 275
             * imgname : 20180112_e25f6767948808dccb7b3d2650d18e68_mwpl_05500201.jpg
             * imgwidth : 550
             * src : http://09.imgmini.eastday.com/mobile/20180112/20180112_e25f6767948808dccb7b3d2650d18e68_mwpl_05500201.jpg
             */

            var alt: String? = null
            var describe: String? = null
            var imgheight: Int = 0
            var imgname: String? = null
            var imgwidth: Int = 0
            var src: String? = null
        }

        class MiniimgBean : Serializable {
            /**
             * alt :
             * describe :
             * imgheight : 240
             * imgname : 20180112_e25f6767948808dccb7b3d2650d18e68_mwpm_03200403.jpg
             * imgwidth : 320
             * src : http://09.imgmini.eastday.com/mobile/20180112/20180112_e25f6767948808dccb7b3d2650d18e68_mwpm_03200403.jpg
             */

            var alt: String? = null
            var describe: String? = null
            var imgheight: Int = 0
            var imgname: String? = null
            var imgwidth: Int = 0
            var src: String? = null
        }
    }
}
