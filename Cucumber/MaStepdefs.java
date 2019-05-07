package Steps;

import Base.BaseUtil;
import Pages.LoginPageObjeks;
//import cucumber.api.DataTable;
import io.cucumber.datatable.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class MaStepdefs extends BaseUtil {
    private BaseUtil base;

    public MaStepdefs(BaseUtil base) {
        this.base = base;
    }

    @And("^I click the login button$")
    public void iClickTheLoginButton() throws Throwable {
        LoginPageObjeks page = new LoginPageObjeks(base.Driver);
        page.ClickLogin();

    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {

        base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");

    }

    @And("^I enter the following login details:$")
    public void iEnterTheFollowingLoginDetails(DataTable table) throws Throwable {

        List<List<String>> data = table.asLists(String.class);
        String userName = data.get(1).get(1);
        String passWord = data.get(1).get(0);

        List<User> users = new ArrayList();
        users.add(new User(userName, passWord));

        LoginPageObjeks page = new LoginPageObjeks(base.Driver);

        for (User user : users)
            page.Login(user.username, user.password);


        //List<User> users = new ArrayList<User>();

        //users = table.asList(User.class);




            Thread.sleep(2000);


        }

        @Then("^I should land on the newest page$")
        public void iShouldLandOnTheNewestPage () throws Throwable {
            Assert.assertEquals("It's not displayed", base.Driver.findElement(By.cssSelector("#details > table > tbody > tr:nth-child(4) > td:nth-child(1) > div > label")).isDisplayed(), true);
        }


    @Then("^I should land on the newest page wrongly$")
    public void iShouldLandOnTheNewestPageWrongly() throws Throwable {
        Assert.assertEquals("It's not displayed", base.Driver.findElement(By.id("fish")).isDisplayed(), true);
    }

    @Then("^I should land on the newest page by other measure$")
    public void iShouldLandOnTheNewestPageByOtherMeasure() throws Throwable {
        Assert.assertEquals("It's not displayed", base.Driver.findElement(By.id("Initial")).isDisplayed(), true);
    }

}

    class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }