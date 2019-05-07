package Steps;

import Base.BaseUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Before;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;
    public Hook(BaseUtil base){this.base = base;}

    @Before
    public void InitializeTest(){

        WebDriverManager.chromedriver().setup();

        System.out.println("\nOpening the browser");
        base.Driver = new ChromeDriver();

    }


}
