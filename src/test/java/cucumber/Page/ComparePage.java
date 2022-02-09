package cucumber.Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import cucumber.utils.Storage;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static cucumber.utils.StringUtils.compareMeaningStrings;
import static cucumber.utils.StringUtils.getPreparedStringValue;

public class ComparePage extends Form {
    private ILink car1Link = AqualityServices.getElementFactory().getLink(By.xpath("//a[@phx-value-vehicle_index='vehicle_1']"), "Vehicle1Link");
    private ILink car2Link = AqualityServices.getElementFactory().getLink(By.xpath("//a[@phx-value-vehicle_index='vehicle_2']"), "Vehicle2Link");
    private IComboBox makeComboBox = AqualityServices.getElementFactory().getComboBox(By.xpath("//select[@name='vehicle_selection[make]']"), "MakeComboBox");
    private IComboBox modelComboBox = AqualityServices.getElementFactory().getComboBox(By.xpath("//select[@name='vehicle_selection[model]']"), "ModelComboBox");
    private IComboBox yearComboBox = AqualityServices.getElementFactory().getComboBox(By.xpath("//select[@name='vehicle_selection[year]']"), "YearComboBox");
    private IComboBox trimComboBox = AqualityServices.getElementFactory().getComboBox(By.xpath("//select[@name='vehicle_selection[trim]']"), "TrimComboBox");
    private IButton submitButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[@type='submit']"), "SubmitButton");
    private IButton compareButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[@phx-click='details']"), "CompareButton");
    private List<ITextBox> textBoxCard1List;
    private List<ITextBox> compareEngineList;
    private List<ITextBox> compareTransmissionList;
    private ILabel overviewLabel = AqualityServices.getElementFactory().getLabel(By.xpath("//*[text()='Overview']"),"OverviewLabel");
    private ITextBox card1DetailsElement = AqualityServices.getElementFactory().getTextBox(By.xpath("//div[contains(@class,'card1')]//div[@class='details']"), "Card1");
    private ITextBox card2DetailsElement = AqualityServices.getElementFactory().getTextBox(By.xpath("//div[contains(@class,'card2')]//div[@class='details']"), "Card2");


    public ComparePage() {
        super(By.xpath(BaseLocator.comparePageTemplate), "ComparePage");
    }

    public void selectCar(Map<String, String> criteria) {
        selectMakeOption(criteria.get("Make"));
        selectModelOption(criteria.get("Model"));
        selectYearOption(criteria.get("Year"));
        selectTrimOption(criteria.get("Style"));
    }

    public boolean checkFirstCar(Map<String, String> criteria) {
        card1DetailsElement.state().waitForDisplayed();
        String name = criteria.get("Year") + " " + criteria.get("Make") + " " + criteria.get("Model");
        textBoxCard1List = AqualityServices.getElementFactory().findElements(By.xpath("//div[contains(@class,'card1')]//div[@class='details']//child::p"), "TextBoxCard1List", ElementType.TEXTBOX);
        return Objects.equals(textBoxCard1List.get(0).getText(), name) && Objects.equals(textBoxCard1List.get(1).getText(), criteria.get("Style"));
    }

    public boolean checkSecondCar(Map<String, String> criteria) {
        card2DetailsElement.state().waitForDisplayed();
        String name = criteria.get("Year") + " " + criteria.get("Make") + " " + criteria.get("Model");
        textBoxCard1List = AqualityServices.getElementFactory().findElements(By.xpath("//div[contains(@class,'card2')]//div[@class='details']//child::p"), "TextBoxCard1List", ElementType.TEXTBOX);
        return Objects.equals(textBoxCard1List.get(0).getText(), name) && Objects.equals(textBoxCard1List.get(1).getText(), criteria.get("Style"));

    }

    public void clickAddCar1() {
        car1Link.focus();
        car1Link.clickAndWait();
    }

    public void clickAddCar2() {
        car2Link.focus();
        car2Link.clickAndWait();
    }

    public void clickOnSubmit() {
        submitButton.clickAndWait();
    }

    public void selectMakeOption(String option) {
        makeComboBox.focus();
        makeComboBox.clickAndSelectByText(option);
    }

    public void selectModelOption(String option) {
        modelComboBox.clickAndSelectByText(option);
    }

    public void selectYearOption(String option) {
        yearComboBox.clickAndSelectByText(option);
    }

    public void selectTrimOption(String option) {
        trimComboBox.clickAndSelectByText(option);
    }

    public void clickOnCompare() {
        compareButton.clickAndWait();
    }

    public boolean checkCompareEngine(String firstName, String secondName) {
        overviewLabel.state().waitForDisplayed();
        compareEngineList = AqualityServices.getElementFactory().findElements(By.xpath("//tr[contains(@class,'engine-section')]//following-sibling::tr[1]//child::p"), ElementType.TEXTBOX);
        return compareMeaningStrings(compareEngineList.get(0).getText(), Storage.getSpecification(firstName).getEngine()) && compareMeaningStrings(compareEngineList.get(1).getText(), Storage.getSpecification(secondName).getEngine());
    }

    public boolean checkCompareTransmission(String firstName, String secondName) {
        overviewLabel.state().waitForDisplayed();
        compareTransmissionList = AqualityServices.getElementFactory().findElements(By.xpath("//td[text()='Transmissions']//ancestor::tr//following::tr[1]//child::p"), ElementType.TEXTBOX);
        return compareMeaningStrings(compareTransmissionList.get(0).getText(), Storage.getSpecification(firstName).getTransmission()) && compareMeaningStrings(compareTransmissionList.get(2).getText(), Storage.getSpecification(secondName).getTransmission());
    }
}
