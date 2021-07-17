package dao;

/**
 * ClassName: Music
 * Description:
 * date: 2021/7/17 16:26
 *
 * @author wt
 * @since JDK 1.8
 */
public class Music {
    private int id;
    private String title;
    private String singer;
    private String time;
    private String url;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", time='" + time + '\'' +
                ", url='" + url + '\'' +
                ", userId=" + userId +
                '}';
    }
}
