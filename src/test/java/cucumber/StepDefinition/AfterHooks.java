package cucumber.StepDefinition;

import cucumber.api.java.After;
import cucumber.utils.BrowserUtils;

public class AfterHooks {
    @After
    public void closeBrowser(){
        BrowserUtils.quit();
    }
}
