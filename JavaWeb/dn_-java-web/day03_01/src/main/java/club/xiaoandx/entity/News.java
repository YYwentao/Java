/*
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and
 * commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 *
 *                        <xiaoandx@gmail.com>
 */
package club.xiaoandx.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * <p> 新闻实体类 </p>
 * @version V1.0.0
 * @ClassName:News
 * @author: WEI.ZHOU
 * @date: 2021/4/21 18:43
 */
public class News {
    private Integer nid;
    private Integer ntid;
    private String ntitle;
    private String nauthor;
    private Timestamp ncreateDate;
    private String npicPath;
    private String ncontent;
    private Timestamp nmodiffyDate;
    private String nsummary;
    private Comments comm;

    public Integer getNid(int nid) {
        return this.nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getNtid(int ntid) {
        return this.ntid;
    }

    public void setNtid(Integer ntid) {
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

    public Timestamp getNcreateDate() {
        return ncreateDate;
    }

    public void setNcreateDate(Timestamp ncreateDate) {
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

    public Timestamp getNmodiffyDate() {
        return nmodiffyDate;
    }

    public void setNmodiffyDate(Timestamp nmodiffyDate) {
        this.nmodiffyDate = nmodiffyDate;
    }

    public String getNsummary() {
        return nsummary;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }

    public Integer getNid() {
        return nid;
    }

    public Integer getNtid() {
        return ntid;
    }

    public Comments getComm() {
        return comm;
    }

    public void setComm(Comments comm) {
        this.comm = comm;
    }

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
                ", nmodiffyDate=" + nmodiffyDate +
                ", nsummary='" + nsummary + '\'' +
                ", comm=" + comm +
                '}';
    }
}
