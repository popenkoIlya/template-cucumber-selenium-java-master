package cucumber.model;

import aquality.selenium.browser.AqualityServices;

public class Specification {
    private String transmission;
    private String engine;

    public Specification(String transmission, String engine) {
        this.transmission = transmission;
        this.engine = engine;
    }
}
