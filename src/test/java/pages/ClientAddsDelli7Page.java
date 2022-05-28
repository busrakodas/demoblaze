package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ClientAddsDelli7Page {
    public ClientAddsDelli7Page() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy (xpath= "//*[text()='Dell i7 8gb']")
    public WebElement dell8gb;

    @FindBy(xpath="//*[contains(text(),'Home')]")
    public WebElement home;

    @FindBy(id="cartur")
    public WebElement cart;

    @FindBy (xpath= "(//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")
    public WebElement delete;

    @FindBy(xpath="//*[contains(text(),'Place Order')]")
    public WebElement placeOrder;

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="country")
    public WebElement country;

    @FindBy(id="city")
    public WebElement city;

    @FindBy(id="card")
    public WebElement creditCard;

    @FindBy(id="month")
    public WebElement month;

    @FindBy(id="year")
    public WebElement year;

    @FindBy (xpath= "//*[text()='Purchase']")
    public WebElement purchase;

    @FindBy(xpath="//*[@id='totalp']")
    public WebElement expectedamount;




}
