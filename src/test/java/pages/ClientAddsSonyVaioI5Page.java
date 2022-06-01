package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ClientAddsSonyVaioI5Page {
    public ClientAddsSonyVaioI5Page() { PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//*[@id='itemc'])[2]")
    public WebElement laptopsButton;

    @FindBy(xpath="//*[contains(text(),'Sony vaio i5')]")
    public WebElement sonyVaio;

    @FindBy(xpath ="//*[@class='btn btn-success btn-lg']")
    public WebElement addToCartButton;

     @FindBy (xpath = "//td[2]")
     public List<WebElement> products;

     @FindBy(xpath = "//p[text()='Amount: 790 USD']")
     public WebElement purchaseSuccessfulReport;

     @FindBy(xpath = "//div[@class='sa-confirm-button-container']")
     public WebElement okButton;

     @FindBy(xpath = "(/html/body/div[10]/p/text()[1])")
     public WebElement id;

     @FindBy(xpath = "//p[contains(@class, 'lead text-muted ')]//br[1]/preceding-sibling::text()[1]")
     public WebElement actualAmount;

}
