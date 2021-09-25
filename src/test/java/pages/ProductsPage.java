package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import pages.components.CommonComponentsAndActions;
import pages.components.FooterComponent;
import pages.components.HeaderComponent;

import java.util.List;

public class ProductsPage extends CommonComponentsAndActions {
    WebDriver driver;
    HeaderComponent headerComponent;
    FooterComponent footerComponent;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponent = new HeaderComponent(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product-item-name")
    List<WebElement> product;

    public void filter(String specTitle, String filter) throws InterruptedException {
        String xpathFilter = "//div[text()='"+specTitle+"']/../div[2]//span[text()='"+filter+"']";

        if(driver.findElements(By.xpath(xpathFilter)).size() > 0){
            if(driver.findElements(By.xpath(xpathFilter)).get(0).isDisplayed()){
                clickElement(driver.findElements(By.xpath(xpathFilter)).get(0));
            } else {
                String xpathShowHideFilters = "//div[text()='"+specTitle+"']/..//div[@class='show-hide-filters']/div";

                if(driver.findElements(By.xpath(xpathShowHideFilters)).size() > 0){
                    if(driver.findElements(By.xpath(xpathShowHideFilters)).get(0).isDisplayed()){
                        clickElement(driver.findElements(By.xpath(xpathShowHideFilters)).get(0));
                        Thread.sleep(2000);
                        clickElement(driver.findElements(By.xpath(xpathFilter)).get(0));
                    }
                }
            }
        }
    }

    public void clickProduct(int index){
        clickElement(product.get(index));
    }

}