package Steps;
import Pages.DashboardPageOne;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DashboardPageOneSteps {
    DashboardPageOne dashboardPageOne = new  DashboardPageOne();
    public int countElementsOutOfRange;
    @Step( "click to „დასვენება“ category")
    public DashboardPageOneSteps clickToButtonRest(){
        dashboardPageOne.buttonRest.click();
        return this;
    }

    @Step("Set minimum price")
    public DashboardPageOneSteps putMinPrice(){
        dashboardPageOne.buttonMinPrice.scrollTo().setValue("200");
        return this;
    }
    @Step("Set maximum price")
    public DashboardPageOneSteps putMaxPrice(){
        dashboardPageOne.buttonMaxPrice.scrollTo().setValue("230");
        return this;
    }
    @Step("Click submit button")
    public DashboardPageOneSteps clickSubmitButton(){
        dashboardPageOne.buttonSubmit.click();
        return this;
    }

    @Step("Check if elements are in selected range")
    public DashboardPageOneSteps countingElementsInRange(){

        List<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < dashboardPageOne.selectedOffers.size(); i++) {
            String checkedText = dashboardPageOne.selectedOffers.get(i).getText();
            Matcher m = Pattern.compile("\\d+").matcher(checkedText);
            while(m.find())
            {
                Integer price = Integer.parseInt(m.group());
                priceList.add(price);
            }
        }
        for (int i = 0; i < dashboardPageOne.selectedOffers.size(); i++) {
            if ( 200 <=priceList.get(i) && priceList.get(i) <= 230 ) {

            }else countElementsOutOfRange ++;
        }

        Assert.assertEquals(countElementsOutOfRange,0,"there should be no element out of range");
        return this;

    }

}
