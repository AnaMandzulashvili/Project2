package Pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPageTwo {
    public SelenideElement buttonRest = $("li.cat-3.cat").$(By.tagName("label"));
    public  ElementsCollection categories = $("li.cat-3.cat").$("li.sub-li").$$(By.tagName("a"));
    public  ElementsCollection selectedLocation =$("div.category-filter-desk").$("div.location-filter").$$(By.tagName("label"));
    public  SelenideElement selectedCategory = $("div.sidebar").$("li.searched-category").$(By.tagName("a"));
    public SelenideElement sortButton = $(By.xpath("//*[@id=\"body\"]//div[@class='category-page-head']//select//option[2]"));
    public ElementsCollection sortedOptions =$$(By.xpath("//*[@id=\"render\"]//*[@id=\"partialid\"]//div[@class='discounted-prices']//p[1]"));

   }