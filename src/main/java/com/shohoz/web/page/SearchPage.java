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

    @Step("Click Book Flight")
    public SearchPage clickBookTicketButton(int flightNumber) {
        step(flightNumber+ "Selected for booking" ,()
                -> page.locator(".btn_book_oneway")).nth(flightNumber).click();
        return this;
    }


}
