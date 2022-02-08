package cucumber.StepDefinition;

import cucumber.api.Transpose;
import cucumber.Page.CarPage;
import cucumber.Page.MainPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.Page.ResearchPage;
import cucumber.utils.BrowserUtils;
import org.junit.Assert;

import java.util.Map;

public class CarSteps {
    private MainPage mainPage = new MainPage();
    private ResearchPage researchPage = new ResearchPage();
    private CarPage carPage;


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
    public void i_search_for_a_car_according_to_such_criteria( @Transpose Map<String,String> criteria) {
        researchPage.selectModelOption(criteria.get("Model"));
        researchPage.selectMakeOption("Make");
        researchPage.selectYearOption("Year");
    }

    @Then("'(.*)' will be found")
    public void this_car_will_be_found(String carName) {
       carPage = new CarPage(carName);
       Assert.assertTrue("Car page is not open",carPage.state().waitForDisplayed());
       Assert.assertTrue("Wrong car page", carPage.IsLabelRight());
    }


    @When("I go to the {string} trim comparison page")
    public void i_go_to_the_trim_comparison_page(String string) {

    }

    @Then("{string} trim comparison page is open")
    public void trim_comparison_page_is_open(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
