package com.shohoz.web.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static io.qameta.allure.Allure.step;

public class SearchPage extends BasePage {

    public SearchPage(Page page) {
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

    public void navigateUrl(String url) {
        step("Navigate to website :" + url, ()
                -> page.navigate(url));
    }

    public SearchPage fillProductName(String productToSearch) {
        step("Search keyword used as: " + productToSearch, ()
                -> getSearchInputFieldLocator().fill(productToSearch)
        );
        return this;
    }

    public void clickSearchButton() {
        step("Entered Search Button", ()
                -> page.locator(".search-box__button--1oH7").click()
        );
    }


    @Step("Search result header data")
    public Locator getSearchResultHeaderLocator() {
        return page.locator(".JrAyI");
    }

    public Locator getSearchResultCountLocator() {
        return page.locator(".M4pDu");
    }

    @Step("Locate Search result input field")
    public Locator getSearchInputFieldLocator() {
        return page.locator("[type=\"search\"]").first();
    }
}
