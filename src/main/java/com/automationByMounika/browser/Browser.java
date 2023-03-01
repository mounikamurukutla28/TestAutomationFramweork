package com.automationByMounika.browser;

import org.openqa.selenium.WebDriver;

public abstract class Browser {
    private boolean isHeadLess;
    private boolean isRemote;
    private boolean isMaximized;
    private Integer pageLoadTimeOut;
    private boolean isDeleteCookies;

    public abstract void setPreferences();
    public abstract WebDriver loadBrowser(String path);


    public boolean isHeadLess() {
        return isHeadLess;
    }

    public void setHeadLess(boolean headLess) {
        isHeadLess = headLess;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public boolean isMaximized() {
        return isMaximized;
    }

    public void setMaximized(boolean maximized) {
        isMaximized = maximized;
    }

    public Integer getPageLoadTimeOut() {
        return pageLoadTimeOut;
    }

    public void setPageLoadTimeOut(Integer pageLoadTimeOut) {
        this.pageLoadTimeOut = pageLoadTimeOut;
    }

    public void setDeleteCookies(boolean cookies) {
        isDeleteCookies = cookies;
    }

    public boolean isDeleteCookies() {
        return isDeleteCookies;
    }
}
