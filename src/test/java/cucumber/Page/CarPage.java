package cucumber.Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CarPage extends Form {
    private String elementsLocTemplate = "//h1[contains(text(),'%s') and contains(text(),'%s') and contains(text(),'%s')]";
    private ILabel carNameLabel;
    private ILink trimLink = AqualityServices.getElementFactory().getLink(By.xpath("//a[@data-linkname='mmyt-trim-compare']"), "trimLink");

    public CarPage() {
        super(By.xpath(BaseLocator.carPageTemplate),  "CarPage");
    }

    public void setCarName(String carMake, String carModel, String carYear){
        carNameLabel = AqualityServices.getElementFactory().getLabel(By.xpath(String.format(elementsLocTemplate, carYear,carMake,carModel)), "carName");
    }
    public void goOnTrim() {
        trimLink.clickAndWait();
    }

    public boolean IsLabelRight() {
        return carNameLabel.state().waitForDisplayed();
    }
}
