package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.CommonComponentsAndActions;
import pages.components.FooterComponent;
import pages.components.HeaderComponent;

public class HomePage extends CommonComponentsAndActions {
    WebDriver driver;
    public HeaderComponent headerComponent;
    public FooterComponent footerComponent;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponent = new HeaderComponent(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.primary")
    WebElement accept;

    public void acceptCookies() {
        clickElement(accept);
    }
}