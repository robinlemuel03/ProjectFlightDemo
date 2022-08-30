package tester.com.pages;

import tester.com.pages.Home.HomePage;

public class CommonPage {

    public HomePage homePage;

    public HomePage homePage() {
        return new HomePage();
    }

}
