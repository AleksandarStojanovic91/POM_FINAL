package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.components.CommonComponentsAndActions;
import pages.components.FooterComponent;
import pages.components.HeaderComponent;

public class ContactPage extends CommonComponentsAndActions {
    WebDriver driver;
    HeaderComponent headerComponent;
    FooterComponent footerComponent;

    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        headerComponent = new HeaderComponent(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }

}