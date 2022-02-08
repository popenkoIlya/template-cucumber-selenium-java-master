package cucumber.Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ComparePage extends Form {
    private ITextBox engineText;
    private ITextBox transmissionText;

    public ComparePage() {
        super(By.xpath(BaseLocator.comparePageTemplate), "ComparePage");
    }

    public void setCarType(String carType) {
        engineText = AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//span[text()='%s']//ancestor::h2//following-sibling::div//th[text()='Engine']", carType)), "EngineText");
        transmissionText = AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//span[text()='%s']//ancestor::h2//following-sibling::div//th[text()='Transmission']", carType)), "TransmissionText");
    }
}
