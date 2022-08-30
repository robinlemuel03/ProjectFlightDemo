package tester.com.pages.Vacation;

import org.openqa.selenium.By;
import tester.com.utils.WebUI;

public class VacationPage {
    By fromInputbox = By.id("vacationsTab_origin");

    public void setFromInputbox(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(fromInputbox);
        WebUI.setText(fromInputbox,"YYZ");


    }


}
