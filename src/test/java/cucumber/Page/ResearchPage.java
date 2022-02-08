package cucumber.Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ResearchPage extends Form {

    private IComboBox makeComboBox = AqualityServices.getElementFactory().getComboBox(By.xpath("//select[@name = 'make']"), "MakeComboBox");
    private IComboBox modelComboBox = AqualityServices.getElementFactory().getComboBox(By.xpath("//select[@name = 'model']"), "ModelComboBox");
    private IComboBox yearComboBox = AqualityServices.getElementFactory().getComboBox(By.xpath("//select[@name = 'year']"), "YearComboBox");
    private IButton researchButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[@data-linkname = 'research-make']"), "researchButton");

    public ResearchPage() {
        super(By.xpath(BaseLocator.researchPageTemplate), "ResearchPage");
    }

    public void selectMakeOption(String option) {
        makeComboBox.clickAndSelectByText(option);
    }

    public void selectModelOption(String option) {
       modelComboBox.clickAndSelectByText(option);
    }

    public void selectYearOption(String option) {
        yearComboBox.clickAndSelectByText(option);
    }

    public void research() {
        researchButton.clickAndWait();
    }
}
