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


    /**
     * Selects a random product from the product list.
     */
    @Description("Select a product from the search result list")
    public SearchResultPage selectRandomProduct() {
        List<Locator> products = getFilteredProducts();
        if (products.isEmpty()) {
            throw new RuntimeException("No products found in search results!");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(products.size());
        products.get(randomIndex).click();
        return this;
    }

    @Step("List products found on search result")
    public List<Locator> getFilteredProducts() {
        return page.locator("._17mcb .Bm3ON")
                .all()
                .stream()
                .filter(Locator::isVisible) // keep only visible items
                .toList();
    }

    @Step("Locate product title")
    public Locator getProductTitle() {
        return page.locator(".pdp-product-title");
    }

    @Step("Click Add To Cart Button")
    public SearchResultPage clickAddToCartButton() {
        page.locator(".add-to-cart-buy-now-btn").nth(1).click();
        return this;
    }

    @Step("Locate Cart success/error message")
    public Locator getCartMessageLocator() {
        return page.locator(".cart-message");
    }

    @Step("Close dialog window")
    public SearchResultPage closeModalWindow() {
        page.locator(".next-icon-close").click();
        return this;
    }

    @Step("Clicking on cart icon ")
    public SearchResultPage clickCartIcon() {
        page.locator(".cart-icon-daraz").click();
        return this;
    }

    @Step("Locate cart items")
    public Locator getCartItemListLocator() {
        return page.locator("#leftContainer_CL");
    }
}
