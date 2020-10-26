package ui;

import models.ui.AuthenficationPage;
import models.ui.CreateAccountPage;
import models.ui.HomePage;
import models.ui.MyAccountPage;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.ui.ServiceUI;

import java.util.concurrent.TimeUnit;

public class CreateAccountTest {

    private ServiceUI serviceUI;
    private HomePage homePage;
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\work\\Drivers\\SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        homePage = new HomePage(driver);
        serviceUI = new ServiceUI();
    }

    @Test
    public void newAccountTest() {
        String accountName = RandomString.make(5);
        String customerFirstname = "Ivan";
        String customerLastname = "Ivanov";
        String password = "11111";
        String day = "1";
        String month = "January";
        String year = "2020";
        String firstname = "Ivan";
        String lastname = "Ivanov";
        String company =  "Kaseya";
        String address1 = "701 Brickell Avenue";
        String address2 = "26 W 17th Street, New York";
        String city = "Miami";
        String state = "Florida";
        String postcode = "33131";
        String other = "Additional information";
        String phone = "+375441111111";
        String phoneMobile = "+375292222222";
        String alias = "18, Baker street";
        AuthenficationPage authenficationPage = homePage.signIn();
        CreateAccountPage accountPage = serviceUI.createNewAccount(authenficationPage, accountName);
        MyAccountPage myAccountPage = serviceUI.fillPersonalInformation(accountPage,true, customerFirstname,
                customerLastname, password, day, month, year, true, true, firstname, lastname,
                company, address1, address2, city, state, postcode, other, phone, phoneMobile, alias);

        Assert.assertEquals(myAccountPage.getTitle(),"My account - My Store" );
        Assert.assertEquals(myAccountPage.getCurrentURL(),
                "http://automationpractice.com/index.php?controller=my-account");
        Assert.assertTrue(myAccountPage.topOfTheScreenBannerIsDisplayed());
        Assert.assertTrue(myAccountPage.mainLogoIsDisplayed());
        Assert.assertTrue(myAccountPage.searchboxIsDisplayed());
        Assert.assertTrue(myAccountPage.myAccountLogoIsDisplayed());
        Assert.assertTrue(myAccountPage.menuLineIsDisplayed());
        Assert.assertTrue(myAccountPage.navigationIsDisplayed());
        Assert.assertEquals(myAccountPage.getPhoneNumber(), "0123-456-789");
        Assert.assertEquals(myAccountPage.getInfoText(),
                "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @AfterTest
    public void finish() {
        driver.quit();
    }


}
//    @Test
//    public void seleniumTest() {
//        driver.findElement(By.cssSelector("div.header_user_info > a")).click();
//        driver.findElement(By.cssSelector(".form-group input"))
//                .sendKeys( RandomString.make(5) + "@gmail.com");
//        driver.findElement(By.cssSelector("#SubmitCreate > span")).submit();
//        driver.findElement(By.cssSelector("[name='id_gender']")).click();
//        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Kirill");
//        driver.findElement(By.cssSelector("[name='customer_lastname']")).sendKeys("Simonovich");
//        driver.findElement(By.cssSelector("[data-validate='isPasswd']")).sendKeys("12345");
//        driver.findElement(By.cssSelector("#uniform-days select")).sendKeys("27");
//        driver.findElement(By.cssSelector("#uniform-months > select")).sendKeys("November");
//        driver.findElement(By.cssSelector("#years")).sendKeys("1994");
//        driver.findElement(By.cssSelector("[type='checkbox']")).click();
//        driver.findElement(By.id("optin")).click();
//        driver.findElement(By.id("firstname")).sendKeys("Kirill");
//        driver.findElement(By.id("lastname")).sendKeys("Simonovich");
//        driver.findElement(By.id("company")).sendKeys("Kaseay");
//        driver.findElement(By.id("address1")).sendKeys("701 Brickell Avenue");
//        driver.findElement(By.id("address2")).sendKeys("26 W 17th Street, New York");
//        driver.findElement(By.id("city")).sendKeys("Miami");
//        driver.findElement(By.id("id_state")).sendKeys("Florida");
//        driver.findElement(By.id("postcode")).sendKeys( "33131");
//        driver.findElement(By.name("other")).sendKeys("Additional information");
//        driver.findElement(By.name("phone")).sendKeys("+375999999997");
//        driver.findElement(By.name("phone_mobile")).sendKeys("+375444444444");
//        driver.findElement(By.name("alias")).sendKeys("18, Baker street");
//        driver.findElement(By.cssSelector("#submitAccount > span")).click();
//
//        Assert.assertEquals(driver.getTitle(), "My account - My Store");
//        Assert.assertEquals(driver.getCurrentUrl(),
//                "http://automationpractice.com/index.php?controller=my-account");
//        Assert.assertTrue(driver.findElement(By.cssSelector(".row a")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("#header > div.banner")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("#searchbox")).isDisplayed());
//        Assert.assertEquals(driver.findElement(By.cssSelector("#center_column .page-heading")).getText(),
//                "MY ACCOUNT");
//        Assert.assertTrue(driver.findElement(By.cssSelector("#header > div.nav")).isDisplayed());
//        Assert.assertEquals(driver.findElement(By.cssSelector(".shop-phone > strong")).getText(),
//                "0123-456-789");
//        Assert.assertEquals(driver.findElement(By.cssSelector(".navigation_page")).getText(), "My account");
//        Assert.assertEquals(driver.findElement(By.cssSelector("#center_column > p")).getText(),
//                "Welcome to your account. Here you can manage all of your personal information and orders.");
//
//    }
