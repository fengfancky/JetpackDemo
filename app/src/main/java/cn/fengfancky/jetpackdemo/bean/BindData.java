package cn.fengfancky.jetpackdemo.bean;

public class BindData {

    private String name;
    private String des;
    private boolean isShow;

    public BindData(String name, String des,boolean isShow) {
        this.name = name;
        this.des = des;
        this.isShow = isShow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
