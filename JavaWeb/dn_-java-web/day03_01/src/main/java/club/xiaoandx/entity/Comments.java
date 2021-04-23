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

/**
 * <p>  </p>
 *
 * @version V1.0.0
 * @ClassName:Comments
 * @author: WEI.ZHOU
 * @date: 2021/4/21 19:36
 */
public class Comments {
    private Integer cid;
    private Integer cnid;
    private String ccontent;
    private Timestamp cdata;
    private String cip;
    private String cauthor;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCnid() {
        return cnid;
    }

    public void setCnid(Integer cnid) {
        this.cnid = cnid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public Timestamp getCdata() {
        return cdata;
    }

    public void setCdata(Timestamp cdata) {
        this.cdata = cdata;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCauthor() {
        return cauthor;
    }

    public void setCauthor(String cauthor) {
        this.cauthor = cauthor;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "cid=" + cid +
                ", cnid=" + cnid +
                ", ccontent='" + ccontent + '\'' +
                ", cdata=" + cdata +
                ", cip='" + cip + '\'' +
                ", cauthor='" + cauthor + '\'' +
                '}';
    }
}
