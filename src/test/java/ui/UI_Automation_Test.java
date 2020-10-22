package ui;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UI_Automation_Test {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\work\\Drivers\\SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void seleniumTest() {
        driver.findElement(By.cssSelector("[href=\"http://automationpractice.com/index.php?controller=my-account\"]")).click();
        driver.findElement(By.id("email_create")).sendKeys( RandomString.make(5) + "@gmail.com");
        driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
        driver.findElement(By.cssSelector("#id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Kirill");
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Simonovich");
        driver.findElement(By.id("passwd")).sendKeys("12345");
        driver.findElement(By.name("days")).sendKeys("27");
        driver.findElement(By.cssSelector("#months")).sendKeys("November");
        driver.findElement(By.cssSelector("#years")).sendKeys("1994");
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("firstname")).sendKeys("Kirill");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Simonovich");
        driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("Kaseay");
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("701 Brickell Avenue");
        driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("26 W 17th Street, New York");
        driver.findElement(By.id("city")).sendKeys("Miami");
        driver.findElement(By.name("id_state")).sendKeys("Florida");
        driver.findElement(By.id("postcode")).sendKeys( "33131");
        driver.findElement(By.id("other")).sendKeys("Additional information");
        driver.findElement(By.cssSelector("#phone")).sendKeys("+375223562500");
        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("+375447482074");
        driver.findElement(By.id("alias")).sendKeys("18, Baker street");
        driver.findElement(By.cssSelector("#submitAccount > span")).click();

        Assert.assertEquals(driver.getTitle(), "My account - My Store");
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
        Assert.assertTrue(driver.findElement(By.cssSelector("[src=\"http://automationpractice.com/modules/blockbanner/img/sale70.png\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#header > div.banner")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("searchbox")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("#center_column > h1")).getText(),"MY ACCOUNT");
        Assert.assertTrue(driver.findElement(By.cssSelector("#header > div.nav")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > span > strong")).getText(),"0123-456-789");
        Assert.assertEquals(driver.findElement(By.linkText("My account")).getText(), "My account");
        //Check text in the page.
        Assert.assertEquals(driver.findElement(By.cssSelector("#center_column > p")).getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @AfterTest
    public void finish() {
        driver.quit();
    }
}
