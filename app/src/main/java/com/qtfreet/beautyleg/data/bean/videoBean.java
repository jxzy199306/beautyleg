package com.qtfreet.beautyleg.data.bean;

import java.util.List;

/**
 * Created by qtfreet00 on 2016/5/7.
 */
public class videoBean {

    private int id;
    private int groupid;
    private int modelid;
    private int no;
    private String pubdate;
    private String albumname;
    private String description;
    private String filedirectory;
    private String filename;
    private String thumbpicurl;
    private int type;
    private PhotoListMapBean photoListMap;
    private ModelBean model;
    private String sourceUrl;
    private int fileCount;
    private int worktype;
    private int zan;
    private int click;
    private int flag;
    private int storage;
    private int thumb;
    private int vip;
    private int level;
    private List<VideoListBean> videoList;
    private List<?> photoDefList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getModelid() {
        return modelid;
    }

    public void setModelid(int modelid) {
        this.modelid = modelid;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFiledirectory() {
        return filedirectory;
    }

    public void setFiledirectory(String filedirectory) {
        this.filedirectory = filedirectory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getThumbpicurl() {
        return thumbpicurl;
    }

    public void setThumbpicurl(String thumbpicurl) {
        this.thumbpicurl = thumbpicurl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public PhotoListMapBean getPhotoListMap() {
        return photoListMap;
    }

    public void setPhotoListMap(PhotoListMapBean photoListMap) {
        this.photoListMap = photoListMap;
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public int getWorktype() {
        return worktype;
    }

    public void setWorktype(int worktype) {
        this.worktype = worktype;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<VideoListBean> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoListBean> videoList) {
        this.videoList = videoList;
    }

    public List<?> getPhotoDefList() {
        return photoDefList;
    }

    public void setPhotoDefList(List<?> photoDefList) {
        this.photoDefList = photoDefList;
    }

    public static class PhotoListMapBean {
    }

    public static class ModelBean {
        /**
         * id : 0
         * groupid : 1
         * name : Beautyleg
         * namecn : 腿模影音电子杂志
         * description :   Beautyleg是以美腿写真为主的腿模影音电子杂志媒体，台湾图站套图屋主打官方发布的腿图，其次还有台湾当地某些新闻发布会拍摄的腿图，即Beautyleg新闻图片。另外官方也会定期放出写真视频。Beautyleg系列以美腿著称，当然首先看重的是模特腿形，因此有些模特相貌平平，但整体而言Beautyleg的模特气质上佳。
         腿模也是一种职业模特，Beautyleg已有媒体杂志开发及厂商合作计划，邀请优质模特儿一同为腿模及厂商代言。Beautyleg台湾的模特居多，包括台北电脑展等高水平展览会，聘请的都是Beautyleg的模特。
         * coverimage :
         * albumcount : 733
         * status : 0
         * flag : 0
         */

        private int id;
        private int groupid;
        private String name;
        private String namecn;
        private String description;
        private String coverimage;
        private int albumcount;
        private int status;
        private int flag;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGroupid() {
            return groupid;
        }

        public void setGroupid(int groupid) {
            this.groupid = groupid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNamecn() {
            return namecn;
        }

        public void setNamecn(String namecn) {
            this.namecn = namecn;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCoverimage() {
            return coverimage;
        }

        public void setCoverimage(String coverimage) {
            this.coverimage = coverimage;
        }

        public int getAlbumcount() {
            return albumcount;
        }

        public void setAlbumcount(int albumcount) {
            this.albumcount = albumcount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }
    }

    public static class VideoListBean {
        /**
         * id : 9014
         * albumid : 11242
         * vd : 0
         * vdDesc : 480P 高清
         * filedirectory : /BeautylegVideo/Joanna/
         * filename : No.730Joanna_480p.mp4
         * fileType : mp4
         * videoUrl : http://data.vod.itc.cn/?new=/23/213/Gt8Jmx16I0JXnIrfEwGYIB.mp4&mkey=8NKtnG0yTOs9zaadJ0vvj04oI0ZFf2ZT&ch=tv&vid=87834634&uid=1488900965965&plat=17&pt=5&prod=ugc&pg=1&eye=0&cateCode=101&id=9014
         * referer :
         * portrait : 0
         * worktype : 0
         * status : 0
         * createtime : Mar 7, 2017
         * fileSize : 0
         */

        private int id;
        private int albumid;
        private int vd;
        private String vdDesc;
        private String filedirectory;
        private String filename;
        private String fileType;
        private String videoUrl;
        private String referer;
        private int portrait;
        private int worktype;
        private int status;
        private String createtime;
        private int fileSize;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAlbumid() {
            return albumid;
        }

        public void setAlbumid(int albumid) {
            this.albumid = albumid;
        }

        public int getVd() {
            return vd;
        }

        public void setVd(int vd) {
            this.vd = vd;
        }

        public String getVdDesc() {
            return vdDesc;
        }

        public void setVdDesc(String vdDesc) {
            this.vdDesc = vdDesc;
        }

        public String getFiledirectory() {
            return filedirectory;
        }

        public void setFiledirectory(String filedirectory) {
            this.filedirectory = filedirectory;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getReferer() {
            return referer;
        }

        public void setReferer(String referer) {
            this.referer = referer;
        }

        public int getPortrait() {
            return portrait;
        }

        public void setPortrait(int portrait) {
            this.portrait = portrait;
        }

        public int getWorktype() {
            return worktype;
        }

        public void setWorktype(int worktype) {
            this.worktype = worktype;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getFileSize() {
            return fileSize;
        }

        public void setFileSize(int fileSize) {
            this.fileSize = fileSize;
        }
    }
}
