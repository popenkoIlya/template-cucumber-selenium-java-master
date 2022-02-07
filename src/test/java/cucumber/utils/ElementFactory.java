package cucumber.utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILink;
import org.openqa.selenium.By;

public class ElementFactory {
    private static IElementFactory elementFactory = AqualityServices.getElementFactory();;

    public static ILink getLink(By locator, String name){
        return elementFactory.getLink(locator,name);
    }
}
