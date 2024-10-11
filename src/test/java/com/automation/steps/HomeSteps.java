package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeSteps {
    HomePage homePage = new HomePage();
    CartPage cartPage=new CartPage();
    int totalProducts= homePage.getProductCount();
    List<String> productNames=homePage.getAllProductNames();

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }
    @When("user click on add to cart button of the first item")
    public void user_click_on_add_to_cart_button_of_the_first_item() {
        homePage.clickOnAddToCartOfFirstItem();
    }
    @Then("verify cart icon displays quantity one")
    public void verify_cart_icon_displays_quantity_one() {
        Assert.assertEquals(homePage.getCartIconQty(), "1");
    }
    @When("user click on cart icon")
    public void user_click_on_cart_icon() {
        homePage.clickOnShoppingCartLink();
    }

    @When("user selects Name \\(Z to A)")
    public void userSelectsNameZToA() {
        homePage.selectOption("Name (Z to A)");
    }

    @Then("verify products are sorted by Z to A")
    public void verifyProductsAreSortedByZToA() {
        List<String> sortedNames=homePage.getAllProductNames();
        sortedNames.sort(Comparator.reverseOrder());
        List<String> products=homePage.getAllProductNames();
        Assert.assertTrue(sortedNames.equals(products));
    }

    @When("user selects Price \\(high to low)")
    public void userSelectsPriceHighToLow() {
        homePage.selectOption("Price (high to low)");
    }

    @Then("verify products are sorted in descending order of price")
    public void verifyProductsAreSortedInDescendingOrderOfPrice() {
        List<Double> sortedPrices=homePage.getAllProductPrice();
        sortedPrices.sort(Comparator.reverseOrder());
        List<Double> prices=homePage.getAllProductPrice();
        Assert.assertTrue(sortedPrices.equals(prices));
    }

    @When("user adds all items into cart")
    public void userAddsAllItemsIntoCart() {
        homePage.addAllItemsToCart();
    }

    @Then("verify cart icon displays total count of items on cart")
    public void verifyCartIconDisplaysTotalCountOfItemsOnCart() {
        Integer cartQuantity=Integer.parseInt(homePage.getCartIconQty());
        Assert.assertTrue(cartQuantity== homePage.getProductCount());
    }

    @Then("verify items on cart page is same as item you added in cart")
    public void verifyItemsOnCartPageIsSameAsItemYouAddedInCart() {
        Collections.sort(productNames);
        List <String> cartItemNames=cartPage.cartItemNames();
        Collections.sort(cartItemNames);
        Assert.assertTrue(totalProducts==cartPage.cartItemCount());
        Assert.assertTrue(productNames.equals(cartItemNames));
    }

    @And("verify remove button is not displayed")
    public void verifyRemoveButtonIsNotDisplayed() {
        Assert.assertTrue(!homePage.isRemoveBtnPresent());
    }
}
