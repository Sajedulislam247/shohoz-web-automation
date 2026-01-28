package com.shohoz.web.page;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public abstract String getPageID();

    public abstract String getUrl();

}
