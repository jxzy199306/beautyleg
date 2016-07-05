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
    private ModelBean model;
    private String sourceUrl;
    private int fileCount;
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

    public static class ModelBean {
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
