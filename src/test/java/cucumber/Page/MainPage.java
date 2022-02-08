package cucumber.Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private ILink researchLink = AqualityServices.getElementFactory().getLink(By.xpath("//a[@data-linkname='research']"),"ResearchLink");
    public MainPage() {
        super(By.xpath(BaseLocator.mainPageTemplate),"HomePage");
    }

    public void  goToResearchPage(){
        researchLink.clickAndWait();
    }
}
