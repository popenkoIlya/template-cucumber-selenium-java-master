package Forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CarPage extends Form {
    private String elementsLocTemplate = "//title[contains(text(),'')]";
    private ILabel carNameLabel;
    private ILink trimLink = AqualityServices.getElementFactory().getLink(By.xpath("//a[@data-linkname = 'mmyt-trim-compare']"),"trimLink");
    public CarPage(String carName) {
        super(By.xpath(BaseLocator.carPageTemplate),carName+"Page");
        carNameLabel = AqualityServices.getElementFactory().getLabel(By.xpath(String.format("//title[contains(text(),'%s')]",carName)),"carName");
    }

    public void goOnTrim(){
        trimLink.clickAndWait();
    }
}
