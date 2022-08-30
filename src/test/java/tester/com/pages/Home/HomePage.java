package tester.com.pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import tester.com.driver.DriverManager;
import tester.com.utils.WebUI;

import static tester.com.utils.WebUI.getJsExecutor;

public class HomePage {
    public By roundTripRadiobox = By.id("bkmgFlights_tripTypeSelector_R");
    public By fromInputBox = By.id("bkmgFlights_origin_trip_1");
    public By toInputBox = By.id("bkmgFlights_destination_trip_1");
    public By departureDateField = By.id("bkmgFlights_travelDates_1-formfield-1");
    public By returnDateField = By.id("bkmgFlights_travelDates_1-formfield-2");
    public By findButton = By.id("bkmgFlights_findButtonContent");
    public By loadingIcon = By.xpath("//*[@class='abc-theme-alert-message']");

    public void inputFromTextbox(String fromInputText) throws InterruptedException {
        WebUI.waitForPageLoaded();
        WebUI.waitForElementPresent(fromInputBox);
//        getJsExecutor().executeScript();
//        WebUI.setText(fromInputBox,fromInputText);
        WebUI.scrollToElement(fromInputBox);
        Thread.sleep(1000);
//        getJsExecutor().executeScript("arguments[0].click();", WebUI.getWebElement(fromInputBox));
        Actions a = new Actions(DriverManager.getDriver());
        a.moveToElement(WebUI.getWebElement(fromInputBox)).click().build().perform();
        Thread.sleep(500);
        String b = Keys.BACK_SPACE.toString();
        Thread.sleep(500);
        WebUI.setText(fromInputBox, b+b+b+b+b+b+b+b+b+b+b);
        WebUI.setText(fromInputBox, fromInputText);
//        getJsExecutor().executeScript("arguments[0].value='" + fromInputText + "';", WebUI.getWebElement(fromInputBox));
//        getJsExecutor().executeScript("arguments[0].value='"+fromInputText+"';", WebUI.getWebElement(fromInputBox));
        Thread.sleep(2000);
//        Actions a = new Actions(DriverManager.getDriver());
        a.moveToElement(WebUI.getWebElement(fromInputBox)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        a.moveToElement(WebUI.getWebElement(fromInputBox)).sendKeys(Keys.TAB).build().perform();
    }

    public void inputToTextbox(String toInputText) throws InterruptedException {
        WebUI.waitForPageLoaded();
        WebUI.waitForElementPresent(toInputBox);
        WebUI.scrollToElement(toInputBox);
        Actions a = new Actions(DriverManager.getDriver());
        a.moveToElement(WebUI.getWebElement(toInputBox)).click().build().perform();
        Thread.sleep(500);
        String b = Keys.BACK_SPACE.toString();
        Thread.sleep(500);
        WebUI.setText(toInputBox, b+b+b+b+b+b+b+b+b+b+b);
        WebUI.setText(toInputBox, toInputText);
        Thread.sleep(2000);
        a.moveToElement(WebUI.getWebElement(toInputBox)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        a.moveToElement(WebUI.getWebElement(toInputBox)).sendKeys(Keys.TAB).build().perform();
    }

    public void isRoundTripRadioSelected() {
        WebUI.waitForElementPresent(roundTripRadiobox);
        if (!WebUI.verifyElementChecked(roundTripRadiobox)) {
            WebUI.clickElement(roundTripRadiobox);
        }
    }

    public void setDepartureDate(String fromDate) throws InterruptedException {
        WebUI.waitForElementPresent(departureDateField);
        WebUI.setText(departureDateField, fromDate);
        getJsExecutor().executeScript("arguments[0].value='" + fromDate + "';", WebUI.getWebElement(departureDateField));
        Thread.sleep(2000);
        Actions a = new Actions(DriverManager.getDriver());
        a.moveToElement(WebUI.getWebElement(fromInputBox)).sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    public void setReturnDate(String toDate) throws InterruptedException {
        WebUI.waitForElementPresent(returnDateField);
        WebUI.setText(returnDateField, toDate);
        getJsExecutor().executeScript("arguments[0].value='" + toDate + "';", WebUI.getWebElement(returnDateField));
        Thread.sleep(2000);
        Actions a = new Actions(DriverManager.getDriver());
        a.moveToElement(WebUI.getWebElement(fromInputBox)).sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    public void clickFindButton() {
//        WebUI.clickElement(findButton);
        WebUI.waitForElementPresent(findButton);
        getJsExecutor().executeScript("arguments[0].click();", WebUI.getWebElement(findButton));
        WebUI.waitForPageLoaded();
        WebUI.waitForElementPresent(loadingIcon);
        WebUI.waitForPageLoaded();

    }


}
