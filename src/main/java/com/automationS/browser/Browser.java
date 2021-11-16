package com.automationS.browser;

import org.openqa.selenium.WebDriver;

public abstract class Browser {

    private boolean isHeadless;

    private boolean isRemote;

    private boolean isMaximized;

    private Integer pageLoadTiemout;

    private boolean deleteCookies;

    public abstract void setPreferences();

    public abstract WebDriver loadBrowser(String path);

    public boolean isHeadless() {
        return isHeadless;
    }

    public void setHeadless(boolean headless) {
        isHeadless = headless;
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

    public Integer getPageLoadTiemout() {
        return pageLoadTiemout;
    }

    public void setPageLoadTiemout(Integer pageLoadTiemout) {
        this.pageLoadTiemout = pageLoadTiemout;
    }

    public boolean isDeleteCookies() {
        return deleteCookies;
    }

    public void setDeleteCookies(boolean deleteCookies) {
        this.deleteCookies = deleteCookies;
    }
}
