import Pages.homepageObj;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
@Listeners(CustomListener.class)
public class Homepage {

   private WebDriver driver;
    private homepageObj homepage;


    @BeforeTest
    public void Initialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void homepageAdsLocation() {
        homepage = new homepageObj(driver);
       driver.get("https://stage.dubizzle-eg.run/en/");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
        //1. Click on location bar
       homepage.locationBar.click();
       //2. Click on L1 Location
       driver.findElement(By.xpath("(//span[@class='_6d5b4928'])[3]")).click();
       //3. Click on L2 Location
       driver.findElement(By.xpath("//span[normalize-space()='Abu Qir']")).click();
       //4. Getting location name from Location Bar
        String location = driver.findElement(By.xpath("//span[@class='_6d5b4928']")).getText();
        System.out.println(location);
        //5. Getting location name from Ad tile
        String AdLocation = driver.findElement(By.xpath("(//span[@class='afabcb7f'])[1]")).getText();
        System.out.println(AdLocation);
        //6. Checking if the ad is from location bar location
        Assert.assertEquals(AdLocation, location);



    }
@Test
    public void searchSuggestion(){
        driver.get("https://stage.dubizzle-eg.run/en/");
        homepage = new homepageObj(driver);
        homepage.searchBar.click();
        homepage.searchBar.sendKeys("iphone");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
    String suggestion = driver.findElement(By.xpath("(//span[@class='cc670c51'])[2]")).getText();
    String searchedKW= "iphone";
    System.out.println(suggestion);
    Assert.assertEquals(suggestion, searchedKW);

}

@Test
    public void catSubCatClick(){
    driver.get("https://stage.dubizzle-eg.run/en/");
    WebElement menuElement = driver.findElement(By.xpath("(//a[@class='_6eb51e9a'])[1]"));
    Actions builder = new Actions(driver);
    builder.moveToElement(menuElement).build().perform();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement subMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='_3cf4abe9'])[1]")));

    WebElement dropdownItem = subMenu.findElement(By.xpath("(//a[@class='_3cf4abe9'])[1]"));
    dropdownItem.click();
    driver.quit();

}

@Test
    public void back2top(){
    driver.get("https://stage.dubizzle-eg.run/en/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 1500);");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


}

@Test
    public void


}
