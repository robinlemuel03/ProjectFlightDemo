

package tester.com.utils;

import org.testng.Reporter;
import tester.com.constants.FrameworkConstants;

public final class BrowserInfoUtils {

    private BrowserInfoUtils() {
    }

    public static String getBrowserInfo() {
        String browser = "";
        if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER") == null) {
            browser = FrameworkConstants.BROWSER.toUpperCase();
        } else {
            browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER").trim().toUpperCase();
        }
        return browser;
    }

    public static String getOSInfo() {
        return System.getProperty("os.name").replace(" ", " ");
    }

}
