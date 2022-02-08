package cucumber.StepDefinition;

import cucumber.Page.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.model.Specification;
import cucumber.utils.BrowserUtils;
import cucumber.utils.Storage;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CarSteps {
    private Specification specification;
    private MainPage mainPage = new MainPage();
    private ResearchPage researchPage = new ResearchPage();
    private CarPage carPage = new CarPage();
    private TrimPage trimPage = new TrimPage();
    private ComparePage comparePage = new ComparePage();


    @When("^I go to the site '(.*)'$")
    public void i_go_to_the_site(String url) {
        BrowserUtils.goToUrl(url);
    }

    @Then("^Main Page is open$")
    public void main_Page_is_open() {
        Assert.assertTrue("Main Page is not open", mainPage.state().waitForDisplayed());
    }

    @When("^I go to the Research page$")
    public void i_go_to_the_Research_page() {
        mainPage.goToResearchPage();
    }

    @Then("Research page is open")
    public void research_page_is_open() {
        Assert.assertTrue("Research page is not open", researchPage.state().waitForDisplayed());
    }

    @When("^I search for a car according to such criteria:$")
    public void i_search_for_a_car_according_to_such_criteria(Map<String, String> criteria) {
        //Map<String,String> criteria = table.asMap(String.class,String.class);io.cucumber.datatable.DataTable table
        researchPage.selectMakeOption(criteria.get("Make"));
        researchPage.selectModelOption(criteria.get("Model"));
        researchPage.selectYearOption(criteria.get("Year"));
        researchPage.research();
    }

    @Then("'(.*)' will be found")
    public void this_car_will_be_found(String carName) {
        String[] words = carName.split(" ");
        carPage.setCarName(words[0], words[1], words[2]);
        Assert.assertTrue("Car page is not open", carPage.state().waitForDisplayed());
        Assert.assertTrue("Wrong car page", carPage.IsLabelRight());
    }


    @When("I go to the trim comparison page")
    public void i_go_to_the_trim_comparison_page() {
        carPage.goOnTrim();
    }

    @Then("'(.*)' trim comparison page is open")
    public void trim_comparison_page_is_open(String string) {
        Assert.assertTrue("Trim Page is not open", trimPage.state().waitForDisplayed());
    }

    @When("I want note down specifications of the car")
    public void i_want_note_down_specifications_the_car() {
    }

    @Then("I make a note about engine and transmission of '(.*)' '(.*)' type and '(.*)' style")
    public void i_make_a_note(String name, String type, String style) {
        trimPage.setCarType(type, style);
        trimPage.clickStyleSpecification();
        String transmission = trimPage.getTransmissionText();
        String engine = trimPage.getEngineText();
        specification = new Specification(transmission, engine);
        Storage.addSpecification(name + " " + style, specification);
    }

    @When("I go to the Compare Page")
    public void i_go_to_the_Compare_Page() {
        researchPage.goToComparePage();
    }

    @Then("Compare Page is open")
    public void compare_page_is_open() {
        Assert.assertTrue("Compare Page is not open", comparePage.state().waitForDisplayed());
    }

    @When("I add the first model:")
    public void i_add_the_first_model(Map<String, String> criteria) {
        comparePage.clickAddCar1();
        comparePage.selectCar(criteria);
        comparePage.clickOnSubmit();
    }

    @Then("First model appears:")
    public void first_model_appears(Map<String, String> criteria) {
        Assert.assertTrue("the first model does not appear",comparePage.checkFirstCar(criteria));
    }

    @When("I add the second model:")
    public void i_add_the_second_model(Map<String, String> criteria) {
        comparePage.clickAddCar2();
        comparePage.selectCar(criteria);
        comparePage.clickOnSubmit();
    }

    @Then("Second model appears:")
    public void second_model_appears(Map<String, String> criteria) {
        Assert.assertTrue("the second model does not appear",comparePage.checkSecondCar(criteria));
    }

    @When("I compare two models")
    public void i_compare_two_models() {
        comparePage.clickOnCompare();
    }

    @Then("I get right information about engines and transmissions these models:")
    public void i_get_right_information(List<String> carList) {
        Assert.assertTrue("information about transmissions is wrong",comparePage.checkCompareTransmission(carList.get(0),carList.get(1)));
        Assert.assertTrue("information about engines is wrong",comparePage.checkCompareEngine(carList.get(0),carList.get(1)));
    }
}
