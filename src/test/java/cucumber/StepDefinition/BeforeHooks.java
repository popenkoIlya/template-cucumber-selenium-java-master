package cucumber.StepDefinition;
import cucumber.api.java.Before;
import cucumber.utils.BrowserUtils;

public class BeforeHooks{
    @Before
    public void initBrowserHook(){
        BrowserUtils.initBrowser();
        BrowserUtils.maximize();
    }
}
