package Robin.com.testcases;

import Robin.com.common.BaseTest;
import Robin.com.constants.FrameworkConstants;
import Robin.com.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Robin.com.pages.Home.HomePage;
import Robin.com.utils.WebUI;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    public HomeTest() {
        //HomeTest homeTest = new HomeTest();
    }

    WebDriver driver;

    @Test
    public void findFlights() throws InterruptedException {
        WebUI.getToUrl(FrameworkConstants.URL_CRM);
        WebUI.waitForPageLoaded();
        HomePage homePage = new HomePage();
        homePage.isRoundTripRadioSelected();
        homePage.inputFromTextbox("YVR");
        homePage.inputToTextbox("YYZ");
        homePage.setDepartureDate("15/09/2022");
        homePage.setReturnDate("22/09/2022");
        homePage.clickFindButton();
    }
}