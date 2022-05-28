package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ClientAddsSonyVaioI5Page {
    public ClientAddsSonyVaioI5Page() { PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//*[@id='itemc'])[2]")
            public WebElement laptopsButton;

    @FindBy(xpath="//*[contains(text(),'Sony vaio i5')]")
    public WebElement sonyVaio;

    @FindBy(xpath ="//*[@class='btn btn-success btn-lg']")
    public WebElement addToCartButton;

















    //@FindBy(id="EmergencyReachPerson")
   // public WebElement acilDurumKisisi;


}
