import com.automationByMounika.Components.ElementFindBy;
import com.automationByMounika.Components.RepositoryLoader;
import com.automationByMounika.Properties.PropertiesLoader;
import com.automationByMounika.Properties.PropertiesValidator;
import com.automationByMounika.browser.DriverManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class sampleTest {
    @Test
    public void testSampleTest() throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        DriverManager driverManager = new DriverManager();
        driverManager.loadDriver();
        driverManager.driver.get("https://www.google.com/");
        Thread.sleep(4000);
        ElementFindBy findBy = new ElementFindBy(DriverManager.driver);
       WebElement element =  findBy.findElementBy("google.tbx_search");
       element.sendKeys("testing framework");
        Thread.sleep(7000);
        driverManager.closeAllBrowsers();
    }
}
