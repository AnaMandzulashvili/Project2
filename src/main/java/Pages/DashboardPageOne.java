package Pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPageOne {
    public  SelenideElement buttonRest = $("li.cat-3.cat").$(By.tagName("label"));
    public   SelenideElement buttonMinPrice = $("div.category-filter-desk").$(By.id("minprice"));
    public   SelenideElement buttonMaxPrice = $("div.category-filter-desk").$(By.id("maxprice"));
    public   SelenideElement buttonSubmit = $("div.category-filter-desk").$("div.submit-button");
    public   ElementsCollection selectedOffers = $$("div.discounted-prices :first-child");
}
