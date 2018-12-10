package cn.fengfancky.jetpackdemo.bean;

import java.io.Serializable;

public class ExamBean implements Serializable {

    private int img;
    private String title;
    private String des;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
