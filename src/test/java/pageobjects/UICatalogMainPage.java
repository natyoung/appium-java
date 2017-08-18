package pageobjects;

import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

public class UICatalogMainPage extends Page {
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]")
    private WebElement actionSheets;

    public void clickActionSheetsCell() {
        waitForElement(actionSheets);
        actionSheets.click();
    }
}
