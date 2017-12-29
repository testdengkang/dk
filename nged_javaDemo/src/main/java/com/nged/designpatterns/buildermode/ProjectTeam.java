package com.nged.designpatterns.buildermode;

/**
 * @Author dengkang
 * 构建者模式最终构建的结果
 */
public class ProjectTeam {
    private String producter;

    private String devloperManager;

    private String dveloperA;


    public String getProducter() {
        return producter;
    }

    public void setProducter(String producter) {
        this.producter = producter;
    }

    public String getDevloperManager() {
        return devloperManager;
    }

    public void setDevloperManager(String devloperManager) {
        this.devloperManager = devloperManager;
    }

    public String getDveloperA() {
        return dveloperA;
    }

    public void setDveloperA(String dveloperA) {
        this.dveloperA = dveloperA;
    }


}
