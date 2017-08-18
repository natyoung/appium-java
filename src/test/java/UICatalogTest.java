import driver.DriverRegistry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobjects.ActionSheetsPage;
import pageobjects.UICatalogMainPage;

import static org.junit.Assert.assertEquals;

public class UICatalogTest {
    private final UICatalogMainPage mainPage = new UICatalogMainPage();
    private final ActionSheetsPage actionSheetsPage = new ActionSheetsPage();

    @BeforeClass
    public static void setUp() throws Exception {
        DriverRegistry.startService();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        DriverRegistry.stopService();
    }

    @Test
    public void canNavigateToActionSheetsFromTheHomepage() throws Exception {
        mainPage.clickActionSheetsCell();
        assertEquals("Action Sheets", actionSheetsPage.getTitle());
    }
}
