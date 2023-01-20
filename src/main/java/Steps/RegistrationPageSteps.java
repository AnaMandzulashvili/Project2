package Steps;
import Pages.RegistrationPage;
import Data.Member;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.sql.SQLException;
import static com.codeborne.selenide.Condition.appear;

public class RegistrationPageSteps {

    public RegistrationPageSteps() throws SQLException {
    }

    RegistrationPage registrationPage =new RegistrationPage();


    @Step("Click to login button")
    public RegistrationPageSteps clickLoginButton(){
        registrationPage.loginButton.click();
        return this;

    }
    @Step("Click to registration ")
    public RegistrationPageSteps clickRegisterButton(){
        registrationPage.registerButton.click();
        return this;
    }
    @Step ("Set Name")
    public RegistrationPageSteps setFirstName(){
        registrationPage.firstName.setValue(Member.firstName);
        return this;
    }
    @Step("Set lastname")
    public RegistrationPageSteps setlastName(){
        registrationPage.lastName.setValue(Member.lastName);
        return this;
    }
    @Step("Set phone")
    public RegistrationPageSteps setPhone(){
        registrationPage.phone.setValue(Member.phone);
        return this;
    }
    @Step("Set email")
    public RegistrationPageSteps setEmail(){
        registrationPage.email.setValue(Member.email);
        return this;
    }
    @Step("Set data of birth")
    public RegistrationPageSteps setDateOfBirth(){
        registrationPage.birthData.setValue(Member.dateOfBirth);
        return this;
    }
    @Step("Set Password")
    public RegistrationPageSteps setPassword(){
        registrationPage.password.setValue(Member.password);
        return this;
    }
    @Step("Confirm password")
    public RegistrationPageSteps confirmPassword(){
        registrationPage.confirmPassword.setValue(Member.password);
        return this;
    }
    @Step("Click submit")
    public RegistrationPageSteps clickSubmitRegistration(){
        registrationPage.submitRegistration.scrollTo().click();
        return this;
    }
    @Step("checking  error message")
    public RegistrationPageSteps checkErrorMassage (){
        registrationPage.physicalInfoMassage.should(appear).shouldHave(Condition.text("გთხოვთ აირჩიოთ სქესი!"));
        return this;
    }


}

