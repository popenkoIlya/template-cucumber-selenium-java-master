package cucumber.Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CarPage extends Form {
    private String elementsLocTemplate = "//title[contains(text(),'%s')]";
    private ILabel carNameLabel;
    private ILink trimLink = AqualityServices.getElementFactory().getLink(By.xpath("//a[@data-linkname = 'mmyt-trim-compare']"),"trimLink");
    public CarPage(String carName) {
        super(By.xpath(BaseLocator.carPageTemplate),carName+"Page");
        carNameLabel = AqualityServices.getElementFactory().getLabel(By.xpath(String.format(elementsLocTemplate,carName)),"carName");
    }

    public void goOnTrim(){
        trimLink.clickAndWait();
    }

    public boolean IsLabelRight(){
        return carNameLabel.state().waitForDisplayed();
    }
}
