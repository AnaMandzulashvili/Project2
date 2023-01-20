package Steps;
import Pages.DashboardPageTwo;
import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Condition.*;


public class DashboardPageTwoSteps {
    DashboardPageTwo pageTwo =new DashboardPageTwo();

    @Step("Hover on „დასვენება“")
    public DashboardPageTwoSteps hoverButtonRest(){
        pageTwo.buttonRest.hover();
        return this;
    }
    @Step("Click on first element")
    public DashboardPageTwoSteps clickToCategories(){
        pageTwo.categories.get(0).hover().click();

        return this;
    }
    @Step ("Check location")
    public DashboardPageTwoSteps checkLocation(){
        pageTwo.selectedLocation.shouldBe(CollectionCondition.size(1));
        pageTwo.selectedLocation.get(0).shouldHave(exactText("ბაკურიანი"));

        return this;
    }

    @Step("Check category")
    public DashboardPageTwoSteps checkCategory(){
        pageTwo.selectedCategory.shouldHave(exactText("ბაკურიანი"));
        pageTwo.selectedCategory.isSelected();
        return this;
    }

    @Step("Sort elements")
    public DashboardPageTwoSteps clickSortButton(){
        pageTwo.sortButton.click();
        return this;
    }
    @Step("Check price of the first item is higher than the price of the second item")
    public DashboardPageTwoSteps compereElements(){
        Integer firstElementInteger = null;
        Integer secondElementInteger=null;
        String compereTwoElement= null;

           String firstElement = pageTwo.sortedOptions.get(0).getText();
           Matcher m = Pattern.compile("\\d+").matcher(firstElement);
            while(m.find())
            {
               firstElementInteger  = Integer.parseInt(m.group());
            }
            System.out.println(firstElement);

           String secondElement = pageTwo.sortedOptions.get(1).getText();
           Matcher m1 =Pattern.compile("\\d+").matcher(secondElement);
           while(m1.find())
           {
             secondElementInteger  = Integer.parseInt(m1.group());
           }
           System.out.println(secondElement);

           if(firstElementInteger > secondElementInteger){
               compereTwoElement ="first item is higher";
           }

        Assert.assertEquals(compereTwoElement,"first item is higher");

        return this;
    }
}
