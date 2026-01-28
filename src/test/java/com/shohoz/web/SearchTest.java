package com.shohoz.web;

import com.shohoz.web.page.HomePage;
import com.shohoz.web.page.SearchPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.DateUtil;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class SearchTest extends BaseTest {
    String websiteUrl = ConfigReader.getProperty("websiteUrl");

    @Test(description = "Verify Flight search")
    @Severity(SeverityLevel.CRITICAL)
    public void searchForOneWayFlightsShouldSucceed() {
        String date = DateUtil.getNextDayNumber(1);
        int flightSelectionNumber =1;
        HomePage homePage = new HomePage(page);
        homePage
                .navigateUrl(websiteUrl)
                .clickOneWayFlights()
                .clickFormDateField()
                .selectDate(date)
                .clickSearchButton();
        this.page.waitForLoadState(LoadState.DOMCONTENTLOADED);

        assertThat(homePage.getTimerLocator().first()).isVisible();

        if (homePage.getNoFlightsLocator().isVisible()) {
            String newDate = DateUtil.getNextDayNumber(2);
            homePage.clickFormDateField()
                    .selectDate(newDate)
                    .clickSearchButton();
        }
        this.page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        assertThat(homePage.getTimerLocator().first()).isVisible();

        SearchPage searchPage = new SearchPage(page);
        searchPage.clickBookTicketButton(flightSelectionNumber);
    }


}
