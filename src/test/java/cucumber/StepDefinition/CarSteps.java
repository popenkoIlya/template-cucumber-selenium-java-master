package cucumber.StepDefinition;

import cucumber.Page.CarPage;
import cucumber.Page.ComparePage;
import cucumber.Page.MainPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.Page.ResearchPage;
import cucumber.model.Specification;
import cucumber.utils.BrowserUtils;
import cucumber.utils.Storage;
import org.junit.Assert;

import java.util.Map;

public class CarSteps {
    private Specification specification;
    private MainPage mainPage = new MainPage();
    private ResearchPage researchPage = new ResearchPage();
    private CarPage carPage = new CarPage();
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
        Assert.assertTrue("Compare Page is not open", comparePage.state().waitForDisplayed());
    }

    @When("I want note down specifications the car")
    public void i_want_note_down_specifications_the_car() {
    }

    @Then("I make a note about '(.*)' type")
    public void i_make_a_note(String name) {
        comparePage.setCarType(name);
        comparePage.openStyleSpecification();
        String transmission = comparePage.getTransmissionText();
        String engine = comparePage.getEngineText();
        specification = new Specification(transmission, engine);
        Storage.addSpecification(name, specification);
    }

}
