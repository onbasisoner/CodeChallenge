package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import client.RestAssuredClient;

//Main Page for website, we only have 1 page so there is only one page class according to POM
public class mainPage extends Base {

    public mainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    //3 elements are needed for project
    @FindBy(xpath ="//*[@id='cc-main-conversion-block']/div/div[2]/div[1]/div[1]/div/div[2]/div/div")
    private WebElement baseCurrency;

    @FindBy(xpath = "//*[@id='cc-main-conversion-block']/div/div[2]/div[3]/div[1]/div/div[2]/div/div")
    private WebElement targetCurrency;

    @FindBy(xpath = "//*[@id='cc-main-conversion-block']/div/div[2]/div[3]/div[2]/div[1]/div/input")
    private WebElement conversionRate;


    //Base currency element, it changable according to cases
    public void clickBaseCurrency(String countryCode){
        wait(500);
        clickAndSelect(baseCurrency,10,countryCode);
        wait(500);
    }

    //Target currency is always EURO so it doesnt get any parameter
    public void clickTargetCurrency(){
        wait(500);
        clickAndSelect(targetCurrency,10,"eur");
        wait(500);
    }

    //Get conversion rate for asserting
    public double getConversionRate(){
        String conversionRateValue = conversionRate.getAttribute("value");
        System.out.println(Double.parseDouble(conversionRateValue));
        return Double.parseDouble(conversionRateValue);
    }


    //With giving country code as a parameter, with RestAPI connection, it gives currency code
    public String getCountryCurrency(String countryCode) throws Exception {
        return RestAssuredClient.getCurrencyCode(countryCode) ;
    }

}
