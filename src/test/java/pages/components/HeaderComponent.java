package pages.components;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent extends CommonComponentsAndActions{
    WebDriver driver;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#searchbox input")
    WebElement search;

    public void search(String searchItem){
        typeText(search, searchItem);
        typeText(search, Keys.ENTER);
    }

}
