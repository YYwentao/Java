package com.tedu.pojo;

/**
 * 新闻类型  实体类
 *
 */
public class NewsTopic {
   private  int tid;//
   private String tname;//

    //  alt+  insert  (+fn)   快捷键


    @Override
    public String toString() {
        return "NewsTopic{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    /**
     * 创建构造方法
     * @param tid
     * @param tname
     */
    public NewsTopic(int tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public NewsTopic() {
    }
}
