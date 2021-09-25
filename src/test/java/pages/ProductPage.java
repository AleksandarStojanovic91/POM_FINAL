package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.CommonComponentsAndActions;
import pages.components.FooterComponent;
import pages.components.HeaderComponent;

import java.util.List;

public class ProductPage extends CommonComponentsAndActions {
    WebDriver driver;
    HeaderComponent headerComponent;
    FooterComponent footerComponent;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponent = new HeaderComponent(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='product-det-cart-btns']//button[@class='buy out-of-stock']")
    WebElement addToCart;
    @FindBy(xpath = "//div[@class=\"product-title\"]/h1")
    WebElement itemName;
    @FindBy(xpath = "//div[@class=\"sw-content showe\"]/h4")
    public WebElement popUpTitle;
    @FindBy(xpath = "//div[@class=\"sw-content showe\"]//h3")
    public List<WebElement> popUpItemName;
    @FindBy(css = "button.white")
    WebElement backToSearch;
    @FindBy(xpath = "//span[@class=\"btnTxt\"]/span/b")
    public WebElement buttonCartItemNum;
    @FindBy(xpath = "//div[@class='cart-preview']//span[@class=\"icon-number\"]")
    public WebElement cartItemNum;


    public void addToCart() throws InterruptedException {
        Thread.sleep(3000);
        clickElement(addToCart);
    }

    public String getProductName() {
        return getText(itemName);
    }

    public void backToSearch(){
        clickElement(backToSearch);
    }

    public String getPopUpTitleText(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(popUpTitle,"Proizvod je dodat u korpu"));

        return getText(popUpTitle);
    }
}