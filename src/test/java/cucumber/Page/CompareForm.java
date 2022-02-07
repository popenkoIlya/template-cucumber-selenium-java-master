package Forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CompareForm extends Form {
    private ITextBox engineText = AqualityServices.getElementFactory().getTextBox(By.xpath("//tbody//tr[@class=\'content-row\'][4]/td[1]"),"EngineText");
    private ITextBox transmissionText = AqualityServices.getElementFactory().getTextBox(By.xpath("//tbody//tr[@class=\'content-row\'][5]/td[1]"),"TransmissionText");
    public CompareForm(By locator, String name) {
        super(locator, name);
    }


}
