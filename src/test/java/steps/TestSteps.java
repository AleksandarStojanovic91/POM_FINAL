package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.Reporter;
import pages.HomePage;
import pages.ProductPage;
import pages.ProductsPage;

public class TestSteps extends BaseTest{
    String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    String BROWSER_VERSION = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER_VERSION");
    String WAIT_TIME = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT_TIME");

    String productName;

    @Before
    public void setUp(){
        init(BROWSER, BROWSER_VERSION, WAIT_TIME);
    }
    @After
    public void tearDown(){
        quit();
    }

    @Given("I navigate to Gigatron")
    public void iNavigateToGigatron(){
        driver.get("https://gigatron.rs/");
    }

    @And("I search for a product {string}")
    public void iSearchForAProduct(String product) {
        HomePage homePage = new HomePage(driver);
        homePage.headerComponent.search(product);
        reportScreenshot("TestName", "TestDesc");
    }

    @And("I filter products by spec title {string} and filter {string}")
    public void iFilterProductsBySpecTitleAndFilter(String specTitle, String filter) throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.filter(specTitle, filter);
    }

    @And("I click on product index {string}")
    public void iClickOnProductIndex(String index) {
        ProductsPage productPages = new ProductsPage(driver);
        productPages.clickProduct(0);
    }

    @And("I add product to cart")
    public void iAddProductToCart() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productName = productPage.getProductName();
        productPage.addToCart();
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @Then("I verify that item is added to the cart")
    public void iVerifyThatItemIsAddedToTheCart() {
        ProductPage productPage = new ProductPage(driver);

        Assert.assertEquals(productPage.getPopUpTitleText(), "Proizvod je dodat u korpu");
        Assert.assertTrue(productName.contains(productPage.popUpItemName.get(0).getText()));

        productPage.backToSearch();

        Assert.assertEquals(productPage.buttonCartItemNum.getText(), "1");
        Assert.assertEquals(productPage.cartItemNum.getText(), "1");
    }

    @And("I navigate to contact page")
    public void iNavigateToContactPage() {
        HomePage homePage = new HomePage(driver);
        homePage.headerComponent.contactPage.click();
    }
}
