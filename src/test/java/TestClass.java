
import Data.Member;
import Steps.DashboardPageOneSteps;
import Steps.DashboardPageTwoSteps;
import Steps.RegistrationPageSteps;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.sql.SQLException;
import Utils.ITestListenerClass;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;
@Epic("Swoop page")
@Listeners({ITestListenerClass.class})

public class TestClass  {

    @BeforeClass
     public void beforeMethod() {
        open("https://www.swoop.ge/");
        browser="chrome";
        holdBrowserOpen = true;
        timeout = 90000;
        screenshots = true;
        savePageSource = false;
        browserSize = "1920x1080";
    }

    @Test(testName = "Test Dashboard Page One",groups = {"Group1"})
    @Severity(value = SeverityLevel.BLOCKER)
    @Description("put range and check returned elements")
    @Feature("Dashboard Page One")
    @Story("Test fails")
    public void firstTestMethod() {

        DashboardPageOneSteps dashboardOne = new DashboardPageOneSteps();
        dashboardOne.clickToButtonRest().putMinPrice().putMaxPrice().clickSubmitButton().countingElementsInRange();
    }


    @Test(testName= "Test Dashboard Page Two",groups = {"Group1"})
    @Severity(value = SeverityLevel.NORMAL)
    @Description("Check category and location, sort elements, compere first and second elements")
    @Feature("Dashboard Page Two")
    @Story("correct text")
    public void secondTestMethod(){

        DashboardPageTwoSteps dashboardTwo = new DashboardPageTwoSteps();
        dashboardTwo.hoverButtonRest().clickToCategories().checkLocation().checkCategory().clickSortButton().compereElements();
    }


    @Test(testName= "Test Registration Page",groups = {"Group2"})
    @Severity(value = SeverityLevel.NORMAL)
    @Description("Register member and check error message")
    @Feature("Registration Page")
    @Story("correct text")
    public void thirdTestMethod() throws SQLException {
        Member member =new Member(3);
        RegistrationPageSteps registerMEmber =new RegistrationPageSteps();
                 registerMEmber.clickLoginButton().clickRegisterButton()
                                 .setFirstName().setlastName().setPhone()
                                 .setEmail().setDateOfBirth().setPassword()
                                 .confirmPassword().clickSubmitRegistration().checkErrorMassage();
    }

    @AfterClass()
    public void afterMethod(){
        closeWindow();
    }
}
