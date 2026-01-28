package com.shohoz.web.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import java.util.List;
import java.util.Random;

public class SearchResultPage extends BasePage {

    public SearchResultPage(Page page) {
        super(page);
    }

    @Override
    public String getPageID() {
        return "";
    }

    @Override
    public String getUrl() {
        return "";
    }


}
