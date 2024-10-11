package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ReviewPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CartSteps {
    CartPage cartPage = new CartPage();
    ReviewPage reviewPage=new ReviewPage();
    @Then("verify user is on cart page")
    public void verify_user_is_on_cart_page() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }
    @When("user click on checkout button")
    public void user_click_on_checkout_button() {
        cartPage.clickOnCheckoutBtn();
    }

    @Then("verify all items on cart is present in review page")
    public void verifyAllItemsOnCartIsPresentInReviewPage() {
        List<String> cartItemNames=cartPage.cartItemNames();
        Double totalPriceOnCart= cartPage.totalPriceOfCartItems(cartPage.cartItemsPrice());
        Collections.sort(cartItemNames);
        Double totalPriceOnCheckedoutPage=reviewPage.totalPriceOfCheckedoutItems(reviewPage.checkedoutItemsPrice());
        Assert.assertTrue(Objects.equals(totalPriceOnCart, totalPriceOnCheckedoutPage));
        List<String> checkedoutItemNames=reviewPage.checkedoutItemNames();
        Collections.sort(checkedoutItemNames);
        Assert.assertTrue(cartItemNames.equals(checkedoutItemNames));
    }
}
