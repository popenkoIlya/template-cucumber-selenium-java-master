package cucumber.StepDefinition;
import Forms.MainPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.utils.BrowserUtils;
import org.junit.Assert;

public class CarSteps {
    private MainPage mainPage;
    @When("^I go to the site '(.*)'$")
    public void i_go_to_the_site(String url){
        BrowserUtils.goToUrl(url);
    }

    @Then("^Main Page is open$")
    public void main_Page_is_open(){
        mainPage = new MainPage();
        Assert.assertTrue("Main Page is not open", mainPage.state().waitForDisplayed());

    }
}
