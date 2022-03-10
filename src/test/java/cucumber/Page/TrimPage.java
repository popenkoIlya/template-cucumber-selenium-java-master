package cucumber.Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;

public class TrimPage extends Form {
    private ITextBox engineTextBox;
    private ITextBox transmissionTextBox;
    private IButton styleButton;
    private String listLocator;
    private List<ITextBox> textBoxList;

    public TrimPage() {
        super(By.xpath(BaseLocator.trimPageTemplate), "ComparePage");
    }

    public void setCarType(String carType, String style) {
        styleButton = AqualityServices.getElementFactory().getButton(By.xpath(String.format("//span[text()='%s']//ancestor::button",carType)),"StyleButton");
        clickStyleSpecification();
        listLocator = String.format("//span[text()='%s']//ancestor::h2//following-sibling::div//th[text()='Style']//ancestor::tr//following-sibling::tr[1]/td",carType);
        textBoxList = AqualityServices.getElementFactory().findElements(By.xpath(listLocator), ElementType.TEXTBOX);
        int i = 1;
        for (ITextBox textbox:textBoxList) {
            if(Objects.equals(textbox.getText(), style)){
                break;
            }
            i++;
        }
        engineTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//span[text()='%s']//ancestor::h2//following-sibling::div//th[text()='Engine']//ancestor::tr//following-sibling::tr[1]/td[%s]", carType, i)), "EngineText");
        transmissionTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath(String.format("//span[text()='%s']//ancestor::h2//following-sibling::div//th[text()='Transmission']//ancestor::tr//following-sibling::tr[1]/td[%s]", carType, i)), "TransmissionText");
        clickStyleSpecification();
    }


    public void clickStyleSpecification(){
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
