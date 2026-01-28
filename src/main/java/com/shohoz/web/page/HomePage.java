package com.shohoz.web.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static io.qameta.allure.Allure.step;

public class HomePage extends BasePage {
    public HomePage(Page page) {
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

    @Step("Open Website Url")
    public HomePage navigateUrl(String url) {
        step("Navigate to website :" + url, ()
                -> page.navigate(url));
        return this;
    }

    @Step("Select One Way Flights")
    public HomePage clickOneWayFlights() {
        step("Clicking One Way Flights radio button");
        page.locator("#one-tab").click();
        return this;
    }

    @Step("Select Form Date")
    public HomePage clickFormDateField() {
        step("Clicking Form Date Selection field");
        page.locator(".react-datepicker-wrapper").first().click();
        return this;
    }

    @Step("Select Form Date")
    public HomePage selectDate(String date) {
        step("Selecting date:" + date);
        page.locator(".react-datepicker:visible")
                .locator("div.react-datepicker__day:not(.react-datepicker__day--disabled)")
                .filter(new Locator.FilterOptions().setHasText(date))
                .click();

        return this;
    }

    @Step("Click Search Button")
    public HomePage clickSearchButton() {
        step("Clicking Search Button");
        page.locator(".search .btn.search_btn").first().click();
        return this;
    }


    public Locator getNoFlightsLocator() {
        return page.locator(".no_flight_avail");
    }

    public Locator getTimerLocator() {
        return page.locator(".Flight_clock_payment_last__DPiPe");
    }
}
