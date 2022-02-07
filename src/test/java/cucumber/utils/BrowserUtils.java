package cucumber.utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public class BrowserUtils {


    private static Browser _browser;

    /// <summary>
    /// initialize browser value
    /// </summary>
    public static void initBrowser() {
        _browser = AqualityServices.getBrowser();
    }

    /// <summary>
    /// maximize window of browser
    /// </summary>
    public static void maximize() {
        _browser.maximize();
    }

    public static void switchToLastTab() {
        _browser.tabs().switchToLastTab();
    }

    public static void closeTab() {
        _browser.tabs().closeTab();
        _browser.tabs().switchToLastTab();
    }

    public static byte[] takeScreenshot() {
        return _browser.getScreenshot();
    }

    public static void goToUrl(String url){
        _browser.goTo(url);
    }

    public static void refresh() {
        _browser.refresh();
    }

    /// <summary>
    /// close processes of browser
    /// </summary>
    public static void quit() {
        _browser.quit();
    }
}
