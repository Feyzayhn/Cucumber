package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HerOkuAppPage {

    public HerOkuAppPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@onclick='addElement()']")
    public WebElement addButonu;

    @FindBy(xpath = "//button[@class='added-manually']")
    public WebElement deleteButonu;

    @FindBy(xpath = "//button[@class='added-manually']")
    public List<WebElement> deleteListesi;



}

