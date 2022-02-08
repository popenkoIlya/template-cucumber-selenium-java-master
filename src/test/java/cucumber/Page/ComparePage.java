package cucumber.Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ComparePage extends Form {
    private ITextBox engineTextBox;
    private ITextBox transmissionTextBox;
    private IButton styleButton;

    public ComparePage() {
        super(By.xpath(BaseLocator.comparePageTemplate), "ComparePage");
    }

    public void setCarType(String carType) {
        engineTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//span[text()='%s']//ancestor::h2//following-sibling::div//th[text()='Engine']//ancestor::tr//following-sibling::tr[1]/td[1]", carType)), "EngineText");
        transmissionTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//span[text()='%s']//ancestor::h2//following-sibling::div//th[text()='Transmission']//ancestor::tr//following-sibling::tr[1]/td[1]", carType)), "TransmissionText");
        styleButton = AqualityServices.getElementFactory().getButton(By.xpath(String.format("//span[text()='%s']//ancestor::button",carType)),"StyleButton");
    }


    public void openStyleSpecification(){
        styleButton.focus();
        styleButton.clickAndWait();
    }
    public String getEngineText(){
        return engineTextBox.getText();
    }

    public String getTransmissionText(){
        return transmissionTextBox.getText();
    }
}
