package Forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class ResearchPage extends Form {

    private ISelect makeSelect = new Select(AqualityServices.getBrowser().getDriver().findElement(By.xpath("//select[@name = 'make']")));
    private ISelect modelSelect = new Select(AqualityServices.getBrowser().getDriver().findElement(By.xpath("//select[@name = 'model']")));
    private ISelect yearSelect = new Select(AqualityServices.getBrowser().getDriver().findElement(By.xpath("//select[@name = 'year']")));
    private IButton researchButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[@data-linkname = 'research-make']"),"researchButton");
    public ResearchPage() {
        super(By.xpath(BaseLocator.researchPageTemplate),"ResearchPage");
    }

    public void selectMakeOption(String option){
        makeSelect.selectByVisibleText(option);
    }

    public void selectModelOption(String option){
        makeSelect.selectByVisibleText(option);
    }
    public void selectYearOption(String option){
        makeSelect.selectByVisibleText(option);
    }

    public void research(){
        researchButton.clickAndWait();
    }
}
