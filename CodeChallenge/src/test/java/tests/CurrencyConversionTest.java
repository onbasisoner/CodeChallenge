package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Base;

//Currency Conversion Test Class
public class CurrencyConversionTest {

    private WebDriver driver;
    private Base base;
    private pages.mainPage mainPage;
    private String url = "https://www.oanda.com/currency-converter/en/";
    private Boolean testSuccess = false;
    private String methodName;


    //SetUp method for starting browser
    //Browser name is a parameter on TestNG on Test Runner, so it can extend with Edge, Firefox acc.
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(url);

            mainPage = new pages.mainPage(driver);
            base = new pages.Base(driver);
        } else {
            System.out.println("Driver not found");
        }
    }



    //Test Groups name is SmokeTest now, but it can extend with other groups name
    /*
    Test Case:
        1.Access webpage
        2.Make a call to API to get currency code with giving Country Code
        3.Enter currency code given by API into base currency
        4.Enter target currency as EURO
        5.Get currency rate
        6.Check currency rate
        7.If rate is greater than 1 test is successful
     */
    //2 cases is very much similar
    @Test(groups = "SmokeTest")
    public void GBConversionTest() throws Exception {
        methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
        mainPage.clickBaseCurrency(mainPage.getCountryCurrency("gb"));
        mainPage.clickTargetCurrency();
        assert mainPage.getConversionRate()>1;
        testSuccess=true;
    }

    @Test(groups = "SmokeTest")
    public void CHConversionTest() throws Exception {
        methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
        mainPage.clickBaseCurrency(mainPage.getCountryCurrency("ch"));
        mainPage.clickTargetCurrency();
        assert mainPage.getConversionRate()>1;
        testSuccess=true;
    }


    //After completing the cases, it always take SS
    @AfterMethod(alwaysRun = true)
    public void exit(){
        if(testSuccess){
            base.takeScreenshot(methodName + "_"+"Success");
        } if (!testSuccess) {
            base.takeScreenshot(methodName + "_"+"Fail");
        }
        testSuccess=false;
        methodName="none";
        driver.quit();
    }


}
