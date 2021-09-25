package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(css = "[name=\"name\"]")
    WebElement name;
    @FindBy(css = "[name=\"email\"]")
    WebElement email;
    @FindBy(css = "[name=\"phone\"]")
    WebElement phone;
    @FindBy(css = "[name=\"contact\"]")
    WebElement contact;
    @FindBy(css = "[name=\"subject\"]")
    WebElement subject;
    @FindBy(xpath = "//div[@class=\"submit\"]/button")
    WebElement submitButton123;


    public void fillContactPage(String nameValue, String emailValue, String phoneValue, String contactValue, String subjectValue) {
        typeText(name, nameValue);
        typeText(email, emailValue);
        typeText(phone, phoneValue);
        selectElementByVisibleText(contact, contactValue);
        typeText(subject, subjectValue);
    }

    public void fillContactPage2(String nameValue, String emailValue, String phoneValue, String contactValue, String subjectValue) {
        typeText(name, nameValue);
        typeText(email, emailValue);
        typeText(phone, phoneValue);
        selectElementByVisibleText(contact, contactValue);
        typeText(subject, subjectValue);
    }
}