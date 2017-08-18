package pageobjects;

import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

public class ActionSheetsPage extends Page {
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAStaticText[1]")
    private WebElement title;

    public String getTitle() {
        waitForElement(title);
        return title.getText();
    }
}
