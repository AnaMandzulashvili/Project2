package Pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement loginButton = $("div.swoop-login");
    public SelenideElement registerButton = $("p.register");
    public SelenideElement firstName = $(By.id("pFirstName"));
    public SelenideElement lastName = $(By.id("pLastName"));
    public SelenideElement email = $(By.id("pEmail"));
    public SelenideElement phone = $(By.id("pPhone"));
    public SelenideElement birthData = $(By.id("pDateBirth"));
    public SelenideElement password = $(By.id("pPassword"));
    public SelenideElement confirmPassword = $(By.id("pConfirmPassword"));
    public SelenideElement submitRegistration = $(By.id("registerFormPlace")).$("input[type=button]");
    public SelenideElement physicalInfoMassage=$(withText("გთხოვთ აირჩიოთ სქესი!"));

}