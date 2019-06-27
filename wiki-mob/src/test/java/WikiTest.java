import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class WikiTest {
  private AndroidDriver driver;

  @BeforeClass
  public void setUp() throws MalformedURLException {

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Qa_19_class");
    capabilities.setCapability("platformVersion", "8.0");
    capabilities.setCapability("automationName", "Appium");
    capabilities.setCapability("appPackage", "org.wikipedia");
    capabilities.setCapability("appActivity", ".main.MainActivity");
    capabilities.setCapability("app", "C:/Users/Elena/Documents/GitHub\\Scheduler19\\wiki-mob\\src\\test\\resources\\org-wikipedia.apk");

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  @Test
  public  void  testAppOpened(){
    System.out.println("App opened");

  }

  @Test
  public void  searchWiki() throws InterruptedException {
    Thread.sleep(5000);

//
if(driver.findElements(By.id("fragment_onboarding_skip_button")).size()>0) {
  driver.findElement(By.id("fragment_onboarding_skip_button")).click();
}

    Thread.sleep(5000);
  driver.findElement(By.id("search_container")).click();

    driver.findElement(By.id("search_src_text")).click();
    driver.findElement(By.id("search_src_text")).clear();
    driver.findElement(By.id("search_src_text")).sendKeys("Appium");

    String articleTitle = driver.findElement(By.id("page_list_item_title")).getText();

    Assert.assertTrue(articleTitle.toLowerCase().contains("appium"));
  }

  @AfterClass
  public  void  tearDown(){
    driver.quit();
  }
}
