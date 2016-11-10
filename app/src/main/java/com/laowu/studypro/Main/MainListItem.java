package com.laowu.studypro.Main;

/**
 * Created by laowu on 2016/11/10.
 */
public class MainListItem {
    private String name;
    private String info;
    private Class myClass;

    public MainListItem(String name, String info, Class myClass) {
        this.name = name;
        this.info = info;
        this.myClass = myClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Class getMyClass() {
        return myClass;
    }

    public void setMyClass(Class myClass) {
        this.myClass = myClass;
    }
}
