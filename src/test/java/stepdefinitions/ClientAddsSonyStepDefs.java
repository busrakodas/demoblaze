package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.ClientAddsDelli7Page;
import pages.ClientAddsSonyVaioI5Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class ClientAddsSonyStepDefs {
    ClientAddsSonyVaioI5Page client=new ClientAddsSonyVaioI5Page();
    ClientAddsDelli7Page dell= new ClientAddsDelli7Page();
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();
    public String expectedamount;
    public String actualAmount;
    public String id;


        @When("user navigates to the home page")
    public void user_navigates_to_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("demo_blaze_url"));
    }
    @When("user clicks on Laptops button")
    public void user_clicks_on_laptops_button() {
        dell.home.click();
        Driver.waitForVisibility(client.laptopsButton,10);
        client.laptopsButton.click();

    }
    @When("user clicks on Sony vaio i5")
    public void user_clicks_on_sony_vaio_i5() throws InterruptedException {
        Thread.sleep(2000);
        JSUtilities.scrollIntoViewJS(client.sonyVaio);
        client.sonyVaio.click();
    }
    @Then("user clicks on Add to cart button")
    public void user_clicks_on_add_to_cart_button() throws InterruptedException {
        Driver.waitForVisibility(client.addToCartButton,15);
        client.addToCartButton.click();
        Thread.sleep(1000);

    }
    @Then("user need to accept pop up confirmation")
    public void user_need_to_accept_pop_up_confirmation() {
        try {
            Driver.getDriver().switchTo().alert().dismiss();
        } catch (UnhandledAlertException f) {
            try {
                Alert alert = Driver.getDriver().switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }
    @When("user clicks on Dell i7 8gb")
    public void user_clicks_on_dell_i7_8gb() throws InterruptedException {
    dell.home.click();
    Thread.sleep(1000);
    client.laptopsButton.click();
    Thread.sleep(1000);
    dell.dell8gb.click();

    }

    @Then("user navigates to cart page")
    public void user_navigates_to_cart_page() {
        dell.cart.click();

    }
    @Then("user delete Dell i7 8gb")
    public void user_delete_dell_i7_8gb() throws InterruptedException {
        Thread.sleep(2000);
        //dell.delete.click();
        for(int i=0;i<client.products.size();i++){
            WebElement delete=Driver.getDriver().findElement(By.xpath("//tr["+(i+1)+"]//td//a"));
            if(client.products.get(i).getText().contains("Dell")){
                Thread.sleep(2000);
                //ReusableMethods.wait(2);
                delete.click();

            }
        }

    }
    @Then("user clicks on place order button")
    public void user_clicks_on_place_order_button() throws InterruptedException {
        Thread.sleep(2000);
        dell.placeOrder.click();

    }
    @Then("user fill in all web form fields")
    public void user_fill_in_all_web_form_fields() throws InterruptedException {
        Thread.sleep(2000);
        dell.name.click();
        Driver.waitAndSendText(dell.name,"isabelle");
        Driver.waitAndSendText(dell.country,"Spain");
        Driver.waitAndSendText(dell.city,"Madrid");
        Driver.waitAndSendText(dell.creditCard,"1234");
        Driver.waitAndSendText(dell.month,"May");
        Driver.waitAndSendText(dell.year,"2023");

    }
    @Then("user clicks on purchase button")
    public void user_clicks_on_purchase_button() throws InterruptedException {
        System.out.println(dell.expectedamount.getText());
        expectedamount=dell.expectedamount.getText();
        Thread.sleep(2000);
        dell.purchase.click();

    }
    @Then("user captures purchase id and amount")
    public void user_captures_purchase_id_and_amount() {
        id = (String)javascriptExecutor.executeScript("return document.evaluate(\"//p[contains(@class, 'lead text-muted ')]//br[1]/preceding-sibling::text()[1]\", document, null, XPathResult.STRING_TYPE, null ).stringValue;");
        System.out.println(id);
        actualAmount = (String)javascriptExecutor.executeScript("return document.evaluate(\"//p[contains(@class, 'lead text-muted ')]//br[2]/preceding-sibling::text()[1]\", document, null, XPathResult.STRING_TYPE, null ).stringValue;");
        System.out.println(actualAmount);

    }
    @Then("user asserts purchase amount equals expected")
    public void user_asserts_purchase_amount_equals_expected() {
        Assert.assertTrue(actualAmount.contains(expectedamount));

    }
    @Then("user clicks on ok button")
    public void user_clicks_on_ok_button() throws InterruptedException {
        Thread.sleep(2000);
        client.okButton.click();
        Driver.closeDriver();

    }

}
