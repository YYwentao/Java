package com.tedu.pojo;

import java.util.Date;
import java.util.List;

/**
 * 新闻的实体类
 */
public class News {

    private int nid;// 主键
    private int ntid;// 新闻类型主键
    private String ntitle;//标题
    private String nauthor;//作者
    private Date ncreateDate;//创建时间
    private String npicPath;//新闻图片
    private String ncontent;//内容
    private Date nmodifyDate;//更新时间
    private String nsummary;//摘要


    //添加一个新闻评论


    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", ntid=" + ntid +
                ", ntitle='" + ntitle + '\'' +
                ", nauthor='" + nauthor + '\'' +
                ", ncreateDate=" + ncreateDate +
                ", npicPath='" + npicPath + '\'' +
                ", ncontent='" + ncontent + '\'' +
                ", nmodifyDate=" + nmodifyDate +
                ", nsummary='" + nsummary + '\'' +
                '}';
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getNtid() {
        return ntid;
    }

    public void setNtid(int ntid) {
        this.ntid = ntid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNauthor() {
        return nauthor;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }

    public Date getNcreateDate() {
        return ncreateDate;
    }

    public void setNcreateDate(Date ncreateDate) {
        this.ncreateDate = ncreateDate;
    }

    public String getNpicPath() {
        return npicPath;
    }

    public void setNpicPath(String npicPath) {
        this.npicPath = npicPath;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Date getNmodifyDate() {
        return nmodifyDate;
    }

    public void setNmodifyDate(Date nmodifyDate) {
        this.nmodifyDate = nmodifyDate;
    }

    public String getNsummary() {
        return nsummary;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }
}
